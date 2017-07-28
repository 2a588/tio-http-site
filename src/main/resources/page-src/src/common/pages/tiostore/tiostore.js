import React from 'react'

import { Row, Col, Card, Table, Icon, Pagination } from 'antd';

import './tiostore.less'

export default class donate extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            
        }
    }

    render() {
        return (
            <div style={{ height: '100%', width: '100%' }}>
                <Row gutter={1}>
                    <Col span={24} >
                        <Card title="t-io是渔，用渔得到的鱼可以在t-io应用市场进行展示">
                           上架步骤
                           <li>提交可运行程序</li>
                           <li>t-io官方进行充分测试</li>
                           <li>t-io官方给出测试数据</li>
                           <li>打回或上架</li>
                        </Card>
                    </Col>
                </Row>
            </div>
        )
    }
}