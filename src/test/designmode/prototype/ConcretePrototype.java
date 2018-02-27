package test.designmode.prototype;
/**
 * 原型实现类，
 * 用于实现对象复制时候调用的实现类
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月13日
 * 
 */
public class ConcretePrototype extends Prototype{
	
	private static final long serialVersionUID = -8734710216034978870L;
	
	private String[] array = {"1", "2"};

	public void show(){
		System.out.println("对象复制");
		System.out.println(array);
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}
	
	

}
