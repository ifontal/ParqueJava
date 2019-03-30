/**
 * Clase que implementa una entrada general.
 * 
 * @author Miguel Traseira López
 * @version marzo de 2019
 */
import java.time.LocalDate;
import java.time.LocalTime;

public class EntradaGeneral extends Entrada {

    /**
     * Constructor para objetos de clase EntradaGeneral
     */
    public EntradaGeneral(boolean vip, LocalDate fechaInicio, Cliente cliente) {
        super.setVip(vip);
        super.setFechaInicio(fechaInicio);
        super.setHoraInicio(LocalTime.parse("00:00"));
        super.setCliente (cliente);
    }
    
    /**
     * Método para obtener el precio de una entrada general
     * 
     * @return el precio
     */
    public double getPrecioEntrada() {
        Cliente cliente = super.getCliente();
        double precio = super.getPrecio()*cliente.getDescuento();
        
        if(super.isVip()) {
            precio = precio + super.getSuplementoVip()*cliente.getDescuento();
            return precio;
        } else {
            return precio*FactoriaTemporadas.getPrecio(super.getFechaInicio());
        }
    }
}
