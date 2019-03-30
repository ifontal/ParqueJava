/**
 * Clase que implementa el descuento de desempleado
 * 
 * @author: Miguel Traseira López
 * @version (a version number or a date)
 */
public class Desempleado extends IncrementarDescuento {
    /**
     * Constructor for objects of class Desempleado
     */
    public Desempleado(Cliente cliente) {
        super(cliente, 0.9);
    }

    /**
     * Método para obtener el descuento
     * 
     * @return     el descuento 
     */
    public double getDescuento () {
        return super.getModDescuento();
    }
}
