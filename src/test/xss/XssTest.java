package test.xss;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2017年7月24日
 * @version v1.0.
 * 
 */
public class XssTest {


	public static void main(String[] args) {
		String s = StringEscapeUtils.escapeHtml("<img/src/onerror=alert(111)>");
		System.out.println(s);
		
		System.out.println(StringEscapeUtils.unescapeHtml(s));
	}
	
	
}
