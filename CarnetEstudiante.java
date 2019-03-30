/**
 * Clase que implementa el descuento del carnet de estudiante
 * 
 * @author: Miguel Traseira López
 * @version (a version number or a date)
 */
public class CarnetEstudiante extends IncrementarDescuento {
    /**
     * Constructor para objetos de clase CarnetEstudiante
     */
    public CarnetEstudiante(Cliente cliente) {
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