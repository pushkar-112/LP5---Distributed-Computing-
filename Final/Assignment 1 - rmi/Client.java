import java.rmi.*;
import java.util.*;

public class Client{


	public static void main(String[] args){
		
		try{
			Scanner sc = new Scanner(System.in);
			String ServerURL = "rmi://localhost/Server";
			ServerIntf serverIntf = (ServerIntf) Naming.lookup(ServerURL);
			
			int num1,num2;
			System.out.println("Enter Number 1");
			num1=sc.nextInt();
			System.out.println("Enter Number 2");
			num2=sc.nextInt();
			System.out.println("Result: "+serverIntf.add(num1,num2));
			
		
	
		}catch(Exception e){
			System.out.println("Errorc: "+e.getMessage());
		}
	}
}
