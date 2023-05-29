import java.rmi.*;

public interface ServerIntf extends Remote{
	public int add(int num1, int num2) throws RemoteException;
}
