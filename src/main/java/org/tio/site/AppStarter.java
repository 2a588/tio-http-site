package org.tio.site;

import java.io.IOException;

import com.alibaba.druid.filter.config.ConfigTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.site.init.HttpServerInit;
import org.tio.site.init.JfinalInit;

import com.jfinal.kit.PropKit;

/**
 * ab -c 10 -n 200000 -k http://127.0.0.1:9527/test/abtest
 * ab -c 20 -n 200000 -k http://127.0.0.1:9527/test/abtest
 * ab -c 40 -n 200000 -k http://127.0.0.1:9527/test/abtest
 * ab -c 60 -n 200000 -k http://127.0.0.1:9527/test/abtest
 * ab -c 80 -n 200000 -k http://127.0.0.1:9527/test/abtest
 * ab -c 100 -n 200000 -k http://127.0.0.1:9527/test/abtest
 * ab -c 200 -n 200000 -k http://127.0.0.1:9527/test/abtest
 * ab -c 300 -n 200000 -k http://127.0.0.1:9527/test/abtest
 * ab -c 400 -n 200000 -k http://127.0.0.1:9527/test/abtest
 * @author tanyaowu 
 * 2017年6月28日 下午5:34:04
 */
public class AppStarter {
	private static Logger log = LoggerFactory.getLogger(AppStarter.class);
	
//	public static Config conf = ConfigFactory.load("app.properties");
	

	/**
	 * 
	 * @author: tanyaowu
	 */
	public AppStarter() {
	}

	/**
	 * @param args
	 * @author: tanyaowu
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		PropKit.use("app.properties");
		JfinalInit.init();
		HttpServerInit.init();
	}
}
