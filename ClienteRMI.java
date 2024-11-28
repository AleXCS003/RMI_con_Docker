import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 80);
            BMIRemoto bmiRemoto = (BMIRemoto) registry.lookup("BMIServicio");
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Calcular BMI");
                System.out.println("2. Obtener categoría del BMI");
                System.out.println("0. Salir");
                opcion = scanner.nextInt();

                if (opcion == 0) {
                    System.out.println("Saliendo...");
                    break;
                }

                System.out.print("Ingrese su peso (kg): ");
                double peso = scanner.nextDouble();
                System.out.print("Ingrese su altura (m): ");
                double altura = scanner.nextDouble();

                switch (opcion) {
                    case 1:
                        double bmi = bmiRemoto.calcularBMI(peso, altura);
                        System.out.println("Su BMI es: " + bmi);
                        break;
                    case 2:
                        double bmiActual = bmiRemoto.calcularBMI(peso, altura);
                        String categoria = bmiRemoto.obtenerCategoria(bmiActual);
                        System.out.println("Categoría: " + categoria);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (true);

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}