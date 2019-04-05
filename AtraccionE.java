/**
 * Clase que implementa la atracción e
 * 
 * @author: Miguel Traseira López
 * @version marzo de 2019
 */
public class AtraccionE extends Atraccion {
    /**
     * Constructor for objects of class AtraccionA
     */
    public AtraccionE(String id) {
        super(7, 1, true, true, id);  
    }

    /**
     * Método que comprueba si un cliente está admitido
     * 
     * @param  el cliente
     */
    public boolean clienteAdmitido (Cliente cliente) {
        if (((cliente instanceof Adulto) || (cliente instanceof Senior))) {
            return true;
        } else {
            return false;
        }
    }
}