package network.chap04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class AutoDisconnect implements AutoCloseable{
	HttpURLConnection connection;
	
	public AutoDisconnect(HttpURLConnection connection) {
		this.connection = connection;
	}
	
	@Override
	public void close() throws Exception{
		connection.disconnect();
	}
}

public class Example1e {

	static void download(String url, String path) throws Exception{
		var urlobj = new URL(url);
		var connection = (HttpURLConnection)urlobj.openConnection();
		try(
			InputStream in = new BufferedInputStream(connection.getInputStream());
			OutputStream out = new BufferedOutputStream(new FileOutputStream(path));
			AutoDisconnect autoDisconnect = new AutoDisconnect(connection);
		){
			while (true) {
				int b = in.read();
				if(b<0) break;
				out.write(b);
			}
		}	
	}
	
	public static void main(String[] args) throws Exception{
		File directory = new File("zip_test");
		if(directory.exists()==false)
			directory.mkdir();
		download("http://www.naver.com", "zip_test/naver.html");
		download("http://news.naver.com", "zip_test/naver_news.html");
		download("http://map.naver.com", "zip_test/naver_map.html");
	}
}
