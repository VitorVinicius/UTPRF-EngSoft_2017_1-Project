/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.Date;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Vitor
 */
@Entity
public class Locacao implements Serializable {
    @Id
    @GeneratedValue
     
    private long id;
    @OneToOne
    private Locatario locatario;
    @OneToOne
    private Equipamento equipamento;
    
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataLocacao;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataDevolucao;
    
    private StatusLocacao status;
    @OneToMany
    
    private Set<Pagamento> pagamentos;
    
    private float valorDiaria;
    
    private float totalLocacao;
    
    private float multaAtraso;
    @OneToOne
    private Funcionario funcionario;

    public float getMultaAtraso() {
        return multaAtraso;
    }

    public void setMultaAtraso(float multaAtraso) {
        this.multaAtraso = multaAtraso;
    }
    
    public Set<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Set<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public float getTotalLocacao() {
        return totalLocacao;
    }

    public void setTotalLocacao(float totalLocacao) {
        this.totalLocacao = totalLocacao;
    }
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public StatusLocacao getStatus() {
        return status;
    }

    public void setStatus(StatusLocacao status) {
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
   
}
