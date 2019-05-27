package practise;

public class Test11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String []  array=new String[]
				{
				"老虎","老鹰","张三","李四","王五","赵六","杨七"
				};
		for(String string:array)
		{
			if(string.equals("王五"))
				break;
			System.out.println(string);
		}
	}

}
