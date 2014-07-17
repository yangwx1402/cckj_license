package com.cckj.license.v1.client.bean;

import java.util.prefs.Preferences;

import de.schlichtherle.license.CipherParam;
import de.schlichtherle.license.DefaultCipherParam;
import de.schlichtherle.license.DefaultKeyStoreParam;
import de.schlichtherle.license.DefaultLicenseParam;
import de.schlichtherle.license.KeyStoreParam;
import de.schlichtherle.license.LicenseParam;
/**
 * 公钥信息参数类
 * @author yangy
 *
 */
public class PublicParam {

	private String publicStorePwd;

	private Class licenseVerifyClassLoader;

	private String publicPath;

	private String publicAlias;

	private String subject;
	
	private LicenseParam param;

	public PublicParam(String publicStorePwd, Class licenseVerifyClassLoader,
			String publicPath, String publicAlias, String subject) {
		super();
		this.publicStorePwd = publicStorePwd;
		this.licenseVerifyClassLoader = licenseVerifyClassLoader;
		this.publicPath = publicPath;
		this.publicAlias = publicAlias;
		this.subject = subject;
	}

	public String getPublicStorePwd() {
		return publicStorePwd;
	}

	public void setPublicStorePwd(String publicStorePwd) {
		this.publicStorePwd = publicStorePwd;
	}

	public Class getLicenseVerifyClassLoader() {
		return licenseVerifyClassLoader;
	}

	public void setLicenseVerifyClassLoader(Class licenseVerifyClassLoader) {
		this.licenseVerifyClassLoader = licenseVerifyClassLoader;
	}

	public String getPublicPath() {
		return publicPath;
	}

	public void setPublicPath(String publicPath) {
		this.publicPath = publicPath;
	}

	public String getPublicAlias() {
		return publicAlias;
	}

	public void setPublicAlias(String publicAlias) {
		this.publicAlias = publicAlias;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public LicenseParam bulidLicenseParams() {
		if(param == null){
		Preferences preference = Preferences
				.userNodeForPackage(licenseVerifyClassLoader);
		CipherParam cipherParam = new DefaultCipherParam(publicStorePwd);

		KeyStoreParam privateStoreParam = new DefaultKeyStoreParam(
				licenseVerifyClassLoader, publicPath, publicAlias,
				publicStorePwd, null);
		 param = new DefaultLicenseParam(subject,
				preference, privateStoreParam, cipherParam);
		}
		return param;
	}
}
