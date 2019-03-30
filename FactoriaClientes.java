/**
 * Abstract class FactoriaClientes - Clase abstracta que se encarga de crear los clientes
 * 
 * @author: Miguel Traseira López
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.Character;


public abstract class FactoriaClientes {
    private static ArrayList<Cliente> clientesParque = new ArrayList<Cliente>();
    
    /**
     * Método para obtener el cliente
     *
     * @param      una edad y una altura
     * @return     un cliente niño (12 o menos años), un cliente adulto (de 13 a 64 años, ambos inclusive)
     *             o un cliente senior (65 años o más), cada uno con sus descuentos especiales si los tiene
     */
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
    
    /**
     * Método para almacenar los clientes del parque
     * 
     * @return     los clientes del parque 
     */
    public static ArrayList<Cliente> getClientesParque() {
        return clientesParque;
    }
}
