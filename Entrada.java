/**
 * Clase abstracta Entrada - implementa una entrada genérica
 * 
 * @author: Miguel Traseira
 * Fecha: marzo de 2019
 */
import java.time.*;

public abstract class Entrada {
    private final double precio = 60;
    private final double suplementoVip = 50;
    private int id;
    private boolean esVIP;
    private LocalDate fechaInicio;
    private LocalTime horaInicio;
    private Cliente clienteAsociado;
    
    /**
     * Método para obtener el id de una entrada
     * 
     * @return      el id
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Método para establecer el id de una entrada
     * 
     * @param       el id de la entrada
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método para obtener el precio de una entrada
     * 
     * @return el precio
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Método para comprobar si una entrada es VIP
     * 
     * @return      true si la entrada es VIP
     */
    public boolean isVip() {
        return this.esVIP;
    }
    
    /**
     * Método para establecer el estado VIP de una entrada
     * 
     * @param       true para entrada VIP
     */
    public void setVip(boolean esVIP) {
        this.esVIP = esVIP;
    }
    
    /**
     * Método para obtener el suplemento VIP
     * 
     * @return      el suplemento VIP
     */
    public double getSuplementoVip() {
        return this.suplementoVip;
    }
    
    /**
     * Método para obtener la fecha de inicio de una entrada
     * 
     * @return      la fecha de inicio
     */
    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }
    
    /**
     * Método para establecer la fecha de inicio de una entrada
     * 
     * @param       fecha de inicio
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    /**
     * Método para obtener la hora de inicio de una entrada
     * 
     * @return      la hora de inicio
     */
    public LocalTime getHoraInicio() {
        return this.horaInicio;
    }
    
    /**
     * Método para establecer la hora de inicio de una entrada
     * 
     * @param       hora de inicio
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }
    
    /**
     * Método para obtener el cliente asociado a una entrada
     * 
     * @return      el cliente
     */
    public Cliente getCliente() {
        return this.clienteAsociado;
    }
    
    /**
     * Método para establecer el cliente asociado a una entrada
     * 
     * @param       cliente
     */
    public void setCliente(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }
    
    public abstract double getPrecioEntrada();
}
