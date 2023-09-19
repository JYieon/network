package network.chap02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example1a {
	
	public static void main(String[] args) throws IOException{
		final String filePath = "out.txt";
		
		FileOutputStream out = new FileOutputStream(filePath);
		byte[] a  = new byte[] { 'h', 'e', 'l', 'l','o', 32, 119, 111, 114, 108, 100 }; 
		out.write(a);
		out.close();
		
		FileInputStream in = new FileInputStream(filePath);
		byte[] buffer = new byte[100];
		int count = in.read(buffer);
		for (int i = 0; i<count;++i)
			System.out.print((char)buffer[i]);
		in.close();
	}
}
