/**
 * Clase abstracta Cliente - implementa un cliente genérico
 * 
 * @author: Miguel Traseira
 * Fecha: marzo de 2019
 */
public abstract class Cliente {
    private int edad;
    private double altura;
    private double modDescuento;

    public Cliente (int edad, double altura, double modDescuento) {
        this.edad = edad;
        this.altura = altura;
        this.modDescuento = modDescuento;
    }
    
    /**
     * Método para estrablecer la edad del cliente
     *
     * @param        la edad del cliente
     * @return      true si se ha cambiado la edad
     */
    public boolean setEdad(int edad) {
        this.edad = edad;
        return true;
    }

    /**
     * Método para obtener la edad del cliente
     *
     * @return        la edad del cliente 
     */
    public int getEdad() {
        return this.edad;
    }

    /**
     * Método para estrablecer la altura del cliente
     *
     * @param        la altura del cliente 
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * Método para obtener la altura del cliente
     *
     * @return        la altura del cliente 
     */
    public double getAltura() {
        return this.altura;
    }

    /**
     * Método para estrablecer el modificador de descuento del cliente
     *
     * @param        el descuento (0.00 = 100% de descuento, 1.00 = 0% de descuento) 
     */
    public void setModDescuento(double modDescuento) {
        this.modDescuento = modDescuento;
    }
    
    /**
     * Método para obtener el modificador de descuento del cliente
     *
     * @return        el descuento (0.00 = 100% de descuento, 1.00 = 0% de descuento) 
     */
    public double getModDescuento() {
        return this.modDescuento;
    }
    
    /**
     * Método para recuperar el descuento total de cliente
     *
     * @return        el coeficiente de descuento total de cliente 
     */
    public abstract double getDescuento();
}
