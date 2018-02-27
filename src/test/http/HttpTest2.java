package test.http;

import java.util.Iterator;

public class HttpTest2 extends Thread{
	
	public String id;
	
	int count = 0;
	
	public HttpTest2 (String id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				String sr = HttpRequestUtil.sendGet("http://jb.echevip.com/Inc/Ajax_tp.aspx", "id="+id);
				count++;
				Thread.sleep(1000);//睡眠时间
//				System.out.println(sr);
//				System.out.println("为   " + id + " 号种子选手刷票 : " + count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		long time = System.currentTimeMillis();
		for (int i = 0; i < 500; i++) {
			HttpTest2 t1 = new HttpTest2("75");//选手号数
			t1.start();
			System.out.println(i);
		}
		long time1 = System.currentTimeMillis();
		System.out.println("耗时 ： "+ (time1 - time));
	}

}
