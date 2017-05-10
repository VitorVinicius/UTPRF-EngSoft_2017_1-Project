/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Database.Persistencia;
import GUI.Main;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vitor
 */
public class TestesTest {

    private static Locatario locatarioCadastrado;
    private static Locatario locatarioComPendenciasCadastrado;
    private static FormaPagamento formaPagamentoCadastrada;
    Locatario locatarioTesteOK;
    Locatario locatarioTesteNOTOK;
    
    private static Concessionaria concessionariaCadastrada;
    private static Equipamento equipamnetoCadastrado;
    private static Equipamento equipamnetoCadastrado2;
    
    private Funcionario funcionarioTesteOK;
    private Funcionario funcionarioTesteNOTOK;
    private Equipamento equipamentoTesteNOTOK;
    private Concessionaria concessionariaTesteOK;
    private Equipamento equipamentoTesteOK;
    private Concessionaria concessionariaTesteNOTOK;
    private FormaPagamento formaPagamentoTesteOK;
    private FormaPagamento formaPagamentoTesteNOTOK;
    private Locacao locacaoReservaTesteOK;
    private Locacao locacaoReservaTesteNOTOK;
    private Locacao locacaoTesteOK;
    private Locacao locacaoTesteNOTOK;
    
    
    public TestesTest(){
       
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        Persistencia.estabelecerConexao();
        //carrega um funcionario do banco para realizar os testes
        {
            Query query = Persistencia.getManager().createQuery("select t from Funcionario as t where t.status <> ?");
            query.setParameter(1, StatusLocatario.Apagado);
            query.setMaxResults(1);
            List<Object> resultado = Persistencia.buscar(query);
            if(resultado!=null && !resultado.isEmpty()){
                Main.setFuncionario((Funcionario)resultado.get(0));
            }
            else{
                throw new Exception("Cadastre um funcionario antes de inicar os testes com JUnit");
            }
        }
        //carrega uma concessionaria do banco para realizar os testes
        {
            Query query = Persistencia.getManager().createQuery("select t from Concessionaria as t where t.status <> ?");
            query.setParameter(1, StatusLocatario.Apagado);
            query.setMaxResults(1);
            List<Object> resultado = Persistencia.buscar(query);
            if(resultado!=null && !resultado.isEmpty()){
                concessionariaCadastrada = ((Concessionaria)resultado.get(0));
            }
            else{
                throw new Exception("Cadastre uma concessionaria antes de inicar os testes com JUnit");
            }
        }
        //carrega um equipamento do banco para realizar os testes
        {
            Query query = Persistencia.getManager().createQuery("select t from Equipamento as t where t.status = ?");
            query.setParameter(1, StatusEquipamento.Disponivel);
            query.setMaxResults(2);
            List<Object> resultado = Persistencia.buscar(query);
            if(resultado!=null && !resultado.isEmpty()){
                equipamnetoCadastrado = ((Equipamento)resultado.get(0));
                equipamnetoCadastrado2 = ((Equipamento)resultado.get(1));
            }
            else{
                throw new Exception("Cadastre um equipamento antes de inicar os testes com JUnit");
            }
        }
        
        
        //carrega uma Formaagamento do banco para realizar os testes
        {
            Query query = Persistencia.getManager().createQuery("select t from FormaPagamento as t where t.apagado = ?");
            query.setParameter(1, false);
            query.setMaxResults(1);
            List<Object> resultado = Persistencia.buscar(query);
            if(resultado!=null && !resultado.isEmpty()){
                formaPagamentoCadastrada = ((FormaPagamento)resultado.get(0));
            }
            else{
                throw new Exception("Cadastre uma forma de pagamento antes de inicar os testes com JUnit");
            }
        }
    }
    
    
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        //carrega um Locatario do banco para realizar os testes
        {
            Query query = Persistencia.getManager().createQuery("select t from Locatario as t  where t.status <> ?");
            query.setParameter(1, StatusLocatario.Apagado);
            query.setMaxResults(1000);
            List<Object> resultado = Persistencia.buscar(query);
            if(resultado!=null && !resultado.isEmpty()){
                for(Object loc: resultado){
                    Locatario locatario = (Locatario)loc;
                    if(locatario.getLocacoesAtrasadas().isEmpty()){
                        locatarioCadastrado = locatario;
                        break;
                    }else if(locatarioComPendenciasCadastrado==null){
                        locatarioComPendenciasCadastrado = locatario;
                    }
                }
            }
            else{
                throw new Exception("Cadastre um locatario antes de inicar os testes com JUnit");
            }
        }
          // Cadastro de Locátario correto
        locatarioTesteOK = new Locatario();
            locatarioTesteOK.setNome("Funcionário de teste correto");
            locatarioTesteOK.setTipo(TipoLocatario.FISICA);
            locatarioTesteOK.setCpf("12345678900");
            locatarioTesteOK.setInscricaoEstadual("123456789");
            locatarioTesteOK.setCnpj("123456789000123");
            locatarioTesteOK.setDataNascimento(new Date());
            locatarioTesteOK.setRua("Avenida de teste");
            locatarioTesteOK.setNumero(123);
            locatarioTesteOK.setCep("12345000");
            locatarioTesteOK.setBairro("Bairro de teste");
            locatarioTesteOK.setCidade("Cidade de teste");
            locatarioTesteOK.setUf("UF");
            locatarioTesteOK.setStatus(StatusLocatario.Normal);
            locatarioTesteOK.setTelefonePrincipal("12912345678");
            locatarioTesteOK.setTelefone2("12912345678");
            locatarioTesteOK.setEmailPrincipal("teste1.teste@teste.com");
            locatarioTesteOK.setEmail2("teste2.teste@teste.com");
        // --------------------------------------------- //
        // Cadastro de Locátario incorreto
        locatarioTesteNOTOK = new Locatario();
            locatarioTesteNOTOK.setNome(null);
            locatarioTesteNOTOK.setCpf(null);
            locatarioTesteNOTOK.setTipo(TipoLocatario.JURIDICA);
            locatarioTesteNOTOK.setInscricaoEstadual(null);
            locatarioTesteNOTOK.setCnpj(null);
            locatarioTesteNOTOK.setDataNascimento(null);
            locatarioTesteNOTOK.setRua(null);
            locatarioTesteNOTOK.setNumero(-1);
            locatarioTesteNOTOK.setCep(null);
            locatarioTesteNOTOK.setBairro(null);
            locatarioTesteNOTOK.setCidade(null);
            locatarioTesteNOTOK.setUf(null);
            locatarioTesteNOTOK.setStatus(null);
            locatarioTesteNOTOK.setTelefonePrincipal(null);
            locatarioTesteNOTOK.setTelefone2(null);
            locatarioTesteNOTOK.setEmailPrincipal(null);
            locatarioTesteNOTOK.setEmail2(null);
            locatarioTesteNOTOK.setPagamentos(null);
            locatarioTesteNOTOK.setId(0);
            locatarioTesteNOTOK.setHistoricos(locatarioTesteNOTOK.getHistoricos());
            String st = locatarioTesteNOTOK.toString();
        // --------------------------------------------- //
        
        
        
