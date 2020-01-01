package organ;

import java.nio.ByteBuffer;

public class OSCMsg {
	private byte[] buf;
	private String address;
	private Integer dataA, dataB;
	
	public OSCMsg() {
		
	}
	
	public OSCMsg(String addr, int dataA, int dataB) {
		address = addr;
		this.dataA = dataA;
		this.dataB = dataB;
	}
	
	public void setAddress(String addr) {
		address = addr;
	}
	
	public void setPayloadInts(int dataA, int dataB) {
		this.dataA = dataA;
		this.dataB = dataB;
	}
	
	public byte[] createMessage() {
		
		String msg = address;
		while ((msg.length() % 4) > 0) {
			msg += "\0";
		}
		
		msg += ",ii";
		while ((msg.length() % 4) > 0) {
			msg += "\0";
		}
		
		byte[] dataABytes = ByteBuffer.allocate(4).putInt(dataA).array();
		byte[] dataBBytes = ByteBuffer.allocate(4).putInt(dataB).array();
		
//		System.out.println("msg: " + msg);

		buf = new byte[msg.length() + dataABytes.length + dataBBytes.length];
		
		byte[] msgBytes = msg.getBytes();
		for (int i = 0; i < buf.length; i++) {
			if (i < msg.length()) {
				buf[i] = msgBytes[i];
			}
			else if (i < (msg.length() + dataABytes.length)) {
				buf[i] = dataABytes[i - msg.length()];
			}
			else {
				buf[i] = dataBBytes[i - msg.length() - dataABytes.length];
			}
		}
		
		/*
		System.out.println("bytes:");
		
		for (int i = 0; i < buf.length; i++) {
			if ((i % 4) == 0) {
				System.out.println();
			}
			System.out.print(buf[i] + " ");
		}
		System.out.println();
//		*/
		
		return buf;
	}
	
}
