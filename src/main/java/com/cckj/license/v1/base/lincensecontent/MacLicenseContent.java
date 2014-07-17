package com.cckj.license.v1.base.lincensecontent;

import de.schlichtherle.license.LicenseContent;
/**
 * 带有mac地址和ip的license信息类
 * @author yangy
 *
 */
public class MacLicenseContent extends LicenseContent{

	private String macAddress;
	
	private String ipAddress;



	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	
}
