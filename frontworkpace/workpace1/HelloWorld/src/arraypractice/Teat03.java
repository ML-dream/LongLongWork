package arraypractice;

import java.util.Random;

public class Teat03 {

	/**
	 * 选择排序算法
	 * @param args
	 */
	public static void main(String[] args) {
			int[] array= new int[10];
			Random random =new Random();
			for(int i=0;i<10;i++){
				array[i]=random.nextInt(50);
			}
			System.out.println("选择的数组是：");
			printArray(array);
			order(array);
			System.out.println();
			System.out.println("排序之后的结果是：");
			printArray(array);
	}
	/**
	 * @param array
	 */
	public static void order(int[] array) {//特点是：比较n-i 但是外循环一次才交换一次 复杂度是n方  
		int min=0; 
		for(int i=0;i<10;i++){//注意外循环和内循环都是进行9次比较。
			min=i;
			for(int j=i;j<9;j++){
				  
		    	if(array[min]>array[j])
		    		min=j;
			}
			int temp=array[min];
			array[min]=array[i];
			array[i]=temp;
		}
	}
	public static void printArray(int[] array) {
		for(int i =0;i<9;i++){
			if(i==0)
				System.out.print("["+array[i]+" ");
			else if(i==8)
				System.out.print(array[i]+"]");
			else 
				System.out.print(array[i]+" ");
			
		}
	}

}
