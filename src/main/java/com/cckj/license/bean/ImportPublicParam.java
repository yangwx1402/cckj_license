package com.cckj.license.bean;
/**
 * 生成公钥库的参数类
 * @author yangy
 *
 */
public class ImportPublicParam {

	/**
	 * keytool -import -alias default_public -file default.cer -storepass
	 * yangyong123 -keystore public_store
	 */
	/**
	 * 公钥库别名
	 */
	private String alias = "default_public";
	/**
	 * 从私钥库中导出的公钥的路径
	 */
	private String cert_file = "default.cer";
	/**
	 * 私钥库密码
	 */
	private String storepass;
	/**
	 * 公钥库路径
	 */
	private String keystore = "public_store";
	
	public ImportPublicParam(String storepass){
		this.storepass = storepass;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getCert_file() {
		return cert_file;
	}

	public void setCert_file(String cert_file) {
		this.cert_file = cert_file;
	}

	public String getStorepass() {
		return storepass;
	}

	public void setStorepass(String storepass) {
		this.storepass = storepass;
	}

	public String getKeystore() {
		return keystore;
	}

	public void setKeystore(String keystore) {
		this.keystore = keystore;
	}
	
	
	
	
}
