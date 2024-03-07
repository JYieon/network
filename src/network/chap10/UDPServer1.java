package network.chap10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer1 {

    public static void main(String[] args)  {
        final int PORT = 7070;
        int count = 0;
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            byte[] data = new byte[512];
            while (true) {
                DatagramPacket packet = new DatagramPacket(data, data.length);
                socket.receive(packet);
                String str = new String(packet.getData(), 0, packet.getLength(), "US-ASCII");
                System.out.printf("%s %d %s %d\n", packet.getAddress(), packet.getPort(), str, ++count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
