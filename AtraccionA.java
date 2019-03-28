
/**
 * Write a description of class AtraccionA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class AtraccionA extends Atraccion {
    
    private static double alturaMin = 1.20;

    /**
     * Constructor for objects of class AtraccionA
     */
    public AtraccionA() {
        super(6, 1, true, true);  
    }

    public boolean clienteAdmitido (Cliente cliente) {
        while (cliente instanceof IncrementarDescuento) {
            cliente = cliente.getCliente();
        }
        if (((cliente instanceof Adulto) || (cliente instanceof Niño)
        || (cliente instanceof Senior)) && (cliente.getAltura() >= this.alturaMin)) {
            return true;
        } else {
            return false;
        }
    }
}
