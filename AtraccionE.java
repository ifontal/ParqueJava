
/**
 * Write a description of class AtraccionE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AtraccionE extends Atraccion {
    /**
     * Constructor for objects of class AtraccionA
     */
    public AtraccionE() {
        super(7, 1, true, true);  
    }

    public boolean clienteAdmitido (Cliente cliente) {
        if (((cliente instanceof Adulto) || (cliente instanceof Senior))) {
            return true;
        } else {
            return false;
        }
    }
}
