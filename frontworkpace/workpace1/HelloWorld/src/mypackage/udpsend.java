package mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpsend {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException  {
	System.out.println("发送端启动。。。。。");
    /*
     * 创建udp发送端。
     * 思路：
     * 1，建立UDP的socket服务。
     * 2.将要发送的数据封装到数据包中。
     * 3.通过udp的socket服务将数据包发送出去。
     * 4.关闭socket服务。
		*/
//     1.udpsocket	服务。使用datasocketpacket的对象。
	 DatagramSocket ds =new DatagramSocket(54786); 
//	 必须要明确端口号。
//		2.将要发送的数据封装到数据包中

	
 	    BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
	 	String line=null;
	 	while((line=bufr.readLine())!=null){
//		 s使用DatagramPacket将数据封装到该对象包中。
//		 InetAddress ip =InetAddress.getLocalHost();
			
		
	 		byte[] buf =line.getBytes();
	 		DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.43.34"),57754);
		 
//		 3.通过udp的服务奖数据包发送出去。使用send方法。
		 ds.send(dp);	}
	

//	 4.关闭资源，
	 ds.close();
	 
	 
			

	}


	
		
	

}
