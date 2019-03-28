
/**
 * Clase que implementa un cliente adulto.
 * 
 * @author Miguel Traseira 
 * @version marzo de 2019
 */
public class Adulto extends Cliente {
    
    /**
     * Constructor para objetos de clase Adulto
     */
    public Adulto(int edad, double altura, double modDescuento) {
        super(edad, altura, modDescuento);
    }

    public boolean setEdad(int edad) {
        if (edad > 12 || edad < 65) {
            super.setEdad(edad);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Método para recuperar el descuento de cliente
     *
     * @return        el coeficiente de descuento del cliente 
     */
    public double getDescuento() {
        return getModDescuento();
    }
    
    public Cliente getCliente() {
        return null;
    }
}
