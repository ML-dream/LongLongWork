package practise;

public class Test09 {

	/**九九乘法表
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i =1;i<=9;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(i+"*"+j+"="+i*j+"\t");//加上\t就能保证每列对齐
			}
			System.out.println();
		}
	}

}
