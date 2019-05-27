/*
 * 
 */
public class InnerClass {
		 int a= 2;
	     static  class Inner{
			InnerClass b =new InnerClass();
		    void run() {
		    	System.out.println(b.a);
		    }
		
	}
		public static void main (String[] args){
			Inner c=new Inner();
			c.run();
		}
	}
	
