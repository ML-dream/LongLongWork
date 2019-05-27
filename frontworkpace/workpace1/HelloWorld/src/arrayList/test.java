package arrayList;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] int7=new int[5];
		int7[2]=10;
		System.out.println(int7[2]);
		Integer integer1 = 127;  
		Integer integer2 = 127;  
		System.out.println("integer1==integer2: " + (integer1 == integer2));// true  自动装箱的两个缓存中
		System.out.println("integer1.equals(integer2): " + (integer1.equals(integer2)));// true  
		System.out.println("integer1.compare(integer2): " + integer1.compareTo(integer2));// 0      
		Integer integer3 = 200;  
		Integer integer4 = 200;  
		System.out.println("integer3==integer4: " + (integer3 == integer4));// false 自动装箱的两个new Integer的引用比较  
		System.out.println("integer3>integer4: " + (integer3 > integer4)); // false 将两个对象拆箱，再比较大小  
		System.out.println("integer3.equals(integer4): " + (integer3.equals(integer4)));// true  
		System.out.println("integer3.compare(integer4): " + integer3.compareTo(integer4));// 0     
		Integer integer5 = new Integer(100);  
		Integer integer6 = new Integer(100);  
		System.out.println("integer5==integer6: " + (integer5 == integer6)); // false 两个不同的Integer对象引用的比较  
		System.out.println("integer5.equals(integer6): " + (integer5.equals(integer6)));// true  原来已经进行了重写，所以比较的是里面的value
		System.out.println("integer5.compare(integer6): " + integer5.compareTo(integer6));// 0      
		int int1 = 100;  
		System.out.println("integer1==int1: " + (integer1 == int1));// true  Integer缓存对象拆箱后与int比较  
		System.out.println("integer1.equals(int1): " + (integer1.equals(int1)));// true  
		System.out.println("integer1.compare(int1): " + integer1.compareTo(int1));// 0        
		int int2 = 200;  
		System.out.println("integer3==int2: " + (integer3 == int2));// true  Integer对象拆箱后与int比较  
		System.out.println("integer3.equals(int2): " + (integer3.equals(int2)));// true  
		System.out.println("integer3.compare(int2): " + integer3.compareTo(int2));// 0   
		int in1 = 223;  
		int in2 = 223;  
		System.out.println("int1==int2: " + (in1 == in2));// true 对于基本数据类型，比较的都是大小值
	}

}