        // Cadastro de Funcionario correto
            funcionarioTesteOK = new Funcionario();
            funcionarioTesteOK.setNome("Funcionário de teste correto cadastrado");
            funcionarioTesteOK.setCpf("12345678900");
            funcionarioTesteOK.setInscricaoEstadual("123456789");
            funcionarioTesteOK.setCnpj("123456789000123");
            funcionarioTesteOK.setDataNascimento(new Date());
            funcionarioTesteOK.setRua("Avenida de teste");
            funcionarioTesteOK.setNumero(123);
            funcionarioTesteOK.setCep("12345000");
            funcionarioTesteOK.setBairro("Bairro de teste");
            funcionarioTesteOK.setCidade("Cidade de teste");
            funcionarioTesteOK.setUf("UF");
            funcionarioTesteOK.setStatus(StatusLocatario.Normal);
            funcionarioTesteOK.setTelefonePrincipal("12912345678");
            funcionarioTesteOK.setTelefone2("12912345678");
            funcionarioTesteOK.setEmailPrincipal("teste1.teste@teste.com");
            funcionarioTesteOK.setEmail2("teste2.teste@teste.com");
            funcionarioTesteOK.setNis("12345678901");
            funcionarioTesteOK.setDataAdmissao(new Date());
            funcionarioTesteOK.setSalario(1200);
            funcionarioTesteOK.setSenha("sdff");
        // --------------------------------------------- //
        
        // Cadastro de Funcionario incorreto
            funcionarioTesteNOTOK = new Funcionario();
            funcionarioTesteNOTOK.setNome("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur massa neque, dictum id ante blandit, placerat faucibus lorem. Pellentesque sagittis lacus turpis, id elementum turpis semper et. Vivamus sodales elementum quam, ac vulputate quam bibendum finibus. Praesent luctus libero erat, nec consectetur leo ullamcorper sit amet. Aliquam erat volutpat. Proin nisi ante, egestas sit amet facilisis ac, vestibulum a nisi. In hac habitasse platea dictumst. Praesent vel mauris malesuada, efficitur nibh ut, varius mauris. Aenean egestas eget diam a consequat. Proin eget ultrices lorem. Aliquam varius lacus neque, sed hendrerit risus hendrerit non. Nunc sit amet quam in libero condimentum");
            funcionarioTesteNOTOK.setCpf(null);
            funcionarioTesteNOTOK.setInscricaoEstadual(null);
            funcionarioTesteNOTOK.setCnpj(null);
            funcionarioTesteNOTOK.setDataNascimento(null);
            funcionarioTesteNOTOK.setRua(null);
            funcionarioTesteNOTOK.setNumero(-1);
            funcionarioTesteNOTOK.setCep(null);
            funcionarioTesteNOTOK.setBairro(null);
            funcionarioTesteNOTOK.setCidade(null);
            funcionarioTesteNOTOK.setUf(null);
            funcionarioTesteNOTOK.setStatus(null);
            funcionarioTesteNOTOK.setTelefonePrincipal(null);
            funcionarioTesteNOTOK.setTelefone2(null);
            funcionarioTesteNOTOK.setEmailPrincipal(null);
            funcionarioTesteNOTOK.setEmail2(null);
            funcionarioTesteNOTOK.setNis(null);
            funcionarioTesteNOTOK.setDataAdmissao(null);
            funcionarioTesteNOTOK.setSalario(-1200);
            funcionarioTesteNOTOK.setSenha(null);
        // --------------------------------------------- //
        
