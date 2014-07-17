package com.cckj.license.bean;
/**
 * 创建私钥库参数类
 * @author yangy
 *
 */
public class PrivateCreateParam {
/**
 * cmd.append("keytool -genkey -v -alias weblogicssl -keyalg RSA -keysize 1024 -validity 365 ");  
	    cmd.append("-keystore C:/weblogic.jks ");  
	    cmd.append("-keypass 123456789 -storepass 123456789 ");  
	    cmd.append("-dname \"CN=localhost,OU=cn,O=cn,L=cn,ST=cn,C=cn\""); 
 */
	/**
	 * 私钥别名
	 */
	private String alias = "default_alias";
	
	private String keyalg = "RSA";
	
	private int keysize = 1024;
	/**
	 * 有效期,单位是天
	 */
	private int validity = 3650;
	/**
	 * 私钥库路径
	 */
	private String private_store = "private_store";
	/**
	 * 公钥,私钥对加密密码
	 */
	private String keypass;
	/**
	 * 私钥库密码
	 */
	private String store_pass;
	/**
	 * 私钥库所有者信息CN=localhost, OU=cn, O=cn, L=cn, ST=cn, C=cn
	 */
	private String dname;

	public PrivateCreateParam(String keypass,String store_pass,String dname){
		this.keypass = keypass;
		this.store_pass = store_pass;
		this.dname = dname;
	}
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getKeyalg() {
		return keyalg;
	}

	public void setKeyalg(String keyalg) {
		this.keyalg = keyalg;
	}

	public int getKeysize() {
		return keysize;
	}

	public void setKeysize(int keysize) {
		this.keysize = keysize;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public String getPrivate_store() {
		return private_store;
	}

	public void setPrivate_store(String private_store) {
		this.private_store = private_store;
	}

	public String getKeypass() {
		return keypass;
	}

	public void setKeypass(String keypass) {
		this.keypass = keypass;
	}

	public String getStore_pass() {
		return store_pass;
	}

	public void setStore_pass(String store_pass) {
		this.store_pass = store_pass;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
}
