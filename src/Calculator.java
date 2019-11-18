import java.rmi.Remote;
import java.rmi.RemoteException;
//Calculator Interface
public interface Calculator extends Remote {
    float addNums(String num1, String num2) throws RemoteException;
    float subtractNums(String num1, String num2) throws RemoteException;
    float multipleNums(String num1, String num2) throws RemoteException;
    float divideNums(String num1, String num2) throws RemoteException;
}
