/**
 * Abstract class FactoriaAtracciones - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
import java.util.ArrayList;

public abstract class FactoriaAtracciones {
    private static final int NUMTIPOA = 4;
    private static final int NUMTIPOB = 6;
    private static final int NUMTIPOC = 4;
    private static final int NUMTIPOD = 3;
    private static final int NUMTIPOE = 7;
    
    private static ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
    
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
    
    public static int getResponsablesTotales() {
        int responsables = 0;
        for (Atraccion atraccion: atracciones) {
            responsables = responsables + atraccion.getNumResponsables();
        }
        return responsables;
    }
    
    public static int getAyudantesTotales() {
        int ayudantes = 0;
        for (Atraccion atraccion: atracciones) {
            ayudantes = ayudantes + atraccion.getNumAyudantes();
        }
        return ayudantes;
    }
    
    public static ArrayList<Atraccion> getAtracciones() {
        return atracciones;
    }
}
