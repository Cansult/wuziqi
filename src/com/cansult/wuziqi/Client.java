package com.cansult.wuziqi;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client {
	
	InputStream is;
	OutputStream os;
	public void connect(String ip, int port) throws Exception {
		Socket socket = new Socket(ip, port);

		//获取流
		is = socket.getInputStream();
		os = socket.getOutputStream();

		//读取服务器发来的信息
		// byte[] b = new byte[1024];
		// is.read(b);
		//
		// String msg = new String(b);
		// System.out.println("服务器说："+msg.trim());

//		while(true) {
//			readMsg(is);
//		}
	}
	public int readMsg() {
		int x = 0;
		try {
			x = is.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	public void sendMsg(int x) {
		try {
			os.write(x);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
