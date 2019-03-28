
/**
 * Write a description of class AtraccionD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AtraccionD extends Atraccion {

    /**
     * Constructor for objects of class AtraccionD
     */
    public AtraccionD() {
        super(5, 1, true, true);  
    }

    public boolean clienteAdmitido (Cliente cliente) {
        if (((cliente instanceof Adulto) || (cliente instanceof Adulto) || (cliente instanceof Senior))) {
            return true;
        } else {
            return false;
        }
    }
}
