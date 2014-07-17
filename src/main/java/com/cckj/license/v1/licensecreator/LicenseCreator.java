package com.cckj.license.v1.licensecreator;

import java.io.File;
import java.util.Properties;

import javax.security.auth.x500.X500Principal;

import com.cckj.license.v1.base.LicenseManagerHolder;
import com.cckj.license.v1.base.LicenseType;
import com.cckj.license.v1.bean.PrivateParam;

import de.schlichtherle.license.LicenseContent;
/**
 * license生成基类
 * @author yangy
 *
 */
public abstract class LicenseCreator {

	protected final static X500Principal DEFAULTHOLDERANDISSUER = new X500Principal(  
            "CN=client,OU=cckj,O=cckj,C=86");
	
	public PrivateParam getParam() {
		return param;
	}

	public LicenseCreator(PrivateParam param){
		this.param = param;
	}
	
	protected PrivateParam param;
	
	protected abstract LicenseContent createLicenseContent(Properties data) throws Exception;
	
	public void createLicense(LicenseType type,File keyFile,Properties data) throws Exception{
		LicenseContent content = createLicenseContent(data);
		LicenseManagerHolder.getLicenseManager(param.bulidLicenseParam(), type).store(content, keyFile);
	}
}
