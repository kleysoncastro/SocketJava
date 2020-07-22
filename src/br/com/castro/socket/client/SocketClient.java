package br.com.castro.socket.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;

public class SocketClient {

	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("localhost", 10000);
			
			BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
			BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
			
			String dado = "dados do clinte";
			
			while(true) {
				
				for(int i = 0; i < dado.length(); i++) {
					
					byte b = (byte)dado.charAt(i);
					bos.write(b);
					bos.flush();
					
					char ch = (char)bis.read();
					System.out.println("recebido no clinte " + ch);
					
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
