package com.xiechy.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

/**
 * @author xdd
 * @date 2018/9/13 16:40
 * @description md5加密工具
 */
public class MD5Util {

	protected static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MD5Util.class);

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
            n += 256;
        }
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * 返回大写MD5
	 *
	 * @param origin
	 * @param charsetname
	 * @return
	 */
	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname)) {
				resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
			} else {
				resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
			}
		} catch (Exception exception) {
			logger.error("MD5加密异常",exception);
		}

		if(org.apache.commons.lang3.StringUtils.isBlank(resultString)) {
			resultString = "";
		}

		return resultString.toUpperCase();
	}

	/****
	 * 双重加密
	 * @param origin 加密参数
	 * @param charsetname 编码
	 * @return
	 */
	public static String MD5EncodeDouble(String origin, String charsetname) {
		return MD5Encode(MD5Encode(origin,charsetname).toUpperCase(),charsetname).toUpperCase();
	}

	private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

	public static String md5s(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte[] b = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
                    i += 256;
                }
				if (i < 16) {
                    buf.append("0");
                }
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}

	}

	public static String sign(String text) {
        return DigestUtils.md5Hex(text);
    }
    
    public static String sign(String text,String charset) {
        return DigestUtils.md5Hex(getContentBytes(text, charset));
    }
    
    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException 
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(String.format("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:%s",charset));
        }
    }

    /**
     * @Description 签名   sign=账户编号+司机编号+可提现金额+版本号+salt
     * @Author xcy
     * @Date  2020/8/11 11:15
     * @param args
     * @return void
    */
	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("CS1278948742015221760");
		buffer.append("CS646545823657623552");
		buffer.append("1000");
		buffer.append("0");
		buffer.append("rNBdNtjuefmwLGzXjHoN");
		String toSign = buffer.toString();
		String resultSign = MD5Util.MD5Encode(toSign, "UTF-8");
		System.out.println("resultSign--》"+resultSign);
	}
}
