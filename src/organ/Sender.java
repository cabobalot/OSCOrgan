package organ;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
    private DatagramSocket socket;
    private InetAddress address;
    private int port;
 

    public Sender( String host, int port) {
    	this.port = port;
        try {
			socket = new DatagramSocket();
			address = InetAddress.getByName(host);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    public void sendMsg(OSCMsg msg) {
    	byte[] buf;
        buf = msg.createMessage();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
        try {
			socket.send(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    public void sendString(String msg) {
    	byte[] buf;
        buf = msg.getBytes();
        System.out.println("length: " + buf.length);
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
        try {
			socket.send(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    public void close() {
        socket.close();
    }
}

