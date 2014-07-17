package com.cckj.license.v1.bean;

import java.util.prefs.Preferences;

import de.schlichtherle.license.CipherParam;
import de.schlichtherle.license.DefaultCipherParam;
import de.schlichtherle.license.DefaultKeyStoreParam;
import de.schlichtherle.license.DefaultLicenseParam;
import de.schlichtherle.license.KeyStoreParam;
import de.schlichtherle.license.LicenseParam;
/**
 * 私钥库信息参数类
 * @author yangy
 *
 */
public class PrivateParam {

	public PrivateParam(String privateStorepwd, Class licenseCreatorClassLoad,
			String privatePath, String privateAlias, String codeCreatePwd,
			String subject) {
		super();
		this.privateStorepwd = privateStorepwd;
		LicenseCreatorClassLoad = licenseCreatorClassLoad;
		this.privatePath = privatePath;
		this.privateAlias = privateAlias;
		this.codeCreatePwd = codeCreatePwd;
		this.subject = subject;
	}

	private LicenseParam param;

	/**
	 * 私钥库密码
	 */
	private String privateStorepwd;
	/**
	 * licenseManager类对象
	 */
	private Class LicenseCreatorClassLoad;
	/**
	 * 私钥库路径
	 */
	private String privatePath;
	/**
	 * 私钥库别名
	 */
	private String privateAlias;
	/**
	 * 加密密码
	 */
	private String codeCreatePwd;
	/**
	 * 主题
	 */
	private String subject;

	public String getPrivateStorepwd() {
		return privateStorepwd;
	}

	public void setPrivateStorepwd(String privateStorepwd) {
		this.privateStorepwd = privateStorepwd;
	}

	public Class getLicenseCreatorClassLoad() {
		return LicenseCreatorClassLoad;
	}

	public void setLicenseCreatorClassLoad(Class licenseCreatorClassLoad) {
		LicenseCreatorClassLoad = licenseCreatorClassLoad;
	}

	public String getPrivatePath() {
		return privatePath;
	}

	public void setPrivatePath(String privatePath) {
		this.privatePath = privatePath;
	}

	public String getPrivateAlias() {
		return privateAlias;
	}

	public void setPrivateAlias(String privateAlias) {
		this.privateAlias = privateAlias;
	}

	public String getCodeCreatePwd() {
		return codeCreatePwd;
	}

	public void setCodeCreatePwd(String codeCreatePwd) {
		this.codeCreatePwd = codeCreatePwd;
	}

	public String getSUbject() {
		return subject;
	}

	public void setSUbject(String subject) {
		this.subject = subject;
	}

	public LicenseParam bulidLicenseParam() throws Exception {
		if (param == null) {
			Preferences preference = Preferences
					.userNodeForPackage(LicenseCreatorClassLoad);
			CipherParam cipherParam = new DefaultCipherParam(privateStorepwd);
			KeyStoreParam privateStoreParam = new DefaultKeyStoreParam(
					LicenseCreatorClassLoad, privatePath, privateAlias,
					privateStorepwd, codeCreatePwd);
			param = new DefaultLicenseParam(subject, preference,
					privateStoreParam, cipherParam);
		}
		return param;
	}
}
