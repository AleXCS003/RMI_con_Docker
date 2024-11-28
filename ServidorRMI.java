import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            BMIRemoto bmiRemoto = new BMIRemotoImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("BMIServicio", bmiRemoto);
            System.out.println("Servidor RMI listo.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}