package test.enumTest;
/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年3月7日
 * @version v1.0.
 * 
 */
public class EnumTest {

	
	public enum Color{
		BLANK("test"),
		BLUE("test2");
		
		private String name;
		
		private Color(String name){
			this.name = name;
		}
		
		public String toString(){
			return this.name;
		}
		
		
	}
	
	
	
	/**
	 * 比较两个对象的位置
	 */
	public void compareTo(){
		System.out.println(Color.BLANK.compareTo(Color.BLUE));
	}
	
	public void getDeclaringClass(){
		System.out.println(Color.BLANK.getDeclaringClass());
	}
	
	public void hashCodeTest(){
		System.out.println(Color.BLANK.hashCode());
	}
	
	public void name(){
		System.out.println(Color.BLANK.name());
	}
	
	public void ordinal(){
		System.out.println(Color.BLANK.ordinal());
	}
	
	public void toStringTest(){
		System.out.println(Color.BLANK.toString());
	}
	
	
	public static void main(String[] args) {
		System.out.println(Color.BLANK);
		EnumTest test = new EnumTest();
		//测试JDK方法
		test.compareTo();
		test.getDeclaringClass();
		test.hashCodeTest();
		test.name();
		test.ordinal();
		test.toStringTest();
		
		
		System.out.println(Color.BLANK.toString());
		
	}
}
