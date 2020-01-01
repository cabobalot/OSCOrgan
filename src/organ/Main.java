package organ;

//import com.illposed.osc.*;



public class Main {

	public static void main(String[] args) {
		
		Sender send;
		Window.startWindow();
		
		if (args.length > 0) {
			send = new Sender("localhost", Integer.parseInt(args[0]));
			System.out.println("using port: " + Integer.parseInt(args[0]));
		}
		else {
			send = new Sender("localhost", 4446);
			System.out.println("using port: " + 4446);
		}
		
		Window.setSender(send);
		
		System.out.println("Stop setup complete");
		
		//send.sendMsg(new OSCMsg("/stop/set", 1425, 13245));
		
		
	}

}



