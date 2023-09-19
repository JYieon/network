package network.chap02;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Example2a {
	
	public static void main(String[] args) throws IOException{
		var url = new URL("https://www.skhu.ac.kr");
		var connection = (HttpURLConnection)url.openConnection();
		InputStream in = connection.getInputStream();
		while(true) {
			int b = in.read();
			if(b<0) break;
			System.out.print((char)b);
		}
		in.close();
	}
}