        // Cadastro de Concessionaria correto
            concessionariaTesteOK = new Concessionaria();
            concessionariaTesteOK.setNome("concessionaria de teste correto" );
            concessionariaTesteOK.setCpf("12345678900");
            concessionariaTesteOK.setInscricaoEstadual("123456789");
            concessionariaTesteOK.setCnpj("123456789000123");
            concessionariaTesteOK.setDataNascimento(new Date());
            concessionariaTesteOK.setRua("Avenida de teste");
            concessionariaTesteOK.setNumero(123);
            concessionariaTesteOK.setCep("12345000");
            concessionariaTesteOK.setBairro("Bairro de teste");
            concessionariaTesteOK.setCidade("Cidade de teste");
            concessionariaTesteOK.setUf("UF");
            concessionariaTesteOK.setStatus(StatusLocatario.Normal);
            concessionariaTesteOK.setTelefonePrincipal("12912345678");
            concessionariaTesteOK.setTelefone2("12912345678");
            concessionariaTesteOK.setEmailPrincipal("teste1.teste@teste.com");
            concessionariaTesteOK.setEmail2("teste2.teste@teste.com");
            concessionariaTesteOK.setNomeResponsavel("Diego alguma coisa");
            concessionariaTesteOK.setRazaoSocial("Muito Boa S/A");
            concessionariaTesteOK.setTipo(TipoLocatario.CONCESSIONARIA);
        // --------------------------------------------- //
        
        // Cadastro de Concessionaria incorreto
            concessionariaTesteNOTOK = new Concessionaria();
            concessionariaTesteNOTOK.setNome("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur massa neque, dictum id ante blandit, placerat faucibus lorem. Pellentesque sagittis lacus turpis, id elementum turpis semper et. Vivamus sodales elementum quam, ac vulputate quam bibendum finibus. Praesent luctus libero erat, nec consectetur leo ullamcorper sit amet. Aliquam erat volutpat. Proin nisi ante, egestas sit amet facilisis ac, vestibulum a nisi. In hac habitasse platea dictumst. Praesent vel mauris malesuada, efficitur nibh ut, varius mauris. Aenean egestas eget diam a consequat. Proin eget ultrices lorem. Aliquam varius lacus neque, sed hendrerit risus hendrerit non. Nunc sit amet quam in libero condimentum");
            concessionariaTesteNOTOK.setCpf("12345678900");
            concessionariaTesteNOTOK.setInscricaoEstadual("123456789");
            concessionariaTesteNOTOK.setCnpj("");
            concessionariaTesteNOTOK.setDataNascimento(null);
            concessionariaTesteNOTOK.setRua("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur massa neque, dictum id ante blandit, placerat faucibus lorem. Pellentesque sagittis lacus turpis, id elementum turpis semper et. Vivamus sodales elementum quam, ac vulputate quam bibendum finibus. Praesent luctus libero erat, nec consectetur leo ullamcorper sit amet. Aliquam erat volutpat. Proin nisi ante, egestas sit amet facilisis ac, vestibulum a nisi. In hac habitasse platea dictumst. Praesent vel mauris malesuada, efficitur nibh ut, varius mauris. Aenean egestas eget diam a consequat. Proin eget ultrices lorem. Aliquam varius lacus neque, sed hendrerit risus hendrerit non. Nunc sit amet quam in libero condimentum");
            concessionariaTesteNOTOK.setNumero(123);
            concessionariaTesteNOTOK.setCep("12345000");
            concessionariaTesteNOTOK.setBairro("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur massa neque, dictum id ante blandit, placerat faucibus lorem. Pellentesque sagittis lacus turpis, id elementum turpis semper et. Vivamus sodales elementum quam, ac vulputate quam bibendum finibus. Praesent luctus libero erat, nec consectetur leo ullamcorper sit amet. Aliquam erat volutpat. Proin nisi ante, egestas sit amet facilisis ac, vestibulum a nisi. In hac habitasse platea dictumst. Praesent vel mauris malesuada, efficitur nibh ut, varius mauris. Aenean egestas eget diam a consequat. Proin eget ultrices lorem. Aliquam varius lacus neque, sed hendrerit risus hendrerit non. Nunc sit amet quam in libero condimentum");
            concessionariaTesteNOTOK.setCidade("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur massa neque, dictum id ante blandit, placerat faucibus lorem. Pellentesque sagittis lacus turpis, id elementum turpis semper et. Vivamus sodales elementum quam, ac vulputate quam bibendum finibus. Praesent luctus libero erat, nec consectetur leo ullamcorper sit amet. Aliquam erat volutpat. Proin nisi ante, egestas sit amet facilisis ac, vestibulum a nisi. In hac habitasse platea dictumst. Praesent vel mauris malesuada, efficitur nibh ut, varius mauris. Aenean egestas eget diam a consequat. Proin eget ultrices lorem. Aliquam varius lacus neque, sed hendrerit risus hendrerit non. Nunc sit amet quam in libero condimentum");
            concessionariaTesteNOTOK.setUf("UF");
            concessionariaTesteNOTOK.setStatus(StatusLocatario.Normal);
            concessionariaTesteNOTOK.setTelefonePrincipal("12912345678");
            concessionariaTesteNOTOK.setTelefone2("12912345678");
            concessionariaTesteNOTOK.setEmailPrincipal("teste1.testeteste.com");
            concessionariaTesteNOTOK.setEmail2("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur massa neque, dictum id ante blandit, placerat faucibus lorem. Pellentesque sagittis lacus turpis, id elementum turpis semper et. Vivamus sodales elementum quam, ac vulputate quam bibendum finibus. Praesent luctus libero erat, nec consectetur leo ullamcorper sit amet. Aliquam erat volutpat. Proin nisi ante, egestas sit amet facilisis ac, vestibulum a nisi. In hac habitasse platea dictumst. Praesent vel mauris malesuada, efficitur nibh ut, varius mauris. Aenean egestas eget diam a consequat. Proin eget ultrices lorem. Aliquam varius lacus neque, sed hendrerit risus hendrerit non. Nunc sit amet quam in libero condimentum");
            concessionariaTesteNOTOK.setNomeResponsavel("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur massa neque, dictum id ante blandit, placerat faucibus lorem. Pellentesque sagittis lacus turpis, id elementum turpis semper et. Vivamus sodales elementum quam, ac vulputate quam bibendum finibus. Praesent luctus libero erat, nec consectetur leo ullamcorper sit amet. Aliquam erat volutpat. Proin nisi ante, egestas sit amet facilisis ac, vestibulum a nisi. In hac habitasse platea dictumst. Praesent vel mauris malesuada, efficitur nibh ut, varius mauris. Aenean egestas eget diam a consequat. Proin eget ultrices lorem. Aliquam varius lacus neque, sed hendrerit risus hendrerit non. Nunc sit amet quam in libero condimentum");
        // --------------------------------------------- //
        
