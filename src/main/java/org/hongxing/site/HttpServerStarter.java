package org.hongxing.site;

import org.hongxing.site.init.HttpServerInit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.utils.jfinal.P;

import java.io.IOException;


public class HttpServerStarter {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(HttpServerStarter.class);

	/**
	 * @param args
	 * @author tanyaowu
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		P.use("app1.properties");
		HttpServerInit.init();
	}

	/**
	 *
	 * @author tanyaowu
	 */
	public HttpServerStarter() {
	}
}
