package network.chap08; 

import java.io.IOException; 
import java.io.InputStream; 
import java.net.Socket; 
import java.net.UnknownHostException; 

public class Date1 { 
	
	static String getTime() throws UnknownHostException, IOException { 
		try (Socket socket = new Socket("time.nist.gov", 13)) { 
			StringBuilder result = new StringBuilder(); 
			InputStream in = socket.getInputStream(); 
			while (true) { 
				int c = in.read(); 
				if (c == -1) break; 
				result.append((char)c); 
			} 
			return result.toString(); 
		} 
	} 
	
	public static void main(String[] args) throws UnknownHostException, IOException { 
		System.out.println(getTime()); 
	} 
}