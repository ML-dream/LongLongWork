package datacollection;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TEST06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		 c.set(Calendar.MINUTE, 0);
	     c.set(Calendar.SECOND, 0);
        c.set(Calendar.HOUR_OF_DAY,8);
      
        String demoDate11 = sdf.format(c.getTime());
        System.out.print(demoDate11);
	}

}
