package datacollection;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String date =  new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println(date);
   	 method2("E:\\"+date+".txt", new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date())+"   ");
   	/* method2(date, itemState1.getValue()+"   ");
   	 method2(date, itemState1.getValue()+"   ");
   	 method2(date, itemState1.getValue()+"/r/n");*/
		
	}
		
	
	
	public static void method2(String file, String conent) {
    	BufferedWriter out = null;
    	try {
    	out = new BufferedWriter(new OutputStreamWriter(
    	new FileOutputStream(file, true)));
    	out.write(conent);
    	} catch (Exception e) {
    	e.printStackTrace();
    	} finally {
    	try {
    	out.close();
    	} catch (IOException e) {
    	e.printStackTrace();
    	}
    	}
    	}

}
