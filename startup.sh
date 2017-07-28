#-Xverify:none -Djava.nio.channels.spi.SelectorProvider=sun.nio.ch.EPollSelectorProvider
#-Xrunjdwp:transport=dt_socket,address=8888,suspend=n,server=y

nohup java -Xverify:none -Xms64m -Xmx256m -XX:+HeapDumpOnOutOfMemoryError -Dtio.default.read.buffer.size=1024 -XX:HeapDumpPath=./tio-site-pid.hprof -cp ./config:./lib/* org.tio.site.AppStarter &