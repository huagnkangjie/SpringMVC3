package test.aop.demo;

public class D2 extends Ope{

	protected Ope ope = null;
	
	public D2(Ope ope){
		this.ope = ope;
	}

	@Override
	void t() {
		System.out.println("第一次刷涂料");
		this.ope.t();
		System.out.println("第二次刷涂料");
	}
}
