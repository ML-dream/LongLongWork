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
System.out.println("���ն���������������");
	/*
	 * ����һ��udp�Ľ��ն�
	 * ˼·��
	 * 1.����udp��socket�ķ�����ΪҪ���շ�������Ҫ��ȷһ���˿ںţ��ҷ��Ͷ�Ҫ����ն˶˶�˿ںű���һ�¡�
	 * 2������һ�����ݰ� �����ڴ洢���յ������ݡ�ͬʱ��������ݰ����Խ��յ����ݽ��н���
	 * 3.ʹ��socket�ķ�����receive�������յ����ݴ洢�����ݰ���
	 * 4.����
	 * 5.�ر�
	
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
