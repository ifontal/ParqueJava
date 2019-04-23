/**
 * Abstract class SubirAtraccion - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public abstract class SubirseAtraccion {
    /**
     * Método para comprobar si un cliente se puede subir a una atracción del parque
     * 
     */
    public static void subiseAtraccion(){
        ArrayList<Atraccion> atracciones = FactoriaAtracciones.getAtracciones();
        ArrayList<AccesoParque.Registro> listaClientes = AccesoParque.getRegistros();
        int contador = 0;
        System.out.println("Clientes que han entrado al parque hoy " + LocalDate.now());
        System.out.println("--------------------------------------------------\n");
        for(AccesoParque.Registro registro: listaClientes){
            Cliente cliente = registro.getCliente();
            LocalDate fecha = registro.getFecha();
            if(fecha.equals(LocalDate.now())){
                System.out.println("Cliente: " + contador + " edad: " + cliente.getEdad() +
                                    " altura " + cliente.getAltura() );
            }
            contador++;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoja un cliente");
        int numCliente = sc.nextInt();
        System.out.println("¿A qué atracción desea subirse?");
        String numAtraccion = sc.next();
        
        for(Atraccion atraccion: atracciones){
            if(atraccion.getId().equals(numAtraccion.toUpperCase())){
                if(atraccion.getActiva()){
                    if(atraccion.clienteAdmitido(listaClientes.get(numCliente).getCliente())){
                        System.out.println("El cliente está admitido");
                    } else {
                        System.out.println("El cliente no está admitido");
                    }
                } else {
                    System.out.println("La atracción no está activa");
                }
            }
        }
    }
}
