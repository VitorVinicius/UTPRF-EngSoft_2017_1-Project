/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Vitor
 */
public class Equipamento {

    private String nome;
    private String fabricante;
    private double valorDiaria;
    private double valorPatrimonio;
    private List<Historico> historicos;
    private StatusEquipamento status;
    private Date proximaRevisao;
    private Date dataCompra;
    private Date validade;
    
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

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getValorPatrimonio() {
        return valorPatrimonio;
    }

    public void setValorPatrimonio(double valorPatrimonio) {
        this.valorPatrimonio = valorPatrimonio;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
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
    
    
    public boolean verificarDisponibilidade() throws Exception{
        throw new Exception("Método ainda não implementado.");
    }
    public StatusEquipamento consultarEstado() throws Exception{
        throw new Exception("Método ainda não implementado.");
    }
    public boolean consultarValidade() throws Exception{
        throw new Exception("Método ainda não implementado.");
    }
    public boolean consultarEstoque() throws Exception{
        throw new Exception("Método ainda não implementado.");
    }
}
