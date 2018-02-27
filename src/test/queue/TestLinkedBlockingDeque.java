package test.queue;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月15日
 * 
 */
public class TestLinkedBlockingDeque {

	
	/**
	 * 
	 * 无界阻塞队列
	 * 
	 * 业务模拟实现
	 * 
	 * 2个线程在不停的插入
	 * 1个线程在不听的读取
	 * 
	 */
	
	@SuppressWarnings("rawtypes")
	public static LinkedBlockingDeque queue = new LinkedBlockingDeque();
	
	public static String sendMessage(){
		return (String) queue.poll();
	}
	
	@SuppressWarnings("unchecked")
	public static boolean receiveMessage(String msg){
		try {
			return queue.offer(msg, 3 , TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void readMsg(){
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					System.out.println("队列size " + queue.size());
					if(queue.size() == 0){
						System.out.println("队列size == 0, 不做读取操作 ");
						continue;
					}
					System.out.println("读取到消息  >>> " + sendMessage());
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
		
	}
	
	public static void writeMsg(){
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i = 1;
				while(true){
					if(i == 20){
						break;
					}
					System.out.println("存储消息 " + receiveMessage(i + ""));
					i++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
		
	}
	
	public static void main(String[] args) {
		writeMsg();
		readMsg();
	}
	
}