       // Cadastro de Equipamento correto
            equipamentoTesteOK = new Equipamento();
            equipamentoTesteOK.setNome("Máquina Agrícola de Teste");
            equipamentoTesteOK.setDataCompra(new Date());
            equipamentoTesteOK.setCategoria("Máquinas");
            equipamentoTesteOK.setConcessionaria(concessionariaCadastrada);
            equipamentoTesteOK.setDataCompra(new Date());
            equipamentoTesteOK.setDescricao("Maquina de fazer alguma coisa");
            equipamentoTesteOK.setFabricante("UmmaAi inc");
            equipamentoTesteOK.setFuncionario(Main.getFuncionario());
            equipamentoTesteOK.setImagemBase64(null);
            equipamentoTesteOK.setProximaRevisao(new Date());
            equipamentoTesteOK.setSerie("2345234");
            equipamentoTesteOK.setStatus(StatusEquipamento.Disponivel);
            equipamentoTesteOK.setValidade(new Date());
            equipamentoTesteOK.setValorDiaria(100);
            equipamentoTesteOK.setValorPatrimonio(1000);
            
        // --------------------------------------------- //
        
        // Cadastro de Equipamento incorreto
            equipamentoTesteNOTOK = new Equipamento();
            equipamentoTesteNOTOK.setNome("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur massa neque, dictum id ante blandit, placerat faucibus lorem. Pellentesque sagittis lacus turpis, id elementum turpis semper et. Vivamus sodales elementum quam, ac vulputate quam bibendum finibus. Praesent luctus libero erat, nec consectetur leo ullamcorper sit amet. Aliquam erat volutpat. Proin nisi ante, egestas sit amet facilisis ac, vestibulum a nisi. In hac habitasse platea dictumst. Praesent vel mauris malesuada, efficitur nibh ut, varius mauris. Aenean egestas eget diam a consequat. Proin eget ultrices lorem. Aliquam varius lacus neque, sed hendrerit risus hendrerit non. Nunc sit amet quam in libero condimentum");
            equipamentoTesteNOTOK.setDataCompra(null);
            equipamentoTesteNOTOK.setCategoria("Máquinas");
            equipamentoTesteNOTOK.setConcessionaria(null);
            equipamentoTesteNOTOK.setDataCompra(new Date());
            equipamentoTesteNOTOK.setDescricao("Maquina de fazer alguma coisa");
            equipamentoTesteNOTOK.setFabricante("UmmaAi inc");
            equipamentoTesteNOTOK.setFuncionario(funcionarioTesteOK);
            equipamentoTesteNOTOK.setImagemBase64(null);
            equipamentoTesteNOTOK.setProximaRevisao(new Date());
            equipamentoTesteNOTOK.setSerie("2345234");
            equipamentoTesteNOTOK.setStatus(StatusEquipamento.Disponivel);
            equipamentoTesteNOTOK.setValidade(new Date());
            equipamentoTesteNOTOK.setValorDiaria(100);
            equipamentoTesteNOTOK.setValorPatrimonio(1000);
            
        // --------------------------------------------- //
        
