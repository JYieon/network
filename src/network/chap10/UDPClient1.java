package network.chap10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class UDPClient1 {

    public static void main(String[] args)  {
        final String HOST = "localhost";
        final int PORT = 7070;
        try (DatagramSocket socket = new DatagramSocket(0)) {
            InetAddress hostAddress = InetAddress.getByName(HOST);
            for (int i = 0; i < 10; ++i) {
                String s = String.format("%tT", new Date());
                System.out.printf("sending %d %s\n", i, s);
                byte[] data = s.getBytes("US-ASCII");
                DatagramPacket packet = new DatagramPacket(data, data.length, hostAddress, PORT);
                socket.send(packet);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

