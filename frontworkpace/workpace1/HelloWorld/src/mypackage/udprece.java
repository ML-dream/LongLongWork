package mypackage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class udprece {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("���ն���������������");
/*
 * 
 * ����udp���ն˵�˼·��
 * 1.����udp��socket����
 * 2.���������ԣ����ڴ洢���յ������ݣ����������ݰ��Ķ��������Щ�迣��
 * 3.ʹ��socket�����received���������յ������ݴ洢�����ݰ��С�
 * 4.ͨ�����ݰ��ķ���������Щ����
 * 5.�ر���Դ��
 * 
		*/
	
//	   1.����udp socket����
		DatagramSocket ds= new DatagramSocket(8899);
//	
		while(true){	
//			2.�������ݰ�
		byte[] buf = new byte[1024];
		DatagramPacket dp=new DatagramPacket(buf,buf.length);
		
//		3.ʹ�ý��շ��������ݴ洢�����ݰ���
		ds.receive(dp);//����

//      4.ͨ�����ݰ�����ķ������������е����ݣ������ַ�˿� ��������
		String ip = dp.getAddress().getHostAddress();
		int port =dp.getPort();
	    String text = new String(dp.getData(),0,dp.getLength());
	    
		System.out.println(ip+":"+port+":"+text);

			
		}
		
	//		5.�ر���Դ
//		ds.close();	
		
	
	}

}
