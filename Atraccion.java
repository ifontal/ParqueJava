/**
 * Abstract class Atraccion - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
import java.util.ArrayList;

public abstract class Atraccion {
    private int numAyudantes;
    private int numResponsables;
    private boolean admiteVip;
    private boolean activa;
    
    public Atraccion (int numAyudantes, int numResponsables, boolean admiteVip, boolean activa) {
        this.numAyudantes = numAyudantes;
        this.numResponsables = numResponsables;
        this.admiteVip = admiteVip;
        this.activa = activa;
    }
    
    public void setNumAyudantes(int numAyudantes) {
        this.numAyudantes = numAyudantes;
    }
    
    public int getNumAyudantes() {
        return this.numAyudantes;
    }
    
    public void setNumResponsables(int numResponsables) {
        this.numResponsables = numResponsables;
    }
    
    public int getNumResponsables() {
        return this.numResponsables;
    }
    
    public void setAdmiteVip(boolean admiteVip) {
        this.admiteVip = admiteVip;
    }
    
    public boolean getAdmiteVip() {
        return this.admiteVip;
    }
    
    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    public boolean getActiva() {
        return this.activa;
    }
    
    public abstract boolean clienteAdmitido(Cliente cliente);
}
