/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Database.Persistencia;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Vitor
 */
@Entity
public class Funcionario extends Locatario {
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAdmissao;
    
    private String nis;
    
    private float salario;
    
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @OneToMany
    private Set<Locacao> locacoesEfetuadas;

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Set<Locacao> getLocacoesEfetuadas() {
        return locacoesEfetuadas;
    }

    public void setLocacoesEfetuadas(Set<Locacao> locacoesEfetuadas) {
        this.locacoesEfetuadas = locacoesEfetuadas;
    }
    
    public void solicitarCadastro() throws Exception{
        throw new Exception("Método não ainda implementado.");
    }
    public void solicitarLocacao() throws Exception{
        throw new Exception("Método não ainda implementado.");
    }
    
    public void cadastrarLocatario(Locatario locatario) throws Exception{
         locatario = (Locatario) Persistencia.salvar(locatario);
         if(this.getHistoricos() == null)
             this.setHistoricos(new HashSet<>());
         
         Historico historico = new Historico();
         historico.setDescricao("Cadastrou um novo locatario ("+ locatario.getClass().getSimpleName()+") com id: " + locatario.getId());
         historico.setTipoOcorrencia(TipoOcorrencia.Cadastro);
         historico.setDataOcorrencia(new Date());
         this.getHistoricos().add(historico);
         Persistencia.atualizar(this);
    }
    
    public void alterarLocatario(Locatario locatario) throws Exception{
        Persistencia.atualizar(locatario);
        if(this.getHistoricos() == null)
             this.setHistoricos(new HashSet<>());
         
         Historico historico = new Historico();
         historico.setDescricao("Atualizou um locatario ("+ locatario.getClass().getSimpleName()+") com id: " + locatario.getId());
         historico.setTipoOcorrencia(TipoOcorrencia.Cadastro);
         historico.setDataOcorrencia(new Date());
         this.getHistoricos().add(historico);
         Persistencia.atualizar(this);
    }

    public void cadastrarEquipamento(Equipamento equipamento) throws Exception {
        equipamento =(Equipamento) Persistencia.salvar(equipamento);
        if(this.getHistoricos() == null)
             this.setHistoricos(new HashSet<>());
         
         Historico historico = new Historico();
         historico.setDescricao("Cadastrou um equipamento com id: " + equipamento.getId());
         historico.setTipoOcorrencia(TipoOcorrencia.Cadastro);
         historico.setDataOcorrencia(new Date());
         this.getHistoricos().add(historico);
         Persistencia.atualizar(this);
    }

    public void atualizarEquipamento(Equipamento equipamento) throws Exception {
        Persistencia.atualizar(equipamento);
        if(this.getHistoricos() == null)
             this.setHistoricos(new HashSet<>());
         
         Historico historico = new Historico();
         historico.setDescricao("Alterou um equipamento com id: " + equipamento.getId());
         historico.setTipoOcorrencia(TipoOcorrencia.Cadastro);
         historico.setDataOcorrencia(new Date());
         this.getHistoricos().add(historico);
         Persistencia.atualizar(this);
    }

    public Locacao efetuarLocacao(Locacao locacao) throws Exception {
        
        if(locacao.getEquipamento().getStatus() == StatusEquipamento.Locado){
            throw new Excecoes.EquipamentoLocado("O equipamento de id '"+locacao.getEquipamento().getId()+"' já está locado.");
        }
        
        locacao = (Locacao) Persistencia.salvar(locacao);
         if(this.getHistoricos() == null)
             this.setHistoricos(new HashSet<>());
         
         Historico historicoFuncionario = new Historico();
         historicoFuncionario.setDescricao("Efetuou uma nova locação com id: " + locacao.getId());
         historicoFuncionario.setTipoOcorrencia(TipoOcorrencia.Locacao);
         historicoFuncionario.setDataOcorrencia(new Date());
         this.getHistoricos().add(historicoFuncionario);
         Persistencia.atualizar(this);
         
         Equipamento equipamento = locacao.getEquipamento();
         equipamento.setStatus(StatusEquipamento.Locado);
         Historico historicoEquipamento = new Historico();
         historicoEquipamento.setDescricao("Foi locado por "+this.getNome()+" na locação de id: " + locacao.getId());
         historicoEquipamento.setTipoOcorrencia(TipoOcorrencia.Locacao);
         historicoEquipamento.setDataOcorrencia(new Date());
         equipamento.getHistoricos().add(historicoEquipamento);
         locacao.setEquipamento(equipamento);
         
         Persistencia.atualizar(equipamento);
         
         return locacao;
    }
    
    
    
}
