/**
 * Clase que implementa el descuento de un carnet joven
 * 
 * @author: Miguel Traseira López 
 * @version (a version number or a date)
 */
public class CarnetJoven extends IncrementarDescuento {
    /**
     * Constructor for objects of class CarnetJoven
     */
    public CarnetJoven(Cliente cliente) {
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
