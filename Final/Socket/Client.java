import java.net.*;
import java.io.*;

public class Client{

	public static void main(String[] args) throws Exception{
	
		Socket s = new Socket("127.0.0.1",5555);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		OutputStream ostream = s.getOutputStream();
		
		PrintWriter pw = new PrintWriter(ostream, true);
		
		InputStream istream = s.getInputStream();
		
		BufferedReader receive = new BufferedReader(new InputStreamReader(istream));
		
		String servermessage = "";
		String clientmessage = "";
	
		while(true){
		
			System.out.println("Enter Message: ");
			clientmessage = br.readLine();
			pw.println("Client message: "+clientmessage);
			if(clientmessage.equals("bye")){
				break;
			}
			
			servermessage = receive.readLine();
			System.out.println("Server Message: "+servermessage);
			if(servermessage.equals("bye")){
				break;
			}
			

			
		
		
		}
		
		s.close();
		istream.close();
		ostream.close();
		
		System.out.println("Terminated");
	}
}
