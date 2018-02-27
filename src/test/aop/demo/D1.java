package test.aop.demo;

public class D1 extends Ope{

	protected Ope ope = null;
	
	public D1(Ope ope){
		this.ope = ope;
	}

	@Override
	void t() {
		System.out.println("第一次刷灰");
		this.ope.t();
		System.out.println("第二次刷灰");
	}
}
