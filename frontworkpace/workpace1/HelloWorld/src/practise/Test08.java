package practise;

import java.util.Scanner;
/*
 * 自己得杨辉三角形。
 */

public class Test08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("qingshuru 行数");
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int num[][] =new int[n][n];
		for(int i=0;i<n;i++)
		{
			num[i][0]=num[i][i]=1;
			for(int j=1;j<i;j++){
				num[i][j]=num[i-1][j-1]+num[i-1][j];
			}
			
		}
		for(int i=0;i<n;i++)
		{
			for(int k=0;k<(n-i);k++)
			{
				System.out.print(" ");
			}
			for(int j =0;j<n;j++)
			{
				System.out.print(num[i][j]+" ");
			}
			System.out.println();
		}
	}

}
