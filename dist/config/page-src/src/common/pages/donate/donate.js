import React from 'react'

import { Row, Col, Card, Table, Icon, Pagination } from 'antd';
import reqwest from 'reqwest';

import './donate.less'

export default class donate extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            dataSource: [],
            pagination: {
                // current:1, 
                pageSize:10,
                showSizeChanger:true,  //是否可以改变 pageSize
                pageSizeOptions:["1","5","10","15","20","25","30","40","50","100","1000"],
                showQuickJumper:true,  //是否可以快速跳转至某页
            },
            loading: 
            {
                tip:"正在为你努力加载",
                spinning: true,
            },
        }
    }

    // state = {
    //     dataSource: [],
    //     pagination: {current:1, pageSize:10},
    //     loading: false,
    // };

    handleTableChange = (pagination, filters, sorter) => {
        // console.log(pagination, filters, sorter);  //pagination: current: 2, pageSize: 10, total: 42

        const pager = { ...this.state.pagination };
        
        pager.current = pagination.current;
        pager.pageSize = pagination.pageSize;
        this.setState({
            pagination: pager,
        });
        this.fetch({
            pageSize: pagination.pageSize,
            pageNumber: pagination.current,
            sortField: sorter.field,
            sortOrder: sorter.order,
        });
    }
    fetch = (params = {}) => {
        this.setState(
            { 
                loading: {
                tip:"正在为你努力加载",
                spinning: true,
            } 
        });
        
        reqwest({
            url: '/donate/page',
            method: 'get',
            data: {
                pageNumber: params.pageNumber,
                pageSize: params.pageSize,
            },
            type: 'json',
        }).then((data) => {
            const pagination = { ...this.state.pagination };
            // Read total count from server
            // pagination.total = data.totalCount;
            console.log(data);
            pagination.total = data.totalRow;
            pagination.current = data.pageNumber;
            // pagination.pageSize = data.totalRow;
            // pagination.total = data.totalRow;

            console.log(pagination);
            this.setState({
                loading: false,
                dataSource: data.list,
                pagination,
            });
        });
    }
    componentDidMount() {
        this.fetch(
            {
                pageNumber: 1, 
                pageSize: this.state.pagination.pageSize
            });
    }

    render() {
        
        let { sortedInfo, filteredInfo } = this.state;
        sortedInfo = sortedInfo || {};
        filteredInfo = filteredInfo || {};

        const columns = [{
                title: '姓名',
                dataIndex: 'name',
                key: 'name',
                sortOrder: sortedInfo.columnKey === 'name' && sortedInfo.order,
            }, 
            {
                title: '金 额',
                dataIndex: 'amount',
                key: 'amount',
            }, 
            {
                title: '个人/公司地址',
                dataIndex: 'url',
                key: 'url',
                render: text => <a target="_blank" href={text}>{text}</a>
            },
            {
                title: '日 期',
                dataIndex: 'time',
                key: 'time',
            },
             {
                title: '捐赠途径',
                dataIndex: 'way',
                key: 'way',
            }
            ,
            {
                title: '捐赠留言',
                dataIndex: 'leavemsg',
                key: 'leavemsg',
            },
            {
                title: '备 注',
                dataIndex: 'remark',
                key: 'remark',
            }
        ];
        
        return (
            <div style={{ height: '100%', width: '100%' }}>
                <Row gutter={1}>
                    <Col span={24} >
                        <div className="donate_wrap">
                            {/* <span className="donate_text">I</span> */}
                            <span className="donate_text">
                                支付宝捐赠<br/>
                                <img className="donate_img" src="https://git.oschina.net/tywo45/t-io/raw/master/docs/pay/ali_300px-1.png" />
                                
                            </span>
                            <span className="donate_text">
                                 <a href="mailto:tywo45@163.com">
                                    为了您的合理权益<br/>
                                    捐赠后请即时反馈
                                 </a>
                            </span>
                            <span className="donate_text">
                                微信捐赠<br/>
                                <img className="donate_img" src="https://git.oschina.net/tywo45/t-io/raw/master/docs/pay/wechat_300px-1.png" />
                                
                            </span>
                            {/* <span className="donate_text">t-io</span>  */}
                        </div>
                    </Col>

                    <Col span={24} >
                        <Table columns={columns}
                            rowKey={record => record.id}
                            dataSource={this.state.dataSource}
                            pagination={this.state.pagination}
                            loading={this.state.loading}
                            onChange={this.handleTableChange}
                            // scroll={{ y: '400' }}
                        />
                    </Col>
                   
                </Row>

            </div>
        )
    }
}