import React from 'react'
import { Row, Col, Card} from 'antd';
import './mycase.less'

export default class follow extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            col:'#666'
        }
        this.cardStyle={height: 420};
        this.cardImgStyle={height: 260, width:'100%'};
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
            ],
            [
                {
                    name:"扫码枪",
                    url:"https://my.oschina.net/u/556878",
                    img:"https://git.oschina.net/tywo45/t-io/raw/master/docs/blog/2-3.jpg",
                    remark:"扫码枪项目"
                },
                {
                    name:"农业灌溉项目",
                    url:"https://my.oschina.net/u/3224077",
                    img:"",
                    remark:"河北某地方的一个农业灌溉项目，生产项目，没有截图"
                },
                {
                    name:"某省移动公司CRM系统业务",
                    url:"https://my.oschina.net/u/2939390",
                    img:"",
                    remark:"某省移动公司CRM系统业务调用受理，这是个短连接项目，生产项目，没有截图"
                }
            ],
            [
                {
                    name:"温控设备",
                    url:"https://my.oschina.net/u/1168934/home",
                    img:"",
                    remark:"上线的项目服务器用的是tio框架，作为server端与温控设备（客户端）进行socket通讯，客户端是客户那边的硬件设备，有自己的协议实现，所以没有用到tio，tio帮我实现了自动重连和心跳检测，所以基本没什么事可以干了。上线两个月，一直很稳定。"
                },
                {
                    name:"燃气安全监测的平台",
                    url:"https://git.oschina.net/tywo45/t-io/raw/master/docs/case/359886056/1.png",
                    img:"https://git.oschina.net/tywo45/t-io/raw/master/docs/case/359886056/1.png",
                    remark:"燃气安全监测的平台"
                },
                {
                    name:"呼叫中心",
                    url:"",
                    img:"",
                    remark:"采用tio-httpserver, tio-websocket, tio-udp, tio-core, JFinal, Hutool等组成的全栈应用程序，没用Spring,也没用servlet框架，这是t-io作者自己的生产项目"
                }
            ],
            [
                {
                    name:"智能家居平台",
                    url:"https://git.oschina.net/tywo45/t-io/raw/master/docs/case/dendai/1.jpg",
                    img:"https://git.oschina.net/tywo45/t-io/raw/master/docs/case/dendai/1.jpg",
                    remark:"基于t-io的长连接服务器，为智能家居平台提供服务，实现了对智能设备的控制。"
                },
                {
                    name:"路灯控制器",
                    url:"",
                    img:"",
                    remark:"用的是最新版的。用来做路灯控制器后台的server。准生产项目，没有截图和其它说明（因为是从mina改造过来的，很快就能上线，所以就不从案例库中撤下来了）"
                },
                {
                    name:"更 多",
                    url:"https://www.oschina.net/p/t-io/comments",
                    img:"https://git.oschina.net/tywo45/t-io/raw/master/docs/case/qq/1.png",
                    remark:"不一一列举，t-io太稳定并且极易使用，导致很多用户的案例收集不到（没问题人家自然不找你），另外早期反馈的案例也找不到相关人员了，还有部分用户不愿意在这里展示其项目，请参考部分用户在tio软件收录地址上的留言和这个张截图，粗略推猜案例数。"
                }
            ],

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