import React from 'react'

import { Row, Col, Card, Table, Icon, Pagination } from 'antd';

import './qa.less'

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
                        <Card title="正在开发... 官方提问区，也可以在osc上提问">
                           
                        </Card>
                    </Col>
                </Row>
            </div>
        )
    }
}