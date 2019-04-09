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
        private double precio;
        
        /**
        * Constructor de registro
        */
        public Registro(Cliente cliente, LocalDate fecha, double precio) {
           this.cliente = cliente;
           this.fecha = fecha;
           this.precio = precio;
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
        
        /**
        * Método que devuelve el precio de un registro
        * 
        * @return      el precio 
        */
        public double getPrecio() {
            return this.precio;
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
        
        if(true){
        //fecha.equals(LocalDate.now()) && LocalTime.now().isAfter(hora)){
            Cliente cliente = entrada.getCliente();
            double precio = entrada.getPrecioEntrada();
            Registro registro = new Registro(cliente, fecha, precio);
            listaClientes.add(registro);
            return true;
        } else {
            return false;
        }
    }
    
    public static void mostrarEstadisticas(String tipo) {
        LocalDate fecha = listaClientes.get(0).getFecha();
        int contador = 0;
        int contador2 = 1;
        int contador3 = 0;
        
        switch(tipo) {
            case "dia":
            for (Registro registro: listaClientes) {
                if (registro.getFecha().equals(fecha)) {
                    contador++;
                } else {
                    System.out.println("Clientes el " + fecha.toString() + ": " + contador);
                    contador2++;
                    contador3 = contador3 + contador;
                    fecha = registro.getFecha();
                    contador = 1;
                }
            }
            System.out.println("Clientes el " + fecha.toString() + ": " + contador);
            System.out.println("Promedio de clientes diario: " + contador3/contador2);
            break;
            case "semana":
            int diaSemana = fecha.getDayOfWeek().getValue();
            fecha = fecha.minusDays(diaSemana-1);
            for (Registro registro: listaClientes) {
                if (registro.getFecha().isBefore(fecha.plusDays(7))) {
                    contador++;
                } else {
                    System.out.println("Clientes la semana del " + fecha.toString()
                    + " al " + fecha.plusDays(6).toString() + ": " + contador);
                    fecha = registro.getFecha();
                    diaSemana = fecha.getDayOfWeek().getValue();
                    fecha = fecha.minusDays(diaSemana-1);
                    contador = 1;
                }
            }
            System.out.println("Clientes la semana del " + fecha.toString()
            + " al " + fecha.plusDays(6).toString() + ": " + contador);
            break;
            case "mes":
            for (Registro registro: listaClientes) {
                if (registro.getFecha().getMonth().equals(fecha.getMonth())) {
                    contador++;
                } else {
                    System.out.println("Clientes en " + fecha.getMonth().toString() + ": " + contador);
                    fecha = registro.getFecha();
                    contador = 1;
                }
            }
            System.out.println("Clientes en " + fecha.getMonth().toString() + ": " + contador);
            break;
            case "año":
            for (Registro registro: listaClientes) {
                if (registro.getFecha().getYear() == fecha.getYear()) {
                    contador++;
                } else {
                    System.out.println("Clientes en " + fecha.getYear() + ": " + contador);
                    fecha = registro.getFecha();
                    contador = 1;
                }
            }
            System.out.println("Clientes en " + fecha.getYear() + ": " + contador);
            break;
        }
    }
}

