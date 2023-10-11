package network.chap03;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Example2b {
	
	public static void main(String[] args) throws IOException{
		var url = new URL("https://www.skhu.ac.kr");
		var connection = (HttpURLConnection)url.openConnection();
		Reader reader = new InputStreamReader(connection.getInputStream());
		while(true) {
			int ch = reader.read();
			if(ch<0) break;
			System.out.print((char)ch);
 		}
		reader.close();
	}

}
