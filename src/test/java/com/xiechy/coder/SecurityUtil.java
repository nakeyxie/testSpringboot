package com.xiechy.coder;

import java.security.MessageDigest;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import lombok.SneakyThrows;

/**
 * @Description 实例-第三方接口签名加密
 * https://blog.csdn.net/xiamofy/article/details/98651593
 * @Author xcy
 * @Date  2021/4/27 10:25
 * @param null
 * @return  
*/
public class SecurityUtil {
	public static final String CHARSET = "UTF-8";

	private static final char[] HEX_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };

	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	private static String hex(byte[] bytes) {
		int len = bytes.length;
		StringBuilder buf = new StringBuilder(len * 2);
		for (int j = 0; j < len; j++) {
			buf.append(HEX_CHARS[(bytes[j] >> 4) & 0x0f]);
			buf.append(HEX_CHARS[bytes[j] & 0x0f]);
		}
		return buf.toString();
	}

	@SneakyThrows
	private static byte[] sha1(byte[] input) {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
		messageDigest.update(input);
		return messageDigest.digest();
	}

	@SneakyThrows
	private static String encodeBase64(byte[] data) {
		return new String(Base64.getEncoder().encode(data), CHARSET);
	}

	@SneakyThrows
	private static byte[] decodeBase64(String data) {
		return Base64.getDecoder().decode(data.getBytes(CHARSET));
	}

	@SneakyThrows
	private static byte[] aes(byte[] data, byte[] key, byte[] iv, boolean encrypt) {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
		cipher.init(encrypt ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"),
				new IvParameterSpec(iv));
		return cipher.doFinal(data);
	}

	/**
	 * 生成签名
	 * 
	 * @param fieldValues 参与签名的字段
	 * @return 签名
	 */
	@SneakyThrows
	public static String generateSign(Object... fieldValues) {
		String joinedStr = Arrays.asList(fieldValues).stream()
				.map(fieldValue -> fieldValue != null ? fieldValue.toString() : "").sorted()
				.collect(Collectors.joining(""));
		return hex(sha1(joinedStr.getBytes(CHARSET)));
	}

	/**
	 * 加密业务数据
	 * 
	 * @param rawData 业务数据
	 * @param key     密钥
	 * @param iv      初始化向量
	 * @return 加密业务数据
	 */
	@SneakyThrows
	public static String encryptData(String rawData, String key, String iv) {
		return encodeBase64(aes(rawData.getBytes(CHARSET), decodeBase64(key), decodeBase64(iv), true));
	}

	/**
	 * 解密业务数据
	 * 
	 * @param encryptedData 加密业务数据
	 * @param key           密钥
	 * @param iv            初始化向量
	 * @return 业务数据
	 */
	@SneakyThrows
	public static String decryptData(String encryptedData, String key, String iv) {
		return new String(aes(decodeBase64(encryptedData), decodeBase64(key), decodeBase64(iv), false), CHARSET);
	}

	// 测试Demo：签名
	public static void testGenerateSign() {
		String appid = "fs8342f8542c13e9ba0400342d015716";
		long timestamp = 1554189997590l;
		String nonce = "YDBuFQgbmladR3oK";
		String data = "{\"count\":1,\"productId\":\"c3e8fd65544f11e9ba0400155d015705\"}";
		String key = "4jSuQA0HNraqPjfq";

		System.out.println("[签名测试]");
		System.out.println("appid：" + appid);
		System.out.println("timestamp：" + timestamp);
		System.out.println("nonce：" + nonce);
		System.out.println("data：" + data);
		System.out.println("key：" + key);
		String sign = generateSign(appid, timestamp, nonce, data, key);
		System.out.println("签名：" + sign);
		System.out.println("----------------");
	}

	// 测试Demo：加密解密
	public static void testEncryptData() {
		String data = "{\"key\":\"value\"}";
		String key = "D3QE5sMzHlNCpxQ5+GMOzK==";
		String iv = "Qb6HMJIDlico8/9lWyKpLf==";

		System.out.println("[加解密测试]");
		System.out.println("原始数据：" + data);
		String encryptedData = encryptData(data, key, iv);
		System.out.println("加密数据：" + encryptedData);
		System.out.println("解密数据：" + decryptData(encryptedData, key, iv));
		System.out.println("----------------");
	}

	@SneakyThrows
	public static void main(String[] args) {
		testGenerateSign();
		testEncryptData();
	}
}
