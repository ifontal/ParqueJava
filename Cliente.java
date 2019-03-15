/**
 * Clase abstracta Cliente - implementa un cliente genérico
 * 
 * @author: Miguel Traseira
 * Fecha: marzo de 2019
 */
public abstract class Cliente {
    private int edad;
    private double altura;

    /**
     * Método para estrablecer la edad del cliente
     *
     * @param        la edad del cliente 
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
     * Método para recuperar el descuento de cliente
     *
     * @return        el coeficiente de descuento del cliente 
     */
    public abstract double getDescuento();
}
