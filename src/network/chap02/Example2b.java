package network.chap02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Example2b {
		
	public static void main(String[] args) throws IOException{
		var url = new URL("https://www.skhu.ac.kr/sites/skhu/images/sub/ideo_3.jpg");
		var connection = (HttpURLConnection)url.openConnection();
		InputStream in = connection.getInputStream();
		FileOutputStream out = new FileOutputStream("ideo_3.jpg");
		while (true) {
			int b = in.read();
			if (b<0) break;
			out.write(b);
		}
		in.close();
		out.close();
	}
}
