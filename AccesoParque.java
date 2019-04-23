/**
* Abstract class AccesoParque - Clase abstracta que implementa el acceso al parque
* 
* @author: Miguel Traseira López
* Date: marzo de 2019
*/
import java.time.*;
import java.util.ArrayList;

public abstract class AccesoParque {
    private enum Meses {NONE, enero, febrero, marzo,
        abril, mayo, junio, julio, agosto,
        septiembre, octubre, noviembre, diciembre};
        
    
    public static class Registro {
        private Cliente cliente;
        private LocalDate fecha;
        private double precioPagado;
    
        /**
        * Constructor de registro
        */
        public Registro(Cliente cliente, LocalDate fecha, double precioPagado){
           this.cliente = cliente;
           this.fecha = fecha;
           this.precioPagado = precioPagado;
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
        public LocalDate getFecha(){
            return this.fecha;  
        }
        
        /**
        * Método que devuelve el precio
        * 
        * @return      el precio 
        */
        public double getPrecio(){
            return this.precioPagado;  
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
            double precioEntrada = entrada.getPrecioEntrada();
            Registro registro = new Registro(cliente, fecha, precioEntrada);
            listaClientes.add(registro);
            
            return true;
        } else {
            return false;
        }
    }
    
    /**
    * Método estático que muestra las estadísticas que pida el cliente de los clientes con su media 
    * y el precio de la entrada con su media
    * 
    * @param       un día, una semana, un mes o un año
    * @return      las estadísticas del parámetro que haya metido 
    */
    public static void mostrarEstadistica(String tipoEstadistica) {
        if (!listaClientes.isEmpty()) {
            Registro primerElem = listaClientes.get(0);
            LocalDate fechaInicial = primerElem.getFecha();
            int contador = 0;
            int totalPeriodo = 1;
            int totalClientes = 0;
            double precioTotal = 0;
    
            switch(tipoEstadistica){
                case "dia":
                for(Registro registro: listaClientes){
                    if(registro.getFecha().equals(fechaInicial)){
                        contador++;                         //contador de clientes por día
                        precioTotal = precioTotal + registro.getPrecio();
                    } else{
                        System.out.println("Clientes el dia " + fechaInicial.toString() + ": " + contador);
                        System.out.println("Precio medio entrada: " + precioTotal/contador);
                        fechaInicial = registro.getFecha();
                        precioTotal = registro.getPrecio();
                        contador = 1;
                        totalPeriodo++;                        //contador de días que se había registro
                    }
                    totalClientes++;
                }
                System.out.println("Clientes el dia " + fechaInicial.toString() + ": " + contador);
                System.out.println("Precio medio entrada: " + precioTotal/contador);
                System.out.println("Promedio de clientes diario: " + totalClientes/totalPeriodo);
                break;
                    
                case "semana":
                int diaSemana = fechaInicial.getDayOfWeek().getValue();
                fechaInicial = fechaInicial.minusDays(diaSemana-1);
                for(Registro registro: listaClientes){
                    if(registro.getFecha().isBefore(fechaInicial.plusDays(7))){
                        contador++;                             //contador de clientes por semana
                        precioTotal = precioTotal + registro.getPrecio();
                    } else{
                        System.out.println("Clientes la semana del " + fechaInicial.toString() + " al " 
                        + fechaInicial.plusDays(6) + ": " + contador);
                        System.out.println("Precio medio entrada: " + precioTotal/contador);
                        fechaInicial = registro.getFecha();
                        diaSemana = fechaInicial.getDayOfWeek().getValue();
                        fechaInicial = fechaInicial.minusDays(diaSemana-1);
                        precioTotal = registro.getPrecio();
                        contador = 1;
                        totalPeriodo++;                                //contador de semanas que había registro
                    }
                    totalClientes++;
                }
                System.out.println("Clientes la semana del " + fechaInicial.toString() + " al " 
                + fechaInicial.plusDays(6) + ": " + contador);
                System.out.println("Precio medio entrada: " + precioTotal/contador);
                System.out.println("Promedio de clientes semanal: " + totalClientes/totalPeriodo);
                break;
                
                case "mes":
                Meses[] nombresMes = Meses.values();
                for(Registro registro: listaClientes){
                    if(registro.getFecha().getMonth().equals(fechaInicial.getMonth())){
                        contador++;                             //contador de clientes mensuales
                        precioTotal = precioTotal + registro.getPrecio();
                    } else{
                        System.out.println("Clientes el mes " + nombresMes[fechaInicial.getMonthValue()] + ": " + contador);
                        System.out.println("Precio medio entrada: " + precioTotal/contador);
                        fechaInicial = registro.getFecha();
                        precioTotal = registro.getPrecio();
                        contador = 1;                                                  
                        totalPeriodo++;                            //contador de meses que hay registro
                    }
                    totalClientes++;
                }
                System.out.println("Clientes el mes " + nombresMes[fechaInicial.getMonthValue()] + ": " + contador);
                System.out.println("Precio medio entrada: " + precioTotal/contador);
                System.out.println("Promedio de clientes mensual: " + totalClientes/totalPeriodo);
                break;
                
                case "año":
                for(Registro registro: listaClientes){
                    if(registro.getFecha().getYear() == fechaInicial.getYear()){
                        contador++;                             //contador de clientes anuales
                        precioTotal = precioTotal + registro.getPrecio();
                    } else{
                        System.out.println("Clientes el año " + fechaInicial.getYear() + ": " + contador);
                        System.out.println("Precio medio entrada: " + precioTotal/contador);
                        fechaInicial = registro.getFecha();
                        precioTotal = registro.getPrecio();
                        contador = 1;
                        totalPeriodo++;                            //contador de años que hay registro
                    }
                    totalClientes++;
                }
                System.out.println("Clientes el año " + fechaInicial.getYear() + ": " + contador);
                System.out.println("Precio medio entrada: " + precioTotal/contador);
                System.out.println("Promedio de clientes anual: " + totalClientes/totalPeriodo);
                break;
                
                default:
                System.out.println("Introduzca año, semana, mes o año");
            }
        } else {
            System.out.println("Todavia no hay registros de ningún cliente");
        }
    }
    
