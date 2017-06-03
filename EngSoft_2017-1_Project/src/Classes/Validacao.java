/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Concessionaria;
import Classes.Equipamento;
import Classes.FormaPagamento;
import Classes.Funcionario;
import Classes.Locacao;
import Classes.Locatario;
import Classes.Pagamento;
import Classes.StatusLocacao;
import Classes.TipoLocatario;
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
        String msgErro = "";
       if(equipamneto.getId()<0){
           msgErro +=("Id Inválido\n");
       }
       if(equipamneto.getNome()== null){
           msgErro +=("Nome Inválido\n");
       }else
       if(equipamneto.getNome().length()>255){
           msgErro +=("Nome Inválido\n");
       }
       
       if(equipamneto.getDescricao()==null){
           msgErro +=("Descrição Inválida\n");
       }
       
       if(equipamneto.getFabricante()==null){
           msgErro +=("Fabricante Inválida\n");
       }else
       if(equipamneto.getFabricante().length()>255){    
       
           msgErro +=("Fabricante Inválida\n");
       
       }
       
       if(equipamneto.getValorDiaria()<=0){
           msgErro +=("Valor de diária Inválido\n");
       }
       if(equipamneto.getValorPatrimonio()<=0){
           msgErro +=("Valor de Patrimonio Inválido\n");
       }
       if(equipamneto.getStatus()==null){
           msgErro +=("Status Inválido\n");
       }
       if(equipamneto.getDataCompra() == null){
           msgErro +=("Data da Compra Inválida\n");
       }
       if(equipamneto.getValidade()== null){
          msgErro +=("Data da Validade Inválida\n");
       }
       if(equipamneto.getProximaRevisao()== null){
           msgErro +=("Data de próxima revisão Inválida\n");
       }
      if(!msgErro.isEmpty()){
          throw new EquipamentoInvalidoException(msgErro);
      }
    }
    
    public static void validarLocatario(Locatario locatario) throws LocatarioInvalidoException{
         String msgErro = "";
        if(locatario.getId()<0){
          msgErro += ("Id inválido\n");
       }
        if(locatario.getTipo() == null){
          msgErro += ("Tipo de Pessoa inválido\n");
       }else{
            if(locatario.getTipo() == TipoLocatario.JURIDICA){
                if(locatario.getRazaoSocial() == null){
                     msgErro += ("Razão Social Inválida\n");
                }else{
                    if(locatario.getRazaoSocial().length() == 0){
                        msgErro += ("Razão Social Inválida\n");
                    }
                    else
                      if(locatario.getRazaoSocial().length() > 255){
                        msgErro += ("Razão Social Inválida\n");
                    }  
                    
                }
            }
        }
       if(locatario.getNome()== null){
           msgErro += ("Nome inválido\n");
       }
       if(locatario.getNome().length()>255){
          msgErro += ("Nome inválido\n");
       }
       
       String regex = "([0-9])+";
       Pattern pattern = Pattern.compile(regex);
       
        msgErro = validarDadosFiscais(locatario, pattern, msgErro);
       
        msgErro = validarEndereco(locatario, msgErro, pattern);
       
       if(locatario.getStatus()== null){
           msgErro += ("Status inválido\n");
       }
       
        msgErro = validarInfoContato(locatario, msgErro, pattern);
        if(!msgErro.isEmpty()){
            throw new Excecoes.LocatarioInvalidoException(msgErro);
        }
    }

    public static String validarDadosFiscais(Locatario locatario, Pattern pattern, String msgErro) {
        String cpf = locatario.getCpf();
        if(cpf!=null){
            Matcher matcher = pattern.matcher(cpf);
            if(!matcher.matches()){
                msgErro += ("CPF inválido\n");
            }
        }String ie = locatario.getInscricaoEstadual();
        if(ie!=null){
            Matcher matcher = pattern.matcher(ie);
            if(!matcher.matches()){
                msgErro += ("IE inválida\n");
            }
        }String cnpj = locatario.getCnpj();
        if(cnpj!=null){
            Matcher matcher = pattern.matcher(cnpj);
            if(!matcher.matches()){
                msgErro += ("CNPJ inválido\n");
            }
        }return msgErro;
    }

    public static String validarEndereco(Locatario locatario, String msgErro, Pattern pattern) {
        if(locatario.getDataNascimento()== null){
            msgErro += ("Data de nascimento inválida\n");
        }if(locatario.getNumero()<=0){
            msgErro += ("Número inválido\n");
        }if(locatario.getRua() == null){
            msgErro += ("Rua inválida\n");
        }if(locatario.getRua().length()>255){
            msgErro += ("Rua inválida\n");
        }String cep = locatario.getCep();
        if(cep == null){
            msgErro += ("Cep inválido\n");
        }else{
            if(cep.length() == 0){
                msgErro += ("Cep inválido\n");
            }
            Matcher matcherCep = pattern.matcher(cep);
            if(!matcherCep.matches()){
                msgErro += ("Cep inválido\n");
            }
        }String bairro = locatario.getBairro();
        if(bairro == null){
            msgErro += ("Bairro inválido\n");
        }else{
            if(bairro.length() == 0){
                msgErro += ("Bairro inválido\n");
            }
            if(bairro.length() > 255){
                msgErro += ("Bairro inválido\n");
            }
        }String cidade = locatario.getCidade();
        if(cidade == null){
            msgErro += ("Cidade inválida\n");
        }else{
            if(cidade.length() == 0){
                msgErro += ("Cidade inválida\n");
            }
            if(cidade.length() > 255){
                msgErro += ("Cidade inválida\n");
            }
        }if(locatario.getUf() == null){
            msgErro += ("UF inválida\n");
        }return msgErro;
    }

    public static String validarInfoContato(Locatario locatario, String msgErro, Pattern pattern) {
        String telefone1 = locatario.getTelefonePrincipal();
        if(telefone1 == null){
            msgErro += ("Telefone1 inválido\n");
        }else{
            if(telefone1.length() == 0){
                msgErro += ("Telefone1 inválido\n");
            }
            Matcher matcherTel1 = pattern.matcher(telefone1);
            if(!matcherTel1.matches()){
                msgErro += ("Telefone1 inválido\n");
            }
        }String telefone2 = locatario.getTelefone2();
        if(telefone2 == null){
            msgErro += ("Telefone2 inválido\n");
        }
        else
        {
            if(telefone2.length() == 0){
                msgErro += ("Telefone2 inválido\n");
            }
            Matcher matcherTel2 = pattern.matcher(telefone2);
            if(!matcherTel2.matches()){
                msgErro += ("Telefone2 inválido\n");
            }
        }
        
        msgErro = validarEmail(locatario, msgErro);
        return msgErro;
    }

    public static String validarEmail(Locatario locatario, String msgErro) {
        String email1 = locatario.getEmailPrincipal();
        String regexEmail = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        Pattern patternEmail = Pattern.compile(regexEmail);
        if(email1 == null){
            msgErro += ("Email1 inválido\n");
        }else{
            if(email1.length() == 0){
                msgErro += ("Email1 inválido\n");
            }
            Matcher matcherEmail1 = patternEmail.matcher(email1);
            if(!matcherEmail1.matches()){
                msgErro += ("Email1 inválido\n");
            }
        }
        String email2 = locatario.getEmail2();
        if(email2 == null){
            msgErro += ("Email2 inválido\n");
        }
        else{
            
            if(email2.length() == 0){
                msgErro += ("Email2 inválido\n");
            }
            Matcher matcherEmail2 = patternEmail.matcher(email2);
            if(!matcherEmail2.matches()){
                msgErro += ("Email2 inválido\n");
            }
        }
        return msgErro;
    }
    
    public static void validarFuncionario(Funcionario funcionario) throws FuncionarioInvalidoException{
        String msgErro = "";
        try{
            validarLocatario(funcionario);
        }
        catch(Exception e){
            msgErro +=(e.getMessage())+"\n";
        }
        if(funcionario.getDataAdmissao() == null){
           msgErro +=("Data de admissão inválida\n");
        }
       String regex = "([0-9])+";
       Pattern pattern = Pattern.compile(regex);
       String nis = funcionario.getNis();
       if(nis == null){
           msgErro +=("NIS inválido\n");
       }else{
            if(nis.length() == 0){
                msgErro +=("NIS inválido\n");
            }
            Matcher matcherNis = pattern.matcher(nis);
            if(!matcherNis.matches()){
                 msgErro +=("NIS inválido\n");
            }
       }
       
       if(funcionario.getSalario()<=0){
            msgErro +=("Salário inválido\n");
       }
       if(funcionario.getSenha() == null){
            msgErro +=("Senha Inválida\n");
       }else
       if(funcionario.getSenha().length() == 0){
           msgErro +=("Senha Inválida\n");
       }
       
       if(!msgErro.isEmpty()){
           throw new Excecoes.FuncionarioInvalidoException(msgErro);
       }
    }
    
    public static void validarConcessionaria(Concessionaria concessionaria) throws ConcessionariaInvalidaException{
        String msgErro = "";
        try{
            validarLocatario(concessionaria);
        }
        catch(Exception e){
             msgErro+=(e.getMessage())+"\n";
        }
        if(concessionaria.getNomeResponsavel() == null){
             msgErro+=("Nome do Resposável Inválido [t : null]\n");
        }else{
            if(concessionaria.getNomeResponsavel().length()==0){
                msgErro+=("Nome do Resposável Inválido [t: 0]\n");
            }else
            if(concessionaria.getNomeResponsavel().length()>255){
                msgErro+=("Nome do Resposável Inválido [t > 255]\n");
            }
        }
        
        if(concessionaria.getRazaoSocial()== null){
            msgErro+=("Razao Social Inválida [t : null]\n");
        }else{
            if(concessionaria.getRazaoSocial().length()==0){
                msgErro+=("Razao Social Inválida [t: 0]\n");
            }else
            if(concessionaria.getRazaoSocial().length()>255){
                msgErro+=("Razao Social Inválida [t > 255]\n");
            }
        }
        if(!msgErro.isEmpty()){
            throw new Excecoes.ConcessionariaInvalidaException(msgErro);
        }
    }
    
    public static void validarLocacao(Locacao locacao) throws LocacaoInvalidaException{
        String msgErro = "";
        
        if(locacao.getId() <0){
            msgErro += "id invalido";
        }
        if(locacao.getLocatario() == null){
           msgErro += "Locatario Obrigatório para locação";
        }
        if(locacao.getFuncionario() == null){
            msgErro += "Funcionario Obrigatório para locação";
        }
        if(locacao.getDataLocacao() == null){
           msgErro += "Data de Locação Obrigatória para locação";
        }
        if(locacao.getDataDevolucao()== null){
            msgErro += "Data de Devolução Obrigatória para locação";
        }
        if(locacao.getStatus()== null){
           msgErro += "Status Obrigatório para locação";
        }
        
        Set<Pagamento> pagamentos = locacao.getPagamentos();
        if((pagamentos ==null || pagamentos.isEmpty())  && locacao.getStatus()!=StatusLocacao.Aberta){
           msgErro += "É obrigatorio pagamentos para autorizar a locação";
        }else
        for(Pagamento pagamento: pagamentos){
            try{
                validarPagamento(pagamento);
            }
            catch(Exception e){
                msgErro += e.getMessage();
            }
        }
        
        
        if(locacao.getValorDiaria()<0){
            msgErro += "Valor de diária inválido";
        }
        
        if(locacao.getTotalLocacao()<0){
            msgErro += "Total da Locação inválido";
        }
        
        if(locacao.getMultaAtraso()<0){
            msgErro += "Multa de Atraso inválida";
        }
        if(!msgErro.isEmpty()){
            throw new Excecoes.LocacaoInvalidaException(msgErro);
        }
    }
    
    public static void validarPagamento(Pagamento pagamento) throws PagamentoInvalidoException{
        
        if(pagamento.getId()<0){
            throw new Excecoes.PagamentoInvalidoException("id de pagamento inválido");
        }
        if(pagamento.getFormaPagamento() == null){
            throw new Excecoes.PagamentoInvalidoException("Forma de Pagamento Inválido");
        }
        try{
            validarFormaPagamento(pagamento.getFormaPagamento());
        }
        catch(Exception e){
            throw new Excecoes.PagamentoInvalidoException(e.getMessage());
        }
        if(pagamento.getReferencia()== null || pagamento.getReferencia().length()>255){
            throw new Excecoes.PagamentoInvalidoException("Referência de Pagamento Inválida");
        }
        if(pagamento.getParcela()<=0){
            throw new Excecoes.PagamentoInvalidoException("Nº de parcelas inválido");
        }
        if(pagamento.getTotalParcelas()<=0){
            throw new Excecoes.PagamentoInvalidoException("Nº total de parcelas inválido");
        }
        if(pagamento.getPendente() == null){
            throw new Excecoes.PagamentoInvalidoException("Estado do pagamento inválido");
        }
        if(pagamento.getDataPagamento()== null){
            throw new Excecoes.PagamentoInvalidoException("Data de pagamento inválida");
        }
        
    }
    
    public static void validarFormaPagamento(FormaPagamento formaPagamento) throws FormaPagamentoInvalida{
        
        if(formaPagamento.getNome() == null){
            throw new Excecoes.FormaPagamentoInvalida("Nome da Forma de Pagamento Inválido");
        }
        if(formaPagamento.getNome().length()>255){
            throw new Excecoes.FormaPagamentoInvalida("Nome da Forma de Pagamento Inválido");
        }
        if(formaPagamento.getDescricao() == null){
             throw new Excecoes.FormaPagamentoInvalida("Descrição da Forma de Pagamento Inválida");
        }
        if(formaPagamento.getDescricao().length()>255){
              throw new Excecoes.FormaPagamentoInvalida("Descrição da Forma de Pagamento Inválida");
        }
    }
}
