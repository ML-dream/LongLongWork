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
		System.out.println("���ն�����������������");
/*
 *   ����һ���������ķ��Ͷ�
 *   ˼·:
 *   1.����udp��socket�ķ���
 *   2.��Ҫ���͵����ݷ�װ�����ݰ��С�3
 *   3.ͨ��udp��socket�������ݱ����ͳ�ȥ��
 *   
		*/
//	����socket�ķ���ʹ��DatagramSocket����
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
//�ر���Դ
   ds.close();
   
	
	}

}
