
/**
 * Write a description of class FactoriaClientes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.Character;

public abstract class FactoriaClientes {
    private static ArrayList<Cliente> clientesParque = new ArrayList<Cliente>();
    
    public static Cliente getCliente(int edad, double altura) {
        Scanner sc = new Scanner(System.in);

        if (edad <= 12) {
            Cliente niño = new Niño(edad, altura, 1);
            System.out.println("¿Diversidad funcional? (S/N): ");
            if (Character.toLowerCase(sc.next().charAt(0)) == 's') {
                niño = new DiversidadFuncional(niño);
            }
            clientesParque.add(niño);
            return niño;
        } else if (edad > 12 && edad < 65) {
            Cliente adulto = new Adulto(edad, altura, 1);
            System.out.println("¿Diversidad funcional? (S/N): ");
            if (Character.toLowerCase(sc.next().charAt(0)) == 's') {
                adulto = new DiversidadFuncional(adulto);
            }
            System.out.println("¿Carnet joven? (S/N)");
            if (Character.toLowerCase(sc.next().charAt(0)) == 's') {
                adulto = new CarnetJoven(adulto);
            }
            System.out.println("¿Estudiante? (S/N): ");
            if (Character.toLowerCase(sc.next().charAt(0)) == 's') {
                adulto = new CarnetEstudiante(adulto);
            }
            System.out.println("¿Desempleado? (S/N)");
            if (Character.toLowerCase(sc.next().charAt(0)) == 's') {
                adulto = new Desempleado(adulto);
            }
            clientesParque.add(adulto);
            return adulto;
        } else if (edad >= 65) {
            Cliente senior = new Senior(edad, altura, 1);
            System.out.println("¿Diversidad funcional? (S/N): ");
            if (Character.toLowerCase(sc.next().charAt(0)) == 's') {
                senior = new DiversidadFuncional(senior);
            }
            clientesParque.add(senior);
            return senior;
        } else {
            return null;
        }
    }
    
    public static ArrayList<Cliente> getClientesParque() {
        return clientesParque;
    }
}
