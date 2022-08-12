package org.hongxing.site.model;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseBlog<M extends BaseBlog<M>> extends Model<M> implements IBean {

	public void setId(Integer id) {
		set("id", id);
	}

	public Integer getId() {
		return get("id");
	}

	public void setLoginname(String loginname) {
		set("loginname", loginname);
	}

	public String getLoginname() {
		return get("loginname");
	}

	public void setPwd(String pwd) {
		set("pwd", pwd);
	}

	public String getPwd() {
		return get("pwd");
	}

	public void setSalt(String salt) {
		set("salt", salt);
	}

	public String getSalt() {
		return get("salt");
	}

	public void setNick(String nick) {
		set("nick", nick);
	}

	public String getNick() {
		return get("nick");
	}

	public void setAvatar(String avatar) {
		set("avatar", avatar);
	}

	public String getAvatar() {
		return get("avatar");
	}

	public void setIp(String ip) {
		set("ip", ip);
	}

	public String getIp() {
		return get("ip");
	}

	public void setCreatetime(java.util.Date createtime) {
		set("createtime", createtime);
	}

	public java.util.Date getCreatetime() {
		return get("createtime");
	}

	public void setStatus(Integer status) {
		set("status", status);
	}

	public Integer getStatus() {
		return get("status");
	}

}