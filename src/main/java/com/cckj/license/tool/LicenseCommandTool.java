package com.cckj.license.tool;

import com.cckj.license.bean.ExportPublicParam;
import com.cckj.license.bean.ImportPublicParam;
import com.cckj.license.bean.PrivateCreateParam;

public class LicenseCommandTool {

	/**
	 * 获取生成私钥库命令
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public static String getCreatePrivateCommand(PrivateCreateParam param)
			throws Exception {
		if (param == null || param.getKeypass() == null
				|| param.getKeypass().trim().equals("")
				|| param.getStore_pass() == null
				|| param.getStore_pass().trim().equals("")
				|| param.getDname() == null
				|| param.getDname().trim().equals(""))
			throw new Exception(
					"param or param.keypass or param.storepass or param.dname is not null or \"\"");
		StringBuffer cmd = new StringBuffer();
		cmd.append("keytool -genkey -v -alias " + param.getAlias()
				+ "  -keysize "
				+ param.getKeysize() + " -validity " + param.getValidity()
				+ " ");
		cmd.append("-keystore " + param.getPrivate_store() + " ");
		cmd.append("-keypass " + param.getKeypass() + " -storepass "
				+ param.getStore_pass() + " ");
		cmd.append("-dname " + param.getDname() + "");
		return cmd.toString();
	}

	/**获取导出公钥命令
	 * keytool -export -alias 别名(第一步中相同) -file certfile.cer -storepass
	 * yangyong123 -keystore privateKeys.store
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public static String getExportPublicCommand(ExportPublicParam param)
			throws Exception {
		if (param == null || param.getPrivateStorePass() == null
				|| param.getPrivateStorePass().trim().equals(""))
			throw new Exception(
					"param or param.keypass or param.storepass or param.dname is not null or \"\"");
		StringBuffer command = new StringBuffer();
		command.append("keytool -export -alias " + param.getAlias() + " -file "
				+ param.getExport_file() + " -storepass "
				+ param.getPrivateStorePass() + " -keystore "
				+ param.getKeystore());
		return command.toString();
	}

	/**获取导入公钥密码
	 * keytool -import -alias default_public -file default.cer -storepass
	 * yangyong123 -keystore public_store
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public static String getImportPublicCommand(ImportPublicParam param)
			throws Exception {
		if (param == null || param.getStorepass() == null
				|| param.getStorepass().trim().equals(""))
			throw new Exception(
					"param or param.keypass or param.storepass or param.dname is not null or \"\"");
		StringBuffer command = new StringBuffer();
		command.append("keytool -import -alias " + param.getAlias() + " -file "
				+ param.getCert_file() + " -storepass " + param.getStorepass()
				+ " -keystore " + param.getKeystore());
		return command.toString();
	}
}
