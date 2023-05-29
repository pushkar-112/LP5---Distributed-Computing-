import java.rmi.*;
import java.rmi.server.*;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf{

	public ServerImpl() throws RemoteException{
	}
	
	public int add(int num1, int num2) throws RemoteException{
		return num1+num2;
	}
}
