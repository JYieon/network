package network.chap10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class UDPClient1a {

    public static void main(String[] args)  {
        for (int i = 0; i < 100; ++i) {
			new Thread(new SendTask()).start();
		}
    }

    static class SendTask implements Runnable {
        @Override
        public void run() {
            final String HOST = "localhost";
            final int PORT = 7070;
            try (DatagramSocket socket = new DatagramSocket(0)) {
                InetAddress hostAddress = InetAddress.getByName(HOST);
                for (int i = 0; i < 10; ++i) {
                    System.out.printf("sending %d\n", i);
                    String s = String.format("%tT", new Date());
                    byte[] data = s.getBytes("US-ASCII");
                    DatagramPacket packet = new DatagramPacket(data, data.length, hostAddress, PORT);
                    socket.send(packet);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

