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
	System.out.println("���Ͷ���������������");
    /*
     * ����udp���Ͷˡ�
     * ˼·��
     * 1������UDP��socket����
     * 2.��Ҫ���͵����ݷ�װ�����ݰ��С�
     * 3.ͨ��udp��socket�������ݰ����ͳ�ȥ��
     * 4.�ر�socket����
		*/
//     1.udpsocket	����ʹ��datasocketpacket�Ķ���
	 DatagramSocket ds =new DatagramSocket(54786); 
//	 ����Ҫ��ȷ�˿ںš�
//		2.��Ҫ���͵����ݷ�װ�����ݰ���

	
 	    BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
	 	String line=null;
	 	while((line=bufr.readLine())!=null){
//		 sʹ��DatagramPacket�����ݷ�װ���ö�����С�
//		 InetAddress ip =InetAddress.getLocalHost();
			
		
	 		byte[] buf =line.getBytes();
	 		DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.43.34"),57754);
		 
//		 3.ͨ��udp�ķ������ݰ����ͳ�ȥ��ʹ��send������
		 ds.send(dp);	}
	

//	 4.�ر���Դ��
	 ds.close();
	 
	 
			

	}


	
		
	

}
