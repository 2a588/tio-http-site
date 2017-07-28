import React from 'react';
import { Row, Col, Card, Timeline, Icon, Pagination } from 'antd';
import './index.less'

import SyntaxHighlighter from 'react-syntax-highlighter';
import { language } from 'react-syntax-highlighter/dist/styles';


export default class index extends React.Component {
    onChange = (page) => {
        console.log(page);
        this.setState({
            current: page,
        });
    }
    render() {
        return (
            <div style={{ height: '100%', width: '100%' }}>
                <Row gutter={1}>
                    <Col span={8} >
                        <Card title="适用场景" style={{ height: 260 }} bodyStyle={{fontSize:'10pt'}}>
                            <p>IM（官方提供了im例子，含web端）</p>
                            <p>实时监控</p>
                            <p>推送服务（已内置API）</p>
                            <p>游戏</p>
                            <p>物联网</p>
                            <p>RPC</p>
                        </Card>
                    </Col>
                    <Col span={8} >
                        <Card title="Maven" style={{ height: 260 }} bodyStyle={{fontSize:'10pt'}}>
                            <SyntaxHighlighter language='xml' style={language} showLineNumbers>
                                {"<dependency>\r\n"
                                    + "  <groupId>org.t-io</groupId>\r\n"
                                    + "  <artifactId>tio-core</artifactId>\r\n"
                                    + "  <version>1.7.2.v20170705-RELEASE</version>\r\n"
                                    + "</dependency>\r\n"}

                            </SyntaxHighlighter>


                        </Card>
                    </Col>
                    <Col span={8} >

                        <Card title="学习步骤" style={{ height: 260 }} bodyStyle={{fontSize:'10pt'}}>
                            <p><a href="https://git.oschina.net/tywo45/t-io" target="_blank">下 载</a></p>
                            <p><a href="https://my.oschina.net/talenttan/blog/889887" target="_blank">jdk bytebuffer</a>（会了的请忽略）</p>
                            <p><a href="https://my.oschina.net/talenttan/blog/884806" target="_blank">hello world</a></p>
                            <p><a href="https://git.oschina.net/tywo45/t-io/raw/master/docs/api/t-io-api.png" target="_blank">t-io全景API</a></p>
                            <p><a href="https://git.oschina.net/tywo45/t-io/tree/master/src/zoo/http" target="_blank">实战一</a>（用t-io实现的http server）</p>
                            <p><a href="https://git.oschina.net/tywo45/t-io/tree/master/src/zoo/websocket" target="_blank">实战二</a>（用t-io实现的websocket）</p>
                        </Card>
                    </Col>
                </Row>

                <Row gutter={1}>
                    <Col span={8} >
                        <Card title="众说t-io" style={{ height: 260 }} bodyStyle={{fontSize:'10pt'}}>
                            <p>
                                网论暴露人品，甄别网论暴露智商
                            </p>
                            <p>
                                <a href="https://my.oschina.net/yyxx9988/tweet/13485737" target="_blank">令人作呕的t-io</a>
                            </p>
                            <p>
                                <a href="http://www.oschina.net/question/2617937_2243270" target="_blank">对t-io的质疑</a>
                            </p>
                            <p>
                                <a href="https://my.oschina.net/u/2369298/blog/915435" target="_blank">30万长连接测试报告</a>
                            </p>
                            <p>
                                <a href="https://my.oschina.net/u/257950/blog/889256" target="_blank">Hello，t-io！请多关照</a>
                            </p>
                            <p>
                                <a href="https://my.oschina.net/u/2461727/blog/897548" target="_blank">t-io 入门篇（三）即时消息发送demo学习</a>
                            </p>
                            <p>
                                <a href="https://my.oschina.net/u/1168934/blog/864239" target="_blank">花十分钟时间给JFinal写了个t-io插件</a>
                            </p>
                        </Card>
                    </Col>
                    <Col span={8} >
                        <Card title="关于性能" style={{ height: 260 }} bodyStyle={{fontSize:'10pt'}}>
                            <p>
                                各位自行测试，不要相信网上关于t-io的各项性能数据，包括t-io作者本人提供的，你测出来是多少就是多少----号称秒发500万条聊天消息，可同时维持百万TCP长连接的t-io，你会测出怎样的数据，作者也很期待！测试步骤请移步：<a target="_blank" href="https://git.oschina.net/tywo45/t-io#性能测试步骤">性能测试步骤</a>
                            </p>
                        </Card>
                    </Col>
                    <Col span={8} >
                        <Card title="关于授权" style={{ height: 260 }} bodyStyle={{fontSize:'10pt'}}>
                            t-io以LGPL协议开放源代码，别问我能不能商用，LGPL说可以那就是可以的。要是免费的用着不放心或是不省心，那就花点钱请作者做你公司的业余技术顾问吧----房价暴涨、RMB变纸的年代，从事正当职业的作者，缺钱似乎也不丢人。
                        </Card>
                    </Col>
                </Row>

                <Row gutter={1}>
                    <Col span={8} >
                        <Card title="t-io公众号" style={{ height: 350 }} bodyStyle={{fontSize:'10pt'}}>
                            <div style={{textAlign:'center'}}>
                                <img src="https://git.oschina.net/tywo45/t-io/raw/master/docs/wechat/1.jpg"/>
                            </div>
                            
                        </Card>
                    </Col>
                    <Col span={8} >
                        <Card title="t-io官方QQ群" style={{ height: 350 }} bodyStyle={{fontSize:'10pt'}}>
                            目前只对有过一些接触的朋友进行开放，也接受内部推荐入群，暂不接受完全陌生的朋友，谢谢理解！
                        </Card>
                    </Col>
                    <Col span={8} >
                        <Card title="项目地址" style={{ height: 350 }} bodyStyle={{fontSize:'10pt'}}>
                            <div style={{textAlign:'center'}}>
                                <a target="_blank" href="https://git.oschina.net/tywo45/t-io">    
                                    <img src="https://git.oschina.net/tywo45/t-io/raw/master/docs/logo/logo.jpg" style={{width:250, height:250,   borderRadius:'100%'}}/>
                                </a>
                            </div>
                        </Card>
                    </Col>
                </Row>
            </div>
        )
    }
}