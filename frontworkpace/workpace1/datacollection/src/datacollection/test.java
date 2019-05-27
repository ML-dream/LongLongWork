/*package datacollection;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		System.out.println(df.format(day));
		String a = df.format(day);
		System.out.print("NL-XS-009-18052804".substring(6));

	*//**********对于字符串来说，比较的是地址****************//*	
		
		String s2 = new String("abc");
		String s3="abc";
        System.out.println(s2==s3);//(false)
        
        String s4="ab";
        String s5="ab";
        System.out.println(s4==s5);//(true)
        
        //(如果不是重新创建的话，那么会先看常量池中是否有该值，有的话直接引用 )
*//************对于iNt来说，java比较的是具体的值****************//*
        int c = 10;
        int b = 10; 	
        
        Integer d = new Integer(10);
        System.out.println(c==b);//(true)
        System.out.println(d==b);//(true)
        System.out.println(d.equals(c));//(true)
        
        
        String test ="abcde";
        System.out.println(test==test.substring(2));
        
        *//**************************************************//*
        int e = 2; 
        int f=2 ;
        Integer g=3;
        Integer i = 3;
        i = 4;
        System.out.println(g==i);//这才是引用true
       //基本数据类型是存在栈中的，不是堆中的，也没有方法，就是一个值而已
        //下面的包装类则不同，他是存在堆中的对象，是一个实例，和对象的使用是一样的！正经的引用传递
        //上面的观点是错误的，一旦重新赋值，就改变了，就像String一样了
        Integer h=g;
      
        System.out.println(g==h);//true
        h=h+1;	
        System.out.println(h);//false
        System.out.println(g==h);
        
        
        
        *//************************************************************//*
        StringBuilder builder =new StringBuilder ("handsadsa");
       
        
	}
	public String replaceSpace(StringBuffer str) {
    	char[] strChar = str.toString().toCharArray();
	        StringBuffer out =new StringBuffer();
	    	for(int i=0;i<=strChar.length;i++){
	            if (strChar[i]==' '){
	                out.append("20%");
	                
	            }else{
	                out.append(strChar[i]);
	            }
	            
	        }
			return out.toString();
    }
	

	
		    public String replaceSpace(StringBuffer str) {
		        String sti = str.toString();
		        char[] strChar = sti.toCharArray();
		        StringBuffer stb = new StringBuffer();
		        for(int i=0;i<strChar.length;i++){
		            if(strChar[i]==' '){
		                stb.append("%20");
		            }else{
		                stb.append(strChar[i]);
		            }
		        }
		        return stb.toString();
		    }
		
	
	public class Solution {
	    public String replaceSpace(StringBuffer str) {
	        char[] strChar = str.toString().toCharArray();
	        StringBuffer out =new StringBuffer();
	    	for(int i=0;i<=strChar.length;i++){
	            if (strChar[i]==' '){
	                out.append("20%");
	                
	            }else{
	                out.append(strChar[i]);
	            }
	            return out.toString();
	        }
	    }
	}

}
*/