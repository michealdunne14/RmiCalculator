import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    int addNums(String num1, String num2) throws RemoteException;
    int subtractNums(String num1, String num2) throws RemoteException;
    int multipleNums(String num1, String num2) throws RemoteException;
    int divideNums(String num1, String num2) throws RemoteException;
}
