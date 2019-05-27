package mypackage2;

import java.io.IOException;
import java.net.DatagramSocket;


 public class Chatdemo 
 {
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
//		1.分别建立udp send和receive端 的socket服务
		DatagramSocket send =new DatagramSocket();//可以不定义端口号
		DatagramSocket rece =new DatagramSocket(20311);//必须定义端口号
		new Thread(new Chatsend(send)).start();//通过构造函数new发送端的对象，并封装到一个线程里面，并启动
		new Thread(new Chatrece(rece)).start();//通过构造函数new接收端的对象，并封装到一个线程里面，并启动
	}

}
