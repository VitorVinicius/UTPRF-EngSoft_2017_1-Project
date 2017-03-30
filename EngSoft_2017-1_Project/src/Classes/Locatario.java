/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;


import java.util.Date;
import Excecoes.HistoricoNaoObtidoException;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Vitor
 */
@Entity
public class Locatario implements Serializable{
    private String cpf;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    private String razaoSocial;
    private String cnpj;
    private String  inscricaoEstadual;
    private String nomeFantasia;
    
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String rua;
    private String numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String uf;
    
    @OneToMany
    private Set<Historico> historicosRelacionados;
    private String tipo;
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @OneToMany
    private Set<Pagamento> pagamentosRelacionados;
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Set<Pagamento> ObterPagamentos() {
        return pagamentosRelacionados;
    }
    
  

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Set<Pagamento> getPagamentos() {
        return pagamentosRelacionados;
    }

    public void setPagamentos(Set<Pagamento> pagamentos) {
        this.pagamentosRelacionados = pagamentos;
    }
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
    
    
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Set<Historico> getHistoricos() throws HistoricoNaoObtidoException {
        return historicosRelacionados;
    }
    
    public void setHistoricos(Set<Historico> historicos) {
        this.historicosRelacionados = historicos;
    }
    
    @Override
    public String toString(){
        return Long.toString(id);
    }
}
