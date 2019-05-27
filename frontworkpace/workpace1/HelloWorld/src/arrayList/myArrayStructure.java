package arrayList;

import java.lang.reflect.Array;
import java.util.Arrays;


public class myArrayStructure {

	/**
	 * 实现一个数组结构，用Java语言
	 * //定义一个class封装数组的一些要素
	 * @param args
	 */
	private int length;
	 Object [] array;
	private int current;
	
	myArrayStructure(){
		this(10);
	}
	myArrayStructure(int num){
		this.array=new Object[num];
		this.length=num;
		this.current=0;
		
		
	}
	/*public void addLast(int obj){
		array[current]=obj;
		current++;
		System.out.println("tianjiachenggong");
	} */
	public void addIndex(int obj,int index){
	/*	if(index>current-1){
			array[index]=obj;
			current++;
			System.out.println("tianjiachenggong");
		}*/
			
		
	
		for(int i =1;i<=(length-index-1);i++){
			array[length-i]=array[length-i-1];
			array[index]=obj;
//			System.out.println("tianjiachenggong");
			this.current++;
		}
		
		
	} 
	
	
	
	
	public static void main(String[] args) {
		 myArrayStructure list = new myArrayStructure();
		 list.addIndex(20, 0);
		 list.addIndex(34, 5);
//		 list.addLast(56);
		 
		 System.out.println(list.array[0]);
	}
	
		

}
