/**
 * Clase que implementa la atracción c
 * 
 * @author: Miguel Traseira López 
 * @version marzo de 2019
 */
import java.time.LocalDate;

public class AtraccionC extends Atraccion {
    private static double alturaMax = 1.20;

    /**
     * Constructor for objects of class AtraccionC
     */
    public AtraccionC(String id) {
        super(3, 1, false, true, id);  
    }

    /**
     * Método que comprueba si un cliente está admitido
     * 
     * @param  el cliente
     */
    public boolean clienteAdmitido (Cliente cliente) {
        if (((cliente instanceof Niño) && (cliente.getAltura() <= this.alturaMax))) {
            super.addRegistro(cliente, LocalDate.now());
            return true;
        } else {
            return false;
        }
    }
}
