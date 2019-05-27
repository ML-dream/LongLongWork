package arraypractice;

import java.util.Scanner;

public class Test01 {

	/**
	 * 获取一维数组的最小值
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String numStrs = scan.nextLine().trim();
		if (numStrs.equals(""))
			System.out.println("请输入内容");
		for (int i = 0; i < numStrs.length(); i++) {
			char charAt = numStrs.charAt(i);
			if (!Character.isDigit(charAt) && charAt != ' ') {// 此处得空格。。。卧槽
				System.out.println("包含非法字符");

			}

		}
		String[] array = numStrs.split(" ");
		int[] numArray = new int[array.length];
		for (int i = 0; i < array.length; i++)
			numArray[i] = Integer.valueOf(array[i]);// 将字符串转化成数字存放至数组
		// 然后在找最小的量
		int min = numArray[0];
		for (int i = 0; i < numArray.length; i++) {
			if (min > numArray[i])
				min = numArray[i];
		}
		System.out.println("zui xiao dezhi wei " + min);
	}

}
