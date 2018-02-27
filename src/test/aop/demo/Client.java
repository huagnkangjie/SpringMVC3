package test.aop.demo;

public class Client {

	public static void main(String[] args) {
		Ope ope = new D1(new D2(new Old()));
//		Ope ope = new Old();
//		Ope ope = new D2(new Old());
//		Ope ope = new D1(new Old());
		ope.t();
	}
}
