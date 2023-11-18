package network.chap04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Example3a {

	static void copyStream(InputStream in, OutputStream out) throws IOException{
		byte[] buffer = new byte[4096];
		while(true) {
			int count = in.read(buffer);
			if(count < -1) break;
			out.write(buffer, 0, count);
		}
	}
	public static void main(String[] args) throws IOException{
		try (
			var in = new ZipInputStream(
					new BufferedInputStream(new FileInputStream("test.zip")));	
		) {
			while(true) {
				ZipEntry entry = in.getNextEntry();
				if(entry == null) break;
				try(
					var out = new BufferedOutputStream(
							new FileOutputStream("zip_test2/"+entry.getName()));
				){
					copyStream(in, out);
				}
			}
		}
	}
} // 디렉토리를 생성하는 코드를 구현하지 않아 오류. Example3b.java에 구현
