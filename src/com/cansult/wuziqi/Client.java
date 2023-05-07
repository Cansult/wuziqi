package com.cansult.wuziqi;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client {
	
	Socket socket;
	InputStream is;
	OutputStream os;
	public void connect(String ip, int port) throws Exception {
		socket = new Socket(ip, port);

		//获取流
		is = socket.getInputStream();
		os = socket.getOutputStream();

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
	
	public void finalize() throws Exception {
		socket.close();
	}
}
