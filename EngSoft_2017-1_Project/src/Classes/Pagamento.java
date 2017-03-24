/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author Vitor
 */
public class Pagamento {

    private long id;
    private float valor;
    private String formaPagamento;
    private String referencia;
    private int parcela;
    private int totalParcelas;
    private Boolean pendente;
    private Date dataPagamento;

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public int getTotalParcelas() {
        return totalParcelas;
    }

    public void setTotalParcelas(int totalParcelas) {
        this.totalParcelas = totalParcelas;
    }

    public Boolean getPendente() {
        return pendente;
    }

    public void setPendente(Boolean pendente) {
        this.pendente = pendente;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    
}
