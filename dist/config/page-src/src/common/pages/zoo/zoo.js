import React from 'react'
import { Row, Col, Card} from 'antd';
import './zoo.less'

export default class follow extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            col:'#666'
        }
        this.cardStyle={height: 400};
        this.cardImgStyle={height: 290, width:'100%'};
        this.cardBodyStyle={fontSize:'10pt'};

        this.cardArr = [
            [
                {
                    name:"WebIM",
                    url:"http://112.74.183.177/webim/",
                    img:"https://git.oschina.net/tywo45/t-io/raw/master/docs/tchat/1.png",
                    remark:"用t-io实现的WebIm"
                },
                {
                    name:"Http Server",
                    url:"http://112.74.183.177/",
                    img:"https://git.oschina.net/tywo45/t-io/raw/master/docs/tchat/site.png",
                    remark:"用t-io实现的Http Server"
                },
                {
                    name:"WebSocket",
                    url:"http://112.74.183.177/webim/",
                    img:"https://git.oschina.net/tywo45/t-io/raw/master/docs/tchat/2.png",
                    remark:"用t-io实现的WebSocket"
                }
            ]

        ];
    }

    getRandomColor = () => {
        this.setState({
            col: '#'+('00000'+(Math.random()*0x1000000<<0).toString(16)).slice(-6)
        });
    }

    // 组件渲染后，500毫秒改变一次组件颜色
    componentDidMount() {
        this.interval = setInterval(this.getRandomColor, 500);
    }

    // 组件将要死亡时清除计时器
    componentWillUnmount() {
        clearInterval(this.interval);
    }

    render() {
        const { col } = this.state;
        let cardStyle = this.cardStyle;
        let cardBodyStyle = this.cardBodyStyle;
        let cardImgStyle = this.cardImgStyle;



        return (
            <div style={{ height: '100%', width: '100%' }}>
                {
                    this.cardArr.map(function (row) {
                        return <Row gutter={1}>
                        {
                            row.map(function (card) {
                                 return <Col span={8} >
                                        <Card title={card.name} style={cardStyle} bodyStyle={cardBodyStyle} extra={<a target="_blank" href={card.url}>查 看</a>}>
                                            <div className="custom-image">
                                                <a target="_blank" href={card.url}>
                                                    <img alt={card.remark} style={cardImgStyle} src={card.img} />
                                                </a>
                                            </div>
                                            <div className="custom-card">
                                                <p>{card.remark}</p>
                                            </div>
                                        </Card>
                                    </Col>
                            })
                        }
                        </Row>
                        
                    })
                }
            </div>
        )
    }
}