package mypackage2;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Chatsend implements Runnable
{
	 /*
     * 创建udp发送端。
     * 思路：
     * 1，建立UDP的socket服务。
     * 2.将要发送的数据封装到数据包中。
     * 3.通过udp的socket服务将数据包发送出去。
     * 4.关闭socket服务。
		*/
	private DatagramSocket ds;
	

	public Chatsend(DatagramSocket ds)
	{
		
		// TODO Auto-generated constructor stub
	      this.ds = ds;
	}
	public void run ()
	   {
//		                                  将要发送的数据封装到数据包中
			BufferedReader bufr =new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			try {
				while((line=bufr.readLine())!=null)
				   {
//					 使用DatagramPacket将数据封装到该对象包中。
//					InetAddress ip =InetAddress.getLocalHost();
					byte[] buf =line.getBytes();
					DatagramPacket dp = new DatagramPacket (buf,buf.length,InetAddress.getByName("192.168.43.255"),20311);	
				   	
//					 通过udp的服务奖数据包发送出去。使用send方法。
					   ds.send(dp);
                                            
					if("886".equals(line))
						break;
				    }
			           } 
			               catch (UnknownHostException e)
			               {
				
				             e.printStackTrace();
			            }  
			                    catch (IOException e) {
				// TODO Auto-generated catch block
				           e.printStackTrace();
			            }
		              ds.close();
	
	    }

 }
