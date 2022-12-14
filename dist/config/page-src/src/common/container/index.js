import React from 'react';
import { Link } from 'react-router-dom'
import { Menu, Icon, Switch, Layout } from 'antd'
import { allMenu } from 'utils/menu'
import Top from './header'
import Contents from './content'
import Footer from './bottom'
import './index.less'
import _ from 'lodash'

const SubMenu = Menu.SubMenu;
const { Sider } = Layout

export default class Container extends React.Component {
  state = {
    theme: 'dark',
    current: 'index',
    collapsed: false,
    mode: 'inline',  // 水平垂直展现
  }
  componentDidMount() {
    this.handleClick([], 'index')
  }
  changeTheme = (value) => {
    this.setState({
      theme: value ? 'dark' : 'light',
    });
  }
  toggle = () => {
    this.setState({
      collapsed: !this.state.collapsed,
      mode: this.state.collapsed ? 'inline' : 'vertical',
    });
  }
  clear = () => {
    this.setState({
      current: 'index',
    });
  }
  handleClick = (e, special) => {
    this.setState({
      current: e.key || special,
    });
  }
  render() {
    return (
      <Layout className="containAll">
        <Sider
          collapsible
          trigger={null}
          collapsed={this.state.collapsed}
          onCollapse={this.onCollapse}
          className="leftMenu"
        >


          { 
            <a href="https://git.oschina.net/tywo45/t-io" target='_blank'>
              <span className="author ">
                I love t-io
              </span>
            </a> 
          }

          <Menu
            theme={this.state.theme}
            onClick={this.handleClick}
            defaultOpenKeys={['']}
            selectedKeys={[this.state.current]}
            className="menu"
            mode={this.state.mode}
          >
            {
              allMenu.map((subMenu) => {
                if (subMenu.children && subMenu.children.length) {
                  return (
                    <SubMenu key={subMenu.url} title={<span><Icon type={subMenu.icon} /><span>{subMenu.name}</span></span>}>
                      {subMenu.children.map(menu => (
                        <Menu.Item key={menu.url}>
                          {
                            (_.startsWith(menu.url, "http://") || _.startsWith(menu.url, "https://"))
                            ? 
                            <a href={menu.url} target="_blank">{menu.name}</a>
                            : 
                            <Link to={`${menu.url}`}>{menu.name}</Link>
                          }
                        </Menu.Item>
                      ))}
                    </SubMenu>
                  )
                }
                return (
                  <Menu.Item key={subMenu.url}>
                    {
                      (_.startsWith(subMenu.url, "http://") || _.startsWith(subMenu.url, "https://"))
                      ? 
                      <a href={subMenu.url} target="_blank">{subMenu.name}</a>
                      : 
                      <Link to={`${subMenu.url}`}>
                        <Icon type={subMenu.icon} /><span className="nav-text">{subMenu.name}</span>
                      </Link>
                    }
                  </Menu.Item>
                )
              })
            }
          </Menu>

        </Sider>
        <Layout>
          <Top toggle={this.toggle} collapsed={this.state.collapsed} clear={this.clear} />
          <Contents />
          <Footer />
        </Layout>
      </Layout>
    );
  }
}