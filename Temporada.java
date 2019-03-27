/**
 * Clase que implementa una temporada de precios
 * 
 * @author: Miguel Traseira
 * @version: marzo de 2019
 */
import java.util.ArrayList;
import java.time.LocalDate;

public class Temporada {
    
    private class IntervaloFechas {
        private LocalDate fechaInicio;
        private LocalDate fechaFin;

        /**
         * Constructor para objectos de clase IntervaloFechas
         */
        public IntervaloFechas(String fechaInicio, String fechaFin) {
            this.fechaInicio = LocalDate.parse(fechaInicio);
            this.fechaFin = LocalDate.parse(fechaFin);
        }

        /**
         * Método para obtener la fecha de inicio de un intervalo
         * 
         * @return      la fecha de inicio
         */
        public LocalDate getFechaInicio() {
            return this.fechaInicio;
        }
    
        /**
         * Método para establecer la fecha de inicio de un intervalo
         * 
         * @param       fecha de inicio
         */
        public void setFechaInicio(LocalDate fechaInicio) {
            if (fechaInicio.isBefore(this.fechaFin)) {
                this.fechaInicio = fechaInicio;
            }
        }
    
        /**
         * Método para obtener la fecha de fin de un intervalo
         * 
         * @return      la fecha de fin
         */
        public LocalDate getFechaFin() {
            return this.fechaFin;
        }
        
        /**
         * Método para establecer la fecha de fin de un intervalo
         * 
         * @param       fecha de fin
         */
        public void setFechaFin(LocalDate fechaFin) {
            if(fechaFin.isAfter(this.fechaInicio)){
                this.fechaFin = fechaFin;
            }
        }
    }
    
    private ArrayList<IntervaloFechas> fechas;
    
    /**
     * Constructor for objects of class Temporada
     */
    public Temporada() {
        this.fechas = new ArrayList<IntervaloFechas>();
    }
    
    /**
     * Método para obtener las fechas de la temporada
     * 
     * @return      la fechas de la temporada
     */
    public ArrayList<IntervaloFechas> getFechas() {
        return this.fechas;
    }
    
    /**
     * Método para añadir fechas a la temporada
     * 
     * @param       intervalo de fechas
     */
    public void addFechas(String fechaInicio, String fechaFin) {
        IntervaloFechas intervalo = new IntervaloFechas(fechaInicio, fechaFin);
        this.fechas.add(intervalo);
    }
    
    /**
     * Método para comprobar si la fecha pertenece a la temporada
     * 
     * @return      true si la fecha está en la temporada
     * @param       la fecha a comprobar
     */
    public boolean tieneFecha(LocalDate fecha) {
        for (IntervaloFechas intervalo: fechas){
            if (fecha.isAfter(intervalo.getFechaInicio().minusDays(1)) && fecha.isBefore(intervalo.getFechaFin().plusDays(1))){
                return true;
            }
        }
        return false;
    }
}
