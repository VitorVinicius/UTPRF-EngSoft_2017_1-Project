/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Excecoes.ConcessionariaInvalidaException;
import Excecoes.EquipamentoInvalidoException;
import Excecoes.FormaPagamentoInvalida;
import Excecoes.FuncionarioInvalidoException;
import Excecoes.LocacaoInvalidaException;
import Excecoes.LocatarioInvalidoException;
import Excecoes.PagamentoInvalidoException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Vitor
 */
public class Validacao {
    
    public static void validarEquipamneto(Equipamento equipamneto) throws EquipamentoInvalidoException{
       EquipamentoInvalidoException ex = new EquipamentoInvalidoException("Equipamento Inválido");
       if(equipamneto.getId()<0){
           throw ex;
       }
       if(equipamneto.getNome()== null){
           throw ex;
       }
       if(equipamneto.getNome().length()>255){
           throw ex;
       }
       if(equipamneto.getDescricao()==null){
           throw ex;
       }
       
       if(equipamneto.getFabricante()==null){
           throw ex;
       }
       
       if(equipamneto.getValorDiaria()<=0){
           throw ex;
       }
       if(equipamneto.getValorPatrimonio()<=0){
           throw ex;
       }
       if(equipamneto.getStatus()==null){
           throw ex;
       }
       if(equipamneto.getDataCompra() == null){
           throw ex;
       }
       if(equipamneto.getValidade()== null){
           throw ex;
       }
       if(equipamneto.getProximaRevisao()== null){
           throw ex;
       }
       if(equipamneto.getFabricante()==null){
           throw ex;
       }
       if(equipamneto.getFabricante().length()>255){
           throw ex;
       }
       if(equipamneto.getHistoricos() == null){
            throw ex;
       }
       if(equipamneto.getHistoricos().isEmpty()){
            throw ex;
       }
    }
    
    public static void validarLocatario(Locatario locatario) throws LocatarioInvalidoException{
         Excecoes.LocatarioInvalidoException ex = new  Excecoes.LocatarioInvalidoException("Locatário Inválido");
        if(locatario.getId()<0){
           throw ex;
       }
       if(locatario.getNome()== null){
           throw ex;
       }
       if(locatario.getNome().length()>255){
           throw ex;
       }
       
       String cpf = locatario.getCpf();
       String regex = "([0-9])+";
       Pattern pattern = Pattern.compile(regex);
       if(cpf!=null){
            Matcher matcher = pattern.matcher(cpf);
            if(!matcher.matches()){
                throw ex;
            }
       }
       String ie = locatario.getInscricaoEstadual();
       if(ie!=null){
            Matcher matcher = pattern.matcher(ie);
            if(!matcher.matches()){
                throw ex;
            }
       }
       String cnpj = locatario.getCnpj();
       if(cnpj!=null){
            Matcher matcher = pattern.matcher(cnpj);
            if(!matcher.matches()){
                throw ex;
            }
       }
       
       if(locatario.getNumero()<=0){
           throw ex;
       }
       
       if(locatario.getDataNascimento()== null){
           throw ex;
       }
       
       if(locatario.getRua() == null){
           throw ex;
       }
       if(locatario.getRua().length()>255){
           throw ex;
       }
       
       if(locatario.getNumero()<0){
           throw ex;
       }
       String cep = locatario.getCep();
       if(cep == null){
           throw ex;
       }
       if(cep.length() == 0){
           throw ex;
       }
       Matcher matcherCep = pattern.matcher(cep);
        if(!matcherCep.matches()){
            throw ex;
        }    
       String bairro = locatario.getBairro();
       if(bairro == null){
           throw ex;
       }
       if(bairro.length() == 0){
           throw ex;
       }
       if(bairro.length() > 255){
           throw ex;
       }
       
       String cidade = locatario.getCidade();
       if(cidade == null){
           throw ex;
       }
       if(cidade.length() == 0){
           throw ex;
       }
       if(cidade.length() > 255){
           throw ex;
       }
       
       if(locatario.getUf() == null){
           throw ex;
       }
       
       if(locatario.getStatus()== null){
           throw ex;
       }
       
       String telefone1 = locatario.getTelefonePrincipal();
       if(telefone1 == null){
           throw ex;
       }
       if(telefone1.length() == 0){
           throw ex;
       }
       Matcher matcherTel1 = pattern.matcher(telefone1);
        if(!matcherTel1.matches()){
            throw ex;
        }  
        
       String telefone2 = locatario.getTelefone2();
       if(telefone2!=null){
            if(telefone2 == null){
                throw ex;
            }
            if(telefone2.length() == 0){
                throw ex;
            }
            Matcher matcherTel2 = pattern.matcher(telefone2);
             if(!matcherTel2.matches()){
                 throw ex;
             }
       }
        String email1 = locatario.getEmailPrincipal();
        
        if(email1 == null){
           throw ex;
        }
        if(email1.length() == 0){
            throw ex;
        }
        String regexEmail = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        Pattern patternEmail = Pattern.compile(regexEmail);
        Matcher matcherEmail1 = patternEmail.matcher(email1);
        if(!matcherEmail1.matches()){
            throw ex;
        }
        
        String email2 = locatario.getEmail2();
        if(email2!=null){
            if(email2 == null){
               throw ex;
            }
            if(email2.length() == 0){
                throw ex;
            }
            Matcher matcherEmail2 = patternEmail.matcher(email2);
            if(!matcherEmail2.matches()){
                throw ex;
            }
        }
    }
    
