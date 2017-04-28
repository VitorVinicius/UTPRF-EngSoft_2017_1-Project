/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Database.Persistencia;
import Excecoes.EquipamentoInvalidoException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Vitor
 */
@Entity
public class Funcionario extends Locatario {
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
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
        Validacao.validarLocatario(locatario);
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
        Validacao.validarLocatario(locatario);
        Persistencia.atualizar(locatario);
        if(this.getHistoricos() == null)
             this.setHistoricos(new HashSet<>());
         
         Historico historico = new Historico();
         historico.setDescricao("Atualizou um locatario ("+ locatario.getClass().getSimpleName()+") com id: " + locatario.getId());
         historico.setTipoOcorrencia(TipoOcorrencia.AlteracaoCadastro);
         historico.setDataOcorrencia(new Date());
         this.getHistoricos().add(historico);
         Persistencia.atualizar(this);
    }
    
    
    public void cadastrarFuncionario(Funcionario funcionario) throws Exception{
         Validacao.validarFuncionario(funcionario);
         funcionario = (Funcionario) Persistencia.salvar(funcionario);
         if(this.getHistoricos() == null)
             this.setHistoricos(new HashSet<>());
         
         Historico historico = new Historico();
         historico.setDescricao("Cadastrou um novo funcionario ("+ funcionario.getClass().getSimpleName()+") com id: " + funcionario.getId());
         historico.setTipoOcorrencia(TipoOcorrencia.Cadastro);
         historico.setDataOcorrencia(new Date());
         this.getHistoricos().add(historico);
         Persistencia.atualizar(this);
    }
    
    public void alterarFuncionario(Funcionario funcionario) throws Exception{
        Validacao.validarFuncionario(funcionario);
        Persistencia.atualizar(funcionario);
        if(this.getHistoricos() == null)
             this.setHistoricos(new HashSet<>());
         
         Historico historico = new Historico();
         historico.setDescricao("Atualizou um funcionario ("+ funcionario.getClass().getSimpleName()+") com id: " + funcionario.getId());
         historico.setTipoOcorrencia(TipoOcorrencia.AlteracaoCadastro);
         historico.setDataOcorrencia(new Date());
         this.getHistoricos().add(historico);
         Persistencia.atualizar(this);
    }
    
    
    public void cadastrarConcessionaria(Concessionaria concessionaria) throws Exception{
         Validacao.validarConcessionaria(concessionaria);
         concessionaria = (Concessionaria) Persistencia.salvar(concessionaria);
         if(this.getHistoricos() == null)
             this.setHistoricos(new HashSet<>());
         
         Historico historico = new Historico();
         historico.setDescricao("Cadastrou uma nova concessionaria ("+ concessionaria.getClass().getSimpleName()+") com id: " + concessionaria.getId());
         historico.setTipoOcorrencia(TipoOcorrencia.Cadastro);
         historico.setDataOcorrencia(new Date());
         this.getHistoricos().add(historico);
         Persistencia.atualizar(this);
    }
    
    public void alterarConcessionaria(Concessionaria concessionaria) throws Exception{
        Validacao.validarConcessionaria(concessionaria);
        Persistencia.atualizar(concessionaria);
        if(this.getHistoricos() == null)
             this.setHistoricos(new HashSet<>());
         
         Historico historico = new Historico();
         historico.setDescricao("Atualizou uma concessionaria ("+ concessionaria.getClass().getSimpleName()+") com id: " + concessionaria.getId());
         historico.setTipoOcorrencia(TipoOcorrencia.AlteracaoCadastro);
         historico.setDataOcorrencia(new Date());
         this.getHistoricos().add(historico);
         Persistencia.atualizar(this);
    }
    
    

    public void cadastrarEquipamento(Equipamento equipamento) throws EquipamentoInvalidoException, Exception  {
        
        Validacao.validarEquipamneto(equipamento);
        
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

    public void atualizarEquipamento(Equipamento equipamento) throws EquipamentoInvalidoException, Exception  {
        
        Validacao.validarEquipamneto(equipamento);
        
        Persistencia.atualizar(equipamento);
        if(this.getHistoricos() == null)
             this.setHistoricos(new HashSet<>());
         
         Historico historico = new Historico();
         historico.setDescricao("Alterou um equipamento com id: " + equipamento.getId());
         historico.setTipoOcorrencia(TipoOcorrencia.AlteracaoCadastro);
         historico.setDataOcorrencia(new Date());
         this.getHistoricos().add(historico);
         Persistencia.atualizar(this);
    }

    public Locacao fazerLocacao(Locacao locacao) throws Exception {
        
        if(locacao.getLocatario().getLocacoesAtrasadas().size() >0){
            throw new Excecoes.LocacaoInvalidaException("Não é possível concluir a locação '"+locacao.getId()+"' porque o cliente têm pendências à resolver.");
        }
        
        if(locacao.getEquipamento().getStatus() != StatusEquipamento.Reservado || locacao.getEquipamento().getLocatarioReserva() == null ){
            throw new Excecoes.LocacaoInvalidaException("O equipamento de id '"+locacao.getEquipamento().getId()+"' não está disponível para locações porque ainda não foi reservado.");
        }
        else
        if(locacao.getLocatario().getId()!=locacao.getEquipamento().getLocatarioReserva().getId()){
            throw new Excecoes.EquipamentoLocadoException("O equipamento de id '"+locacao.getEquipamento().getId()+"' não está disponível para locações porque foi reservado para outro locatário.");
        }
        
        if(locacao.getPagamentos() == null || locacao.getPagamentos().isEmpty()){
            throw new Excecoes.LocacaoInvalidaException("Nenhum pagamento detectado para a locação '"+locacao.getId()+"'. Insira um pagamento para efetivar a locaçao.");
        }
        locacao.setStatus(StatusLocacao.EmDia);
        
        
        if(locacao.getId()!=0)
            locacao = (Locacao) Persistencia.salvar(locacao);
        else{
            Persistencia.atualizar(locacao);
        }
        
         if(this.getHistoricos() == null)
             this.setHistoricos(new HashSet<>());
         
         Historico historicoFuncionario = new Historico();
         historicoFuncionario.setDescricao("Locou o equipamento de id '"+locacao.getId()+"' na locacao com id: " + locacao.getId());
         historicoFuncionario.setTipoOcorrencia(TipoOcorrencia.Locacao);
         historicoFuncionario.setDataOcorrencia(new Date());
         this.getHistoricos().add(historicoFuncionario);
         Persistencia.atualizar(this);
         
         Equipamento equipamento = locacao.getEquipamento();
         equipamento.setStatus(StatusEquipamento.Locado);
         Historico historicoEquipamento = new Historico();
         historicoEquipamento.setDescricao("Foi locado por "+this.getNome()+" para '"+locacao.getLocatario().getNome()+"' locação de id: " + locacao.getId());
         historicoEquipamento.setTipoOcorrencia(TipoOcorrencia.Locacao);
         historicoEquipamento.setDataOcorrencia(new Date());
         equipamento.getHistoricos().add(historicoEquipamento);
         locacao.setEquipamento(equipamento);
         
         Persistencia.atualizar(equipamento);
         
         return locacao;
    }
    
    public Locacao fazerReserva(Locacao locacao) throws Exception {
        
        if(locacao.getLocatario().getLocacoesAtrasadas().size() >0){
            throw new Excecoes.LocacaoInvalidaException("Não é possível concluir a reserva porque o cliente têm pendências à resolver.");
        }
        
        if(locacao.getEquipamento().getStatus() != StatusEquipamento.Disponivel){
            throw new Excecoes.EquipamentoLocadoException("O equipamento de id '"+locacao.getEquipamento().getId()+"' não está disponível para reservas/locações.");
        }
        
        locacao = (Locacao) Persistencia.salvar(locacao);
         if(this.getHistoricos() == null)
             this.setHistoricos(new HashSet<>());
         
         Historico historicoFuncionario = new Historico();
         historicoFuncionario.setDescricao("Efetuou uma nova reserva com id de locação: " + locacao.getId());
         historicoFuncionario.setTipoOcorrencia(TipoOcorrencia.Reserva);
         historicoFuncionario.setDataOcorrencia(new Date());
         this.getHistoricos().add(historicoFuncionario);
         Persistencia.atualizar(this);
         
         Equipamento equipamento = locacao.getEquipamento();
         equipamento.setStatus(StatusEquipamento.Reservado);
         equipamento.setLocatarioReserva(locacao.getLocatario());
         Historico historicoEquipamento = new Historico();
         historicoEquipamento.setDescricao("Foi reservado por "+this.getNome()+" para '"+locacao.getLocatario().getNome()+"' locação de id: " + locacao.getId());
         historicoEquipamento.setTipoOcorrencia(TipoOcorrencia.Reserva);
         historicoEquipamento.setDataOcorrencia(new Date());
         equipamento.getHistoricos().add(historicoEquipamento);
         locacao.setEquipamento(equipamento);
         
         Persistencia.atualizar(equipamento);
         
         return locacao;
    }

    public void atualizarLocacao(Locacao locacao) throws Exception {
        
        Persistencia.atualizar(locacao);
         Historico historicoFuncionario = new Historico();
         historicoFuncionario.setDescricao("Atualizou a locação com id: " + locacao.getId());
         historicoFuncionario.setTipoOcorrencia(TipoOcorrencia.Locacao);
         historicoFuncionario.setDataOcorrencia(new Date());
         this.getHistoricos().add(historicoFuncionario);
         Persistencia.atualizar(this);
         
    }

    public void registrarFormaPagamento(FormaPagamento forma) throws Exception {
        forma = (FormaPagamento) Persistencia.salvar(forma);
         Historico historicoFuncionario = new Historico();
         historicoFuncionario.setDescricao("Criou a forma de pagamento '"+forma.getNome()+"': " + forma.getId());
         historicoFuncionario.setTipoOcorrencia(TipoOcorrencia.Cadastro);
         historicoFuncionario.setDataOcorrencia(new Date());
         this.getHistoricos().add(historicoFuncionario);
         Persistencia.atualizar(this);
    }
    public void atualizarFormaPagamento(FormaPagamento forma) throws Exception {
         Persistencia.atualizar(forma);
         Historico historicoFuncionario = new Historico();
         historicoFuncionario.setDescricao("Atualizou a forma de pagamento '"+forma.getNome()+"': " + forma.getId());
         historicoFuncionario.setTipoOcorrencia(TipoOcorrencia.AlteracaoCadastro);
         historicoFuncionario.setDataOcorrencia(new Date());
         this.getHistoricos().add(historicoFuncionario);
         Persistencia.atualizar(this);
    }
    
    
    
}
