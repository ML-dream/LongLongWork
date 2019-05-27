package mypackage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class send {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("发收端启动。。。。。。");
/*
 *   创建一个聊天程序的发送端
 *   思路:
 *   1.建立udp的socket的服务
 *   2.将要发送的数据封装到数据包中。3
 *   3.通过udp的socket服务将数据宝发送出去。
 *   
		*/
//	建立socket的服务，使用DatagramSocket对象
		DatagramSocket ds = new DatagramSocket(9993);
   BufferedReader  bufr= new BufferedReader(new InputStreamReader(System.in));
   String line =null;
   while((line=bufr.readLine())!=null){
	   byte[] buf =line.getBytes();
	  DatagramPacket dp= new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.43.34"),57566);
	   ds.send(dp);
	   if("886".equals(line))
		   break;
	   
   }
//关闭资源
   ds.close();
   
	
	}

}
