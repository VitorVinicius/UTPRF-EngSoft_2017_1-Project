/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import GUI.TelaCadastroEquipamento;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitor
 */
@Entity
public class Equipamento implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @Lob
    @Column(nullable=false) 
    private String nome;
    @Lob
    private String descricao;
    @OneToOne
    private Concessionaria concessionaria;
    @Lob
    private String imagemBase64;

    public String getImagemBase64() {
        return imagemBase64;
    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }
    @Column(nullable=false) 
    private String ean;
    private String categoria;

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Historico> historicos;
    @Column(nullable=false) 
    private StatusEquipamento status = StatusEquipamento.Disponivel;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date proximaRevisao = new Date();
    
    @Column(nullable=false) 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCompra = new Date();
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date validade = new Date();
    
    public Concessionaria getConcessionaria() {
        return concessionaria;
    }

    public void setConcessionaria(Concessionaria concessionaria) {
        this.concessionaria = concessionaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private String fabricante;
    @Column(nullable=false) 
    private float valorDiaria;
    @Column(nullable=false) 
    private float valorPatrimonio;
    

    @OneToOne
    private Funcionario funcionario;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public float getValorPatrimonio() {
        return valorPatrimonio;
    }

    public void setValorPatrimonio(float valorPatrimonio) {
        this.valorPatrimonio = valorPatrimonio;
    }

    public Set<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(Set<Historico> historicos) {
        this.historicos = historicos;
    }

    public StatusEquipamento getStatus() {
        return status;
    }

    public void setStatus(StatusEquipamento status) {
        this.status = status;
    }

    public Date getProximaRevisao() {
        return proximaRevisao;
    }

    public void setProximaRevisao(Date proximaRevisao) {
        this.proximaRevisao = proximaRevisao;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public boolean verificarDisponibilidade() throws Exception {
        throw new Exception("Método ainda não implementado.");
    }

    public StatusEquipamento consultarEstado() throws Exception {
        throw new Exception("Método ainda não implementado.");
    }

    public boolean consultarValidade() throws Exception {
        throw new Exception("Método ainda não implementado.");
    }

    public boolean consultarEstoque() throws Exception {
        throw new Exception("Método ainda não implementado.");
    }
    @Override
    public String toString(){
        return Long.toString(id);
    }
    
    @Override
    public Equipamento clone(){
        Equipamento clone = new Equipamento();
        clone.setId(0);
        clone.setCategoria(categoria);
        clone.setConcessionaria(concessionaria);
        clone.setDataCompra(dataCompra);
        clone.setDescricao(descricao);
        clone.setEan(ean);
        clone.setFabricante(fabricante);
        clone.setFuncionario(funcionario);
        clone.setHistoricos(new HashSet<>());
        for(Historico hist: this.historicos){
            Historico historico = new Historico();
            historico.setDataOcorrencia(hist.getDataOcorrencia());
            historico.setDescricao(hist.getDescricao());
            historico.setTipoOcorrencia(hist.getTipoOcorrencia());
            clone.getHistoricos().add(historico);
        }
        clone.setNome(nome);
        clone.setProximaRevisao(proximaRevisao);
        clone.setStatus(status);
        clone.setValidade(validade);
        clone.setValorDiaria(valorDiaria);
        clone.setValorPatrimonio(valorPatrimonio);
        return clone;
    }
    public BufferedImage obterImagem() throws IOException {
        String imagem = getImagemBase64();
        byte[] imgBytes = Base64.getDecoder().decode(imagem);
        InputStream in = new ByteArrayInputStream(imgBytes);
        BufferedImage bImageFromConvert = ImageIO.read(in);
        return bImageFromConvert;
        
    } 
}
