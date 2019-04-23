/**
 * Abstract class FactoriaTemporadas - Clase abstracta que se encarga de crear las temporadas
 * 
 * @author: Miguel Traseira López 
 * @version marzo de 2019
 */
import java.time.LocalDate;

public abstract class FactoriaTemporadas {
    private final static String[][] FECHASALTA = {{"2019-01-01", "2019-01-08"},{"2019-04-01", "2019-04-30"},{"2019-08-01", "2019-08-31"},{"2019-12-01", "2019-12-31"}};
    private final static String[][] FECHASBAJA = {{"2019-02-01", "2019-02-28"},{"2019-11-01", "2019-11-30"}};
    private static Temporada TemporadaAlta = new Temporada(FECHASALTA);
    private static Temporada TemporadaBaja = new Temporada(FECHASBAJA);
    
    /**
     * Método para obtener el precio de la temporada
     * 
     * @param       la fecha
     * @return      el descuento
     */
    public static double getPrecio(LocalDate fecha) {
        if (TemporadaAlta.tieneFecha(fecha)) {
            return 1.15;
        } else if (TemporadaBaja.tieneFecha(fecha)) {
            return 0.85;
        } else {
            return 1;
        }
    }
}