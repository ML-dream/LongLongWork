package mypackage2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class receive {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
System.out.println("接收端启动。。。。。");
	/*
	 * 建立一个udp的接收端
	 * 思路：
	 * 1.建立udp的socket的服务，因为要接收服务，所以要明确一个端口号，且发送端要与接收端端额端口号保持一致。
	 * 2；创建一个数据包 ，用于存储接收到的数据。同时用这个数据包来对接收的数据进行解析
	 * 3.使用socket的方法的receive方法接收的数据存储到数据包中
	 * 4.解析
	 * 5.关闭
	
	*/
//	1111



DatagramSocket ds= new DatagramSocket(57566);

while(true){byte[] buf =new byte [1024];
DatagramPacket dp = new DatagramPacket(buf,buf.length);
ds.receive(dp);
String ip = dp.getAddress().getHostAddress();
int port= dp.getPort();
String text =new String(dp.getData(),0,dp.getLength());
System.out.println(ip+":"+port+":"+text);
}


//555
//ds.close();

	}
	

}
