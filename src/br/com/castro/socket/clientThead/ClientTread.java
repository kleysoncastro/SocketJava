package br.com.castro.socket.clientThead;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientTread {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(10000);
			
			while(true) {
				Socket s = ss.accept();
				Service servico = new Service(s);
				servico.start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	private static class Service extends Thread {
		Socket socket = null;
		
		public Service(Socket s) {
			this.socket = s;
		}
		
		public void run() {
			try {
				BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
				BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
				
				while(true) {
					int ch = bis.read();
					bos.write((byte)ch);
					bos.flush();
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
