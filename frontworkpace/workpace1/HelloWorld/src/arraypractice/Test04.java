package arraypractice;

import java.util.Arrays;
import java.util.Random;

public class Test04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array= new int[10];
		Arrays.binarySearch(a, key)
		Random random =new Random();
		for(int i=0;i<10;i++){
			array[i]=random.nextInt(50);
		}
		System.out.println("选择的数组是：");
		printArray(array);
		System.out.println();
		order(array);
		System.out.println();
		System.out.println("排序之后的结果是：");
		printArray(array);
		
	}
	public static void order(int[] array) {
		
		for(int i=1;i<10;i++){
			
			for(int j=1;j<=10-i;j++){
				  
		    	
		    	if(array[array.length-j]<array[array.length-j-1]){//两种方式，看个人喜好，从前向后比较简单！！好理解，而且我写的swap并不是通用的
//		    		swap(array.length-j,array.length-j-1,array);
					tran(array, j);
		    	/*if(array[j-1]>array[j]){
		    		swap(j-1,j,array);*/
		    		
				}
		    	
					
			}
			printArray(array);
	    	System.out.println();
			
		}
	}
	/**
	 * @param array
	 * @param j
	 */
	public static void tran(int[] array, int j) {
		int temp=0;
		temp=array[array.length-j];
		array[array.length-j]=array[array.length-j-1];
		array[array.length-j-1]=temp;
	}
	public static void swap(int i, int j,int [] array) {
		int temp = 0;
		temp=array[j];
		array[j]=array[j-1];
		array[j-1]=temp;
	}
	
	public static void printArray(int[] array) {
		for(int i =0;i<10;i++){
			if(i==0)
				System.out.print("["+array[i]+" ");
			else if(i==9)
				System.out.print(array[i]+"]");
			else 
				System.out.print(array[i]+" ");
			
		}
	}

}
