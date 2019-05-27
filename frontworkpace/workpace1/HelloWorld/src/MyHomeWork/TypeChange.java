package MyHomeWork;

public class TypeChange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
     byte b = 127;
//	 char b = 'a';	
     char c = 'W';
     short s = 23561;
     int i = 3333;
     long l = 4000000L;
     float f = 3.1415926F;
//     int d = (int)f;
     //低类型向高类型转换
     System.out.println("累加byte等于："+(int)f);
     System.out.println("累加char等于："+	(b+c+s));
     System.out.println("累加char等于："+	(b+c+s+i));
     System.out.println("累加char等于："+	(b+c+s+i+l));
     System.out.println("累加char等于："+	(i+f));
     System.out.println("累加char等于："+f);
	}

}
