/**
 * Abstract class AccesoParque - Clase abstracta que implementa el acceso al parque
 * 
 * @author: Miguel Traseira López
 * Date: marzo de 2019
 */
import java.time.*;
import java.util.ArrayList;

public abstract class AccesoParque {
    private class Registro {
        private Cliente cliente;
        private LocalDate fechaAct;
        
        /**
        * Constructor de registro
        */
        public Registro(Cliente cliente, String fecha){
           this.cliente = cliente;
           this.fechaAct = LocalDate.parse(fecha);
        }
        
        /**
        * Método que devuelve el cliente
        * 
        * @return      el cliente 
        */
        public Cliente getCliente(){
            return this.cliente;  
        }
       
        /**
        * Método que devuelve la fecha actual
        * 
        * @return      la fecha 
        */
        public LocalDate getFechaAct(){
            return this.fechaAct.now();  
        }
    }
    
    private static ArrayList<Registro> listaClientes;
    
    /**
    * Constructor de AccesoParque
    */
    public AccesoParque(){
        this.listaClientes = new ArrayList<Registro>();
    }
    
    /**
     * Método para obtener la lista de clientes con su correspondiente cliente y fecha de entrada al parque
     * 
     * @return      los clientes con sus fechas 
     */
    public ArrayList<Registro> getRegistros(){
        return this.listaClientes;
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
            //guardarclientes
            return true;
        } else {
            return false;
        }
    }
    
    public static void mostrarEstadistica() {
    }
}

