/**
 * Abstract class Trabajadores - Clase abstracta que implementa un trabajador genérico
 * 
 * @author: Miguel Traseira López
 * Date: marzo de 2019
 */
import java.time.*;

public abstract class Trabajadores {
    private int sueldoMensual;

    /**
     * Constructor para objetos de clase Trabajadores
     */
    public Trabajadores(int sueldoMensual){
        this.sueldoMensual = sueldoMensual;
    }
    
    /**
     * Método para obtener el sueldo mensual
     * 
     * @return        el sueldo mensual de un trabajador
     */
    public int getSueldoMensual(){
        return this.sueldoMensual;
    }
    
    /**
     * Método para obtener la media del sueldo mensual
     * 
     * @return        el sueldo diario de los trabajadores 
     */
    public int getSueldoDiario(){
        boolean esBisiesto = LocalDate.now().isLeapYear();
        if(esBisiesto){
            return (this.sueldoMensual*12)/366;
        } else{
            return (this.sueldoMensual*12)/365;
        }
    }
    
    /**
     * Método para obtener el sueldo anual
     * 
     * @return        el sueldo anual de un trabajador 
     */
    public int getSueldoAnual(){
        int sueldoAño;
        sueldoAño = this.sueldoMensual * 12;
        return sueldoAño;
    }
    
}