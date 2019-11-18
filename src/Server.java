import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements Calculator {

	public ServerGUI serverGUI;

	protected Server() throws RemoteException {
		super();
		serverGUI = new ServerGUI();
		serverGUI.getmDisplay().append("Calculator bound in registry \n");
		serverGUI.getmDisplay().append("Connected to Client \n");
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


	@Override
	public float addNums(String num1, String num2) throws RemoteException {
		float number1 = Float.parseFloat(num1);
		float number2 = Float.parseFloat(num2);
		float total = number1 + number2;
		System.out.println(total);
		serverGUI.getmDisplay().append("--------------------------\n");
		serverGUI.getmDisplay().append("First Number " + number1 + "\n");
		serverGUI.getmDisplay().append("Second Number " + number2 + "\n");
		serverGUI.getmDisplay().append("Operator + \n" );
		serverGUI.getmDisplay().append("Added Numbers " + total + "\n");
		return total;
	}

	@Override
	public float subtractNums(String num1, String num2) throws RemoteException {
		float number1 = Integer.parseInt(num1);
		float number2 = Integer.parseInt(num2);
		float total = number1 - number2;
		System.out.println(total);
		serverGUI.getmDisplay().append("--------------------------\n");
		serverGUI.getmDisplay().append("First Number " + number1 + "\n");
		serverGUI.getmDisplay().append("Second Number " + number2 + "\n");
		serverGUI.getmDisplay().append("Operator - \n");
		serverGUI.getmDisplay().append("Subtract Numbers " + total + "\n");
		return total;
	}

	@Override
	public float multipleNums(String num1, String num2) throws RemoteException {
		float number1 = Integer.parseInt(num1);
		float number2 = Integer.parseInt(num2);
		float total = number1 * number2;
		System.out.println(total);
		serverGUI.getmDisplay().append("--------------------------\n");
		serverGUI.getmDisplay().append("First Number " + number1 + "\n");
		serverGUI.getmDisplay().append("Second Number " + number2 + "\n");
		serverGUI.getmDisplay().append("Operator * \n");
		serverGUI.getmDisplay().append("Multiply Numbers " + total + "\n");
		return total;
	}

	@Override
	public float divideNums(String num1, String num2) throws RemoteException {
		float number1 = Integer.parseInt(num1);
		float number2 = Integer.parseInt(num2);
		float total = number1/number2;
		System.out.println(total);
		serverGUI.getmDisplay().append("--------------------------\n");
		serverGUI.getmDisplay().append("First Number " + number1 + "\n");
		serverGUI.getmDisplay().append("Second Number " + number2 + "\n");
		serverGUI.getmDisplay().append("Operator / \n");
		serverGUI.getmDisplay().append("Divide Numbers " + total + "\n");
		return total;
	}

}
