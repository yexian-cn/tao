package com.xiaochun.tao.utils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.google.common.base.Objects;


/**
 * @Description 封装了一些加密工具方法, 包括 3DES, MD5 等.
 */
public class CryptTool {

	public CryptTool() {
	}
	//通讯加密KEY
	public final static String KEY="[5)JL\">jTD$B+!mP`tM|eS^E-_#03gHa?v{nC<wq";
	
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

	/**
	 * 转换字节数组为16进制字串
	 *
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString().toUpperCase();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * 生成3DES密钥.
	 *
	 * @param key_byte
	 *            seed key
	 * @throws Exception
	 * @return javax.crypto.SecretKey Generated DES key
	 */
	public static SecretKey genDESKey(byte[] key_byte)
			throws Exception {

		SecretKey k = null;
		k = new SecretKeySpec(key_byte, "DESede");
		return k;
	}

	public static SecretKey genDESKey() throws Exception {
		String keyStr = "$1#2@f3&4~6%7!a+*cd(e-h)";// 使用固定key
		// System.out.println("DES 加密使用的固定key，keyStr ＝＝ " + keyStr);
		byte key_byte[] = keyStr.getBytes();// 3DES 24 bytes key
		SecretKey k = null;
		k = new SecretKeySpec(key_byte, "DESede");
		return k;
	}

	public static SecretKey genDESKey(String key) throws Exception {
		String keyStr = key;// 使用固定key
		// System.out.println("DES 加密使用的固定key，keyStr ＝＝ " + keyStr);
		byte key_byte[] = keyStr.getBytes();// 3DES 24 bytes key
		SecretKey k = null;
		k = new SecretKeySpec(key_byte, "DESede");
		return k;
	}


