package org.tio.site.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseUserOsc<M extends BaseUserOsc<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setUserid(java.lang.Integer userid) {
		set("userid", userid);
	}

	public java.lang.Integer getUserid() {
		return get("userid");
	}

	public void setOscid(java.lang.String oscid) {
		set("oscid", oscid);
	}

	public java.lang.String getOscid() {
		return get("oscid");
	}

	public void setOscnick(java.lang.String oscnick) {
		set("oscnick", oscnick);
	}

	public java.lang.String getOscnick() {
		return get("oscnick");
	}

	public void setCreatetime(java.util.Date createtime) {
		set("createtime", createtime);
	}

	public java.util.Date getCreatetime() {
		return get("createtime");
	}

}
