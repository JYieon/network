package network.chap03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

public class Example4c {

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(
									new GZIPInputStream(new FileInputStream("out2.txt.gz"))));
		while(true) {
			String s = reader.readLine();
			if(s==null)break;
			System.out.println(s);
		}
		reader.close();
	}
}
