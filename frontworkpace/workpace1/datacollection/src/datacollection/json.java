package datacollection;

import org.json.JSONException;
import org.json.JSONStringer;

public class json {
	
	
	
	public static void main (String[] args) throws JSONException{  
        JSONStringer jst = new JSONStringer();  
        //json对象开始  
        jst.object();  
        jst.key("name");  
        jst.value("owen");  
          
        jst.key("sss");  
        jst.value(21);  
          
        
    jst.endObject();  
    System.out.println(jst.toString());  
    }  

}
