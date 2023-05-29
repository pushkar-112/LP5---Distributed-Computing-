import java.util.*;

public class tokenring {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of process");
		int n = sc.nextInt();
		
		//form ring
		System.out.println("Processess in ring");
		for(int i=0;i<n;i++) {
			System.out.print(i+" ");
		}
		System.out.println(0);
		
		int token=0;
		int c = 1;
		while(c==1) {
			
			//take input		
			System.out.println("Enter Sender");
			int s = sc.nextInt();
			System.out.println("Enter reciever");
			int r = sc.nextInt();		
			System.out.println("Enter messagee ");
			sc.nextLine();
			String m = sc.nextLine();		

		
			//transfer token to sender
			System.out.println("Passing token to sender ");
			for(int i=token;i<s;i++) {
				token++;
				System.out.println("Token passed to "+token);
			}
			System.out.println("Token recieved at sender ");
		
		
			//forward message to reciever
			System.out.println("Sender sending message "+m+" to reciever");
			for(int i=s;i<r;i++) {
				System.out.println("Message "+m+ " forwarded to "+i);
			}
			for(int i=token;i<s;i++) {
				token++;
				System.out.println("Message "+m+"  recieved at reciever "+r);
			}
			token=0;
			System.out.println("Choice 1. continue 2. exit");
			c=sc.nextInt();
		}
	}
}
