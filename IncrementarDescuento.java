/**
 * Abstract class IncrementarDescuento - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class IncrementarDescuento extends Cliente {
    private Cliente cliente;

    public IncrementarDescuento (Cliente cliente, double modDescuento) {
        super(cliente.getEdad(), cliente.getAltura(), modDescuento);
        this.cliente = cliente;
    }
    
    public double getModDescuento() {
        return cliente.getModDescuento() * super.getModDescuento();
    }
}
