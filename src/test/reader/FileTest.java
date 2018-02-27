package test.reader;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2017年5月4日
 * @version v1.0.
 * 
 */
public class FileTest {

	
	public static void main(String[] args) {
		
		File f = new File("d://12.png");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println(sdf.format(new Date(f.lastModified())));
		
		
		String path = "D:/1/2";
		File file = new File(path);
		if(!file.exists()){
			boolean flag = file.mkdirs();
			System.out.println(flag);
		}
	}
	
}
