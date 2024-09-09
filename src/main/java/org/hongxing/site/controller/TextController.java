package org.hongxing.site.controller;

import com.jfinal.kit.Kv;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.server.annotation.RequestPath;
import org.tio.http.server.util.Resps;


@RequestPath(value = "/txt")
public class TextController {
	private static Logger log = LoggerFactory.getLogger(TextController.class);

	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}

	String html = "<div style='position:relation;border-radius:10px;text-align:center;padding:10px;font-size:40pt;font-weight:bold;background-color:##e4eaf4;color:#2d8cf0;border:0px solid #2d8cf0; width:600px;height:400px;margin:auto;box-shadow: 1px 1px 50px #000;position: fixed;top:0;left:0;right:0;bottom:0;'>"
			+ "<a style='text-decoration:none' href='https://gitee.com/tywo45/t-io' target='_blank'>" + "<div style='text-shadow: 8px 8px 8px #99e;'>hello tio httpserver</div>"
			+ "</a>" + "</div>";

	String txt = html;

	/**
	 *
	 * @author tanyaowu
	 */
	public TextController() {
	}


	@RequestPath(value = "/")
	public HttpResponse defult(HttpRequest request) throws Exception {
		HttpResponse ret = Resps.html(request, html);
		return ret;
	}

	@RequestPath(value = "/index")
	public HttpResponse index(HttpRequest request) throws Exception {
		HttpResponse ret = Resps.html(request, html);
		return ret;
	}

	@RequestPath(value = "/index2")
	public HttpResponse index2(HttpRequest request) throws Exception {
		HttpResponse ret = Resps.html(request, html);
		Engine engine = Engine.create("myEngine");
		engine.setDevMode(true);
		engine.setToClassPathSourceFactory();
		Template template = engine.getTemplate("wxAppMsg.txt");
		String wxAppMsg = template.renderToString(Kv.by("toUser", "james"));

		engine = Engine.use("myEngine");
		return ret;
	}

	 
}
