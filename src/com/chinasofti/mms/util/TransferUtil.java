package com.chinasofti.mms.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.sun.jmx.snmp.Timestamp;

import sun.misc.BASE64Encoder;

public class TransferUtil {
	
	// 获取UUID
	public String getUUID(){
		// 生成随机的UUID
		UUID uuid=UUID.randomUUID();
		// 转换成字符串
		String string=uuid.toString();
		// 去除横杠
		string=string.replaceAll("-", "");
		return string;
	}
	
	// 用于返回已加密的字符串
	public String getMD5(String str){
		String password=null;
		MessageDigest md;
		try {
			// 固定加密算法
			md=MessageDigest.getInstance("MD5");
			// 获取加密后的数组
			byte[] b=md.digest(str.getBytes());
			// 进行BASE64编码
			BASE64Encoder base64Encoder=new BASE64Encoder();
			// 将加密后的数组进行base64编码，转换成对应的字符串
			password=base64Encoder.encode(b);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return password;
	}
	
	public String formatDate(Date date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}

}
