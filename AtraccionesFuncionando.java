/**
 * Abstract class AtraccionesFuncionando - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
import java.util.ArrayList;
import java.util.Scanner;

public abstract class AtraccionesFuncionando {
    
    /**
     * Método para ver las atracciones que están activas en el parque
     * 
     */
    public static void verAtraccionesActivas(){
        ArrayList<Atraccion> atracciones = FactoriaAtracciones.getAtracciones();
        System.out.println("Atracciones activas:");
        for(Atraccion atraccion: atracciones){
            if(atraccion.getActiva()){
                System.out.println(atraccion.getId());
            }
        }
    }
    
    /**
     * Método para desactivar las atracciones del parque
     * 
     */
    public static void desactivarAtracciones(){
        System.out.println("¿Qué atracciones desea desactivar? (Escriba sus ids separados por comas)");
        Scanner sc = new Scanner(System.in);
        String [] ids = sc.next().split(",");
        ArrayList<Atraccion> atracciones = FactoriaAtracciones.getAtracciones();
        
        for(Atraccion atraccion: atracciones){
            for(String id: ids){
                if(atraccion.getId().equals(id.toUpperCase())){
                    atraccion.setActiva(false);
                    break;
                }
            }
        }
    }
    
    /**
     * Método para activar las atracciones del parque
     * 
     */
    public static void activarAtracciones(){
        System.out.println("¿Qué atracciones desea activar? (Escriba sus ids separados por comas)");
        Scanner sc = new Scanner(System.in);
        String [] ids = sc.next().split(",");
        ArrayList<Atraccion> atracciones = FactoriaAtracciones.getAtracciones();
        
        for(Atraccion atraccion: atracciones){
            for(String id: ids){
                if(atraccion.getId().equals(id.toUpperCase())){
                    atraccion.setActiva(true);
                    break;
                }
            }
        }
    }
}
