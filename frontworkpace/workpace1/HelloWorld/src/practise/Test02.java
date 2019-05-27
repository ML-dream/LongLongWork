package practise;
/*
 * 实现两个变量的互换 不需要中间的额变量
 */
import java.util.Scanner;

	
public class Test02 {
	public static void main(String [] args){
		Scanner scan =new Scanner(System.in);
		System.out.println("请输入变量A的值为:");
		long A = scan.nextLong();
		System.out.println("请输入变量B的值");
		long B= scan.nextLong();
		System.out.println("A="+A+"\tB="+B);
		System.out.println("执行变量互换。。。。。");
		A=A^B;
		B=B^A;
		A=A^B;
		System.out.println("A="+A+"\tB="+B);
		
	}

}
