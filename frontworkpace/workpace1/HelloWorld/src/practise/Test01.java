package practise;
import java.util.Scanner;

/*
 * 
 */
public class Test01 {
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个整数");
		long number=scan.nextLong();
		System.out.println("你输入得整数乘以2:"+(number<<1));
		System.out.println("你输入得整数乘以4:"+(number<<2));
		System.out.println("你输入得整数乘以8:"+(number<<3));
		System.out.println("你输入得整数乘以16:"+(number<<4));
		System.out.println("你输入得整数是:"+number);
	}
	
}
