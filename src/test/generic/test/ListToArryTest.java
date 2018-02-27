package test.generic.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2017年7月27日
 * @version v1.0.
 * 
 */
public class ListToArryTest {
	
	public static void main(String[] args) {
		testMap();
		testBean();
	}

	/**
	 * 
	 * @param List<? extends Object> list
	 * @param bccSize
	 * @return
	 */
	public  static List<? extends Object[]> listToArray(List<? extends Object> list,int bccSize){  
        List<Object []> list2 = new ArrayList<Object []>();  
        Object arr[]=null;  
        for(int j=1,len=list.size()+1;j<len;j++){  
            if(j==1){  
                if(len>bccSize){ //初始化数组大小  
                    arr=new Object[bccSize];  
                }else{  
                    arr=new Object[len-1];  
                }     
            }  
            arr[j-(bccSize*list2.size())-1]=list.get(j-1);  //给数组赋值  
            if(j%bccSize==0){  
                list2.add((Object[]) arr);  //数组填值满后放到集合中  
                if(len-j-1>bccSize){  
                    arr=new Object[bccSize];  
                //不允许数组有空值创建最后一个数组的大小(如果都要一定大小可以去掉)  
                }else{   
                    arr=new Object[len-(bccSize*list2.size())-1];  
                }     
            }else if(j==len-1){  
                list2.add((Object[]) arr);//最后一个数组可能没有规定大小  
            }  
        }  
        return list2;  
    }
	
	@SuppressWarnings("unchecked")
	public static void testMap(){
		List<Map<String, Object>> list = new  ArrayList<Map<String, Object>>();
		for (int i = 0; i < 11; i++) {
			Map<String, Object> map = new  HashMap<String, Object>();
			map.put("i", i);
			list.add(map);
		}
		List<Map<String, Object>[]> listarray = (List<Map<String, Object>[]>) listToArray(list, 2);
		System.err.println(listarray);
		for (int i = 0; i < listarray.size(); i++) {
			Object[] s= listarray.get(i);
			if (s.length > 0) {
				for (int j = 0; j < s.length; j++) {
					Map<String, Object> maps = (Map<String, Object>) s[j];
					System.out.println("第 " + (i + 1) + "组map = " + maps);
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void testBean(){
		List<EqptBean> list = new  ArrayList<EqptBean>();
		for (int i = 0; i < 11; i++) {
			EqptBean bean = new  EqptBean();
			bean.setDevID(i+"");
			list.add(bean);
		}
		List<EqptBean[]> listarray = (List<EqptBean[]>) listToArray(list, 2);
		System.err.println(listarray);
		for (int i = 0; i < listarray.size(); i++) {
			Object[] s= listarray.get(i);
			if (s.length > 0) {
				for (int j = 0; j < s.length; j++) {
					EqptBean maps = (EqptBean) s[j];
					System.out.println("第 " + (i + 1) + "组bean = " + maps.getDevID());
				}
			}
		}
	}
}
