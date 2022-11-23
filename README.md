#tio-http
 
#技术栈
1. [tio-httpserver](https://git.oschina.net/tywo45/t-io)作http服务器
2. [JFinal] 使用jfinal 作为Dao 
3. [JFinal] 使用jfinal 的Enjoy 模板引擎
 

#初始化
ubuntu 系统安装 mariadb 
sudo apt-get install mariadb-plugin-rocksdb

1. 数据库配置在resources\app.properties，请修改密码
2. 初始化脚本在resources\sql\tio_site.sql，请执行一下

#启动
 

###启动方式二：源代码启动
 
1. 以普通java程序的方式运行org.tio.site.AppStarter即可，启动时间在1秒内， 如果大于1秒，那可能环境有问题
2. 访问[http://127.0.0.1]
 
#说明
1. 使用 JFinal作为Dao ，使用JFinal 模板引擎
