/**
 * Clase que implementa la atracción c
 * 
 * @author: Miguel Traseira López 
 * @version marzo de 2019
 */
public class AtraccionC extends Atraccion {
    private static double alturaMax = 1.20;

    /**
     * Constructor for objects of class AtraccionC
     */
    public AtraccionC() {
        super(3, 1, false, true);  
    }

    /**
     * Método que comprueba si un cliente está admitido
     * 
     * @param  el cliente
     */
    public boolean clienteAdmitido (Cliente cliente) {
        if (((cliente instanceof Niño) && (cliente.getAltura() <= this.alturaMax))) {
            return true;
        } else {
            return false;
        }
    }
}
