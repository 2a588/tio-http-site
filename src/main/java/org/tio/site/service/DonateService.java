package org.tio.site.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.site.init.JfinalInit;
import org.tio.site.model.Donate;
import org.tio.site.utils.EhcacheConst;

import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.SqlPara;
import com.jfinal.plugin.ehcache.CacheKit;

/**
 * @author tanyaowu 
 * 2017年7月22日 上午10:44:55
 */
public class DonateService {
	private static Logger log = LoggerFactory.getLogger(DonateService.class);
	public static final DonateService me = new DonateService();
	private final Donate dao = new Donate().dao();
	
	@SuppressWarnings("unchecked")
	public Page<Donate> page(int pageNumber, int pageSize) {
		String cacheName = EhcacheConst.CacheName.T_5;
		String cacheKey = "donate_page" + "_" + pageNumber + "_" + pageSize;
		Object obj = CacheKit.get(cacheName, cacheKey);
		if (obj != null) {
			return (Page<Donate>)obj;
		}
		
		SqlPara sqlPara = dao.getSqlPara("donate.page");
		Page<Donate> ret = dao.paginate(pageNumber, pageSize, sqlPara);
		CacheKit.put(cacheName, cacheKey, ret);
		return ret;
	}

	/**
	 * 
	 * @author: tanyaowu
	 */
	public DonateService() {
	}

	/**
	 * @param args
	 * @author: tanyaowu
	 */
	public static void main(String[] args) {
		JfinalInit.init();
		
		Page<Donate> page = DonateService.me.page(1, 10);
		System.out.println(page);
	}
}
