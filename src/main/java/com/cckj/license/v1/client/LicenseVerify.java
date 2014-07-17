package com.cckj.license.v1.client;

import java.io.File;

import com.cckj.license.v1.client.bean.PublicParam;
/**
 * license验证类
 * @author yangy
 *
 */
public class LicenseVerify {

	private PublicParam param;

	public LicenseVerify(PublicParam param, String licPath) throws Exception {
		this(param,new File(licPath));
	}

	public LicenseVerify(PublicParam param, File licFile) throws Exception {
		this.param = param;
		install(licFile);
	}

	private void install(File licFile) throws Exception {
		LicenseManagerClient.getLicenseManager(param.bulidLicenseParams())
				.install(licFile);
	}

	public boolean verify() {
		/************** 证书使用者端执行 ******************/
		// 验证证书
		try {
			LicenseManagerClient.getLicenseManager(param.bulidLicenseParams())
					.verify();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		PublicParam publicParam = new PublicParam("xhspublic123", LicenseVerify.class, "/public.store", "xinhuashe_public", "xinhuashe");
		LicenseVerify verify = new LicenseVerify(publicParam,"F:\\mac.license");
		for(int i=0;i<1000;i++){
		long now = System.currentTimeMillis();
		System.out.println(verify.verify()+",time -"+(System.currentTimeMillis()-now));
		}
	}
}
