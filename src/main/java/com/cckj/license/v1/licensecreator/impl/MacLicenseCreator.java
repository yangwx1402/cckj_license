package com.cckj.license.v1.licensecreator.impl;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import com.cckj.license.v1.base.LicenseType;
import com.cckj.license.v1.base.lincensecontent.MacLicenseContent;
import com.cckj.license.v1.bean.PrivateParam;
import com.cckj.license.v1.licensecreator.LicenseCreator;

import de.schlichtherle.license.LicenseContent;
/**
 * 带有mac地址和ip地址的license生成器实现
 * @author yangy
 *
 */
public class MacLicenseCreator extends LicenseCreator {

	public MacLicenseCreator(PrivateParam param) {
		super(param);
		this.param = param;
	}

	@Override
	protected LicenseContent createLicenseContent(Properties data) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		MacLicenseContent content = null;
		content = new MacLicenseContent();
		content.setSubject(this.getParam().getSUbject());
		content.setHolder(DEFAULTHOLDERANDISSUER);
		content.setIssuer(DEFAULTHOLDERANDISSUER);
		try {
			content.setIssued(format.parse(data.getProperty("issued")));
		} catch (ParseException e) {
			throw new Exception("issued 时间格式不正确,正确的格式为yyyy-MM-dd");
		}
		try {
			content.setNotBefore(format.parse(data.getProperty("notbefore")));
		} catch (ParseException e) {
			throw new Exception("notbefore 时间格式不正确,正确的格式为yyyy-MM-dd");
		}
		try {
			content.setNotAfter(format.parse(data.getProperty("notafter")));
		} catch (ParseException e) {
			throw new Exception("notafter 时间格式不正确,正确的格式为yyyy-MM-dd");
		}
		content.setConsumerType(data.getProperty("consumerType"));
		content.setConsumerAmount(Integer.parseInt(data
				.getProperty("consumerAmount")));
		content.setInfo(data.getProperty("info"));
		if(data.containsKey("mac")&&data.get("mac")!=null&&!data.get("mac").toString().trim().equals("")){
		content.setMacAddress(data.getProperty("mac"));
		}else{
			throw new Exception("mac 地址不能为空");
		}
		if(data.containsKey("ip")&&data.get("ip")!=null&&!data.get("ip").toString().trim().equals("")){
		content.setIpAddress(data.getProperty("ip"));
		}else{
			throw new Exception("ip 地址不能为空");
		}
		// 扩展
		content.setExtra(new Object());
		return content;
	}

	public static void main(String[] args) throws Exception {
		Properties data = new Properties();
		data.load(LicenseCreator.class
				.getResourceAsStream("/license.properties"));
		PrivateParam param = new PrivateParam("jetyun123",
				LicenseCreator.class, "/private.store", "default_alias",
				"jetyun123", "jetyun");
		LicenseCreator creator = new MacLicenseCreator(param);
		creator.createLicense(LicenseType.mac, new File("F:\\mac.lic"), data);
	}
}
