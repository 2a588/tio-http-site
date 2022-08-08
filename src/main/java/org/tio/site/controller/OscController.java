package org.tio.site.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.http.common.*;
import org.tio.http.server.annotation.RequestPath;
import org.tio.http.server.util.Resps;

/**
 * @author tanyaowu 
 * 2017年6月29日 下午7:53:59
 */
@RequestPath(value = "/osc")
public class OscController {
	private static Logger log = LoggerFactory.getLogger(OscController.class);

	/**
	 * 
	 * @author: tanyaowu
	 */
	public OscController() {
	}

	@RequestPath(value = "/cb")
	public HttpResponse json(HttpRequest httpRequestPacket, HttpConfig httpServerConfig, ChannelContext channelContext)
			throws Exception {
		HttpResponse ret = Resps.json(httpRequestPacket, "ok", httpServerConfig.getCharset());
		return ret;
	}

	/**
	 *
	 * @author: hong.chen
	 */
	@RequestPath(value = "")
	public HttpResponse main(HttpRequest httpRequestPacket, HttpConfig httpServerConfig, ChannelContext channelContext) throws Exception {
		HttpResource body =  httpServerConfig.getResource(httpRequestPacket,"/page/index.html");
		HttpResponse ret2 = Resps.json(httpRequestPacket, "222222ok", httpServerConfig.getCharset());
		HttpResponse ret = Resps.html(httpRequestPacket, String.valueOf(body), httpServerConfig.getCharset());
		return ret;
	}
}
