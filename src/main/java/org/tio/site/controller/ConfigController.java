package org.tio.site.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.http.common.HttpPacket;
import org.tio.http.common.session.HttpSession;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.common.HttpConfig;
import org.tio.http.server.annotation.RequestPath;
import org.tio.http.server.util.Resps;

import com.jfinal.kit.PropKit;

/**
 * @author tanyaowu 
 * 2017年6月29日 下午7:53:59
 */
@RequestPath(value = "/config")
public class ConfigController {
	private static Logger log = LoggerFactory.getLogger(ConfigController.class);

	/**
	 * 
	 * @author: tanyaowu
	 */
	public ConfigController() {
	}

	@RequestPath(value = "/update")
	public HttpResponse json(HttpRequest httpRequestPacket, HttpConfig httpServerConfig, ChannelContext channelContext)
			throws Exception {
//		AppStarter.conf = ConfigFactory.load("app.conf");
		PropKit.useless("app.properties");
		PropKit.use("app.properties", "utf-8");
		HttpResponse ret = Resps.json(httpRequestPacket, "更新成功", httpServerConfig.getCharset());
		return ret;
	}

	/**
	 * @param args
	 * @author: tanyaowu
	 */
	public static void main(String[] args) {

	}
}