    public static void validarFuncionario(Funcionario funcionario) throws FuncionarioInvalidoException{
        Excecoes.FuncionarioInvalidoException ex = new Excecoes.FuncionarioInvalidoException("Funcionário Inválido");
        try{
            validarLocatario(funcionario);
        }
        catch(Exception e){
             throw ex;
        }
        if(funcionario.getDataAdmissao() == null){
            throw ex;
        }
       String regex = "([0-9])+";
       Pattern pattern = Pattern.compile(regex);
       String nis = funcionario.getNis();
       if(nis == null){
           throw ex;
       }
       if(nis.length() == 0){
           throw ex;
       }
       Matcher matcherNis = pattern.matcher(nis);
       if(!matcherNis.matches()){
           throw ex;
       }
       if(funcionario.getSalario()<=0){
            throw ex;
       }
       if(funcionario.getSenha() == null){
           throw ex;
       }
       if(funcionario.getSenha().length() == 0){
           throw ex;
       }
    }
    
    public static void validarConcessionaria(Concessionaria concessionaria) throws ConcessionariaInvalidaException{
        Excecoes.ConcessionariaInvalidaException ex = new Excecoes.ConcessionariaInvalidaException("Concessionária Inválida");
        try{
            validarLocatario(concessionaria);
        }
        catch(Exception e){
             throw ex;
        }
        if(concessionaria.getNomeResponsavel() == null){
            throw ex;
        }
        if(concessionaria.getNomeResponsavel().length()==0){
            throw ex;
        }
    }
    
    public static void validarLocatacao(Locacao locacao) throws LocacaoInvalidaException{
        Excecoes.LocacaoInvalidaException ex = new Excecoes.LocacaoInvalidaException("Locação Inválida");
        if(locacao.getId() <0){
            throw ex;
        }
        if(locacao.getLocatario() == null){
           throw ex;
        }
        if(locacao.getFuncionario() == null){
           throw ex;
        }
        if(locacao.getDataLocacao() == null){
           throw ex;
        }
        if(locacao.getDataDevolucao()== null){
           throw ex;
        }
        if(locacao.getStatus()== null){
           throw ex;
        }
        if(locacao.getStatus()!=StatusLocacao.Aberta && locacao.getStatus()!=StatusLocacao.Apagada){
            Set<Pagamento> pagamentos = locacao.getPagamentos();
            if(pagamentos ==null){
               throw ex;
            }
            if(pagamentos.isEmpty()){
                throw ex;
            }
            for(Pagamento pagamento: pagamentos){
                try{
                    validarPagamento(pagamento);
                }
                catch(Exception e){
                    throw ex;
                }
            }
        }
        
        if(locacao.getValorDiaria()<0){
            throw ex;
        }
        
        if(locacao.getTotalLocacao()<0){
            throw ex;
        }
        
        if(locacao.getMultaAtraso()<0){
            throw ex;
        }
    }
    
    public static void validarPagamento(Pagamento pagamento) throws PagamentoInvalidoException{
        Excecoes.PagamentoInvalidoException ex = new Excecoes.PagamentoInvalidoException("Pagamento Inválido");
        if(pagamento.getId()<0){
            throw ex;
        }
        if(pagamento.getFormaPagamento() == null){
            throw ex;
        }
        try{
            validarFormaPagamento(pagamento.getFormaPagamento());
        }
        catch(Exception e){
            throw ex;
        }
        if(pagamento.getReferencia()== null){
            throw ex;
        }
        if(pagamento.getReferencia().length()>255){
            throw ex;
        }
        if(pagamento.getParcela()<=0){
            throw ex;
        }
        if(pagamento.getTotalParcelas()<=0){
            throw ex;
        }
        if(pagamento.getPendente() == null){
            throw ex;
        }
        if(pagamento.getDataPagamento()== null){
            throw ex;
        }
        
    }
    
    public static void validarFormaPagamento(FormaPagamento formaPagamento) throws FormaPagamentoInvalida{
        Excecoes.FormaPagamentoInvalida ex = new Excecoes.FormaPagamentoInvalida("Forma de Pagamento Inválida");
        if(formaPagamento.getNome() == null){
            throw ex;
        }
        if(formaPagamento.getNome().length()>255){
            throw ex;
        }
        if(formaPagamento.getDescricao() == null){
             throw ex;
        }
        if(formaPagamento.getDescricao().length()>255){
             throw ex;
        }
    }
}
