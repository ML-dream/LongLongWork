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
//		1.�ֱ���udp send��receive�� ��socket����
		DatagramSocket send =new DatagramSocket();//���Բ�����˿ں�
		DatagramSocket rece =new DatagramSocket(20311);//���붨��˿ں�
		new Thread(new Chatsend(send)).start();//ͨ�����캯��new���Ͷ˵Ķ��󣬲���װ��һ���߳����棬������
		new Thread(new Chatrece(rece)).start();//ͨ�����캯��new���ն˵Ķ��󣬲���װ��һ���߳����棬������
	}

}
