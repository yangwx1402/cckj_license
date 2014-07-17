package com.cckj.license.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {

	public static void mvFile(File from,File to) throws IOException{
		if(!from.exists())
			throw new IOException("--from path ["+from+"] is error");
		InputStream is = new FileInputStream(from);
		OutputStream os = new FileOutputStream(to);
		byte[] buffer = new byte[1024];
		while(is.read(buffer)!=-1){
			os.write(buffer);
			os.flush();
		}
		is.close();
		os.close();
	}
	
	public static boolean rmFile(File file){
		if(file.exists())
			return file.delete();
		return true;
	}
}
