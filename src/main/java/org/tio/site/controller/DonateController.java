package org.tio.site.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.http.common.*;
import org.tio.http.common.session.HttpSession;
import org.tio.http.server.annotation.RequestPath;
import org.tio.http.server.util.Resps;
import org.tio.site.model.Donate;
import org.tio.site.service.DonateService;

import com.jfinal.plugin.activerecord.Page;
import org.tio.utils.json.Json;

/**
 * @author tanyaowu 
 * 2017年7月22日 上午10:44:13
 */
@RequestPath(value = "/donate")
public class DonateController {
	private static Logger log = LoggerFactory.getLogger(DonateController.class);

	static final DonateService srv = DonateService.me;

	/**
	 * 
	 * @author: tanyaowu
	 */
	public DonateController() {
	}

	@RequestPath(value = "/page")
	public HttpResponse page(Integer pageNumber, Integer pageSize, HttpRequest httpRequestPacket, HttpConfig httpServerConfig,
			ChannelContext channelContext) throws Exception {
		Page<Donate> page = srv.page(pageNumber, pageSize);
		HttpResponse ret = Resps.json(httpRequestPacket, Json.toJson(page), httpServerConfig.getCharset());
		ret.addHeader(HeaderName.Access_Control_Allow_Origin,HeaderValue.from("Access-Control-Allow-Origin"));
		ret.addHeader(HeaderName.Access_Control_Allow_Headers ,HeaderValue.from("x-requested-with,content-type"));
		return ret;
	}

	/**
	 * @param args
	 * @author: tanyaowu
	 */
	public static void main(String[] args) {

	}
}
