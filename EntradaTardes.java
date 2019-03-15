/**
 * Clase que implementa una entrada de tardes.
 * 
 * @author Miguel Traseira 
 * @version marzo de 2019
 */
import java.time.*;

public class EntradaTardes extends Entrada {
    private double descuento;
    
    public EntradaTardes(int id, boolean vip, LocalDate fechaInicio, Cliente cliente) {
        super.setId(id);
        super.setVip(vip);
        super.setFechaInicio(fechaInicio);
        super.setHoraInicio(LocalTime.parse("16:00"));
        super.setCliente (cliente);
        this.descuento=0.90;
    }
    
    public double getPrecioEntrada() {
        Cliente cliente = super.getCliente();
        double precio = super.getPrecio()*cliente.getDescuento();
        
        if(super.isVip()) {
            precio = precio + super.getSuplementoVip()*cliente.getDescuento();
        }
        
        return precio*this.descuento;
    }
    
    public double getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}