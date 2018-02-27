package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * [类说明]
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年4月21日
 * 
 */
public class DateTest {

	
	
	public static void main(String[] args) {
		DateTest test = new DateTest();
		test.getDate("2017-04-21 09:59:22");
		
	}
	
	/**
	 * 根据指定时间字符串获取date
	 * @param dates
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Date getDate(String dates){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(dates);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(">>>>>>>>>>>" + date.getHours());
		return date;
	}
}