        // Cadastro de Forma de Pagamento correto
            formaPagamentoTesteOK = new FormaPagamento();
            formaPagamentoTesteOK.setAtiva(true);
            formaPagamentoTesteOK.setDescricao("A vista no dinheiro");
            formaPagamentoTesteOK.setNome("A vista");
        // --------------------------------------------- //
         // Cadastro de Forma de Pagamento correto
            formaPagamentoTesteNOTOK = new FormaPagamento();
            formaPagamentoTesteNOTOK.setAtiva(true);
            formaPagamentoTesteNOTOK.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur massa neque, dictum id ante blandit, placerat faucibus lorem. Pellentesque sagittis lacus turpis, id elementum turpis semper et. Vivamus sodales elementum quam, ac vulputate quam bibendum finibus. Praesent luctus libero erat, nec consectetur leo ullamcorper sit amet. Aliquam erat volutpat. Proin nisi ante, egestas sit amet facilisis ac, vestibulum a nisi. In hac habitasse platea dictumst. Praesent vel mauris malesuada, efficitur nibh ut, varius mauris. Aenean egestas eget diam a consequat. Proin eget ultrices lorem. Aliquam varius lacus neque, sed hendrerit risus hendrerit non. Nunc sit amet quam in libero condimentum");
            formaPagamentoTesteNOTOK.setNome(null);
        // --------------------------------------------- //
        {
            // Cadastro de Locacao Reserva correto
                locacaoReservaTesteOK = new Locacao();
                locacaoReservaTesteOK.setFuncionario(Main.getFuncionario());
                 String data = "05/05/2030";
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date1 = format.parse(data);
                locacaoReservaTesteOK.setDataDevolucao(date1);
                locacaoReservaTesteOK.setDataLocacao(new Date());
                locacaoReservaTesteOK.setEquipamento(equipamnetoCadastrado);
                locacaoReservaTesteOK.setId(0);
                locacaoReservaTesteOK.setLocatario(locatarioCadastrado);
                locacaoReservaTesteOK.setMultaAtraso(0);
                locacaoReservaTesteOK.setStatus(StatusLocacao.Aberta);
                locacaoReservaTesteOK.setTotalLocacao(equipamnetoCadastrado.getValorDiaria());
                locacaoReservaTesteOK.setValorDiaria(equipamnetoCadastrado.getValorDiaria());
                Pagamento pagamento = new Pagamento();
                pagamento.setDataPagamento(new Date());
                pagamento.setFormaPagamento(formaPagamentoCadastrada);
                pagamento.setReferencia("Locação de equipamento");
                pagamento.setPendente(false);
                pagamento.setParcela(1);
                pagamento.setTotalParcelas(1);
                pagamento.setValor(locacaoReservaTesteOK.getTotalLocacao());
                locacaoReservaTesteOK.getPagamentos().add(pagamento);

            // --------------------------------------------- //

            // Cadastro de Locacao Reserva incorreto
                locacaoReservaTesteNOTOK = new Locacao();
                locacaoReservaTesteNOTOK.setFuncionario(Main.getFuncionario());
                locacaoReservaTesteNOTOK.setDataDevolucao(new Date());
                locacaoReservaTesteNOTOK.setDataLocacao(new Date());
                locacaoReservaTesteNOTOK.setEquipamento(null);
                locacaoReservaTesteNOTOK.setId(0);
                locacaoReservaTesteNOTOK.setLocatario(locatarioCadastrado);
                locacaoReservaTesteNOTOK.setMultaAtraso(0);
                locacaoReservaTesteNOTOK.setStatus(StatusLocacao.Aberta);
                locacaoReservaTesteNOTOK.setTotalLocacao(equipamnetoCadastrado.getValorDiaria());
                locacaoReservaTesteNOTOK.setValorDiaria(equipamnetoCadastrado.getValorDiaria());

            // --------------------------------------------- //
        }
        // Cadastro de Locacao Reserva correto
            locacaoTesteOK = new Locacao();
            locacaoTesteOK.setFuncionario(Main.getFuncionario());
            String data = "05/05/2030";
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date1 = format.parse(data);
                locacaoReservaTesteOK.setDataDevolucao(date1);
            locacaoTesteOK.setDataDevolucao(date1);
            locacaoTesteOK.setDataLocacao(new Date());
            locacaoTesteOK.setEquipamento(equipamnetoCadastrado2);
            locacaoTesteOK.setId(0);
            locacaoTesteOK.setLocatario(locatarioCadastrado);
            locacaoTesteOK.setMultaAtraso(0);
            locacaoTesteOK.setStatus(StatusLocacao.Aberta);
            locacaoTesteOK.setTotalLocacao(equipamnetoCadastrado2.getValorDiaria());
            locacaoTesteOK.setValorDiaria(equipamnetoCadastrado2.getValorDiaria());
            Pagamento pagamento = new Pagamento();
            pagamento.setDataPagamento(new Date());
            pagamento.setFormaPagamento(formaPagamentoCadastrada);
            pagamento.setPendente(false);
            pagamento.setParcela(1);
            pagamento.setTotalParcelas(1);
            pagamento.setValor(locacaoTesteOK.getTotalLocacao());
            locacaoTesteOK.getPagamentos().add(pagamento);
            
        // --------------------------------------------- //
        
        // Cadastro de Locacao Reserva incorreto
            locacaoTesteNOTOK = new Locacao();
            locacaoTesteNOTOK.setFuncionario(Main.getFuncionario());
            locacaoTesteNOTOK.setDataDevolucao(new Date());
            locacaoTesteNOTOK.setDataLocacao(new Date());
            locacaoTesteNOTOK.setEquipamento(null);
            locacaoTesteNOTOK.setId(0);
            locacaoTesteNOTOK.setLocatario(locatarioCadastrado);
            locacaoTesteNOTOK.setMultaAtraso(0);
            locacaoTesteNOTOK.setStatus(StatusLocacao.Aberta);
            locacaoTesteNOTOK.setTotalLocacao(equipamnetoCadastrado2.getValorDiaria());
            locacaoTesteNOTOK.setValorDiaria(equipamnetoCadastrado2.getValorDiaria());
            
