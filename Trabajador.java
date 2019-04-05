/**
 * Abstract class Trabajadores - Clase abstracta que implementa un trabajador genérico
 * 
 * @author: Miguel Traseira López
 * Date: marzo de 2019
 */
import java.time.*;

public abstract class Trabajador {
    private double sueldoMensual;

    /**
     * Constructor para objetos de clase Trabajadores
     */
    public Trabajador(double sueldoMensual){
        this.sueldoMensual = sueldoMensual;
    }
    
    /**
     * Método para obtener el sueldo mensual
     * 
     * @return        el sueldo mensual de un trabajador
     */
    public double getSueldoMensual(){
        return this.sueldoMensual;
    }
    
    /**
     * Método para obtener la media del sueldo mensual
     * 
     * @return        el sueldo diario de los trabajadores 
     */
    public double getSueldoDiario(){
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
    public double getSueldoAnual(){
        double sueldoAño;
        sueldoAño = this.sueldoMensual * 12;
        return sueldoAño;
    }
    
}