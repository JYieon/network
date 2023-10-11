package network.chap03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.zip.GZIPInputStream;

public class Example5c {
	
	public static void main(String[] args) throws IOException{
		Reader reader = new InputStreamReader(new GZIPInputStream(
							new BufferedInputStream(new FileInputStream("out2.txt.gz"))));
		Writer writer = new OutputStreamWriter(new BufferedOutputStream(System.out));
		while(true){
			int ch = reader.read();
			if(ch<0) break;
			writer.write(ch);
		}
		reader.close();
		writer.close();
	}

}
