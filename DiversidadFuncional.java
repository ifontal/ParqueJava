
/**
 * Write a description of class DiversidadFuncional here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DiversidadFuncional extends IncrementarDescuento {
    public DiversidadFuncional(Cliente cliente) {
        super(cliente, 0.8);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public double getDescuento () {
        return super.getModDescuento();
    }
}
