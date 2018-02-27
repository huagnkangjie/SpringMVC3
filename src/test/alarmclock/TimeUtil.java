package test.alarmclock;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月3日
 * 
 */
public class TimeUtil {

	/**
	 * HH:mm
	 * @return
	 */
	public static String getDate() {
		return new SimpleDateFormat("HH:mm").format(new Date());
	}
}
