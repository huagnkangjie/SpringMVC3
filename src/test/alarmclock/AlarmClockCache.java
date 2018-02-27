package test.alarmclock;

import java.util.HashMap;
import java.util.Map;

/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月3日
 * 
 */
public class AlarmClockCache {


	/**
	 * 闹钟寄存器，用于存放当前所有的单独闹钟对象
	 */
	public static Map<String, Object> map = new HashMap<String, Object>();
	
	
	public static void setValue(String key, Object value){
		map.put(key, value);
	}
	
	public static Object getVlaue(String key){
		return map.get(key);
	}
	
	/**
	 * 闹钟寄存器，用于存放一响铃的闹钟，有则一直响，没有了，只不响铃
	 */
	public static Map<String, Object> mapDel = new HashMap<String, Object>();
}
