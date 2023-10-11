package network.chap03;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Example5a {

	public static void main(String[] args) throws IOException{
		Reader reader = new InputStreamReader(new BufferedInputStream(System.in));
		char[] a = new char[100];
		while (true) {
			int count = reader.read(a);
			if(count < 0) break;
			System.out.println(a);
		}
		reader.close();
	}
}
