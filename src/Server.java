import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements Calculator {

	protected Server() throws RemoteException {
		super();
	}

	@Override
	public int addNums(String num1, String num2) throws RemoteException {
		int number1 = Integer.parseInt(num1);
		int number2 = Integer.parseInt(num2);
		int total = number1 + number2;
		System.out.println(total);
		return total;
	}

	@Override
	public int subtractNums(String num1, String num2) throws RemoteException {
		int number1 = Integer.parseInt(num1);
		int number2 = Integer.parseInt(num2);
		int total = number1 - number2;
		System.out.println(total);
		return total;
	}

	@Override
	public int multipleNums(String num1, String num2) throws RemoteException {
		int number1 = Integer.parseInt(num1);
		int number2 = Integer.parseInt(num2);
		int total = number1 * number2;
		System.out.println(total);
		return total;
	}

	@Override
	public int divideNums(String num1, String num2) throws RemoteException {
		int number1 = Integer.parseInt(num1);
		int number2 = Integer.parseInt(num2);
		int total = number1/number2;
		System.out.println(total);
		return total;
	}

	public static void main(String[] args)
	{
		try {
			Server obj = new Server();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("Calculator",obj);
			System.out.println("Calculator bound in registry");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
