package org.hongxing.site;

import org.hongxing.site.init.HttpServerInit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.utils.jfinal.P;

import java.io.IOException;


public class HttpServerShowcaseStarter {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(HttpServerShowcaseStarter.class);

	/**
	 * @param args
	 * @author tanyaowu
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {

		P.use("app23.properties");
		HttpServerInit.init();
	}

	/**
	 *
	 * @author tanyaowu
	 */
	public HttpServerShowcaseStarter() {
	}
}
