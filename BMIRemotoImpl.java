import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class BMIRemotoImpl extends UnicastRemoteObject implements BMIRemoto {
    
    protected BMIRemotoImpl() throws RemoteException {
        super();
    }

    @Override
    public double calcularBMI(double peso, double altura) throws RemoteException {
        return peso / (altura * altura);
    }

    @Override
    public String obtenerCategoria(double bmi) throws RemoteException {
        if (bmi < 18.5) {
            return "Bajo peso";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Peso normal";
        } else if (bmi >= 25 && bmi < 30) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}