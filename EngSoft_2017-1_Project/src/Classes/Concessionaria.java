/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import javax.persistence.Entity;



/**
 *
 * @author Vitor
 */
@Entity
public class Concessionaria extends Locatario implements Serializable {
    
    public Concessionaria(){
        super.setTipo(TipoLocatario.CONCESSIONARIA);
    }
    
    private String nomeResponsavel;

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
    
}
