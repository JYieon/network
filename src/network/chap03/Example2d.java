package network.chap03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Example2d {
	
	static void copyText(Reader reader, Writer writer) throws IOException{
		while (true) {
			int ch = reader.read();
			if(ch < 0) break;
			writer.write(ch);
		}
		reader.close();
		writer.close();
	}
	public static void main(String[] args) throws IOException{
		Reader reader = new InputStreamReader(new FileInputStream("home.html"), "UTF-8");
		Writer writer = new OutputStreamWriter(new FileOutputStream("home2.html"), "euc-kr");
		copyText(reader, writer);
	}

}