    /**
    * Método estático que muestra las estadísticas de los clientes y la media que han visitado las atracciones
    * 
    * @param       un día, una semana, un mes o un año
    * @return      las estadísticas del parámetro que haya metido 
    */
    public static void estadisticasAtracciones(String tipoEstadistica){
        ArrayList<Atraccion> atracciones = FactoriaAtracciones.getAtracciones();
        ArrayList<Atraccion.Registro> clientesAtraccion;
        Atraccion.Registro primerElem;
        LocalDate fechaInicial;
        int diaSemana, contador, totalClientes, totalPeriodo;
        
        for(Atraccion atraccion: atracciones){
            clientesAtraccion = atraccion.getRegistros();
            if (!clientesAtraccion.isEmpty()) {
                switch(tipoEstadistica){
                    case"semana":
                    contador = 0;
                    totalClientes = 0;
                    totalPeriodo = 1;
                    primerElem = clientesAtraccion.get(0);
                    fechaInicial = primerElem.getFecha();
                    diaSemana = fechaInicial.getDayOfWeek().getValue();
                    fechaInicial = fechaInicial.minusDays(diaSemana-1);
                    
                    for(Atraccion.Registro registro: clientesAtraccion){
                        if(registro.getFecha().isBefore(fechaInicial.plusDays(7))){
                            contador++;
                        } else{
                            System.out.println("Clientes de la atraccion " + atraccion.getId() + " en la semana del " 
                            + fechaInicial + " al " + fechaInicial.plusDays(6) + ": " + contador);
                            contador = 1;
                            fechaInicial = registro.getFecha();
                            diaSemana = fechaInicial.getDayOfWeek().getValue();
                            fechaInicial = fechaInicial.minusDays(diaSemana-1);
                            totalPeriodo++;
                        }
                        totalClientes++;
                    }
                    
                    System.out.println("Clientes de la atraccion " + atraccion.getId() + " en la semana del " 
                    + fechaInicial + " al " + fechaInicial.plusDays(6) + ": " + contador);
                    System.out.println("Media de clientes semanal de la atraccion " + atraccion.getId() +": "
                    + totalClientes/totalPeriodo);
                    break;
                    
                    case "mes":
                    Meses[] nombresMes = Meses.values();
                    contador = 0;
                    totalClientes = 0;
                    totalPeriodo = 1;
                    primerElem = clientesAtraccion.get(0);
                    fechaInicial = primerElem.getFecha();

                    for(Atraccion.Registro registro: clientesAtraccion){
                        if(registro.getFecha().getMonth().equals(fechaInicial.getMonth())){
                            contador++;
                        } else{
                            System.out.println("Clientes de la atraccion " + atraccion.getId() + " en el mes " 
                            + nombresMes[fechaInicial.getMonthValue()] + ": " + contador);
                            contador = 1;
                            fechaInicial = registro.getFecha();
                            totalPeriodo++;
                        }
                        totalClientes++;
                    }
                    
                    System.out.println("Clientes de la atraccion " + atraccion.getId() + " en el mes " 
                    + nombresMes[fechaInicial.getMonthValue()] + ": " + contador);
                    System.out.println("Media de clientes mensual de la atraccion " + atraccion.getId() +": "
                    + totalClientes/totalPeriodo);
                    break;
                    
                    case "año":
                    contador = 0;
                    totalClientes = 0;
                    totalPeriodo = 1;
                    primerElem = clientesAtraccion.get(0);
                    fechaInicial = primerElem.getFecha();

                    for(Atraccion.Registro registro: clientesAtraccion){
                        if(registro.getFecha().getYear() == fechaInicial.getYear()){
                            contador++;
                        } else{
                            System.out.println("Clientes de la atraccion " + atraccion.getId() + " en el año " 
                            + fechaInicial.getYear() + ": " + contador);
                            contador = 1;
                            fechaInicial = registro.getFecha();
                            totalPeriodo++;
                        }
                        totalClientes++;
                    }
                    
                    System.out.println("Clientes de la atraccion " + atraccion.getId() + " en el año " 
                    + fechaInicial.getYear() + ": " + contador);
                    System.out.println("Media de clientes anual de la atraccion " + atraccion.getId() +": "
                    + totalClientes/totalPeriodo);
                    break;
                    
                    default:
                    System.out.println("Introduzca semana, mes o año");
                }
            }
        }
    }
}

