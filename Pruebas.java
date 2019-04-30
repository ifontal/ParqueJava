/**
 * Abstract class Pruebas - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
import java.time.LocalDate;
import java.util.Random;
import java.util.ArrayList;

public abstract class Pruebas {
    private static final int nNiños = 5;
    private static final int nAdultos = 5;
    private static final int nSenior = 5;
    
    public static void prueba1 () {
        Cliente cliente;
        Entrada entrada;
        int edad;
        double altura;
        Random r = new Random();
        ArrayList<Entrada> arrayEntradas = FactoriaEntradas.getListaEnt();
        
        for (int i = 0; i < nNiños; i++) {
            edad = r.nextInt(10)+2;
            altura = r.nextDouble()+0.5;
            altura = Math.round(altura*100d)/100d;
            cliente = new Niño(edad, altura, 1);
            entrada = new EntradaGeneral(false, LocalDate.now(), cliente);
            arrayEntradas.add(entrada);
            AccesoParque.entradaParque(entrada);
        }
        for (int i = 0; i < nAdultos; i++) {
            edad = r.nextInt(51)+13;
            altura = r.nextDouble()+1.5;
            altura = Math.round(altura*100d)/100d;
            cliente = new Adulto(edad, altura, 1);
            entrada = new EntradaGeneral(false, LocalDate.now(), cliente);
            arrayEntradas.add(entrada);
            AccesoParque.entradaParque(entrada);
        }
        for (int i = 0; i < nSenior; i++) {
            edad = r.nextInt(35)+65;
            altura = r.nextDouble()+1.5;
            altura = Math.round(altura*100d)/100d;
            cliente = new Senior(edad, altura, 1);
            entrada = new EntradaGeneral(false, LocalDate.now(), cliente);
            arrayEntradas.add(entrada);
            AccesoParque.entradaParque(entrada);
        }
        
    }
}
