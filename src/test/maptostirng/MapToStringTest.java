package test.maptostirng;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.common.util.JacksonUtil;

/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2017年7月5日
 * @version v1.0.
 * 
 */
public class MapToStringTest {

	public static void main(String[] args) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("one", 1);
		map.put("two", "2");
		map.put("three", null);
		map.put("four", "");
		
		System.err.println(JacksonUtil.mapToJson(map));
		
		Map<String, String> mapStr = new HashMap<String, String>();
		
		Object[] keys = map.keySet().toArray();
		for (Object object : keys) {
			System.out.println(object);
			System.out.println(map.get(object));
			mapStr.put(String.valueOf(object), String.valueOf(map.get(object)));
		}
		
		BackJson bacj = new BackJson();
		bacj.setVersion("ver");
		bacj.setMsgType("ver");
		bacj.setMsgSeq("ver");
		
		String json = JacksonUtil.objToJson(bacj);
		
		System.out.println("base = " + json);
		
		
		String jsonStr = JacksonUtil.mapToJson(mapStr);
		
		System.out.println("str = " + jsonStr);
		
		
		String backJson = json + jsonStr;
		backJson = backJson.replace("}{", ",");
		System.out.println(backJson);
		
		
	}
}
