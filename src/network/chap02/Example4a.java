package network.chap02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class Example4a {

	static void copyStream(InputStream in, OutputStream out) throws IOException {
		while (true) {
			int b = in.read();
			if(b<0) break;
			out.write(b);;
		}
		in.close();
		out.close();
	}
	
	public static void main(String[] args) throws IOException {
		OutputStream out = new BufferedOutputStream(new FileOutputStream("out.txt"));
		byte[] a = new byte[] { 'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', '\n' };
		for (int i = 0; i<10000;++i)
			out.write(a);
		out.close();
		
		InputStream in1 = new BufferedInputStream(new FileInputStream("out.txt"));
		OutputStream out1 = new BufferedOutputStream(new FileOutputStream("out1.txt"));
		copyStream(in1, out1);
		
		InputStream in2 = new BufferedInputStream(new FileInputStream("out.txt"));
		OutputStream out2 = new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream("out2.txt.gz")));
		copyStream(in2, out2);
	}
}
