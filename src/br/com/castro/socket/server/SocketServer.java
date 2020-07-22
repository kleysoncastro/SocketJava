package br.com.castro.socket.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	
	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(10000);
			
			while(true) {
				Socket s = ss.accept();
				BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
				BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
