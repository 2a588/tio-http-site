import React from 'react';
import { Route , Redirect} from 'react-router-dom'
import { Layout } from 'antd'
import './content.less'
import index from 'pages/index/index'
import mycase from 'pages/mycase/mycase'
import donate from 'pages/donate/donate'
import zoo from 'pages/zoo/zoo'
import qa from 'pages/qa/qa'
import contribute from 'pages/contribute/contribute'
import tiostore from 'pages/tiostore/tiostore'



const { Content } = Layout

export default class Contents extends React.Component {
  render() {
    return (
      <Content className="content">
        {/**<Redirect from="/" to="/index"/>**/}
        
        <Route exact path="/" component={index} />
        <Route exact path="/index" component={index} />
        <Route exact path="/mycase" component={mycase} />
        <Route exact path="/donate" component={donate} />
        <Route exact path="/zoo" component={zoo} />
        <Route exact path="/qa" component={qa} />
        <Route exact path="/contribute" component={contribute} />
        <Route exact path="/tiostore" component={tiostore} />

      </Content>
    );
  }
}