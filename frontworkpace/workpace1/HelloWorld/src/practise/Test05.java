
package practise;

import java.util.Scanner;

/**
 * @author 戴志强
 *
 */
public class Test05 {

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入你的姓名");
		String name =scan.nextLine();
		System.out.println("请输入你的语言");
		String language =scan.nextLine();
		switch(language.hashCode()){
			case 3254818:
				System.out.println("员工"+name+"被分配到"+language+"部门");
				break;
			case 3104:
			     System.out.println("员工"+name+"被分配到"+language+"部门");
				break;
			default:
			     System.out.println("本公司不需要该");
		}
	}

}
