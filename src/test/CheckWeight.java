package test;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie 4 8
 * @version 创建时间：2017年3月15日
 * 
 */
public class CheckWeight {
	
	public static int[] array = { 1, 1, 1, 1, 1, 1, 1, 0, 1, 1,  1,  1};
	public static int[] index = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

	public static void main(String[] args) {
		
		/**
		 * 第1次称左1、2、3、4    右5、6、7、8 ?
		 * 第2次称左1、5、9、11 右2、3、6、10?
		 * 第3次称左4、8、9、10 右1、2、5、12?
		 */
		
		int a1 = array[1-1] + array[2-1] + array[3-1] + array[4-1];
		int a2 = array[4-1] + array[5-1] + array[6-1] + array[7-1];
		
		int b1 = array[1-1] + array[5-1] + array[9-1] + array[11-1];
		int b2 = array[2-1] + array[3-1] + array[6-1] + array[10-1];
		
		int c1 = array[4-1] + array[8-1] + array[9-1] + array[10-1];
		int c2 = array[1-1] + array[2-1] + array[5-1] + array[12-1];
		
		if( (a1 > a2) && (b1 > b2) && (c1 < c2)){
			System.out.println("1重");
		}
		if( (a1 < a2) && (b1 < b2) && (c1 > c2)){
			System.out.println("1轻");
		}
		
		if( (a1 > a2) && (b1 < b2) && (c1 < c2)){
			System.out.println("2重");
		}
		if( (a1 < a2) && (b1 > b2) && (c1 > c2)){
			System.out.println("2轻");
		}
		
		if( (a1 > a2) && (b1 < b2) && (c1 == c2)){
			System.out.println("3重");
		}
		if( (a1 < a2) && (b1 > b2) && (c1 == c2)){
			System.out.println("3轻");
		}
		
		if( (a1 == a2) && (b1 == b2) && (c1 > c2)){
			System.out.println("4重");
		}
		if( (a1 == a2) && (b1 == b2) && (c1 < c2)){
			System.out.println("4轻");
		}
		
		if( (a1 < a2) && (b1 > b2) && (c1 < c2)){
			System.out.println("5重");
		}
		if( (a1 > a2) && (b1 < b2) && (c1 > c2)){
			System.out.println("5轻");
		}
		
		if( (a1 < a2) && (b1 < b2) && (c1 == c2)){
			System.out.println("6重");
		}
		if( (a1 > a2) && (b1 > b2) && (c1 == c2)){
			System.out.println("6轻");
		}
		
		if( (a1 < a2) && (b1 == b2) && (c1 == c2)){
			System.out.println("7重");
		}
		if( (a1 > a2) && (b1 == b2) && (c1 == c2)){
			System.out.println("7轻");
		}
		
		if( (a1 == a2) && (b1 == b2) && (c1 > c2)){
			System.out.println("8重");
		}
		if( (a1 == a2) && (b1 == b2) && (c1 < c2)){
			System.out.println("8轻");
		}
		
		if( (a1 == a2) && (b1 > b2) && (c1 > c2)){
			System.out.println("9重");
		}
		if( (a1 == a2) && (b1 < b2) && (c1 < c2)){
			System.out.println("9轻");
		}
		
		if( (a1 == a2) && (b1 < b2) && (c1 > c2)){
			System.out.println("10重");
		}
		if( (a1 == a2) && (b1 > b2) && (c1 < c2)){
			System.out.println("10轻");
		}
		
		if( (a1 == a2) && (b1 > b2) && (c1 == c2)){
			System.out.println("11重");
		}
		if( (a1 == a2) && (b1 < b2) && (c1 == c2)){
			System.out.println("11轻");
		}
		
		if( (a1 == a2) && (b1 == b2) && (c1 < c2)){
			System.out.println("12重");
		}
		if( (a1 == a2) && (b1 == b2) && (c1 > c2)){
			System.out.println("12轻");
		}
		
		if( (a1 == a2) && (b1 == b2) && (c1 == c2)){
			System.out.println("没有问题");
		}
		
		
	}
}
