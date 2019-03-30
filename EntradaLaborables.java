/**
 * Clase que implementa una entrada de día laboral.
 * 
 * @author Miguel Traseira López
 * @version marzo de 2019
 */
import java.time.*;

public class EntradaLaborables extends Entrada {
    private double descuento;
    
    /**
     * Constructor para objetos de clase EntradaLaborables
     */
    public EntradaLaborables(boolean vip, LocalDate fechaInicio, Cliente cliente) {
        super.setVip(vip);
        super.setFechaInicio(fechaInicio);
        super.setHoraInicio(LocalTime.parse("00:00"));
        super.setCliente (cliente);
        this.descuento=0.90;
    }
    
    /**
     * Método para obtener el precio de una entrada de días laborables
     * 
     * @return el precio
     */
    public double getPrecioEntrada() {
        Cliente cliente = super.getCliente();
        double precio = super.getPrecio()*cliente.getDescuento();
        
        if(super.isVip()) {
            precio = precio + super.getSuplementoVip()*cliente.getDescuento();
            return precio*this.descuento;
        } else {
            return precio*this.descuento*FactoriaTemporadas.getPrecio(super.getFechaInicio());
        }
    }
    
    /**
     * Método para obtener el descuento de una entrada de días laborables
     * 
     * @return el descuento
     */
    public double getDescuento() {
        return this.descuento;
    }
    
    /**
     * Método para fijar el descuento de una entrada de días laborables
     * 
     * @param  el descuento
     * @return el precio
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}