	/**
	 * 将表示16进制值的字符串转换为byte数组， 和public static String byteArrayToHexString(byte[] b)
	 * 互为可逆的转换过程
	 *
	 * @param strIn
	 *            需要转换的字符串
	 * @return 转换后的byte数组
	 * @throws Exception
	 *             本方法不处理任何异常，所有异常全部抛出
	 * @author LiGuoQing
	 */
	public static byte[] hexString2ByteArray(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;

		// 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

	/**
	 * 3DES 解密(byte[]).
	 *
	 * @param key
	 *            SecretKey
	 * @param crypt
	 *            byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	public static byte[] desDecrypt(SecretKey key, byte[] crypt)
			throws Exception {
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DESede");
		cipher.init(javax.crypto.Cipher.DECRYPT_MODE, key);
		return cipher.doFinal(crypt);
	}

	/**
	 * 3DES 解密(String).
	 *
	 * @param key
	 *            SecretKey
	 * @param crypt
	 *            byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	public static String desDecrypt(SecretKey key, String crypt)
			throws Exception {
		return byteArrayToHexString(desDecrypt(key, crypt.getBytes("UTF-8")));
	}

	/**
	 * 3DES加密(byte[]).
	 *
	 * @param key
	 *            SecretKey
	 * @param src
	 *            byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	public static byte[] desEncrypt(SecretKey key, byte[] src)
			throws Exception {
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DESede");
		cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(src);
	}

	/**
	 * 3DES加密(String).
	 *
	 * @param key
	 *            SecretKey
	 * @param src
	 *            byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	public static String desEncrypt(SecretKey key, String src)
			throws Exception {
		return byteArrayToHexString(desEncrypt(key, src.getBytes("UTF-8")));
	}

	/**
	 * MD5 摘要计算(byte[]).
	 *
	 * @param src
	 *            byte[]
	 * @throws Exception
	 * @return byte[] 16 bit digest
	 */
	public static byte[] md5Digest(byte[] src) throws Exception {
		java.security.MessageDigest alg = java.security.MessageDigest
				.getInstance("MD5"); // MD5 is 16 bit message digest

		return alg.digest(src);
	}

	/**
	 * MD5 摘要计算(String).
	 *
	 * @param src
	 *            String
	 * @throws Exception
	 * @return String
	 */
	public static String md5Digest(String src) throws Exception {
		return byteArrayToHexString(md5Digest(src.getBytes()));
	}

    /**
     * MD5 摘要计算(String).
     *
     * @param src
     *            String
     * @throws Exception
     * @return String
     */
    public static String md5DigestUTF8(String src) throws Exception {
        return byteArrayToHexString(md5Digest(src.getBytes("UTF-8")));
    }

    /**
     * MD5 解密
     *
     * @param src
     *            String
     * @throws Exception
     * @return String
     */
    public static String md5Enc(String src) throws Exception {
        return byteArrayToHexString(md5Digest(src.getBytes()));
    }

	/**
	 * BASE64 编码.
	 *
	 * @param src
	 *            String inputed string
	 * @return String returned string
	 */
	public static String base64Encode(String src) {
        Base64 encoder = new Base64();

		return encoder.encodeToString(src.getBytes());
	}

	/**
	 * BASE64 编码(byte[]).
	 *
	 * @param src
	 *            byte[] inputed string
	 * @return String returned string
	 */
	public static String base64Encode(byte[] src) {
        Base64 encoder = new Base64();

		return encoder.encodeToString(src);
	}

	/**
	 * BASE64 解码.
	 *
	 * @param src
	 *            String inputed string
	 * @return String returned string
	 */
	public static String base64Decode(String src) {
        Base64 decoder = new Base64();

		try {
			return byteArrayToHexString(decoder.decode(src));
		} catch (Exception ex) {
			return null;
		}

	}

	/**
	 * BASE64 解码(to byte[]).
	 *
	 * @param src
	 *            String inputed string
	 * @return String returned string
	 */
	public static byte[] base64DecodeToBytes(String src) {
		Base64 decoder = new Base64();
		try {
			return decoder.decode(src);
		} catch (Exception ex) {
			return null;
		}

	}

	/**
	 * 对给定字符进行 URL 编码.
	 *
	 * @param src
	 *            String
	 * @return String
	 */
	public static String urlEncode(String src) {
		try {
			src = java.net.URLEncoder.encode(src, "UTF-8");

			return src;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return src;
	}

	/**
	 * 对给定字符进行 URL 解码
	 *
	 * @param value
	 *            解码前的字符串
	 * @return 解码后的字符串
	 */
	public static String urlDecode(String value) {
		try {
			return java.net.URLDecoder.decode(value, "UTF-8");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return value;
	}

    /**
     *  先3DES加密，再base64编码
     * @param key  密钥
     * @param str 需要加密的字符串
     */
    public static String des3Base64Enc(SecretKey key,String str)throws Exception{
        if(key==null)
            key = genDESKey();
        byte[] enc = desEncrypt(key,str.getBytes());
        return base64Encode(enc);
    }

    /**
     *  先base64解码,再3DES解密，
     * @param key  密钥
     * @param str 需要加密的字符串
     */
    public static String des3Base64Dec(SecretKey key,String str)throws Exception{
        if(key==null)
            key = genDESKey();
        byte[] decbase64 = base64DecodeToBytes(str);
        byte[] dec = desDecrypt(key, decbase64);
        return new String(dec,"UTF-8");
    }

	/** Test crypt */
	public static void main(String[] args) {
		try {
			// 获得的明文数据

//			// 使用固定key值
//			//String keyStr = "G7AXS7874305BV59";// 使用固定key
//			//desStr = desStr + "&KEY=" + keyStr;// 将key值和明文数据组织成一个待加密的串
//			System.out.println("待加密的字符串 desStr ＝＝ " + str);
//			// 转成字节数组
//			String desStr = new String(str.getBytes(),"UTF-8");
//			byte src_byte[] = desStr.getBytes();
//
//			// MD5摘要
//			byte[] md5Str = md5Digest(src_byte);
//			// 生成最后的SIGN
//			String SING = byteArrayToHexString(md5Str);
//			System.out.println("SING == " + SING);


//            String str = "helloworld";
////        des3Base64Dec() ;解密
//            System.out.println(desEncrypt(genDESKey(),str));

//
//            byte[] enc = desEncrypt(genDESKey(),str.getBytes());
//
//            System.out.println("enc="+enc);
//            String encStr = new String(enc,"UTF-8");
//            System.out.println("encStr="+encStr);
//            String encbase64 = base64Encode(enc);
//            System.out.println("encbase64="+encbase64);
//
//
//            byte[] decbase64 = base64DecodeToBytes(encbase64);
//            System.out.println("decbase64="+new String(decbase64,"UTF-8"));
//
//            byte[] dec = desDecrypt(genDESKey(), decbase64);
//            System.out.println("dec="+dec);
//            String decStr = new String(dec,"UTF-8");
//            System.out.println("decStr="+decStr);


//            String m=CryptTool.urlDecode("www.reblah.com");
//            System.out.println(m);
//            SecretKey key = CryptTool.genDESKey();
//            String m1="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDbqoQ+EnglXWS6Zks20wp2RZ8LfdVJmXbWJhXNqY7Hd1lOKtNJyzFY+hJD5rzc5vQllO2K/q+vHQvw24G9Vt6pwG97Nk1wEefgvJagT+ONbGr+7vVuO/8hb2IGsrMKjws0USmrsLn5ILtRkA6uryBjmz21wUEWK36IYSX/3H0cywIDAQAB";
//            String a = CryptTool.des3Base64Dec(key,m);
//            System.out.println("加密后："+a);
//			String orderId="2545723754@www.cbczcxn.com";
//			String enc=CryptTool.urlEncode(CryptTool.des3Base64Enc(CryptTool.genDESKey(), orderId));
//			System.out.println(enc);
//			String dec=CryptTool.des3Base64Dec(CryptTool.genDESKey(), CryptTool.urlDecode(enc));
//			String[] s=dec.split("@");
//			System.out.println(s[0]);
//			System.out.println(s[1]);
			
			//String data="{searchType:2,startDate:\"2015-12-31\",takeOffDate:\"\",startCity:\"BJS\",endCity:\"TYO\",returnDate:\"2016-01-02\",shippingSpace:\"Y\"}";
			
		//	String data="{searchType:2,startDate:\"2015-12-31\",takeOffDate:\"\",startCity:\"PEK\",endCity:\"TYO\",returnDate:\"2016-01-02\",shippingSpace:\"Y\",turnNum:\"-1\"}";
			//String data="{searchType:1,startDate:\"2016-01-24\",startCity:\"CAN\",endCity:\"SPK\",shippingSpace:\"Y\"}";
		//	String data="{airlineNo:\"\",airlineCompany:\"\",takeOffDate:\"\"}";
			//String data="{searchType:2,startDate:\"2016-01-05\",returnDate:\"2016-01-19\",takeOffDate:\"\",startCity:\"OSA\",endCity:\"SHA\",shippingSpace:\"Y\",turnNum:\"2\",rideNumber:\"2,0,0\"}";
			String data="{dicType:\"00\"}";
			System.out.println(CryptTool.md5DigestUTF8(data+CryptTool.KEY));
        } catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 支付加密规则
	 * @param orderId 加密SID
	 * @param key 加密key
	 * @return
	 * @throws Exception 
	 */
	public static String payEncrypt(String orderId,String key) throws Exception{
		return CryptTool.urlEncode(CryptTool.des3Base64Enc(CryptTool.genDESKey(), orderId+"@"+key));
	}
	
	/**
	 * 
	 * @param orderId 加密SID
	 * @param key 加密key
	 * @param crypt 密文
	 * @return
	 * @throws Exception 
	 */
	public static boolean checkToken(String orderId,String key,String crypt){
		boolean fals=false;
		try {
			String data=CryptTool.des3Base64Dec(CryptTool.genDESKey(),CryptTool.urlDecode(crypt));
			String[] s=data.split("@");
			if(Objects.equal(s[0],orderId) && Objects.equal(s[1],key)){
				fals=true;
			}else{
				fals=false;
			}
		} catch (Exception e) {
			fals=false;
		}
		return fals;
	}
}
