package com.cckj.license.tool;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
/**
 * 获取mac地址
 * @author yangy
 *
 */
public class GetLocalMac {

	public static String getMacAddress(String host)  
    {  
        String mac = "";  
        StringBuffer sb = new StringBuffer();  
          
        try   
        {  
            NetworkInterface ni = NetworkInterface.getByInetAddress(InetAddress.getByName(host));  
              
            byte[] macs = ni.getHardwareAddress();  
              
            for(int i=0; i<macs.length; i++)  
            {  
                mac = Integer.toHexString(macs[i] & 0xFF);   
                  
                 if (mac.length() == 1)   
                 {   
                     mac = '0' + mac;   
                 }   
  
                sb.append(mac + "-");  
            }  
                          
        } catch (SocketException e) {  
            e.printStackTrace();  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        }  
          
        mac = sb.toString();  
        mac = mac.substring(0, mac.length()-1);  
          
        return mac;  
    }  
	
	public static void main(String[] args) {
		GetLocalMac mac = new GetLocalMac();
		System.out.println(mac.getMacAddress("192.168.0.109"));
	}
}
