package practise;
import java.util.Scanner;

/*
 * 判断一年是否是润年
 */
public class Test03 {
	@SuppressWarnings("finally")
	public static void main(String [] args){
		
		while(true){
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入一个年份");
			try{
			long year = scan.nextLong();
			if(year%4==0&&year%100!=0||year%400==0){
				System.out.println(year+"shirunnian");
			}
			else{
				System.out.println(year+"不shirunnian");
			}
			
		}catch(Exception e){
			System.out.println("你输入得不是有效的年份");
			}
			}
		
		
		
	}
	
	
	
}
