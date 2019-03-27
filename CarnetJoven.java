
/**
 * Write a description of class CarnetJoven here.
 * 
 * @author (your name) 
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
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public double getDescuento () {
        return super.getModDescuento();
    }
}
