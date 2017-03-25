/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;


import java.util.List;

/**
 *
 * @author Vitor
 */
public class PessoaFisica extends Pessoa implements Locatario{
    private String cpf;
    private String dataNascimento;
    private List<Pagamento> pagamentos;
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public List<Pagamento> ObterPagamentos() {
        return pagamentos;
    }
    
}
