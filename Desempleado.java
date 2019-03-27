
/**
 * Write a description of class Desempleado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Desempleado extends IncrementarDescuento {
    public Desempleado(Cliente cliente) {
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
