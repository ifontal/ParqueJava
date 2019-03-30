/**
 * Abstract class FactoriaAtracciones - Clase abstracta que se ocupa de crear las atracciones
 * 
 * @author: Miguel Traseira López
 * Date: marzo de 2019
 */
import java.util.ArrayList;

public abstract class FactoriaAtracciones {
    private static final int NUMTIPOA = 4;
    private static final int NUMTIPOB = 6;
    private static final int NUMTIPOC = 4;
    private static final int NUMTIPOD = 3;
    private static final int NUMTIPOE = 7;
    
    private static ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
    
    /**
     * Método estático que se encarga de construir las atracciones
     * 
     */
    public static void constructorAtracciones() {
        Atraccion atraccion;
        for (int i = 0; i < NUMTIPOA; i++) {
            atraccion = new AtraccionA();
            atracciones.add(atraccion);
        }
        for (int i = 0; i < NUMTIPOB; i++) {
            atraccion = new AtraccionB();
            atracciones.add(atraccion);
        }
        for (int i = 0; i < NUMTIPOC; i++) {
            atraccion = new AtraccionC();
            atracciones.add(atraccion);
        }
        for (int i = 0; i < NUMTIPOD; i++) {
            atraccion = new AtraccionD();
            atracciones.add(atraccion);
        }
        for (int i = 0; i < NUMTIPOE; i++) {
            atraccion = new AtraccionE();
            atracciones.add(atraccion);
        }
    }
    
    /**
     * Método que calcula los responsables totales
     * 
     * @return  los responsables totales
     */
    public static int getResponsablesTotales() {
        int responsables = 0;
        for (Atraccion atraccion: atracciones) {
            responsables = responsables + atraccion.getNumResponsables();
        }
        return responsables;
    }
    
    /**
     * Método que calcula los ayudantes totales
     * 
     * @return  los ayudantes totales
     */
    public static int getAyudantesTotales() {
        int ayudantes = 0;
        for (Atraccion atraccion: atracciones) {
            ayudantes = ayudantes + atraccion.getNumAyudantes();
        }
        return ayudantes;
    }
    
    /**
     * Método que almacena las atracciones para después devolverlas
     * 
     * @return  las atracciones
     */
    public static ArrayList<Atraccion> getAtracciones() {
        return atracciones;
    }
}