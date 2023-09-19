package network.chap02;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class Example4b {
	
	public static void main(String[] args) throws IOException {
		InputStream in = new GZIPInputStream(new BufferedInputStream(
				new FileInputStream("out2.txt.gz")));
		while (true) {
			int b = in.read();
			if (b<0) break;
			System.out.print((char)b);
		}
		in.close();
	}

}
