/**
 * Clase que implementa un cliente niño.
 * 
 * @author Miguel Traseira 
 * @version marzo de 2019
 */
public class Niño extends Cliente {
    private static double descuento;
    private double modDescuento;
    
    /**
     * Constructor para objetos de clase Niño
     */
    public Niño(int edad, double altura, double modDescuento) {
        super.setEdad(edad); 
        super.setAltura(altura);
        this.modDescuento = modDescuento;
    }
    
    public static void setDescuento (double d) {
        descuento = d;
    }
    
    public boolean setEdad(int edad) {
        if (edad <= 12) {
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
        if (super.getEdad() <= 2) {
            return 0;
        } else {
            return this.descuento*this.modDescuento;
        }
    }
}