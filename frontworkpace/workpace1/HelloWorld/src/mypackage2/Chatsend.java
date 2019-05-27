package mypackage2;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Chatsend implements Runnable
{
	 /*
     * ����udp���Ͷˡ�
     * ˼·��
     * 1������UDP��socket����
     * 2.��Ҫ���͵����ݷ�װ�����ݰ��С�
     * 3.ͨ��udp��socket�������ݰ����ͳ�ȥ��
     * 4.�ر�socket����
		*/
	private DatagramSocket ds;
	

	public Chatsend(DatagramSocket ds)
	{
		
		// TODO Auto-generated constructor stub
	      this.ds = ds;
	}
	public void run ()
	   {
//		                                  ��Ҫ���͵����ݷ�װ�����ݰ���
			BufferedReader bufr =new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			try {
				while((line=bufr.readLine())!=null)
				   {
//					 ʹ��DatagramPacket�����ݷ�װ���ö�����С�
//					InetAddress ip =InetAddress.getLocalHost();
					byte[] buf =line.getBytes();
					DatagramPacket dp = new DatagramPacket (buf,buf.length,InetAddress.getByName("192.168.43.255"),20311);	
				   	
//					 ͨ��udp�ķ������ݰ����ͳ�ȥ��ʹ��send������
					   ds.send(dp);
                                            
					if("886".equals(line))
						break;
				    }
			           } 
			               catch (UnknownHostException e)
			               {
				
				             e.printStackTrace();
			            }  
			                    catch (IOException e) {
				// TODO Auto-generated catch block
				           e.printStackTrace();
			            }
		              ds.close();
	
	    }

 }
