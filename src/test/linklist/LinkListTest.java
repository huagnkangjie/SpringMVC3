package test.linklist;

import java.util.LinkedList;

import javax.sound.midi.Synthesizer;

public class LinkListTest {

	
	public void print(LinkedList<String> lList){
		for (int i = 0; i < lList.size(); i++) {
			System.out.println(lList.get(i));
		}
	}
	
	public static void main(String[] args) {
		LinkListTest t = new LinkListTest();
		LinkedList<String> lList = new LinkedList<String>();  
	    lList.add("1");  
	    lList.add("2");  
	    lList.add("3");  
	    lList.add("4");  
	    lList.add("5");  
	  
	    System.out.println("链表的长度 : " + lList.size());
	    System.out.println("链表的第一个元素是 : " + lList.getFirst());  
	    System.out.println("链表最后一个元素是 : " + lList.getLast());  
	    
	    t.print(lList);
	    System.out.println("-----------移除第一个后----------------");
	    lList.removeFirst();
	    t.print(lList);
	    
	    System.out.println("指定删除 ： " + lList.remove(1));
	    t.print(lList);
	}
}
