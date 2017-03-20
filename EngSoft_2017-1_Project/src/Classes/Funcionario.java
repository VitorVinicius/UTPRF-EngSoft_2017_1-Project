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
public class Funcionario {
    private Date dataAdmissao;
    private String nis;
    private double salario;
    private List<Locacao> locacoesEfetuadas;

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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Locacao> getLocacoesEfetuadas() {
        return locacoesEfetuadas;
    }

    public void setLocacoesEfetuadas(List<Locacao> locacoesEfetuadas) {
        this.locacoesEfetuadas = locacoesEfetuadas;
    }
    
    public void solicitarCadastro() throws Exception{
        throw new Exception("Método não ainda implementado.");
    }
    public void solicitarLocacao() throws Exception{
        throw new Exception("Método não ainda implementado.");
    }
    
}
