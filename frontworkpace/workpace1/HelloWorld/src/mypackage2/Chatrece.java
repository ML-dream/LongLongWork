package mypackage2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/*
 * 
 * 建立udp接收端的思路：
 * 1.建立udp的socket服务
 * 2.创建数据脑，用于存储接收到的数据，方便用数据包的对象解析这些疏浚。
 * 3.使用socket服务的received方法将接收到的数据存储到数据包中。
 * 4.通过数据包的方法解析这些数据
 * 5.关闭资源。
 * 
		*/
public class Chatrece implements Runnable
{

  private DatagramSocket ds;
  public Chatrece(DatagramSocket ds)
  {
	  this.ds=ds;
	  
  }
  @Override
  public void run()
  {
	
	  try {
		while(true)
		  {
//		      	创建数据包
			  byte[] buf = new byte[1024];
			  DatagramPacket dp =new DatagramPacket(buf,buf.length);
//			  使用接收方法将数据存储到数据包中
				ds.receive(dp);
			
				
//				通过数据包对象的方法，解析其中的数据，比如地址端口 数据内容
			  String ip = dp.getAddress().getHostAddress();
//			  int port =dp.getPort();
			  String text =new String(dp.getData(),0,dp.getLength());
			  System.out.println(ip+"::"+text);
			  //设置退出聊天室 的的程序
			  if(text.equals("886"))
			  {
				  System.out.println(ip+"...退出聊天室");
			 
		      } 
		 
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 
  }
  
}
