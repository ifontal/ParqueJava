/**
* Abstract class FactoriaTrabajadores - Clase abstracta que se encarga de crear los trabajadores necesarios
* 
* @author: Miguel Traseira López
* Date:    marzo de 2019
*/
import java.util.ArrayList;

public abstract class FactoriaTrabajadores {
    private final static double SUELDOAYUDANTES = 950;
    private final static double SUELDORESPONSABLES = SUELDOAYUDANTES * 1.15;
    private final static double SUELDOATCLIENTE = SUELDOAYUDANTES * 1.10;
    private final static double SUELDORRPP = SUELDOAYUDANTES *1.20;
    private static ArrayList<Trabajador> trabajadoresExt = new ArrayList<Trabajador>();
    
    /**
     * Método encargado de crear los trabajadores con su sueldo
     */
    public static void crearTrabajadores(){
        int ayudantes = FactoriaAtracciones.getAyudantesTotales();
        int responsables = FactoriaAtracciones.getResponsablesTotales();
        int atCliente = (int)((ayudantes + responsables)*0.30);
        int relPublicas = (int)((ayudantes + responsables)*0.10);
        
        ArrayList<Atraccion> atracciones = FactoriaAtracciones.getAtracciones();
        
        Trabajador ayudante, responsable;      
        for(Atraccion atraccion: atracciones){
            for(int i = 0; i < atraccion.getNumAyudantes(); i++){
                ayudante = new AyudanteAtraccion(SUELDOAYUDANTES);
                atraccion.addTrabajador(ayudante);
            }
            for(int i = 0; i < atraccion.getNumResponsables(); i++){
                responsable = new ResponsableAtraccion(SUELDORESPONSABLES);
                atraccion.addTrabajador(responsable);
            }
        }
        
        AtencionCliente atencionCliente;
        for(int i = 0; i < atCliente; i++){
            atencionCliente = new AtencionCliente(SUELDOATCLIENTE);
            trabajadoresExt.add(atencionCliente);
        }
        
        RelacionesPublicas relacionesPublicas;
        for(int i = 0; i < relPublicas; i++){
            relacionesPublicas = new RelacionesPublicas(SUELDORRPP);
            trabajadoresExt.add(relacionesPublicas);
        }
    }
    
    /**
     * Método encargado de devolver el sueldo de cada trabajador correspondiente si la atracción está activa
     * 
     * @return   el sueldo del trabajador por día/semana/mes/año
     */
    public static double gastoDePersonal(String tipoSueldo) {
        double sueldoTotal = 0;
        ArrayList<Atraccion> atracciones = FactoriaAtracciones.getAtracciones();
        ArrayList<Trabajador> trabajadores;
        for (Atraccion atraccion : atracciones) {
            if(atraccion.getActiva()) {
                trabajadores = atraccion.getTrabajadores();
                for(Trabajador trabajador: trabajadores){
                    switch(tipoSueldo){
                        case "dia":
                        sueldoTotal = sueldoTotal + trabajador.getSueldoDiario();
                        break;
                        case "semana":
                        sueldoTotal = sueldoTotal + trabajador.getSueldoDiario()*7;
                        break;
                        case "mes":
                        sueldoTotal = sueldoTotal + trabajador.getSueldoMensual();
                        break;
                        case "año":
                        sueldoTotal = sueldoTotal + trabajador.getSueldoAnual();
                        break;
                        default:
                        return 0;
                    }
                }
            }
        }
        
        for(Trabajador trabajador: trabajadoresExt){
            switch(tipoSueldo){
                case "dia":
                sueldoTotal = sueldoTotal + trabajador.getSueldoDiario();
                break;
                case "semana":
                sueldoTotal = sueldoTotal + trabajador.getSueldoDiario()*7;
                break;
                case "mes":
                sueldoTotal = sueldoTotal + trabajador.getSueldoMensual();
                break;
                case "año":
                sueldoTotal = sueldoTotal + trabajador.getSueldoAnual();
                break;
                default:
                return 0;
            }
        }
            
        return sueldoTotal;
    }
}