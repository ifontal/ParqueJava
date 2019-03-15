
/**
 * Write a description of class FactoriaEntradas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.time.LocalDate;

public class FactoriaEntradas {

    public static Entrada getEntrada(String tipoEntrada, boolean esVip, Cliente cliente) {

        if(tipoEntrada.equals("general")) {
            return new EntradaGeneral(1, esVip, LocalDate.now(), cliente);
        } else if (tipoEntrada.equals("reducida")) {
            return new EntradaReducida(1, esVip, LocalDate.now(), cliente);
        } else if (tipoEntrada.equals("tardes")) {
            return new EntradaTardes(1, esVip, LocalDate.now(), cliente);
        } else {
            return null;
        }
    }
}
