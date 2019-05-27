package com.casit;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import org.jinterop.dcom.common.JIException;
import org.jinterop.dcom.common.JISystem;
import org.jinterop.dcom.core.JIVariant;
import org.openscada.opc.lib.common.ConnectionInformation;
import org.openscada.opc.lib.common.NotConnectedException;
import org.openscada.opc.lib.da.AddFailedException;
import org.openscada.opc.lib.da.AutoReconnectController;
import org.openscada.opc.lib.da.DuplicateGroupException;
import org.openscada.opc.lib.da.Group;
import org.openscada.opc.lib.da.Item;
import org.openscada.opc.lib.da.Server;
public class wode2 {
 public static void main(String[] args){
  AutoReconnectController autos = null;
  try {
   JISystem.setAutoRegisteration(true);
   
   ConnectionInformation ci = new ConnectionInformation();
   ci.setHost("192.168.0.104");
   ci.setDomain("192.168.0.104");
   ci.setProgId("Knight.OPC.Server.Demo");
//   ci.setClsid("B57C679B-665D-4BB0-9848-C5F2C4A6A280");
   ci.setUser("dzq");
   ci.setPassword("123");
   
   
   final Server s = new Server(ci,Executors.newSingleThreadScheduledExecutor());
         autos = new AutoReconnectController(s);
         autos.connect();
         Thread.sleep(100);
         
   
   
//   dumpTree(s.getTreeBrowser().browse(),0);
   
            Group group = s.addGroup("group");
            group.setActive(true);
            final Item item = group.addItem("Channel1.Device1.D0");
            item.setActive(true);
            Thread.sleep(100);
            System.out.println("读取值："+item.read(false).getValue().getObjectAsUnsigned().getValue());
            JIVariant value = JIVariant.makeVariant(new Integer(777));
   item.write(value);
   
   
//   final AccessBase access = new Async20Access(s,100,false);
//            access.addItem ( "sim.test.D0", new DataCallbackDumper());
//            access.bind ();
//            Thread.sleep(100*1000);
//            access.unbind();
           
  } catch (IllegalArgumentException e) {
   e.printStackTrace();
  } catch (UnknownHostException e) {   
   e.printStackTrace();
  } catch (JIException e) {  
   e.printStackTrace();
  } catch (NotConnectedException e) {  
   e.printStackTrace();
  } catch (DuplicateGroupException e) {              
   e.printStackTrace();
  } catch (AddFailedException e) {
   e.printStackTrace();
  } catch (InterruptedException e) {
   e.printStackTrace();
  }finally{
   autos.disconnect();
  }  
 }
}