import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ArithmeticServiceImpl extends UnicastRemoteObject implements ArithmeticService {

    protected ArithmeticServiceImpl() throws RemoteException {
        super();
    }

    public double add(double a, double b) throws RemoteException {
        return a + b;
    }

    public double subtract(double a, double b) throws RemoteException {
        return a - b;
    }

    public double multiply(double a, double b) throws RemoteException {
        return a * b;
    }

    public double divide(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Cannot divide by zero");
        }
        return a / b;
    }
}
