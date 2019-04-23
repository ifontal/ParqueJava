/**
 * Abstract class Atraccion - Clase abstracta que implementa una atracción genérica
 * 
 * @author: Miguel Traseira López
 * Date: marzo de 2019
 */
import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Atraccion {
    public class Registro{
        private Cliente cliente;
        private LocalDate fecha;
        
        public Registro(Cliente cliente, LocalDate fecha){
            this.cliente = cliente;
            this.fecha = fecha;
        }
        
        /**
        * Método que devuelve el cliente de un registro
        * 
        * @return      el cliente 
        */
        public Cliente getCliente(){
            return this.cliente;  
        }
        
        /**
        * Método que devuelve la fecha de un registro
        * 
        * @return      la fecha 
        */
        public LocalDate getFecha(){
            return this.fecha;  
        }
    }
    
    private int numAyudantes;
    private int numResponsables;
    private boolean admiteVip;
    private boolean activa;
    private String id;
    private ArrayList<Trabajador> trabajadores;
    private ArrayList<Registro> clientesAtraccion;
    
    /**
     * Constructor para objetos de clase Atraccion
     */
    public Atraccion (int numAyudantes, int numResponsables, boolean admiteVip, boolean activa, String id) {
        this.numAyudantes = numAyudantes;
        this.numResponsables = numResponsables;
        this.admiteVip = admiteVip;
        this.activa = activa;
        this.id = id;
        this.trabajadores = new ArrayList<Trabajador>();
        this.clientesAtraccion = new ArrayList<Registro>();
    }
    
    /**
     * Método para fijar el número de ayudantes de una atracción
     * 
     * @param el número de ayudantes
     */
    public void setNumAyudantes(int numAyudantes) {
        this.numAyudantes = numAyudantes;
    }
    
    /**
     * Método para obtener el número de ayudantes de una atracción
     * 
     * @return el número de ayudantes
     */
    public int getNumAyudantes() {
        return this.numAyudantes;
    }
    
    /**
     * Método para fijar el número de responsables de una atracción
     * 
     * @param el número de responsables
     */
    public void setNumResponsables(int numResponsables) {
        this.numResponsables = numResponsables;
    }
    
    /**
     * Método para obtener el número de responsables de una atracción
     * 
     * @return el número de responsables
     */
    public int getNumResponsables() {
        return this.numResponsables;
    }
    
    /**
     * Método para saber si admite vip una atracción
     * 
     * @param el vip
     */
    public void setAdmiteVip(boolean admiteVip) {
        this.admiteVip = admiteVip;
    }
    
    /**
     * Método para obtener si admite vip 
     * 
     * @return el vip
     */
    public boolean getAdmiteVip() {
        return this.admiteVip;
    }
    
    /**
     * Método para saber si está activa
     * 
     * @param si está activa
     */
    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    /**
     * Método para obtener si está activa
     * 
     * @return si está activa
     */
    public boolean getActiva() {
        return this.activa;
    }
    
    /** Método para añadir trabajador
     * 
     * @param   un trabajador
     */
    public void addTrabajador(Trabajador trabajador){
        this.trabajadores.add(trabajador);
    }
    
    /** Método para obtener el array de trabajadores
     * 
     * @return  la lista de trabajadores
     */
    public ArrayList<Trabajador> getTrabajadores(){
        return this.trabajadores;
    }
    
    /**
    * Método para añadir un registro
    * 
    * @param un registro 
    */
    public void addRegistro(Cliente cliente, LocalDate fecha){
        Registro registro = new Registro(cliente, fecha);
        this.clientesAtraccion.add(registro);
    }
    
    /**
    * Método para devolver el array de registros
    * 
    * @return un registro 
    */
    public ArrayList<Registro> getRegistros(){
        return this.clientesAtraccion;
    }
    
    /** Método para obtener el id de la atracción
     * 
     * @return  el id de la atracción
     */
    public String getId(){
        return this.id;
    }
    
    public abstract boolean clienteAdmitido(Cliente cliente);
}
