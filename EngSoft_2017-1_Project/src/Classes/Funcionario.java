/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Database.Conector;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Vitor
 */
public class Funcionario extends Locatario {
    private Date dataAdmissao;
    private String nis;
    private float salario;
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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
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
    
    public void cadastrarCliente(Locatario locatario) throws SQLException{
        //Aqui colocar a acao de jogar no banco, chamando o metodo statico ExecutarConsulta
        PreparedStatement  pstmt = Conector.getConexao().prepareStatement("INSERT INTO `locadora`.`pessoa`\n" +
                                                "(`nome`,\n" +
                                                "`rua`,\n" +
                                                "`numero`,\n" +
                                                "`cep`,\n" +
                                                "`bairro`,\n" +
                                                "`cidade`,\n" +
                                                "`tipo`,\n" +
                                                "`cpf`,\n" +
                                                "`dataNascimento`,\n" +
                                                "`razaoSocial`,\n" +
                                                "`nomeFantasia`,\n" +
                                                "`incricaoEstadual`,\n" +
                                                "`cnpj`,\n" +
                                                "`uf`)\n" +
                                                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);"); 
        pstmt.setString(1, locatario.getNome());
        pstmt.setString(2, locatario.getRua());
        pstmt.setString(3, locatario.getNumero());
        pstmt.setString(4, locatario.getCep());
        pstmt.setString(5, locatario.getBairro());
        pstmt.setString(6, locatario.getCidade());
        pstmt.setString(7, locatario.getTipo());
        pstmt.setString(8, locatario.getCpf());
        Date dataNasc = locatario.getDataNascimento();
        if(dataNasc!=null){
            java.sql.Date sqlDate = new java.sql.Date(locatario.getDataNascimento().getTime());
            pstmt.setDate(9, sqlDate);
        }else{
            pstmt.setDate(9, null);
        }
        pstmt.setString(10, locatario.getRazaoSocial());
        pstmt.setString(11, locatario.getNomeFantasia());
        pstmt.setString(12, locatario.getInscricaoEstadual());
        pstmt.setString(13, locatario.getCnpj());
        pstmt.setString(14, locatario.getUf());
        pstmt.executeUpdate();
        
    }
    
}
