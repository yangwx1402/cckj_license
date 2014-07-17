package com.cckj.license.v1.client;

import com.cckj.license.v1.base.licensemanager.BaseLicenseManager;

import de.schlichtherle.license.LicenseManager;
import de.schlichtherle.license.LicenseParam;

public class LicenseManagerClient {

	private static LicenseManager licenseManager;  
	
    public static synchronized LicenseManager getLicenseManager(LicenseParam licenseParams) {  
        if(licenseManager==null)
        	licenseManager = new BaseLicenseManager(licenseParams);
        return licenseManager;
    }  
}
