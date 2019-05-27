package practise;
/*
 * 这是网上的 杨辉三角形，下面我自己按照这个思路自己写一下。
 */

import java.util.Scanner;

public class Test07 {  
    public static void main(String args[]){  
    	System.out.println("请输入行数");
        Scanner cin = new Scanner(System.in);  
        int n =cin.nextInt();  
        int num[][]=new int[n][n];  //这是在给二维数据赋值 的程序！
        for(int i=0;i<n;i++)  
        {  
            num[i][0]=num[i][i]=1;
//        	num[0][0]=1;
            for(int j=1;j<i;j++)  //这实际上就是从i=2开始执行的，因为j默认开始等于1，所以i=0或1时是不满足下面的循环条件，从而避免了数组越界!
            {  
                num[i][j]=num[i-1][j-1]+num[i-1][j];  
            }  
        }  
        for(int i=0;i<n;i++)  
        {  
        	for(int k=1;k<n-i;k++){
        		System.out.print(" ");//其实就是每一行的输入打印，但是在打印二维数组的时候，前面要加上“ ”从而形成好看的三角形
        	}
            for(int j=0;j<=i;j++)  
            {  
                System.out.print(num[i][j]+" ");  
            }  
            System.out.println();  
        }  
    }  
}  