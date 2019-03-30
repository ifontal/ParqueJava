/**
 * Clase que implementa el descuento de diversidad funcional
 * 
 * @author: Miguel Traseira López 
 * @version (a version number or a date)
 */
public class DiversidadFuncional extends IncrementarDescuento {
    /**
     * Constructor for objects of class DiversidadFuncional
     */
    public DiversidadFuncional(Cliente cliente) {
        super(cliente, 0.8);
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