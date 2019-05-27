package com.casit;

import java.net.UnknownHostException;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.Spring;

import org.jinterop.dcom.common.JIException;
import org.jinterop.dcom.core.JIVariant;
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

public class wode1 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		 String host = "192.168.11.190";  
		 String domain = "192.168.11.190"; //SIEMENS-789BE42 SIEMENS-789BE42 SIEMENS-789BE42(this computer)
		 String progId = "OPC.SINUMERIK.Machineswitch";  
		 String user = "auduser";  
		 String password = "SUNRISE"; 
		 //ServerList serverList = new ServerList(host,user,password,domain);  
		 System.out.println("111111111111111111111111111111");
		 //showAllOPCServer(serverList); 
		 
		 final ConnectionInformation ci = new ConnectionInformation();  
		 ci.setHost(host);  
    	 ci.setClsid("75d00afe-dda5-11d1-b944-9e614d000000");  //serverList.getClsIdFromProgId (progId)
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
	    final String itemId1="/Channel/MachineAxis/aavactB[1]";  
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
	    	  
	    	  
	  	    System.out.println("<<< first read: " + itemState1.getValue()); 
	  	    System.out.println("<<< first read: " + itemState2.getValue()); 
//	  	    System.out.println("<<< first read: " + itemState3.getValue()); 
//	  	 	 System.out.println("<<< first read: " + itemState4.getValue());
//	  		System.out.println("<<< first read: " + itemState5.getValue());
//	  		System.out.println("<<< first read: " + itemState6.getValue());
//	  	    System.out.println("<<< first read: " + itemState7.getValue());
	  	
	  	  Thread.sleep(1000);
	  	JSONStringer jst = new JSONStringer();  
	    }
	  
	      
//	    final JIVariant value = new JIVariant(100);  
//	    try {  
//	        System.out.println(">>> writing value: " + value.getObjectAsInt());  
//	        item.write(value);  
//	    } catch (JIException e) {  
//	        e.printStackTrace();  
//	    }  
//	      
//	    itemState = item.read(true);  
//	    System.out.println("<<< after writing: " + itemState.getValue());  
}  
	
	private static void sleep(int i) {
	}
	/** 
	 * 使用Async20Access类隔时间段地进行异步读取数据 
	 * Async20Access实现了IOPCDataCallback接口，基于事件回调的实现 
	 * @throws Exception 
	 */  
	public static void asyncRead(Server server) throws Exception{  
	    final String itemId = "a.a.h";  
	    //第三个参数用于设置初始化时是否执行访问  
	    AccessBase access = new Async20Access(server, 1000, false);  
	    access.addItem(itemId, new DataCallback(){  
	  
	      

			public void changed(Item item, ItemState itemState) {
				System.out.println(">>> Asynchronized read: value="   
	                    + itemState.getValue());  
			}  
	          
	    });  
	    access.bind();  
	    Thread.sleep(5*1000);  
	    access.unbind();  
	}
	
	protected static void showAllOPCServer(ServerList serverList)   
	        throws JIException, IllegalArgumentException, UnknownHostException {  
	      
	    final Collection<ClassDetails> detailsList = serverList.listServersWithDetails (  
	            new Category[] { Categories.OPCDAServer20 }, new Category[] {} );  
	      
	    for ( final ClassDetails details : detailsList )  
	    {  
	        System.out.println ( String.format ( "Found: %s", details.getClsId () ) );  
	        System.out.println ( String.format ( "\tProgID: %s", details.getProgId () ) );  
	        System.out.println ( String.format ( "\tDescription: %s", details.getDescription () ) );  
	    }  
	}  

}
