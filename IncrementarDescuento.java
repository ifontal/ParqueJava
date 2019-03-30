/**
 * Abstract class IncrementarDescuento - Clase abstracta que implementa el descuento de un cliente
 * 
 * @author: Miguel Traseira López
 * Date: 
 */
public abstract class IncrementarDescuento extends Cliente {
    private Cliente cliente;

    /**
     * Constructor para objetos de clase IncrementarDescuento
     */
    public IncrementarDescuento (Cliente cliente, double modDescuento) {
        super(cliente.getEdad(), cliente.getAltura(), modDescuento);
        this.cliente = cliente;
    }
    
    /**
     * Método para obtener el descuento del cliente
     *
     * @return        true si la edad es mayor o igual que 65 
     */
    public double getModDescuento() {
        return cliente.getModDescuento() * super.getModDescuento();
    }
    
    /**
     * Método para recuperar el cliente
     *
     * @return        el cliente
     */
    public Cliente getCliente() {
        return this.cliente;
    }
}