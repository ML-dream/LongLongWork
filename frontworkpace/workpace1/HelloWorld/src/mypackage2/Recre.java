package mypackage2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Recre {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		

		
		System.out.println("启动1");
			ServerSocket ss = new ServerSocket(8898);
			System.out.println("启动2");
			Socket s = ss.accept();
			System.out.println("启动3");
		
			InputStream in =s.getInputStream();
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			String text = new String(buf,0,buf.length);
			System.out.println(text);
			OutputStream out = s.getOutputStream();
			s.close();
		
		   
		
		
	}

}
