/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Vitor
 */
@Entity
public class FormaPagamento implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    
    private String nome;
    private String descricao;
    private boolean apagado = false;

    public boolean isApagado() {
        return apagado;            
    }

    public void setApagado(boolean apagado) {
        this.apagado = apagado;
    }
    
    private boolean ativa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    
    
}
