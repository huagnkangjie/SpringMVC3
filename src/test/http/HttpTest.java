package test.http;

public class HttpTest extends Thread{
	
	public String id;
	
	int count = 0;
	
	public HttpTest (String id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				String sr = HttpRequestUtil.sendGet("http://jb.echevip.com/Inc/Ajax_tp.aspx", "id="+id);
				count++;
				Thread.sleep(1000);
				System.out.println(sr);
				System.out.println("为   " + id + " 号种子选手刷票 : " + count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		HttpTest t1 = new HttpTest("69");
		HttpTest t2 = new HttpTest("69");
		HttpTest t3 = new HttpTest("69");
		HttpTest t4 = new HttpTest("69");
		HttpTest t5 = new HttpTest("69");
		HttpTest t6 = new HttpTest("69");
		HttpTest t7 = new HttpTest("69");
		HttpTest t8 = new HttpTest("69");
		HttpTest t9 = new HttpTest("69");
		HttpTest t10 = new HttpTest("69");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
	}

}