        // --------------------------------------------- //
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Teste para inserir um locatario válido
     */
    @Test
    public void testFuncionalCadastrarLocatario() {
        System.out.println("cadastrarLocatario");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            instance.cadastrarLocatario(locatarioTesteOK);
            
        } catch (Exception ex) {
            erro = ex;
        }
        assertNull(erro);
        
    }

     /**
     * Teste para alterar um locatario válido
     */
    @Test
    public void testFuncionalAlterarLocatario(){
        System.out.println("alterarLocatario");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            if(locatarioTesteOK.getId()==0){
                instance.cadastrarLocatario(locatarioTesteOK);
            }
            locatarioTesteOK.setNome(locatarioTesteOK.getNome() + "- alterado");
            instance.alterarLocatario(locatarioTesteOK);
            
        } catch (Exception ex) {
            erro = ex;
        }
        assertNull(erro);
    }
    
    /**
     * Teste para inserir um locatario inválido
     */
    @Test
    public void testFuncionalCadastrarLocatarioInvalido() {
        System.out.println("cadastrarLocatarioInvalido");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            instance.cadastrarLocatario(this.locatarioTesteNOTOK);
            
        } catch (Exception ex) {
            erro = ex;
        }
        assertNotNull(erro);
        
    }

     /**
     * Teste para alterar um locatario inválido
     */
    @Test
    public void testFuncionalAlterarLocatarioInvalido(){
        System.out.println("alterarLocatarioInvalido");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            locatarioTesteNOTOK.setNome(locatarioTesteNOTOK.getNome() + "- alterado");
            instance.alterarLocatario(locatarioTesteNOTOK);
            
        } catch (Exception ex) {
            erro = ex;
        }
        assertNotNull(erro);
    }
    
    
    
    /**
     * Teste para inserir um Funcionario válido
     */
    @Test
    public void testFuncionalCadastrarFuncionario() {
        System.out.println("cadastrarFuncionario");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            instance.cadastrarFuncionario(funcionarioTesteOK);
            
        } catch (Exception ex) {
            erro = ex;
        }
        assertNull(erro);
        
    }

     /**
     * Teste para alterar um Funcionario válido
     */
    @Test
    public void testFuncionalAlterarFuncionario(){
        System.out.println("alterarFuncionario");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            if(funcionarioTesteOK.getId()==0){
                instance.cadastrarFuncionario(funcionarioTesteOK);
            }
            funcionarioTesteOK.setNome(funcionarioTesteOK.getNome() + "- alterado");
            instance.alterarFuncionario(funcionarioTesteOK);
            
        } catch (Exception ex) {
            erro = ex;
        }
        assertNull(erro);
    }
    
    /**
     * Teste para inserir um funcionario inválido
     */
    @Test
    public void testFuncionalCadastrarFuncionarioInvalido() {
        System.out.println("cadastrarFuncionarioInvalido");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            instance.cadastrarFuncionario(this.funcionarioTesteNOTOK);
            
        } catch (Exception ex) {
            erro = ex;
        }
        assertNotNull(erro);
        
    }

     /**
     * Teste para alterar um Funcionario inválido
     */
    @Test
    public void testFuncionalAlterarFuncionarioInvalido(){
        System.out.println("alterarFuncionarioInvalido");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            funcionarioTesteNOTOK.setNome(funcionarioTesteNOTOK.getNome() + "- alterado");
            instance.alterarFuncionario(funcionarioTesteNOTOK);
            
        } catch (Exception ex) {
            erro = ex;
        }
        assertNotNull(erro);
    }
    
    
    /**
     * Teste para inserir uma Concessionaria válida
     */
    @Test
    public void testFuncionalCadastrarConcessionaria() {
        System.out.println("cadastrarConcessionaria");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            instance.cadastrarConcessionaria(concessionariaTesteOK);
            
        } catch (Exception ex) {
            erro = ex;
        }
        assertNull(erro);
        
    }

     /**
     * Teste para alterar um Concessionaria válido
     */
    @Test
    public void testFuncionalAlterarConcessionaria(){
        System.out.println("alterarConcessionaria");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            if(concessionariaTesteOK.getId()==0){
                instance.cadastrarConcessionaria(concessionariaTesteOK);
            }
            concessionariaTesteOK.setNome(concessionariaTesteOK.getNome() + "- alterado");
            instance.alterarConcessionaria(concessionariaTesteOK);
            
        } catch (Exception ex) {
            erro = ex;
        }
        assertNull(erro);
    }
    
    /**
     * Teste para inserir um Concessionaria inválido
     */
    @Test
    public void testFuncionalCadastrarConcessionariaInvalido() {
        System.out.println("cadastrarConcessionariaInvalido");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            instance.cadastrarConcessionaria(this.concessionariaTesteNOTOK);
            
        } catch (Exception ex) {
            erro = ex;
        }
        assertNotNull(erro);
        
    }

     /**
     * Teste para alterar um Concessionaria inválido
     */
    @Test
    public void testFuncionalAlterarConcessionariaInvalido(){
        System.out.println("alterarConcessionariaInvalido");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            concessionariaTesteNOTOK.setNome(concessionariaTesteNOTOK.getNome() + "- alterado");
            instance.alterarConcessionaria(concessionariaTesteNOTOK);
            
        } catch (Exception ex) {
            erro = ex;
        }
        assertNotNull(erro);
    }

    
    /**
     * Teste para inserir uma Equipamento válido
     */
    @Test
    public void testFuncionalCadastrarEquipamento() {
        System.out.println("cadastrarEquipamento");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            instance.cadastrarEquipamento(this.equipamentoTesteOK);
            
        }
        catch (Exception ex) {
            erro = ex;
        }
        assertNull(erro);
        
    }

     /**
     * Teste para alterar um Equipamento válido
     */
    @Test
    public void testFuncionalAlterarEquipamento(){
        System.out.println("alterarEquipamento");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            if(equipamentoTesteOK.getId()==0){
                instance.cadastrarEquipamento(equipamentoTesteOK);
            }
            equipamentoTesteOK.setNome(equipamentoTesteOK.getNome() + "- alterado");
            instance.alterarEquipamento(equipamentoTesteOK);
            
        }
        catch (Exception ex) {
            erro = ex;
        }
        assertNull(erro);
    }
    
    /**
     * Teste para inserir um Equipamento inválido
     */
    @Test
    public void testFuncionalCadastrarEquipamentoInvalido() {
        System.out.println("cadastrarEquipamentoInvalido");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            instance.cadastrarEquipamento(this.equipamentoTesteNOTOK);
            
        } 
        catch (Exception ex) {
            erro = ex;
        }
        assertNotNull(erro);
        
    }

     /**
     * Teste para alterar um Equipamento inválido
     */
    @Test
    public void testFuncionalAlterarEquipamentoInvalido(){
        System.out.println("alterarEquipamentoInvalido");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            equipamentoTesteNOTOK.setNome(equipamentoTesteNOTOK.getNome() + "- alterado");
            instance.alterarEquipamento(equipamentoTesteNOTOK);
            
        } catch (Exception ex) {
            erro = ex;
        }
        assertNotNull(erro);
    }
    
    /**
     * Teste para inserir uma FormaPagamento válida
     */
    @Test
    public void testFuncionalCadastrarFormaPagamento() {
        System.out.println("cadastrarFormaPagamento");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            instance.cadastrarFormaPagamento(this.formaPagamentoTesteOK);
            
        }
        
        catch (Exception ex) {
            erro = ex;
        }
        assertNull(erro);
        
    }

     /**
     * Teste para alterar uma FormaPagamento válida
     */
    @Test
    public void testFuncionalAlterarFormaPagamento(){
        System.out.println("alterarFormaPagamento");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            if(formaPagamentoTesteOK.getId()==0){
                instance.cadastrarFormaPagamento(formaPagamentoTesteOK);
            }
            formaPagamentoTesteOK.setNome(formaPagamentoTesteOK.getNome() + "- alterado");
            instance.alterarFormaPagamento(formaPagamentoTesteOK);
            
        }
        catch (Exception ex) {
            erro = ex;
        }
        assertNull(erro);
    }
    
    /**
     * Teste para inserir uma FormaPagamento inválida
     */
    @Test
    public void testFuncionalCadastrarFormaPagamentoInvalido() {
        System.out.println("cadastrarFormaPagamentoInvalida");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            instance.cadastrarFormaPagamento(this.formaPagamentoTesteNOTOK);
            
        } 
        catch (Exception ex) {
            erro = ex;
        }
        assertNotNull(erro);
        
    }

     /**
     * Teste para alterar uma FormaPagamento inválido
     */
    @Test
    public void testFuncionalAlterarFormaPagamentoInvalido(){
        System.out.println("alterarFormaPagamentoInvalido");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            formaPagamentoTesteNOTOK.setNome(formaPagamentoTesteNOTOK.getNome() + "- alterado");
            instance.alterarFormaPagamento(formaPagamentoTesteNOTOK);
            
        } catch (Exception ex) {
            erro = ex;
        }
        assertNotNull(erro);
    }
    
    /**
     * Teste para inserir uma Locacao Reseva válida
     */
    @Test
    public void testFuncionalCadastrarLocacaoReserva() {
        System.out.println("cadastrarLocacaoReserva");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            locacaoReservaTesteOK = instance.fazerReserva(this.locacaoReservaTesteOK);
            
        }
        
        catch (Exception ex) {
            erro = ex;
        }
        assertNull(erro);
        
    }

    /**
     * Teste para inserir uma Locacao Reserva válida com locatario com pendencias
     */
    @Test
    public void testFuncionalCadastrarLocacaoReservaLocatarioPendente(){
        System.out.println("alterarLocacaoReservaLocPendente");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
             locacaoReservaTesteOK.setLocatario(locatarioComPendenciasCadastrado);
             instance.fazerReserva(locacaoReservaTesteOK);
        }
        catch (Exception ex) {
            erro = ex;
        }
        locacaoReservaTesteOK.setLocatario(locatarioCadastrado);
        assertNotNull(erro);
    }
    
    /**
     * Teste para inserir uma Locacao Reserva válida com locatario com pendencias
     */
    @Test
    public void testFuncionalCadastrarLocacaoReservaEquipamentoLocado(){
        System.out.println("alterarLocacaoReservaLocPendente");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
             locacaoReservaTesteOK.getEquipamento().setStatus(StatusEquipamento.Reservado);
             instance.fazerReserva(locacaoReservaTesteOK);
        }
        catch (Exception ex) {
            erro = ex;
        }
        
        assertNotNull(erro);
    }
    
     /**
     * Teste para alterar uma Locacao Reserva válida
     */
    @Test
    public void testFuncionalAlterarLocacaoReserva(){
        System.out.println("alterarLocacaoReserva");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            
            locacaoReservaTesteOK.setValorDiaria(locacaoReservaTesteOK.getValorDiaria()+1);
            instance.atualizarLocacao(locacaoReservaTesteOK);
            
        }
        catch (Exception ex) {
            erro = ex;
        }
        assertNull(erro);
    }
    
    
    
    /**
     * Teste para inserir uma Locacao Reserva inválida
     */
    @Test
    public void testFuncionalCadastrarLocacaoInvalido() {
        System.out.println("cadastrarLocacaoReservaInvalida");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            instance.fazerReserva(this.locacaoReservaTesteNOTOK);
            
        } 
        catch (Exception ex) {
            erro = ex;
        }
        assertNotNull(erro);
        
    }

     /**
     * Teste para alterar uma Locacao Reserva inválida
     */
    @Test
    public void testFuncionalAlterarLocacaoReservaInvalido(){
        System.out.println("alterarLocacaoReservaInvalido");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            locacaoReservaTesteNOTOK.setId(-1);
            instance.atualizarLocacao(locacaoReservaTesteNOTOK);
            
        } catch (Exception ex) {
            erro = ex;
        }
        assertNotNull(erro);
    }
    
    /**
     * Teste para inserir uma Locacao válida com locatario que reservou equipamento diferente do que pretende reservar
     */
    @Test
    public void testFuncionalCadastrarLocacaoLocatarioReservaDiferente() {
        System.out.println("cadastrarLocacao");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            
            locacaoReservaTesteOK = instance.fazerLocacao(this.locacaoReservaTesteOK);
            
        }
        
        catch (Exception ex) {
            erro = ex;
        }
        assertEquals(erro,null);
        
    }
    
    /**
     * Teste para inserir uma Locacao válida com equipamento nao reservado
     */
    @Test
    public void testFuncionalCadastrarLocacaoEqipamentoSemReserva() {
        System.out.println("cadastrarLocacao");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            locacaoReservaTesteOK.getEquipamento().setLocatarioReserva(locacaoReservaTesteOK.getLocatario());
            locacaoReservaTesteOK.getEquipamento().setStatus(StatusEquipamento.Disponivel);
            locacaoReservaTesteOK = instance.fazerLocacao(this.locacaoReservaTesteOK);
            
        }
        
        catch (Exception ex) {
            erro = ex;
        }
        assertNotNull(erro);
        
    }
    
    /**
     * Teste para inserir uma Locacao válida sem pagamentos
     */
    @Test
    public void testFuncionalCadastrarLocacaoEqipamentoSemPagamentos() {
        System.out.println("cadastrarLocacao");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            locacaoReservaTesteOK.getEquipamento().setLocatarioReserva(locacaoReservaTesteOK.getLocatario());
            locacaoReservaTesteOK.getPagamentos().clear();
            locacaoReservaTesteOK = instance.fazerLocacao(this.locacaoReservaTesteOK);
            
        }
        
        catch (Exception ex) {
            erro = ex;
        }
        assertNotNull(erro);
        
    }
    
    /**
     * Teste para inserir uma Locacao válida
     */
    @Test
    public void testFuncionalCadastrarLocacao() {
        System.out.println("cadastrarLocacao");
        Funcionario instance = Main.getFuncionario();
        Exception erro = null;
        try {
            locacaoReservaTesteOK.getEquipamento().setLocatarioReserva(locacaoReservaTesteOK.getLocatario());
            locacaoReservaTesteOK.getEquipamento().setStatus(StatusEquipamento.Reservado);
            Pagamento pagamento = new Pagamento();
            pagamento.setDataPagamento(new Date());
            pagamento.setFormaPagamento(formaPagamentoCadastrada);
            pagamento.setReferencia("Locação de equipamento");
            pagamento.setPendente(false);
            pagamento.setParcela(1);
            pagamento.setTotalParcelas(1);
            pagamento.setValor(locacaoTesteOK.getTotalLocacao());
            locacaoReservaTesteOK.getPagamentos().add(pagamento);
            locacaoReservaTesteOK = instance.fazerLocacao(this.locacaoReservaTesteOK);
            
        }
        
        catch (Exception ex) {
            erro = ex;
        }
        assertNull(erro);
        
    }
    
    /**
     * Teste obter locacoes abertas/reservads de um locatario
     */
    @Test
    public void testEstruturalObterLocacaosAbertas() {
        System.out.println("ObterLocacoesAbertas");
        
        Exception erro = null;
        try {
            locatarioComPendenciasCadastrado.getLocacoesAbertas();
        }
        
        catch (Exception ex) {
            erro = ex;
        }
        assertNull(erro);
        
    }
    /**
     * Teste obter locacoes de um locatario
     */
    @Test
    public void testEstruturalObterLocacoesPagamentos() {
        System.out.println("ObterLocacoes");
        
        Exception erro = null;
        try {
            locatarioComPendenciasCadastrado.getLocacoes();
            locatarioComPendenciasCadastrado.getPagamentos();
        }
        
        catch (Exception ex) {
            erro = ex;
        }
        assertNull(erro);
        
    }
    
    /**
     * Teste uso de UF
     */
    @Test
    public void testEstruturalUsoUF() {
        System.out.println("UsoUF");
        
        UF uf = UF.SP;
        assertEquals("SP",uf.name());
        
    }
    
    /**
     * Teste uso de UF 2
     */
    @Test
    public void testEstruturalUsoUF2() {
        System.out.println("UsoUF");
        
        UF uf = UF.SP;
        UF ufN = UF.valueOf("SP");
        assertEquals(uf,ufN);
        
    }
    
    /**
     * Teste uso de Forma de Pagamento
     */
    @Test
    public void testEstruturalUsoFormaPagamento() {
        System.out.println("UsoFP");
        formaPagamentoCadastrada.setApagado(false);
        formaPagamentoCadastrada.setId(formaPagamentoCadastrada.getId());
        assertTrue(!formaPagamentoCadastrada.isApagado() && formaPagamentoCadastrada.isAtiva() && !formaPagamentoCadastrada.toString().isEmpty());
        
    }
    
    /**
     * Teste uso de Historico
     */
    @Test
    public void testEstruturalUsoHistorico() {
        System.out.println("UsoHistorico");
        Set<Historico> historicos =  Main.getFuncionario().getHistoricos();
        for(Historico hist: historicos){
            long id =hist.getId();
            hist.getTipoOcorrencia();
            hist.getDataOcorrencia();
            hist.getDescricao();
            hist.setId(id);
            assertEquals(String.valueOf(id),hist.toString());
        }
    }
    
    /**
     * Teste uso de Pagamentos
     */
    @Test
    public void testEstruturalUsoPagamento() {
        System.out.println("UsoHistorico");
        Set<Historico> historicos =  Main.getFuncionario().getHistoricos();
        for(Historico hist: historicos){
            long id =hist.getId();
            hist.getTipoOcorrencia();
            hist.getDataOcorrencia();
            hist.getDescricao();
            hist.setId(id);
            assertEquals(String.valueOf(id),hist.toString());
        }
    }
    
}
