/**
 * Clase que implementa una entrada general.
 * 
 * @author Miguel Traseira 
 * @version marzo de 2019
 */
import java.time.LocalDate;
import java.time.LocalTime;

public class EntradaGeneral extends Entrada {

    public EntradaGeneral(int id, boolean vip, LocalDate fechaInicio, Cliente cliente) {
        super.setId(id);
        super.setVip(vip);
        super.setFechaInicio(fechaInicio);
        super.setHoraInicio(LocalTime.parse("00:00"));
        super.setCliente (cliente);
    }
    
    public double getPrecioEntrada() {
        Cliente cliente = super.getCliente();
        double precio = super.getPrecio()*cliente.getDescuento();
        
        if(super.isVip()) {
            precio = precio + super.getSuplementoVip()*cliente.getDescuento();
        }
        
        return precio;
    }
}