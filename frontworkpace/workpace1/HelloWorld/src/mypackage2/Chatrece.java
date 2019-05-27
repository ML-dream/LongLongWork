package mypackage2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
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
//		      	�������ݰ�
			  byte[] buf = new byte[1024];
			  DatagramPacket dp =new DatagramPacket(buf,buf.length);
//			  ʹ�ý��շ��������ݴ洢�����ݰ���
				ds.receive(dp);
			
				
//				ͨ�����ݰ�����ķ������������е����ݣ������ַ�˿� ��������
			  String ip = dp.getAddress().getHostAddress();
//			  int port =dp.getPort();
			  String text =new String(dp.getData(),0,dp.getLength());
			  System.out.println(ip+"::"+text);
			  //�����˳������� �ĵĳ���
			  if(text.equals("886"))
			  {
				  System.out.println(ip+"...�˳�������");
			 
		      } 
		 
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 
  }
  
}
