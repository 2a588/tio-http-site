package org.tio.site.init;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.tio.http.common.HttpConfig;
import org.tio.http.server.handler.DefaultHttpRequestHandler;
import org.tio.http.server.HttpServerStarter;
import org.tio.http.server.handler.DefaultHttpRequestHandler;
import org.tio.site.AppStarter;
import org.tio.site.utils.Threads;

import com.jfinal.kit.PropKit;
import org.tio.utils.SystemTimer;
import org.tio.utils.thread.pool.SynThreadPoolExecutor;


/**
 * @author tanyaowu 
 * 2017年7月19日 下午4:59:04
 */
public class HttpServerInit {
	private static Logger log = LoggerFactory.getLogger(HttpServerInit.class);

    public static HttpConfig httpServerConfig;

	public static DefaultHttpRequestHandler httpRequestHandler;

	public static HttpServerStarter httpServerStarter;

	/**
	 * 
	 * @author: tanyaowu
	 */
	public HttpServerInit() {
	}

	public static void init() throws Exception {
		long start =  SystemTimer.currentTimeMillis();
		PropKit.use("app.properties");
		
		int port = PropKit.getInt("http.port");//启动端口
		String pageRoot = PropKit.get("page.root");//html/css/js等的根目录，支持classpath:，也支持绝对路径
		String[] scanPackages = new String[] { AppStarter.class.getPackage().getName() };//tio mvc需要扫描的根目录包

		//pageRoot, port, scanPackages, null, Threads.tioExecutor, Threads.groupExecutor
		httpServerStarter = new HttpServerStarter(httpServerConfig,httpRequestHandler);
		//httpServerStarter.start(pageRoot, port, scanPackages, null, Threads.tioExecutor, Threads.groupExecutor);
		httpServerStarter.start();

		long end  = SystemTimer.currentTimeMillis();
		long iv = end - start;
		log.info("Tio Http Server启动完毕,耗时:{}ms,访问地址:http://127.0.0.1:{}", iv, port);
	}

	/**
	 * @param args
	 * @author: tanyaowu
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	}
}
