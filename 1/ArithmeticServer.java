import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ArithmeticServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            ArithmeticService service = new ArithmeticServiceImpl();
            Naming.rebind("rmi://localhost/ArithmeticService", service);
            System.out.println("Arithmetic Server is ready...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
