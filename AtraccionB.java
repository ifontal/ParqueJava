/**
 * Clase que implementa la atracción b
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class AtraccionB extends Atraccion {
    private static double alturaMin = 1.20;
    private static double alturaMax = 1.90;

    /**
     * Constructor for objects of class AtraccionB
     */
    public AtraccionB() {
        super(5, 1, false, true);  
    }

    /**
     * Método que comprueba si un cliente está admitido
     * 
     * @param  el cliente
     */
    public boolean clienteAdmitido (Cliente cliente) {
        if (((cliente instanceof Adulto) || (cliente instanceof Senior))
        && (cliente.getAltura() >= this.alturaMin) && (cliente.getAltura() <= this.alturaMax)) {
            return true;
        } else {
            return false;
        }
    }
}
