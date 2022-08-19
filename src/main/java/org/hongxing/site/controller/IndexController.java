package org.hongxing.site.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.server.annotation.RequestPath;
import org.tio.http.server.util.Resps;


@RequestPath(value = "/index")
public class IndexController {
	private static Logger log = LoggerFactory.getLogger(IndexController.class);

	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}

	String html = "<div style='position:relation;border-radius:10px;" +
			"text-align:center;padding:10px;font-size:40pt;font-weight:bold;background-color:##e4eaf4;" +
			"color:#2d8cf0;border:0px solid #2d8cf0; " +
			"width:600px;height:400px;margin:auto;box-shadow: 1px 1px 50px #000;position: fixed;" +
			"top:0;left:0;right:0;bottom:0;'>"
			+ "<a style='text-decoration:none' href='https://gitee.com/tywo45/t-io' target='_blank'>"
			+ "<div style='text-shadow: 8px 8px 8px #99e;'> index  首页  html  index / </div>"
			+ "</a>" + "</div>";

	String txt = html;

	/**
	 *
	 * @author tanyaowu
	 */
	public IndexController() {
	}

	@RequestPath(value = "")
	public HttpResponse defult2(HttpRequest request) throws Exception {
		String html2 = "index 首页 html index not / ";
		HttpResponse ret = Resps.html(request, html2);
		return ret;
	}


	@RequestPath(value = "/")
	public HttpResponse defult(HttpRequest request) throws Exception {
		HttpResponse ret = Resps.html(request, html);
		return ret;
	}

	@RequestPath(value = "/index.html")
	public HttpResponse index(HttpRequest request) throws Exception {
		HttpResponse ret = Resps.html(request, html);
		return ret;
	}

	 
}
