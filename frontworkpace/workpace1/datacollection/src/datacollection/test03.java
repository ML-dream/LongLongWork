package datacollection;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test03 {
	 @SuppressWarnings("deprecation")
	public static void main ( String[] args ) throws Exception
	    {
		 
		 String beginTime=new String("2018-08-15 10:22:22"); 
	
		 	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		 	String createTime = df.format(new Date());
		 	Date bt=df.parse(beginTime); 
		 	Date et=df.parse(createTime); 
		 	/*System.out.print(bt.before(et));
		 	System.out.print(bt.before(et));*/
		 
		 	 Calendar c = Calendar.getInstance();
		        c.set(Calendar.HOUR_OF_DAY, 8);
		        c.add(Calendar.HOUR_OF_DAY, 4);
		        c.add(Calendar.HOUR_OF_DAY, 4);
		        c.set(Calendar.MINUTE, 0);
		        c.set(Calendar.SECOND, 0);
		        Date m6 = c.getTime();
		        System.out.println(df.format(m6));
		       
			
				
		 
		 if (bt.before(et)){ 
			 //System.out.print(createTime);
			}else{ 
			
			} 
		 	Date date = new Date();
		 	System.out.println("data1 = "+date.toLocaleString());
		 	date.setHours(new Date().getHours()+3);
		 	System.out.println("date2 = "+date.toLocaleString());
		 	
		/* while(true) {
			 
		 }*/
		 
		 
	    
	    }

}
