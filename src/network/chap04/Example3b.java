package network.chap04;

import java.io.BufferedInputStream; 
import java.io.BufferedOutputStream; 
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.nio.file.Files; 
import java.nio.file.Paths; 
import java.util.zip.ZipEntry; 
import java.util.zip.ZipInputStream;

public class Example3b {

	static void copyStream(InputStream in, OutputStream out) throws IOException{
		byte[] buffer = new byte[4096];
		while(true) {
			int count = in.read(buffer);
			if(count < 0) break;
			out.write(buffer, 0, count);
		}
	}
	
	static void createDirectory(String path) throws IOException{
		Files.createDirectories(Paths.get(path));
	}
	
	public static void main(String[] args) throws IOException{
		try (
			var in = new ZipInputStream(
					new BufferedInputStream(new FileInputStream("test.zip")));	
		) {
			while(true) {
				ZipEntry entry = in.getNextEntry();
				if(entry == null) break;
				
				String outputName = "zip_test2/" + entry.getName();
				if(entry.isDirectory()) {
					createDirectory(outputName);
				}else {
					String directory = new File(outputName).getParent();
					createDirectory(directory);
					try (
						var out = new BufferedOutputStream(
								new FileOutputStream(outputName));
					){
						copyStream(in, out);
					}
				}
			}
		}
	}
} 
