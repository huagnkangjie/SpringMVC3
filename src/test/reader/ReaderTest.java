package test.reader;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2017年5月3日
 * @version v1.0.
 * 
 */
public class ReaderTest {

	public static void main(String[] args) {
		readString4();
	}

	public static String filePath = "D:/test.jpg";
//	 public static String filePath = "D:/proxy.txt";

	private static String readString4()

	{
		String imgStr = "";
		try {
			File imgFile = new File(filePath);
			FileInputStream fis = new FileInputStream(imgFile);
			byte[] bytes = new byte[fis.available()];

			fis.read(bytes);
			fis.close();

			imgStr = byte2hex(bytes);

			System.out.println(">>>>>>>>>>" + imgStr);
			saveToImgByStr(imgStr.toString(), "D:/", "12.png");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return imgStr.toString();

	}

	public static int saveToImgByStr(String imgStr, String imgPath, String imgName) {
		try {
			System.out.println("===imgStr.length()====>" + imgStr.length() + "=====imgStr=====>" + imgStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int stateInt = 1;
		if (imgStr != null && imgStr.length() > 0) {
			try {

				// 将字符串转换成二进制，用于显示图片
				// 将上面生成的图片格式字符串 imgStr，还原成图片显示
				byte[] imgByte = hex2byte(imgStr);

				InputStream in = new ByteArrayInputStream(imgByte);

				File file = new File(imgPath, imgName);// 可以是任何图片格式.jpg,.png等
				FileOutputStream fos = new FileOutputStream(file);

				byte[] b = new byte[1024];
				int nRead = 0;
				while ((nRead = in.read(b)) != -1) {
					fos.write(b, 0, nRead);
				}
				fos.flush();
				fos.close();
				in.close();

			} catch (Exception e) {
				stateInt = 0;
				e.printStackTrace();
			} finally {
			}
		}
		return stateInt;
	}

	/**
	 * 二进制转字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) // 二进制转字符串
	{
		StringBuffer sb = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0XFF);
			if (stmp.length() == 1) {
				sb.append("0" + stmp);
			} else {
				sb.append(stmp);
			}

		}
		return sb.toString();
	}

	/**
	 * 字符串转二进制
	 * 
	 * @param str
	 *            要转换的字符串
	 * @return 转换后的二进制数组
	 */
	public static byte[] hex2byte(String str) { // 字符串转二进制
		if (str == null)
			return null;
		str = str.trim();
		int len = str.length();
		if (len == 0 || len % 2 == 1)
			return null;
		byte[] b = new byte[len / 2];
		try {
			for (int i = 0; i < str.length(); i += 2) {
				b[i / 2] = (byte) Integer.decode("0X" + str.substring(i, i + 2)).intValue();
			}
			return b;
		} catch (Exception e) {
			return null;
		}
	}

}
