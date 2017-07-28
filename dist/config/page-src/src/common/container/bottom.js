import React from 'react'
import { Layout } from 'antd'
import './bottom.less'

const { Footer } = Layout

export default class Bottom extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            // timer: 0
        }
    }

    // tick = () => {
    //     this.setState({ timer:this.state.timer + 1 });
    // }

    // 组件渲染后开始循环执行tick函数
    componentDidMount() {
        //this.interval = setInterval(this.tick, 1000);
    }

    // 组件将要死亡时清除计时器，不清除也可以
    componentWillUnmount() {
        //clearInterval(this.interval);
    }

    render() {
        return (
            <Footer className="bottom" style={{padding:"10px"}}>
                <div className="text">
                    <span>© 2017 t-io</span>
                </div>
            </Footer>
        );
    }
}