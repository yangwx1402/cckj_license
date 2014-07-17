package com.cckj.license.v1.example;

import java.io.File;
import java.util.Properties;

import com.cckj.license.bean.ExportPublicParam;
import com.cckj.license.bean.ImportPublicParam;
import com.cckj.license.bean.PrivateCreateParam;
import com.cckj.license.tool.CommandExecutor;
import com.cckj.license.tool.FileUtils;
import com.cckj.license.tool.LicenseCommandTool;
import com.cckj.license.v1.base.LicenseType;
import com.cckj.license.v1.bean.PrivateParam;
import com.cckj.license.v1.client.LicenseVerify;
import com.cckj.license.v1.client.bean.PublicParam;
import com.cckj.license.v1.licensecreator.LicenseCreator;
import com.cckj.license.v1.licensecreator.impl.MacLicenseCreator;

public class LicenseExample {

	public static void main(String[] args) throws Exception {
		//编码方式
		String encode = "gb2312";
		//秘钥别名
		String privateAlias = "jetyun_private";
		//秘钥过期时间
		int validity = 3650;
        //生成公钥秘钥对的密码		
		String keyPass = "xinhuashe123";
		//Dname就是名字,公司,组织,location等信息
		String dname = "\"CN=localhost,OU=cn,O=cn,L=cn,ST=cn,C=cn\"";
		//秘钥库密码
		String privateStorePass = "jetyun123";
		//秘钥库存放路径
		String privateStorePath = "F:\\private.store";
		//license主题
		String subjuct = "xinhuashe";
		//导出公钥路径
		String publicKeyPath = "F:\\public.cer";
		//公钥库路径
		String publicStorePath = "F:\\public.store";
		//公钥别名
		String publicAlias = "xinhuashe_public";
		/**
		 * 生成一个秘钥库
		 */
	    PrivateCreateParam param = new PrivateCreateParam(keyPass,privateStorePass , dname);
	    param.setAlias(privateAlias);
	    param.setValidity(validity);
	    param.setPrivate_store(privateStorePath);
	    String command = LicenseCommandTool.getCreatePrivateCommand(param);
	    System.out.println("create private store command ["+command+"]");
	    StringBuffer result = CommandExecutor.execute(command,encode);
	    System.out.println("create private store result ["+result.toString()+"]");
	    System.out.println();
	    /**
	     * 导出秘钥库中的公钥
	     */
	    ExportPublicParam export = new ExportPublicParam(privateStorePass);
	    export.setExport_file(publicKeyPath);
	    export.setKeystore(privateStorePath);
	    export.setAlias(privateAlias);
	    String exportCommand = LicenseCommandTool.getExportPublicCommand(export);
	    System.out.println("export public key command ["+exportCommand+"]");
	    StringBuffer exportResult = CommandExecutor.execute(exportCommand,encode);
	    System.out.println("export public key result["+exportResult.toString()+"]");
	    System.out.println();
	    
	    /**
	     * 讲公钥导入到公钥库中
	     */
	    ImportPublicParam improtParam = new ImportPublicParam(privateStorePass);
	    improtParam.setKeystore(publicStorePath);
	    improtParam.setCert_file(publicKeyPath);
	    improtParam.setAlias(publicAlias);
	    String importCommand = LicenseCommandTool.getImportPublicCommand(improtParam);
	    System.out.println("create public store command ["+importCommand+"]");
	    StringBuffer importResult = CommandExecutor.execute(importCommand,"y",encode);
	    System.out.println("create public store result ["+importResult.toString()+"]");
	    FileUtils.rmFile(new File(publicKeyPath));
	    /**
	     * 讲公钥库和私钥库导入到classpath
	     */
	    String path = LicenseExample.class.getResource("/").getPath()+File.separator;
	    File privateStoreFile = new File(privateStorePath);
	    File publicStoreFile = new File(publicStorePath);
	    File privateStoreDest = new File(path,privateStoreFile.getName());
	    File publicStoreDest = new File(path,publicStoreFile.getName());
	    /**
	     * 将私钥库到如到classpath
	     */
	    FileUtils.mvFile(privateStoreFile, privateStoreDest);
	    FileUtils.rmFile(privateStoreFile);
	    //生成证书
	    Properties data = new Properties();
		data.load(LicenseCreator.class
				.getResourceAsStream("/license.properties"));
		PrivateParam privateParam = new PrivateParam(privateStorePass,
				LicenseCreator.class, "/"+privateStoreDest.getName(), privateAlias,
				keyPass, subjuct);
		
		File licensePath = new File("F:\\mac.license");
		LicenseCreator creator = new MacLicenseCreator(privateParam);
		//生成一个可以验证mac地址和ip地址的license
		creator.createLicense(LicenseType.mac, licensePath, data);
	    
		/**
		 * 将公钥库导入到classpath
		 */
		FileUtils.mvFile(publicStoreFile, publicStoreDest);
		FileUtils.rmFile(publicStoreFile);
	    PublicParam publicParam = new PublicParam(privateStorePass, LicenseVerify.class, "/"+publicStoreDest.getName(), publicAlias, subjuct);
		//加载license
	    LicenseVerify verify = new LicenseVerify(publicParam,licensePath);
		//验证1000次,貌似时间还挺快
		for(int i=0;i<1000;i++){
		long now = System.currentTimeMillis();
		System.out.println(verify.verify()+",time -"+(System.currentTimeMillis()-now));
		}
	}
}
