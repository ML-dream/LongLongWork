package test2;
public class ggg {
    
    public static void main(String[] args) { 
        ggg t = new ggg(); 
        int a=99; 
        t.test1(a);//这里传递的参数a就是按值传递 
        System.out.println(a);
         
        MyObj obj=new MyObj(); 
        t.test2(obj);//这里传递的参数obj就是引用传递
        System.out.println(obj.b);
    } 
     
    public void test1(int a){ 
        a=a+1;
        System.out.println(a);
        } 
     
    public void test2(MyObj g){ 
        g.b=166666;
        System.out.println(g.b);
        }
    
    
}

class MyObj{
    public int b=99;
}