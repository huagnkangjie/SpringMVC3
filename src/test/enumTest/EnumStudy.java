package test.enumTest;
/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年3月7日
 * @version v1.0.
 * 
 */
enum Colors {
	  Red("afdasdf"),
	  C2101("hemuapp-1"),
	  C2102("hejiaiqng"),
	  C210333333333333333333333333("hejiaiqng");
	
	 private String name;
	
	 private Colors(String test){
		 this.name= test;
	 }
	 
	 public String names(){
		 return this.name;
	 }
	 
	}
public class EnumStudy {
	
	
	public static String getAPPID(String appid){
		try {
			Colors color = Colors.valueOf(appid);
			if(color != null){
				return color.names();
			}
		} catch (Exception e) {
			System.err.println("没有找到匹配的APPID");
		}
		
		return appid;
	}
	
	public static String getAPPID2(String appid){
		if(appid.equals("C2101")){
			return "hemuapp-1";
		}else if(appid.equals("C2102")) {
			return "hejiaiqng";
		}else if(appid.equals("C210333333333333333333333333")) {
			return "C210333333333333333333333333";
		}else{
			return appid;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Colors color;
		Colors all[] = Colors.values();
		for (Colors a : all)
		    System.out.println(a.names());

		    System.out.println();

			color = Colors.valueOf("Red");
		    System.out.println(color);
		    
		    System.out.println("获取的appid : " + getAPPID("C2101"));

		    long start = System.currentTimeMillis();
		    for(int i = 0; i  < 1000000000; i ++){
				
				getAPPID("C2102");
				
			}
		    long end = System.currentTimeMillis();
			System.out.println("第一种耗时：" + (end - start));
			
			long start1 = System.currentTimeMillis();
		    for(int i = 0; i  < 1000000000; i ++){
		    	
		    	getAPPID2("C2102");
		    	
		    }
		    long end1 = System.currentTimeMillis();
	    	System.out.println("第二种耗时：" + (end1 - start1));
		    
	}
	
	

}
