package datacollection;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.Spring;

import org.jinterop.dcom.common.JIException;
import org.jinterop.dcom.core.JIVariant;
import org.json.JSONStringer;
import org.openscada.opc.dcom.list.ClassDetails;
import org.openscada.opc.lib.common.AlreadyConnectedException;
import org.openscada.opc.lib.common.ConnectionInformation;
import org.openscada.opc.lib.da.AccessBase;
import org.openscada.opc.lib.da.Async20Access;
import org.openscada.opc.lib.da.DataCallback;
import org.openscada.opc.lib.da.Group;
import org.openscada.opc.lib.da.Item;
import org.openscada.opc.lib.da.ItemState;
import org.openscada.opc.lib.da.Server;
import org.openscada.opc.lib.list.Categories;
import org.openscada.opc.lib.list.Category;
import org.openscada.opc.lib.list.ServerList;


public class DaDataCollection {

	/**
	 * 840d数据采集
	 * 版权声明 ：
	 *	     本样板的所有内容，包括文字、图片,均为原创。对未经许可擅自使用者，本公司保留追究其法律责任的权利！
	 *												声明人：戴志强
	 * 时间：2018-05-15
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		 String host = "169.254.19.";  
		 String domain = "169.254.19.204"; 
		 //SIEMENS-789BE42 SIEMENS-789BE42 SIEMENS-789BE42(this computer)
		 String progId = "OPC.SINUMERIK.Machineswitch";  
		 String user = "auduser";  
		 String password = "SUNRISE"; 
		 //ServerList serverList = new ServerList(host,user,password,domain);  
		 //showAllOPCServer(serverList); 
		 
		 final ConnectionInformation ci = new ConnectionInformation();  
		 ci.setHost(host);  
    	 ci.setClsid("75d00afe-dda5-11d1-b944-9e614d000000");  
    	 //serverList.getClsIdFromProgId (progId)
    	 // System.out.println("11111111111"+serverList.getClsIdFromProgId (progId));
		 ci.setUser(user);  
		 ci.setPassword(password);
		 
		 ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();  
		 Server server = new Server(ci, exec);  
		 server.connect();
         //	 asyncRead(server);
		 syncWrite(server);
	    }
	
	
	    public static void syncWrite(Server server) throws Exception{  
	    final String itemId1="/Channel/ProgramInfo/progName[u1]";  
	    final String itemId2="/Channel/MachineAxis/actToolBasePos[u1,1]"; 
//	    final String itemId3="/Drive Hsa/State/actual Current[u<1 1>]"; //dianliu
//	    final String itemId4="/Drive Hsa/State/actual Speed[u<1 1>]"; //主轴转速
//	    final String itemId5="/Nck/Spindle/ac Const Cuts[<1 1>]"; //且学速度
//	    final String itemId6="/Tool/Data/tool State[u<1 1>,<1 1>]"; //dao ju zhuang tai
//	    final String itemId7="/Channel/ Geometric Axis/act Feed Rate[u1,1]"; //  x axis jingeilv
	    //final String itemId3="/Bag/State/opMode[u1]"; 
	    //final String itemId3="/Bag/State/opMode[u1]"; 
	    
	    
	    Group group = server.addGroup("test");  
	    Item item1 = group.addItem(itemId1);
	    Item item2 = group.addItem(itemId2); 
//	    Item item3 = group.addItem(itemId3); //get item for writing  
//	    Item item4 = group.addItem(itemId4);
//	    Item item5 = group.addItem(itemId5);
//	    Item item6 = group.addItem(itemId6);
//	    Item item7 = group.addItem(itemId7);
	      
	    //第一次读  
	    while(true){
	    	  ItemState itemState1 = item1.read(true); 
	    	  ItemState itemState2 = item2.read(true); 
//	    	  ItemState itemState3 = item3.read(true); 
//	    	  ItemState itemState4 = item4.read(true); 
//	    	  ItemState itemState5 = item5.read(true); 
//	    	  ItemState itemState6 = item6.read(true); 
//	    	  ItemState itemState7 = item7.read(true); 

	    	  
	    	 method2("E:\\dd.txt", new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date())+"/b");
	    	 method2("E:\\dd.txt", itemState1.getValue()+"/b");
	    	 method2("E:\\dd.txt", itemState1.getValue()+"/b");
	    	 method2("E:\\dd.txt", itemState1.getValue()+"/r/n");
	    	  
	  	    System.out.println("<<< first read: " + itemState1.getValue()); 
	  	    System.out.println("<<< first read: " + itemState2.getValue()); 
//	  	    System.out.println("<<< first read: " + itemState3.getValue()); 
//	  	 	 System.out.println("<<< first read: " + itemState4.getValue());
//	  		System.out.println("<<< first read: " + itemState5.getValue());
//	  		System.out.println("<<< first read: " + itemState6.getValue());
//	  	    System.out.println("<<< first read: " + itemState7.getValue());
	  	
	  	    //Thread.sleep(1000);
		  	/*JSONStringer jst = new JSONStringer();  
	        //json对象开始  
		  	jst.object();  
	        jst.key("name");  
	        jst.value("owen");  
	          
	        jst.key("age");  
	        jst.value(21);  
	          
	        jst.key("friends");  
	            JSONStringer jst2 = new JSONStringer();  
	            jst2.object();  
	                jst2.key("1");  
	                jst2.value("张三");  
	                  
	                jst2.key("2");  
	                jst2.value("李四");  
	            jst2.endObject();  
	        jst.value(jst2);  
	          
	        jst.key("爱好");  
	            JSONStringer jst3 = new JSONStringer();  
	            jst3.array();  
	                jst3.value("游泳");  
	                jst3.value("唱歌");  
	                jst3.value("跳舞");  
	             jst3.endArray();  
	         jst.value(jst3);  
	    jst.endObject();  
	    System.out.println(jst.toString());*/ 
	    }
	    
	    

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
