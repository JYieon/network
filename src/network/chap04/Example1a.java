package network.chap04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Example1a {

	static void download(String url, String path) throws IOException{
		var urlobj = new URL(url);
		var connection = (HttpURLConnection)urlobj.openConnection();
		InputStream in = new BufferedInputStream(connection.getInputStream());
		OutputStream out = new BufferedOutputStream(new FileOutputStream(path));
		while(true) {
			int b = in.read();
			if(b<0) break;
			out.write(b);
		}
		in.close();
		out.close();
		connection.disconnect();
	}
	public static void main(String[] args) throws IOException{
		File directory = new File("zip_test");
		if (directory.exists() == false)
			directory.mkdir();
		download("https://www.naver.com", "zip_test/naver.html");
		download("https://news.naver.com", "zip_test/news.html");
		download("https://map.naver.com", "zip_test/map.html");
	}
}
