package network.chap08;

import java.net.Socket;

public class PortScanner1 {

	public static void main(String[] args) {
		String host = "www.skhu.ac.kr";
		int portFrom = 1, portTo = 10000;
		
		for(int port = portFrom; port <= portTo; ++port) {
			System.out.printf("%s %d", host, port);
			try(Socket socket = new Socket(host, port)){
				System.out.println("연결 성공");
			} catch (Exception e) {
				System.out.println(e.getClass().getName()+" "+e.getMessage());
			}
		}
	}
}
