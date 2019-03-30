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
    
    /**
     * Método para poner la edad de un cliente
     *
     * @return        true si la edad se encuentra entre 12 y 65, no incluídos ambos 
     */
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
    
    /**
     * Método para recuperar el cliente
     *
     * @return        null 
     */
    public Cliente getCliente() {
        return null;
    }
}
