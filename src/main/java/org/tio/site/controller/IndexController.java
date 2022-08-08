package org.tio.site.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.http.common.HttpConfig;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.server.annotation.RequestPath;
import org.tio.http.server.util.Resps;

/**
 * @author tanyaowu 
 * 2017年6月29日 下午7:53:59
 */
@RequestPath(value = "/index")
public class IndexController {
	private static Logger log = LoggerFactory.getLogger(IndexController.class);

	/**
	 *
	 * @author: tanyaowu
	 */
	public IndexController() {

	}

	@RequestPath(value = "/cb")
	public HttpResponse json(HttpRequest httpRequestPacket, HttpConfig httpServerConfig, ChannelContext channelContext)
			throws Exception {
		HttpResponse ret = Resps.json(httpRequestPacket, "ok", httpServerConfig.getCharset());
		return ret;
	}

	@RequestPath(value = "/cb2")
	public HttpResponse json2(HttpRequest httpRequestPacket, HttpConfig httpServerConfig, ChannelContext channelContext)
			throws Exception {
		HttpResponse ret = Resps.json(httpRequestPacket, "ok", httpServerConfig.getCharset());
		return ret;
	}


	/**
	 * @param args
	 * @author: tanyaowu
	 */
	public static void main(String[] args) {

	}
}
