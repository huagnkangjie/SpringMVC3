package test.enumTest;
/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年3月7日
 * @version v1.0.
 * 
 */
public class TestMy {

	
	public enum Color {
		RED(1),
		BLANK(2);
		
		private int index;
		
		private Color(int index){
			this.index = index;
		}
		
		public int prints(){
			return this.index;
		}
		
		public String getName(){
			return 
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Color.BLANK.in);
	}
}
