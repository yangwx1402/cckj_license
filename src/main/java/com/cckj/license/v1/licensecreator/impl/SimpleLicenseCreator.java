package com.cckj.license.v1.licensecreator.impl;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import com.cckj.license.v1.base.LicenseType;
import com.cckj.license.v1.bean.PrivateParam;
import com.cckj.license.v1.licensecreator.LicenseCreator;

import de.schlichtherle.license.LicenseContent;
/**
 * 简单的基于过期时间的license生成实现类
 * @author yangy
 *
 */
public class SimpleLicenseCreator extends LicenseCreator{
	
	public SimpleLicenseCreator(PrivateParam param) {
		super(param);
		this.param = param;
	}

	@Override
	protected LicenseContent createLicenseContent(Properties data) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        LicenseContent content = null;  
        content = new LicenseContent();  
        content.setSubject(this.getParam().getSUbject());  
        content.setHolder(DEFAULTHOLDERANDISSUER);  
        content.setIssuer(DEFAULTHOLDERANDISSUER);  
        try {  
            content.setIssued(format.parse(data.getProperty("issued")));
            content.setNotBefore(format.parse(data.getProperty("notbefore")));  
            content.setNotAfter(format.parse(data.getProperty("notafter")));  
        } catch (ParseException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        content.setConsumerType(data.getProperty("consumerType"));  
        content.setConsumerAmount(Integer.parseInt(data.getProperty("consumerAmount")));  
        content.setInfo(data.getProperty("info"));  
        // 扩展  
        content.setExtra(new Object());  
        return content;  
    
	}

	public static void main(String[] args) throws Exception {
		Properties data = new Properties();
		data.load(LicenseCreator.class.getResourceAsStream("/license.properties"));
		PrivateParam param = new PrivateParam("yangyong123", LicenseCreator.class, "/private_store", "default_alias", "yangzhi123", "oa_system");
		LicenseCreator creator = new SimpleLicenseCreator(param);
		creator.createLicense(LicenseType.simple, new File("F:\\key1.lic"), data);
	}
}
