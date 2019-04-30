/**
 * Abstract class FactoriaEntradas - Clase abstracta que crea las entradas
 * 
 * @author: Miguel Traseira López 
 * @version marzo de 2019
 */
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Character;

public abstract class FactoriaEntradas {
    private static ArrayList<Entrada> arrayEntradas = new ArrayList<Entrada>();
    
    /**
     * Método estático para obtener una entrada
     * 
     * @param  el tipo de entrada, si es vip o no y la fecha
     * @return la entrada
     */
    public static Entrada getEntrada(String tipoEntrada, boolean esVip, String fecha, int edad, double altura) {

        Cliente cliente = FactoriaClientes.getCliente(edad, altura);
        
        if(tipoEntrada.equals("general")) {
            return new EntradaGeneral(esVip, LocalDate.parse(fecha), cliente);
        } else if (tipoEntrada.equals("tardes")) {
            return new EntradaTardes(esVip, LocalDate.parse(fecha), cliente);
        } else if (tipoEntrada.equals("laborables")) {
            int dia = LocalDate.parse(fecha).getDayOfWeek().getValue();
            switch (dia) {
                case 1:
                case 2:
                case 3:
                case 4:
                return new EntradaLaborables(esVip, LocalDate.parse(fecha), cliente);
                default:
                return null;
            }
        } else {
            return null;
        }
    }
    
    /**
     * Método estático para obtener la lista de entradas
     * @return la lista de entradas
     */
    public static ArrayList<Entrada> getListaEnt(){
        return arrayEntradas;
    }
}