
/**
 * Write a description of class FactoriaTemporadas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.time.LocalDate;

public abstract class FactoriaTemporadas {
    private final static String[][] FECHASALTA = {{"2019-01-01", "2019-01-08"},{"2019-04-01", "2019-04-30"},{"2019-08-01", "2019-08-31"},{"2019-12-01", "2019-12-31"}};
    private final static String[][] FECHASBAJA = {{"2019-02-01", "2019-02-28"},{"2019-11-01", "2019-11-30"}};
    
    public static double getPrecio(LocalDate fecha) {
        Temporada TemporadaAlta = new Temporada();
        Temporada TemporadaBaja = new Temporada();
        
        for (int i = 0; i < FECHASALTA.length; i++) {
            TemporadaAlta.addFechas(FECHASALTA[i][0], FECHASALTA[i][1]);
        }
        
        for (int i = 0; i < FECHASBAJA.length; i++) {
            TemporadaBaja.addFechas(FECHASBAJA[i][0], FECHASBAJA[i][1]);
        }
        
        if (TemporadaAlta.tieneFecha(fecha)) {
            return 1.15;
        } else if (TemporadaBaja.tieneFecha(fecha)) {
            return 0.85;
        } else {
            return 1;
        }
    }
}
