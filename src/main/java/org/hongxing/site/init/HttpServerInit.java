package org.hongxing.site.init;

import org.hongxing.site.service.SiteIpStatListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpConfig;
import org.tio.http.common.handler.HttpRequestHandler;
import org.tio.http.server.handler.DefaultHttpRequestHandler;
import org.hongxing.site.HttpServerStarter;
import org.tio.server.TioServerConfig;
import org.tio.utils.SystemTimer;
import org.tio.utils.jfinal.P;
import org.tio.utils.time.Time;

/**
 * @author tanyaowu
 * 2017年7月19日 下午4:59:04
 */
public class HttpServerInit {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(HttpServerInit.class);

	public static HttpConfig httpConfig;

	public static HttpRequestHandler requestHandler;

	public static org.tio.http.server.HttpServerStarter httpServerStarter;

	public static TioServerConfig serverTioConfig;

	public static void init() throws Exception {

		long start = SystemTimer.currTime;

		int port = P.getInt("http.port");//启动端口
		String pageRoot = P.get("http.page");//html/css/js等的根目录，支持classpath:，也支持绝对路径
		httpConfig = new HttpConfig(port, null, null, null);
		httpConfig.setPageRoot(pageRoot);
		httpConfig.setMaxLiveTimeOfStaticRes(P.getInt("http.maxLiveTimeOfStaticRes"));
		httpConfig.setPage404(P.get("http.404"));
		httpConfig.setPage500(P.get("http.500"));
		httpConfig.setUseSession(false);
		httpConfig.setCheckHost(false);

		requestHandler = new DefaultHttpRequestHandler(httpConfig, HttpServerStarter.class);//第二个参数也可以是数组

		httpServerStarter = new org.tio.http.server.HttpServerStarter(httpConfig, requestHandler);

		//增加ip包 流量统计功能
		serverTioConfig = httpServerStarter.getTioServerConfig();
		serverTioConfig.setIpStatListener(SiteIpStatListener.me);
		serverTioConfig.ipStats.addDuration(Time.MINUTE_1 * 5);

		long end  = SystemTimer.currentTimeMillis();
		long iv = end - start;
		httpServerStarter.start(); //启动http服务器
		log.info("Tio Http Server启动完毕,耗时:{}ms,访问地址:http://127.0.0.1:{}", iv, port);

	}

}
