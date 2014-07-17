package com.cckj.license.bean;
/**
 * 用于导出公钥的参数类
 * @author yangy
 *
 */
public class ExportPublicParam {

	/**
	 * keytool -export -alias 别名(第一步中相同) -file certfile.cer -storepass yangyong123 -keystore privateKeys.store
	 */
	/**
	 * 私钥库别名
	 */
	private String alias = "default_alias";
	/**
	 * 导出公钥的路径
	 */
	private String export_file = "default.cer";
	/**
	 * 私钥库路径
	 */
	private String keystore = "private_store";
	/**
	 * 私钥库密码
	 */
	private String privateStorePass;
	
	public ExportPublicParam(String privateStorePass){
		this.privateStorePass = privateStorePass;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getExport_file() {
		return export_file;
	}

	public void setExport_file(String export_file) {
		this.export_file = export_file;
	}

	public String getKeystore() {
		return keystore;
	}

	public void setKeystore(String keystore) {
		this.keystore = keystore;
	}

	public String getPrivateStorePass() {
		return privateStorePass;
	}

	public void setPrivateStorePass(String privateStorePass) {
		this.privateStorePass = privateStorePass;
	}
	
	
}
