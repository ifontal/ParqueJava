
/**
 * Write a description of class FactoriaEntradas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Character;

public abstract class FactoriaEntradas {
    
    
    public static Entrada getEntrada(String tipoEntrada, boolean esVip, String fecha) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("¿Cuál es su edad?: ");
        int edad = sc.nextInt();
        
        System.out.println("¿Cuál es su altura?: ");
        double altura = sc.nextDouble();

        Cliente cliente = FactoriaClientes.getCliente(edad, altura);
        
        if(tipoEntrada.equals("general")) {
            return new EntradaGeneral(esVip, LocalDate.parse(fecha), cliente);
        } else if (tipoEntrada.equals("reducida")) {
            return new EntradaReducida(esVip, LocalDate.parse(fecha), cliente);
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
}
