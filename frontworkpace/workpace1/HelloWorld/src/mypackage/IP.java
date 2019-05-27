package mypackage;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IP {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub

		
		InetAddress ip =InetAddress.getLocalHost();
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getHostName());
	}

}
