package network.chap02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Example2d {

	static void copyStream(InputStream in, OutputStream out) throws IOException{
		while(true) {
			int b = in.read();
			if(b<0) break;
			out.write(b);
		}
		in.close();
		out.close();
	}
	public static void main(String[] args) throws IOException{
		var url = new URL("https://www.skhu.ac.kr/sites/skhu/images/sub/ideo_3.jpg");
		var connection = (HttpURLConnection)url.openConnection();
		InputStream in = connection.getInputStream();
		FileOutputStream out = new FileOutputStream("ideo_3.jpg");
		copyStream(in,out);
		
		FileInputStream in2 = new FileInputStream("ideo_3.jpg");
		FileOutputStream out2 = new FileOutputStream("ideo_3_copy.jpg");
		copyStream(in2, out2);
	}
}
