import React from 'react'

import { Row, Col, Card, Table, Icon, Pagination } from 'antd';

import './index.less'

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
                        <Card title="贡献榜单，正在开发... 记录那些为tio贡献的朋友们">
                           
                        </Card>
                    </Col>
                </Row>
            </div>
        )
    }
}