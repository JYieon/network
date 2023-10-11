package network.chap03;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

public class Example2c {
	
	static void copyText(Reader reader, Writer writer) throws IOException{
		while(true) {
			int ch = reader.read();
			if(ch<0) break;
			writer.write(ch);
		}
		reader.close();
		writer.close();
	}
	
	public static void main(String[] args) throws IOException{
		var url = new URL("https://www.skhu.ac.kr");
		var connection = (HttpURLConnection)url.openConnection();
		Reader reader = new InputStreamReader(connection.getInputStream());
		Writer writer = new FileWriter("home.html");
		copyText(reader, writer);
	}

}
