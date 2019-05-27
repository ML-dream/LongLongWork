package practise;

import java.util.Scanner;

public class Test04 {
	public static void main(String [] args){
		Scanner scan =new Scanner(System.in);
		System.out.println("请输入用户名为:");
		String A = scan.nextLine();
		System.out.println("请输入密码为");
		String B = scan.nextLine();
		if(!A.equals("mr")){
			System.out.println("你输入的用户名是错误的");
		}else if(!B.equals("123")){
			System.out.println("你输入的mima是错误的");
			
		}else{
			System.out.println("验证成功");
		}
}
}