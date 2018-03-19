package test.callback.mytest2;
/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年3月16日
 * @version v1.0.
 * 
 */
public class Test {

	public static void main(String[] args) {
		Teacher t = new Teacher(new StudentXiaoMing());
		t.askQuestion();
	}
}
