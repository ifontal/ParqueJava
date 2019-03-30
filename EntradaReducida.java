/**
 * Clase que implementa una entrada reducida
 * 
 * @author: Miguel Traseira López
 * @version marzo de 2019
 */
import java.time.LocalDate;
import java.time.LocalTime;

public class EntradaReducida extends Entrada {
    private double descuento;
    
    /**
     * Constructor para objetos de clase EntradaReducida
     */
    public EntradaReducida(boolean vip, LocalDate fechaInicio, Cliente cliente) {
        super.setVip(vip);
        super.setFechaInicio(fechaInicio);
        super.setHoraInicio(LocalTime.parse("00:00"));
        super.setCliente (cliente);
        this.descuento=0.60;
    }
    
    /**
     * Método para obtener el precio de una entrada reducida
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
     * Método para obtener el descuento de una entrada reducida
     * 
     * @return el descuento
     */
    public double getDescuento() {
        return this.descuento;
    }
    
    /**
     * Método para fijar el descuento de una entrada reducida
     * 
     * @param  el descuento
     * @return el descuento
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
