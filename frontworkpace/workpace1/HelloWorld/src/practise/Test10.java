package practise;

public class Test10 {

	/**利用while计算1+1/2!+1/3!...1/20!得用BigDecimal
	 * @param args
	 */
	public static void main(String[] args) {
		int i=1;
		int sum=1;
		int amount=0;
		while(i<=20)
		{
			
			sum=sum*i;
//			int temp=1/sum;
			
			amount=amount+sum;
			i++;
		}
		System.out.print(amount);
	}

}
