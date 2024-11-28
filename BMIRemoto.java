import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BMIRemoto extends Remote {
    double calcularBMI(double peso, double altura) throws RemoteException;
    String obtenerCategoria(double bmi) throws RemoteException;
}