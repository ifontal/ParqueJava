/**
 * Clase que implementa una entrada de día laboral.
 * 
 * @author Miguel Traseira 
 * @version marzo de 2019
 */
import java.time.*;

public class EntradaLaborables extends Entrada {
    private double descuento;
    
    public EntradaLaborables(boolean vip, LocalDate fechaInicio, Cliente cliente) {
        super.setVip(vip);
        super.setFechaInicio(fechaInicio);
        super.setHoraInicio(LocalTime.parse("00:00"));
        super.setCliente (cliente);
        this.descuento=0.90;
    }
    
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
    
    public double getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}