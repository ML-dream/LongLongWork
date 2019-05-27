package arraypractice;

public class Test02 {

	/**
	 * ，模拟二维数组的行列调换!!!还有方法二：新建一个二维数组，分别数值调换了赋值！
	 * @param args
	 */
	public static void main(String[] args) {
		int [][] numArray=new int[][]{
				{1,2,3},
				{4,5,6},
				{7,8,9}};
		for(int i=0;i<3;i++){
			for(int j=i;j<3;j++){
				int temp =numArray[i][j];
				numArray[i][j]=numArray[j][i];
				numArray[j][i]=temp;
			}
			
		}
		
		printArray(numArray);
		
	}

	/**
	 * @param numArray
	 */
	public static void printArray(int[][] numArray) {
		for(int i=0;i<3;i++){     // 这个单独封装起来 做个函数
			for(int j=0;j<3;j++){
				System.out.print(numArray[i][j]+"\t");
			}
			System.out.println();
			System.out.println();
		}
	}

}
