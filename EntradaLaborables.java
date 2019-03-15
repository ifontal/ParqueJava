/**
 * Clase que implementa una entrada de día laboral.
 * 
 * @author Miguel Traseira 
 * @version marzo de 2019
 */
import java.time.*;

public class EntradaLaborables extends Entrada {
    public EntradaLaborables(LocalTime horaInicio, LocalTime horaFin) {
        setHoraInicio(horaInicio);
        setHoraFin(horaFin);
    }
    
    public double getPrecioEntrada() {
        return super.getPrecio()*0.50;
    }
}