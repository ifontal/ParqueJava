/**
 * Clase que implementa la atracción d
 * 
 * @author: Miguel Traseira López
 * @version marzo de 2019
 */
public class AtraccionD extends Atraccion {

    /**
     * Constructor for objects of class AtraccionD
     */
    public AtraccionD() {
        super(5, 1, true, true);  
    }

    /**
     * Método que comprueba si un cliente está admitido
     * 
     * @param  el cliente
     */
    public boolean clienteAdmitido (Cliente cliente) {
        if (((cliente instanceof Adulto) || (cliente instanceof Adulto) || (cliente instanceof Senior))) {
            return true;
        } else {
            return false;
        }
    }
}
