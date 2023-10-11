package network.chap03;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Example1c {

	public static void main(String[] args) throws IOException{
		Writer writer = new FileWriter("out.txt");
		writer.write("안녕하세요 여러분\n");
		writer.close();
		
		Reader reader = new FileReader("out.txt");
		while (true) {
			int ch = reader.read();
			if(ch<0) break;
			System.out.printf("%d ", ch);
		}
		reader.close();
	}
}
