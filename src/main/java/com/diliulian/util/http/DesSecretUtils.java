/**
 * 
 */
package com.diliulian.util.http;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.springframework.util.DigestUtils;

/**
 * @author ht
 * 
 */
public class DesSecretUtils
{

	private static final String PASSWORD_CRYPT_KEY = "______________BSCO______________";
	private final static String DES = "DES";

	/**
	 * 加密
	 * 
	 * @param src
	 *            数据源
	 * 
	 * @param key
	 *            密钥，长度必须是8的倍数
	 * @return 返回加密后的数据
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] src, byte[] key) throws Exception
	{
		// DES算法要求有一个可信任的随机数源

		SecureRandom sr = new SecureRandom();
		// 从原始密匙数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);
		// 创建一个密匙工厂，然后用它把DESKeySpec转换成

		// 一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
		// 现在，获取数据并加密
		// 正式执行加密操作
		return cipher.doFinal(src);
	}

	/**
	 * 解密
	 * 
	 * @param src
	 *            数据源
	 * 
	 * @param key
	 *            密钥，长度必须是8的倍数
	 * @return 返回解密后的原始数据
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] src, byte[] key) throws Exception
	{
		// DES算法要求有一个可信任的随机数源

		SecureRandom sr = new SecureRandom();
		// 从原始密匙数据创建一个DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);
		// 创建一个密匙工厂，然后用它把DESKeySpec对象转换成

		// 一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(DES);
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
		// 现在，获取数据并解密
		// 正式执行解密操作
		return cipher.doFinal(src);
	}

	/**
	 * 密码解密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public final static String decrypt(String data)
	{
		try
		{
			return new String(decrypt(hex2byte(data.getBytes("UTF-8")), PASSWORD_CRYPT_KEY.getBytes("UTF-8")));
		} catch (Exception e)
		{
		}
		return null;
	}

	/**
	 * 密码加密
	 * 
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public final static String encrypt(String password)
	{
		try
		{
			return byte2hex(encrypt(password.getBytes("UTF-8"), PASSWORD_CRYPT_KEY.getBytes("UTF-8")));
		} catch (Exception e)
		{
		}
		return null;
	}

	/**
	 * 
	 * 二行制转字符串
	 * 
	 * 
	 * @param b
	 * 
	 * @return
	 */

	public static String byte2hex(byte[] b)
	{
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++)
		{
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();
	}

	public static byte[] hex2byte(byte[] b)
	{
		if ((b.length % 2) != 0)
			throw new IllegalArgumentException("长度不是偶数");
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2)
		{
			String item = new String(b, n, 2);
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}

	/**
	 * MD5加密类
	 * 
	 * @param str
	 *            要加密的字符串
	 * @return 加密后的字符串
	 */
	public static String toMD5(String str)
	{
		try
		{
			String password = DigestUtils.md5DigestAsHex(str.getBytes());
			return password;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args)
	{
		System.out.println(toMD5("1"));
	}

}