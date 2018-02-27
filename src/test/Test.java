package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateUtils;

public class Test {
	
	public static int a = 1;
	public int b = 1;
	
	public Test(){
		a++;
		b++;
		System.out.println("a=" + a);
		System.out.println("b=" + b);
	}

	public static void main(String[] args) {
		Test t = new Test();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("entName", "拉米科技");
		map.put("stuName", "黄康杰");
		
		String s = "";
		for (String key : map.keySet()) {
			System.out.println("key = " + key + ",  value = " + map.get(key));
			s = s + "&" + key + "=" + map.get(key);
			System.out.println(s);
		}
		
		
		String s1 = "测试";
		String sArray[] = s1.split(",");
		System.out.println(sArray.length);
		
		System.out.println(">>>>>>>>>>>>" + s1.replace("测", "ss"));
		
		String randomNum = RandomStringUtils.randomNumeric(10);
		System.out.println(">>>>>>>> 10位随机数 ： " + randomNum);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String time = sdf.format(date);
		
		System.out.println(time);
		
		System.out.println( 1502959920 - 1502959860);
	}
}
