package test2;

import java.io.UnsupportedEncodingException;

public class tesrttt {
//ua程序的话：首先得先配置好机床上的东西，之后再链接机床的opc服务器，链接的时候需要证书进行授权的额，其次，还要链接对应的ip和端口号！之后进行连接，还要配置电脑的信息
	//同时电脑的信息还要进行配置
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String aa = new String("你好".getBytes("utf-8"),"utf-8");
		System.out.print(aa);
		System.out.print("你好".getBytes("ISO-8859-1"));
		System.out.print(aa);
		
	}

}
