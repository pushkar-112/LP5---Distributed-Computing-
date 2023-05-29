import java.net.*;
import java.io.*;

public class Server{

	public static void main(String[] args) throws Exception{
	
		ServerSocket ss = new ServerSocket(5555);
		
		Socket s = ss.accept();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		OutputStream ostream = s.getOutputStream();
		
		PrintWriter pw = new PrintWriter(ostream, true);
		
		InputStream istream = s.getInputStream();
		
		BufferedReader receive = new BufferedReader(new InputStreamReader(istream));
		
		String servermessage = "";
		String clientmessage = "";
	
		while(true){
			
			clientmessage = receive.readLine();
			System.out.println("Client Message: "+clientmessage);
			if(clientmessage.equals("bye")){
				break;
			}
			
			System.out.println("Enter Message: ");
			servermessage = br.readLine();
			pw.println("Server message: "+servermessage);
			if(servermessage.equals("bye")){
				break;
			}
			
		
		
		}
		
		s.close();
		ss.close();
		istream.close();
		ostream.close();
		
		System.out.println("Terminated");
	}
}
