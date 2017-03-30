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
    private String nomeResponsavel;

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
    
    public boolean consultarConcessionaria() throws Exception{
        throw new Exception("Método ainda não implementado.");
    }
   public boolean solicitarRevisaoEquipamento(Equipamento equipamento) throws Exception{
        throw new Exception("Método ainda não implementado.");
    }
   public boolean solicitarAtualizacaoEquipamento(Equipamento equipamento) throws Exception{
        throw new Exception("Método ainda não implementado.");
    }
   public boolean solicitarEquipamento(Equipamento equipamento) throws Exception{
        throw new Exception("Método ainda não implementado.");
    }
}
