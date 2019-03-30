/**
 * Clase que implementa un cliente niño.
 * 
 * @author Miguel Traseira 
 * @version marzo de 2019
 */
public class Niño extends Cliente {
    private static double descuento = 0.50;
    
    /**
     * Constructor para objetos de clase Niño
     */
    public Niño(int edad, double altura, double modDescuento) {
        super(edad, altura, modDescuento);  
    }
    
    /**
     * Método para poner el descuento de un cliente 
     */
    public static void setDescuento (double d) {
        descuento = d;
    }
    
    /**
     * Método para poner la edad de un cliente
     *
     * @return        true si la edad es menor o igual a 12 años 
     */
    public boolean setEdad(int edad) {
        if (edad <= 12) {
            setEdad(edad);
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
        if (super.getEdad() <= 2) {
            return 0;
        } else {
            return this.descuento*getModDescuento();
        }
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
