package com.cckj.license.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
/**
 * 命令执行器
 * @author yangy
 *
 */
public class CommandExecutor {

	public static StringBuffer execute(String command,String encode) throws IOException{
	    Process ps = Runtime.getRuntime().exec(command.toString());
	    BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream(),encode));
	    String line = null;
	    StringBuffer sb = new StringBuffer();
	    while((line=br.readLine())!=null){
	    	sb.append(line);
	    }
	    ps.destroy();
	    return sb;
	}
	
	public static StringBuffer execute(String command,String yesOrNo,String encode) throws IOException{
		 Process ps = Runtime.getRuntime().exec(command.toString());
		 PrintWriter pw = new PrintWriter(ps.getOutputStream());
		 pw.println(yesOrNo+"\n");
		 pw.flush();
		 BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream(),encode));
		    String line = null;
		    StringBuffer sb = new StringBuffer();
		    while((line=br.readLine())!=null){
		    	sb.append(line);
		    }
		    ps.destroy();
		    return sb;
	}

	public static void main(String[] args) throws Exception {
		
	}
}
