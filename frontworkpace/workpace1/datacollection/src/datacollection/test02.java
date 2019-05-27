package datacollection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
 
public class test02
{
    public static void main ( String[] args ) throws Exception
    {
    	
    	
    	System.out.println("NL-XS-009-18070216".substring(6));
    	
    	System.out.print(new Date());
       /* // 定义标记位：表示当前输入的是第几个数字
        // 0表示要输入第一个，1表示要输入第二个
        int where = 0;
        int i1 = 0;
        int i2 = 0;
        String str = null;
        BufferedReader buf = new BufferedReader (new InputStreamReader (System.in));
        // 定义一个死循环，但是里面用break改变逻辑，不再死
        while (true)
        {
            try
            {
                // 输入第一个数字
                if (where == 0)
                {
                    System.out.println ("输入第一个数字：");
                    str = buf.readLine ();
                    i1 = Integer.parseInt (str);
                    where = 1;
                }
                // 输入第二个数字
                if (where == 1)
                {
                    System.out.println ("输入第二个数字：");
                    str = buf.readLine ();
                    i2 = Integer.parseInt (str);
                }
                System.out.println ("两数相加之和等于：" + ( i1 + i2 ));
                // 关闭读入流
                buf.close ();
                // 跳出循环
                break;
            }
            // 捕获字符串转数字时的数字格式化异常
            catch (NumberFormatException e)
            {
                System.out.println ("输入数据不是数字类型数据请您更改 !");
                // 如果异常发生，结束当前循环，返回继续
                continue;
                
            }
        }*/
    }
}
