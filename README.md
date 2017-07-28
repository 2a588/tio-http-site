#tio-site
##[t-io](https://git.oschina.net/tywo45/t-io)官网源代码:[http://112.74.183.177](http://112.74.183.177 "t-io官网")

#技术栈
1. [tio-httpserver](https://git.oschina.net/tywo45/t-io)作http服务器
2. [JFinal](https://git.oschina.net/jfinal/jfinal)作Dao工具
3. [Hutool](https://git.oschina.net/loolly/hutool)作日常工具
4. 前端用了react + webpack + vscode + antd等，接触前端不久，多多指教

#初始化
1. 数据库配置在resources\app.properties，请修改密码
2. 初始化脚本在resources\sql\tio_site.sql，请执行一下

#启动

###启动方式一：快速启动

1. 执行dist目录下的startup.bat即可
2. 访问[http://127.0.0.1](http://127.0.0.1)

###启动方式二：源代码启动
1. 导入工程到eclipse，注意把resources目录编译过去，否则会报错
2. 以普通java程序的方式运行org.tio.site.AppStarter即可，启动时间应该在1秒内，如果大于这个时间，那可能环境有问题
3. 访问[http://127.0.0.1](http://127.0.0.1)
#界面
![](https://git.oschina.net/tywo45/t-io/raw/master/docs/tio-site/1.png)
![](https://git.oschina.net/tywo45/t-io/raw/master/docs/tio-site/2.png)

#说明
1. 第一次用JFinal作为Dao，用得不对的地方，多多指教
2. 前端源代码在resources\page-src目录，多多指教