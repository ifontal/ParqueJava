
/**
 * Write a description of class AtraccionC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AtraccionC extends Atraccion {
    private static double alturaMax = 1.20;

    /**
     * Constructor for objects of class AtraccionC
     */
    public AtraccionC() {
        super(3, 1, false, true);  
    }

    public boolean clienteAdmitido (Cliente cliente) {
        if (((cliente instanceof Niño) && (cliente.getAltura() <= this.alturaMax))) {
            return true;
        } else {
            return false;
        }
    }
}
