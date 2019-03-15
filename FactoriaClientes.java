
/**
 * Write a description of class FactoriaClientes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class FactoriaClientes {
    private static ArrayList<Cliente> clientesParque = new ArrayList<Cliente>();
    
    public static Cliente getCliente(int edad, double altura, ArrayList<Double> descuentos) {
        double modDescuento = 1;
        
        for (double descuento: descuentos) {
            modDescuento *= descuento; /* En el array "descuentos" vendrán los descuentos
                                        tipo carnet joven, diversidad funcional, etc... */
        }

        if (edad <= 12) {
            Niño niño = new Niño(edad, altura, modDescuento);
            clientesParque.add(niño);
            return niño;
        } else if (edad > 12 || edad < 65) {
            Adulto adulto = new Adulto(edad, altura, modDescuento);
            clientesParque.add(adulto);
            return adulto;
        } else if (edad >= 65) {
            Senior senior = new Senior(edad, altura, modDescuento);
            clientesParque.add(senior);
            return senior;
        } else {
            return null;
        }
    }
    
    public static ArrayList<Cliente> getClientesParque() {
        return clientesParque;
    }
}
