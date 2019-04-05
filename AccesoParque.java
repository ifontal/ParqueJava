/**
 * Abstract class AccesoParque - Clase abstracta que implementa el acceso al parque
 * 
 * @author: Miguel Traseira López
 * Date: marzo de 2019
 */
import java.time.*;
import java.util.ArrayList;

public abstract class AccesoParque {
    private static class Registro {
        private Cliente cliente;
        private LocalDate fecha;
        
        /**
        * Constructor de registro
        */
        public Registro(Cliente cliente, LocalDate fecha) {
           this.cliente = cliente;
           this.fecha = fecha;
        }
        
        /**
        * Método que devuelve el cliente
        * 
        * @return      el cliente 
        */
        public Cliente getCliente() {
            return this.cliente;  
        }
       
        /**
        * Método que devuelve la fecha de un registro
        * 
        * @return      la fecha 
        */
        public LocalDate getFecha() {
            return this.fecha;
        }
    }
    
    private static ArrayList<Registro> listaClientes = new ArrayList<Registro>();
    
    /**
     * Método para obtener la lista de clientes con su correspondiente cliente y fecha de entrada al parque
     * 
     * @return      los clientes con sus fechas 
     */
    public static ArrayList<Registro> getRegistros(){
        return listaClientes;
    }
    
    /**
     * Método estático que comprueba que la fecha de la entrada es correcta (día y hora actual)
     * 
     * @param       una entrada
     * @return      true si la hora es igual o posterior a la de la entrada 
     */
    public static boolean entradaParque(Entrada entrada) {
        LocalTime hora = entrada.getHoraInicio();
        LocalDate fecha = entrada.getFechaInicio();
        
        if(fecha.equals(LocalDate.now()) && LocalTime.now().isAfter(hora)){
            Cliente cliente = entrada.getCliente();
            Registro registro = new Registro(cliente, fecha);
            listaClientes.add(registro);
            return true;
        } else {
            return false;
        }
    }
    
    public static void mostrarEstadisticas() {
        LocalDate dia = listaClientes.get(0).getFecha();
        int contador = 0;
        
        for (Registro registro: listaClientes) {
            if (registro.getFecha().equals(dia)) {
                contador++;
            } else {
                System.out.println("Clientes el " + dia.toString() + ": " + contador);
                dia = registro.getFecha();
                contador = 0;
            }
        }
        System.out.println("Clientes el " + dia.toString() + ": " + contador);
    }
}

