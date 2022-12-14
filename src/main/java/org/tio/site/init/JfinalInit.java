package org.tio.site.init;

import java.io.File;
import java.sql.Connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.site.model._MappingKit;

import com.alibaba.druid.filter.config.ConfigTools;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;

/**
 * @author tanyaowu 
 * 2017年7月19日 下午5:23:21
 */
public class JfinalInit {
	private static Logger log = LoggerFactory.getLogger(JfinalInit.class);

	/**
	 * 
	 * @author: tanyaowu
	 */
	public JfinalInit() {
	}

	public static DruidPlugin druidPlugin;

	public static void init() {
		try {
			PropKit.use("app.properties");
		} catch (Exception e2) {
			log.error(e2.toString(), e2);
		}

		try {
			final String URL = PropKit.get("db01.jdbc.url");
			final String USERNAME = PropKit.get("db01.jdbc.username");
			final String PASSWORD= PropKit.get("db01.jdbc.password");
//			try {
////				PASSWORD = ConfigTools.decrypt(PropKit.get("db01.jdbc.password"));
//			} catch (Exception e) {
//				throw new RuntimeException(e);
//			}
			final Integer INITIALSIZE = PropKit.getInt("db.jdbc.pool.initialSize");
			final Integer MIDIDLE = PropKit.getInt("db.jdbc.pool.minIdle");
			final Integer MAXACTIVEE = PropKit.getInt("db.jdbc.pool.maxActive");
			druidPlugin = new DruidPlugin(URL, USERNAME, PASSWORD);
			//		druidPlugin.setConnectionProperties(PropKit.get("connectionProperties"));
			druidPlugin.set(INITIALSIZE, MIDIDLE, MAXACTIVEE);
			druidPlugin.setFilters("stat,wall");
			druidPlugin.start();
		} catch (Exception e1) {
			log.error(e1.toString(), e1);
		}

		try {
			ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
			arp.setTransactionLevel(Connection.TRANSACTION_READ_COMMITTED);
			_MappingKit.mapping(arp);
			// 强制指定复合主键的次序，避免不同的开发环境生成在 _MappingKit 中的复合主键次序不相同
			arp.setPrimaryKey("document", "mainMenu,subMenu");
			//    me.add(arp);
			if (PropKit.getBoolean("devMode", false)) {
				arp.setShowSql(true);
			}
			arp.setBaseSqlTemplatePath(PathKit.getRootClassPath() + File.separator + PropKit.get("sqlfile"));
			//arp.addSqlTemplate("all_sqls.sql");
			arp.start();
		} catch (Exception e) {
			log.error(e.toString(), e);
		}

		try {
			EhCachePlugin ehCache = new EhCachePlugin();
			ehCache.start();
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
	}

	/**
	 * @param args
	 * @author: tanyaowu
	 */
	public static void main(String[] args) {

	}
}
