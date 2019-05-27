
package offer;

public class Solution01 {
	
	public static void main(String arg[]) {
    
		/*int[][] array= {{1,2,3},{4,5,6},{7,8,9}};
		Solution01 sou = new Solution01 ();*/
		String a = "2,3,4,5";
//		char[] a= a. 
			System.out.print("20%".length());
	}
	
	
	
	
	
	public boolean Find (int target, int [][] array) {
        for(int i=0 ;i<array.length;i++)
        {
            for(int j=0;j<array[i].length;j++){
                if(target==array[i][j]){
                    return true;
                }
            }
      
        }
		return false;
    }
	
}