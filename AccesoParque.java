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
        int totalPeriodo = 1;
        int totalClientes = 0;
        double precioTotal = 0;
        
        switch(tipo) {
            case "dia":
            for (Registro registro: listaClientes) {
                if (registro.getFecha().equals(fecha)) {
                    contador++;
                    precioTotal = precioTotal + registro.getPrecio();
                } else {
                    System.out.println("Clientes el " + fecha.toString() + ": " + contador);
                    System.out.println("Precio medio: " + precioTotal/contador);
                    fecha = registro.getFecha();
                    precioTotal = registro.getPrecio();
                    contador = 1;
                    totalPeriodo++;
                }
                totalClientes++;
            }
            System.out.println("Clientes el " + fecha.toString() + ": " + contador);
            System.out.println("Precio medio: " + precioTotal/contador);
            System.out.println("Promedio de clientes diario: " + totalClientes/totalPeriodo);
            break;
            
            case "semana":
            int diaSemana = fecha.getDayOfWeek().getValue();
            fecha = fecha.minusDays(diaSemana-1);
            for (Registro registro: listaClientes) {
                if (registro.getFecha().isBefore(fecha.plusDays(7))) {
                    contador++;
                    precioTotal = precioTotal + registro.getPrecio();
                } else {
                    System.out.println("Clientes la semana del " + fecha.toString()
                    + " al " + fecha.plusDays(6).toString() + ": " + contador);
                    System.out.println("Precio medio: " + precioTotal/contador);
                    fecha = registro.getFecha();
                    diaSemana = fecha.getDayOfWeek().getValue();
                    fecha = fecha.minusDays(diaSemana-1);
                    precioTotal = registro.getPrecio();
                    contador = 1;
                    totalPeriodo++;
                }
                totalClientes++;
            }
            System.out.println("Clientes la semana del " + fecha.toString()
            + " al " + fecha.plusDays(6).toString() + ": " + contador);
            System.out.println("Precio medio: " + precioTotal/contador);
            System.out.println("Promedio de clientes semanal: " + totalClientes/totalPeriodo);
            break;
            
            case "mes":
            for (Registro registro: listaClientes) {
                if (registro.getFecha().getMonth().equals(fecha.getMonth())) {
                    contador++;
                    precioTotal = precioTotal + registro.getPrecio();
                } else {
                    System.out.println("Clientes en " + fecha.getMonth().toString() + ": " + contador);
                    System.out.println("Precio medio: " + precioTotal/contador);
                    fecha = registro.getFecha();
                    precioTotal = registro.getPrecio();
                    contador = 1;
                    totalPeriodo++;
                }
                totalClientes++;
            }
            System.out.println("Clientes en " + fecha.getMonth().toString() + ": " + contador);
            System.out.println("Precio medio: " + precioTotal/contador);
            System.out.println("Promedio de clientes mensual: " + totalClientes/totalPeriodo);
            break;
            
            case "año":
            for (Registro registro: listaClientes) {
                if (registro.getFecha().getYear() == fecha.getYear()) {
                    contador++;
                    precioTotal = precioTotal + registro.getPrecio();
                } else {
                    System.out.println("Clientes en " + fecha.getYear() + ": " + contador);
                    System.out.println("Precio medio: " + precioTotal/contador);
                    fecha = registro.getFecha();
                    precioTotal = registro.getPrecio();
                    contador = 1;
                    totalPeriodo++;
                }
                totalClientes++;
            }
            System.out.println("Clientes en " + fecha.getYear() + ": " + contador);
            System.out.println("Precio medio: " + precioTotal/contador);
            System.out.println("Promedio de clientes anual: " + totalClientes/totalPeriodo);
            break;
        }
    }
}

