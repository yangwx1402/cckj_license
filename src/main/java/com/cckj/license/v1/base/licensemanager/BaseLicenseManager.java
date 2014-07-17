package com.cckj.license.v1.base.licensemanager;

import com.cckj.license.tool.GetLocalMac;
import com.cckj.license.v1.base.lincensecontent.MacLicenseContent;

import de.schlichtherle.license.LicenseContent;
import de.schlichtherle.license.LicenseContentException;
import de.schlichtherle.license.LicenseManager;
import de.schlichtherle.license.LicenseParam;
/**
 * 基本的license管理器
 * @author yangy
 *
 */
public class BaseLicenseManager extends LicenseManager {

	public BaseLicenseManager(LicenseParam param) {
		super(param);
	}

	/**
	 * 验证license
	 */
	@Override
	protected synchronized void validate(LicenseContent content)
			throws LicenseContentException {
		MacLicenseContent mac = null;
		String macAddress = null;
		String ipAddress = null;
		if (content instanceof MacLicenseContent) {
			mac = (MacLicenseContent) content;
			macAddress = mac.getMacAddress();
			ipAddress = mac.getIpAddress();
			if (macAddress == null || ipAddress == null)
				throw new LicenseContentException("mac or ip is null");
			if (!macAddress.equalsIgnoreCase(GetLocalMac
					.getMacAddress(ipAddress))) {
				throw new LicenseContentException(" you mac is wrong!");
			}
		}
		super.validate(content);

	}
}
