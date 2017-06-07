/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Database.Persistencia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcos Felipe
 */
public class FuncionarioTest {
    Persistencia persistencia;
    
    Locatario locatarioTesteOK;
    Funcionario funcionarioTesteOK;
    Concessionaria concessionariaTesteOK;
    Equipamento equipamentoTesteOK;
    Locacao locacaoTesteOK;
    FormaPagamento pagamentoTesteOK;
    
    public FuncionarioTest() {
        persistencia = new Persistencia();
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception{
        Persistencia.estabelecerConexao();
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception{
       // Persistencia.encerrarConexao();
    }
    
    @Before
    public void setUp() throws ParseException {
            String data = "05/05/1500";
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date1 = format.parse(data);
            
            data = "05/06/1505";
            format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date2 = format.parse(data);

            data = "05/07/1510";
            format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date3 = format.parse(data);
            
        // Cadastro de Locátario correto
        locatarioTesteOK = new Locatario();
            locatarioTesteOK.setNome("Funcionário de teste correto");
            locatarioTesteOK.setCpf("12345678900");
            locatarioTesteOK.setInscricaoEstadual("123456789");
            locatarioTesteOK.setCnpj("123456789000123");
            locatarioTesteOK.setDataNascimento(date1);
            locatarioTesteOK.setRua("Avenida de teste");
            locatarioTesteOK.setNumero(123456789);
            locatarioTesteOK.setCep("12345000");
            locatarioTesteOK.setBairro("Bairro de teste");
            locatarioTesteOK.setCidade("Cidade de teste");
            locatarioTesteOK.setTipo(TipoLocatario.FISICA);
            locatarioTesteOK.setUf("UF");
            locatarioTesteOK.setStatus(StatusLocatario.Normal);
            locatarioTesteOK.setTelefonePrincipal("12912345678");
            locatarioTesteOK.setTelefone2("12912345678");
            locatarioTesteOK.setEmailPrincipal("teste1.teste@teste.com");
            locatarioTesteOK.setEmail2("teste2.teste@teste.com");
        // Cadastro de funcionário correto
         funcionarioTesteOK = new Funcionario();
            funcionarioTesteOK.setNome("Funcionário de teste correto");
            funcionarioTesteOK.setCpf("12345678900");
            funcionarioTesteOK.setInscricaoEstadual("123456789");
            funcionarioTesteOK.setCnpj("123456789000123");
            funcionarioTesteOK.setDataNascimento(date1);
            funcionarioTesteOK.setRua("Avenida de teste");
            funcionarioTesteOK.setNumero(123456789);
            funcionarioTesteOK.setCep("12345000");
            funcionarioTesteOK.setBairro("Bairro de teste");
            funcionarioTesteOK.setCidade("Cidade de teste");
            funcionarioTesteOK.setUf("UF");
            funcionarioTesteOK.setStatus(StatusLocatario.Normal);
            funcionarioTesteOK.setTelefonePrincipal("12912345678");
            funcionarioTesteOK.setTelefone2("12912345678");
            funcionarioTesteOK.setEmailPrincipal("teste1.teste@teste.com");
            funcionarioTesteOK.setEmail2("teste2.teste@teste.com"); 
            funcionarioTesteOK.setTipo(TipoLocatario.FUNCIONARIO);
            // Exclusivos de Funcionario
            funcionarioTesteOK.setDataAdmissao(date1);
            funcionarioTesteOK.setSenha("123");
            funcionarioTesteOK.setNis("2");
            funcionarioTesteOK.setSalario(500);
        // Cadastro de Concessionaria correta
         concessionariaTesteOK = new Concessionaria();
            concessionariaTesteOK.setNome("Concessionária de teste correto");
            concessionariaTesteOK.setCpf("12345678900");
            concessionariaTesteOK.setInscricaoEstadual("123456789");
            concessionariaTesteOK.setRazaoSocial("Razao Teste");
            concessionariaTesteOK.setCnpj("123456789000123");
            concessionariaTesteOK.setDataNascimento(date1);
            concessionariaTesteOK.setRua("Avenida de teste");
            concessionariaTesteOK.setNumero(123456789);
            concessionariaTesteOK.setCep("12345000");
            concessionariaTesteOK.setBairro("Bairro de teste");
            concessionariaTesteOK.setCidade("Cidade de teste");
            concessionariaTesteOK.setUf("UF");
            concessionariaTesteOK.setStatus(StatusLocatario.Normal);
            concessionariaTesteOK.setTelefonePrincipal("12912345678");
            concessionariaTesteOK.setTelefone2("12912345678");
            concessionariaTesteOK.setEmailPrincipal("teste1.teste@teste.com");
            concessionariaTesteOK.setEmail2("teste2.teste@teste.com");
            // Exclusivos de Concessionaria
            concessionariaTesteOK.setNomeResponsavel("Responsavel de teste");
        // Cadastro de equipamento correto
         equipamentoTesteOK = new Equipamento();
            //equipamentoTesteOK.setId(500);
            equipamentoTesteOK.setNome("Equipamento de teste");
            equipamentoTesteOK.setSerie("100");
            equipamentoTesteOK.setDescricao("Equipamento criado somente para teste");
            equipamentoTesteOK.setFabricante("JUnit");
            equipamentoTesteOK.setValorDiaria(500);
            equipamentoTesteOK.setValorPatrimonio(500);
            equipamentoTesteOK.setStatus(StatusEquipamento.Disponivel);
            equipamentoTesteOK.setDataCompra(date1);
            equipamentoTesteOK.setValidade(date3);
            equipamentoTesteOK.setProximaRevisao(date2);
            equipamentoTesteOK.setHistoricos(new HashSet<>());
            equipamentoTesteOK.setCategoria("Categoria de teste");
            equipamentoTesteOK.setConcessionaria(concessionariaTesteOK);
            equipamentoTesteOK.setFuncionario(funcionarioTesteOK);
        // Cadastro de locação correta
         locacaoTesteOK = new Locacao();
            locacaoTesteOK.setLocatario(locatarioTesteOK);
            locacaoTesteOK.setFuncionario(funcionarioTesteOK);
            locacaoTesteOK.setEquipamento(equipamentoTesteOK);
            locacaoTesteOK.setDataLocacao(date1);
            locacaoTesteOK.setDataDevolucao(date2);
            locacaoTesteOK.setStatus(StatusLocacao.EmDia);
            locacaoTesteOK.setValorDiaria(500);
            locacaoTesteOK.setTotalLocacao(1000);
            locacaoTesteOK.setMultaAtraso(1000);
        // Cadastro de forma de pagamento correta
        pagamentoTesteOK = new FormaPagamento();
            pagamentoTesteOK.setNome("Pagamento de teste");
            pagamentoTesteOK.setDescricao("Descrição de pagamento de teste");
            pagamentoTesteOK.setAtiva(true);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Lista de métodos relacionados à insercao/alteracao: 
     * [OK] cadastrarFuncionario, 
     * [OK] alterarFuncionario,
     * 
     * [OK] cadastrarLocatario, 
     * [OK] alterarLocatario, 
 
     * [OK] cadastrarConcessionaria, 
     * [OK] alterarConcessionaria, 
     * 
     * [OK] cadastrarEquipamento, 
     * [OK] atualizarEquipamento, 
     * 
     * [OK] fazerLocacao,
     * [OK] atualizarLocacao, 
     * 
     * [OK] fazerReserva, 
     * 
     * [OK] registrarFormaPagamento,
     * [OK] atualizarFormaPagamento
     */

    /**
     * Test of solicitarLocacao method, of class Funcionario.
     */
    @Test
    public void testAlterarFuncionario() throws Exception {
        System.out.println("Teste Alterar Funcionario");
        funcionarioTesteOK.cadastrarFuncionario(funcionarioTesteOK);
        
        Funcionario funcionarioTesteAux = new Funcionario();
        
        funcionarioTesteAux.setNome(funcionarioTesteOK.getNome());
        
        funcionarioTesteOK.setNome("Nome Alterado");
                
        funcionarioTesteOK.alterarFuncionario(funcionarioTesteOK);
        
        System.out.printf(funcionarioTesteOK.getNome() + " <==> " + funcionarioTesteAux.getNome()); // Debug
        
        Funcionario busca = (Funcionario) Persistencia.buscar(Funcionario.class, funcionarioTesteOK.getId());
        
        assertTrue(funcionarioTesteOK.getId()>0);
        assertNotSame(busca.getNome(), funcionarioTesteAux.getNome());
    }
    
    @Test
    public void CadastrarFuncionarioErrado() throws Exception {
        System.out.println("Teste Cadastrar Funcionario Errado");
        funcionarioTesteOK.cadastrarFuncionario(funcionarioTesteOK);
        
        Exception erro = null;
        Funcionario funcionarioNotOK = new Funcionario();
        try {
            // -- exclusivo de funcionario -- //
            funcionarioNotOK.setNis("a");
            funcionarioNotOK.setSenha("");

            funcionarioTesteOK.cadastrarFuncionario(funcionarioNotOK);
        }
        catch (Exception ex) {
            erro = ex;
        }
        
        assertNotNull(erro);
        
        try {
            // -- exclusivo de funcionario -- //
            funcionarioNotOK.setNis("");

            funcionarioTesteOK.cadastrarFuncionario(funcionarioNotOK);
        }
        catch (Exception ex) {
            erro = ex;
        }
        
        assertNotNull(erro);
    }    
    
    
    @Test
    public void testCadastrarLocatario() throws Exception {
        System.out.println("Teste Cadastrar Locatario");
        funcionarioTesteOK.cadastrarFuncionario(funcionarioTesteOK);
        funcionarioTesteOK.cadastrarLocatario(locatarioTesteOK);
        
        Locatario busca = (Locatario) Persistencia.buscar(Locatario.class, locatarioTesteOK.getId());
        
        assertTrue(locatarioTesteOK.getId()>0);
        assertEquals(locatarioTesteOK.getId(), busca.getId());
    }
    
    @Test
    public void testAlterarLocatario() throws Exception {
        System.out.println("Teste Alterar Locatario");
        funcionarioTesteOK.cadastrarFuncionario(funcionarioTesteOK);
        funcionarioTesteOK.cadastrarLocatario(locatarioTesteOK);
        
        Locatario locatarioTesteAux = new Locatario();
        
        locatarioTesteAux.setNome(locatarioTesteOK.getNome());
        
        locatarioTesteOK.setNome("Nome Alterado");
                
        funcionarioTesteOK.alterarLocatario(locatarioTesteOK);
        
        //System.out.printf(locatarioTesteOK.getNome() + " <==> " + locatarioTesteAux.getNome()); // Debug
        
        Locatario busca = (Locatario) Persistencia.buscar(Locatario.class, locatarioTesteOK.getId());
        
        assertTrue(locatarioTesteOK.getId()>0);
        assertNotSame(busca.getNome(), locatarioTesteAux.getNome());
    }   
    
    @Test
    public void CadastrarLocatarioErrado() throws Exception {
        System.out.println("Teste Cadastrar Locatario Errado");
        funcionarioTesteOK.cadastrarFuncionario(funcionarioTesteOK);
        
        Exception erro = null;
        String vazio = new String();
        String invalido = "=^!@#$%^&*根";
        Locatario LocatarioNotOK = new Locatario();

        LocatarioNotOK.setId(-1);
        
        LocatarioNotOK.setCpf(invalido);

        LocatarioNotOK.setInscricaoEstadual(invalido);
        
        LocatarioNotOK.setUf(null);

        LocatarioNotOK.setStatus(null);
        
        try {
            LocatarioNotOK.setTipo(null);

            LocatarioNotOK.setRazaoSocial("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur massa neque, dictum id ante blandit, placerat faucibus lorem. Pellentesque sagittis lacus turpis, id elementum turpis semper et. Vivamus sodales elementum quam, ac vulputate quam bibendum finibus. Praesent luctus libero erat, nec consectetur leo ullamcorper sit amet. Aliquam erat volutpat. Proin nisi ante, egestas sit amet facilisis ac, vestibulum a nisi. In hac habitasse platea dictumst. Praesent vel mauris malesuada, efficitur nibh ut, varius mauris. Aenean egestas eget diam a consequat. Proin eget ultrices lorem. Aliquam varius lacus neque, sed hendrerit risus hendrerit non. Nunc sit amet quam in libero condimentum");

            LocatarioNotOK.setCep(null);

            LocatarioNotOK.setBairro(null);

            LocatarioNotOK.setCidade(null);

            LocatarioNotOK.setTelefonePrincipal(null);

            LocatarioNotOK.setTelefone2(null);

            LocatarioNotOK.setEmailPrincipal("");

            LocatarioNotOK.setEmail2("");

            funcionarioTesteOK.cadastrarLocatario(LocatarioNotOK);
        }
        catch (Exception ex) {
            erro = ex;
        }
             
        try {
            
            LocatarioNotOK.setTipo(TipoLocatario.JURIDICA);

            LocatarioNotOK.setRazaoSocial(vazio);
    
            LocatarioNotOK.setCep(vazio);

            LocatarioNotOK.setBairro(vazio);

            LocatarioNotOK.setCidade(vazio);

            LocatarioNotOK.setTelefonePrincipal(vazio);

            LocatarioNotOK.setTelefone2(vazio);

            LocatarioNotOK.setEmailPrincipal(vazio);

            LocatarioNotOK.setEmail2(vazio);
            
            funcionarioTesteOK.cadastrarLocatario(LocatarioNotOK);
        }
        catch (Exception ex) {
            erro = ex;
        }
        
        try {
            LocatarioNotOK.setTipo(TipoLocatario.JURIDICA);

            LocatarioNotOK.setCep(invalido);

            LocatarioNotOK.setTelefonePrincipal(invalido);

            LocatarioNotOK.setTelefone2(invalido);

            LocatarioNotOK.setEmailPrincipal(invalido);

            LocatarioNotOK.setEmail2(invalido);

            funcionarioTesteOK.cadastrarLocatario(LocatarioNotOK);
        }
        
        catch (Exception ex) {
            erro = ex;
        }
        
        assertNotNull(erro);
    }
    
    @Test
    public void testCadastrarConcessionaria() throws Exception {
        System.out.println("Teste Cadastrar Concessionaria");
        funcionarioTesteOK.cadastrarFuncionario(funcionarioTesteOK);
        funcionarioTesteOK.cadastrarConcessionaria(concessionariaTesteOK);
        
        Concessionaria busca = (Concessionaria) Persistencia.buscar(Concessionaria.class, concessionariaTesteOK.getId());
        
        assertTrue(concessionariaTesteOK.getId()>0);
        assertEquals(concessionariaTesteOK.getId(), busca.getId());
    }
    
    @Test
    public void testAlterarConcessionaria() throws Exception {
        System.out.println("Teste Alterar Concessionaria");
        funcionarioTesteOK.cadastrarFuncionario(funcionarioTesteOK);
        funcionarioTesteOK.cadastrarConcessionaria(concessionariaTesteOK);
        
        Concessionaria concessionariaTesteAux = new Concessionaria();
        
        concessionariaTesteAux.setNomeResponsavel(concessionariaTesteOK.getNomeResponsavel());
        
        concessionariaTesteOK.setNomeResponsavel("Nome Responsavel Alterado");
        
        funcionarioTesteOK.alterarConcessionaria(concessionariaTesteOK);
        
        System.out.printf(concessionariaTesteOK.getNome() + " <==> " + concessionariaTesteAux.getNome()); // Debug
        
        Concessionaria busca = (Concessionaria) Persistencia.buscar(Concessionaria.class, concessionariaTesteOK.getId());
        
        assertTrue(concessionariaTesteOK.getId()>0);
        assertNotSame(busca.getNome(), concessionariaTesteAux.getNome());
    }   
    
    @Test
    public void CadastrarConcessionariaErrado() throws Exception {
        System.out.println("Teste Cadastrar Concessionaria Errado");
        funcionarioTesteOK.cadastrarFuncionario(funcionarioTesteOK);
        
        Exception erro = null;
        String vazio = new String();
        Concessionaria concessionariaNotOK = new Concessionaria();

        
        try {
            
            concessionariaNotOK.setNomeResponsavel(null);
            concessionariaNotOK.setRazaoSocial(vazio);

            funcionarioTesteOK.cadastrarConcessionaria(concessionariaNotOK);
        }
        catch (Exception ex) {
            erro = ex;
        }
        
        try {        
            concessionariaNotOK.setNomeResponsavel(vazio);
            concessionariaNotOK.setRazaoSocial("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur massa neque, dictum id ante blandit, placerat faucibus lorem. Pellentesque sagittis lacus turpis, id elementum turpis semper et. Vivamus sodales elementum quam, ac vulputate quam bibendum finibus. Praesent luctus libero erat, nec consectetur leo ullamcorper sit amet. Aliquam erat volutpat. Proin nisi ante, egestas sit amet facilisis ac, vestibulum a nisi. In hac habitasse platea dictumst. Praesent vel mauris malesuada, efficitur nibh ut, varius mauris. Aenean egestas eget diam a consequat. Proin eget ultrices lorem. Aliquam varius lacus neque, sed hendrerit risus hendrerit non. Nunc sit amet quam in libero condimentum");            
            funcionarioTesteOK.cadastrarConcessionaria(concessionariaNotOK);
        }
        catch (Exception ex) {
            erro = ex;
        }
        
        assertNotNull(erro);
    }
    
    @Test
    public void testCadastrarEquipamento() throws Exception {
        System.out.println("Teste Cadastrar Equipamento");
        funcionarioTesteOK.cadastrarFuncionario(funcionarioTesteOK);
        funcionarioTesteOK.cadastrarConcessionaria(concessionariaTesteOK);
        funcionarioTesteOK.cadastrarEquipamento(equipamentoTesteOK);
        
        Equipamento busca = (Equipamento) Persistencia.buscar(Equipamento.class, equipamentoTesteOK.getId());
        
        assertTrue(equipamentoTesteOK.getId()>0);
        assertEquals(equipamentoTesteOK.getId(), busca.getId());
    }
    
    @Test
    public void testAtualizarEquipamento() throws Exception {
        System.out.println("Teste Atualizar Equipamento");
        funcionarioTesteOK.cadastrarFuncionario(funcionarioTesteOK);
        funcionarioTesteOK.cadastrarConcessionaria(concessionariaTesteOK);
        funcionarioTesteOK.cadastrarEquipamento(equipamentoTesteOK);
        
        Equipamento equipamentoTesteAux = new Equipamento();
        
        equipamentoTesteAux.setNome(equipamentoTesteOK.getNome());
        
        equipamentoTesteOK.setNome("Nome Alterado");
        
        funcionarioTesteOK.alterarEquipamento(equipamentoTesteOK);
        
        System.out.printf(equipamentoTesteOK.getNome() + " <==> " + equipamentoTesteAux.getNome()); // Debug
        
        Equipamento busca = (Equipamento) Persistencia.buscar(Equipamento.class, equipamentoTesteOK.getId());
        
        assertTrue(equipamentoTesteOK.getId()>0);
        assertNotSame(busca.getNome(), equipamentoTesteAux.getNome());
    }
    
    @Test
    public void CadastrarEquipamentoErrado() throws Exception {
        System.out.println("Teste Cadastrar Equipamento Errado");
        funcionarioTesteOK.cadastrarFuncionario(funcionarioTesteOK);
        funcionarioTesteOK.cadastrarConcessionaria(concessionariaTesteOK);
        
        Exception erro = null;
        String vazio = new String();
        Equipamento equipamentoNotOK = new Equipamento();

        equipamentoNotOK.setId(-1);
        equipamentoNotOK.setNome(null);
        equipamentoNotOK.setDescricao(null); 
        equipamentoNotOK.setValorDiaria(-1);  
        equipamentoNotOK.setValorPatrimonio(-1);
        equipamentoNotOK.setStatus(null);      
        equipamentoNotOK.setDataCompra(null); 
        equipamentoNotOK.setValidade(null);   
        equipamentoNotOK.setProximaRevisao(null);
                
        try {
            equipamentoNotOK.setFabricante(null);
            funcionarioTesteOK.cadastrarEquipamento(equipamentoNotOK);
        }
        catch (Exception ex) {
            erro = ex;
        }
        
        try {        
            equipamentoNotOK.setFabricante("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur massa neque, dictum id ante blandit, placerat faucibus lorem. Pellentesque sagittis lacus turpis, id elementum turpis semper et. Vivamus sodales elementum quam, ac vulputate quam bibendum finibus. Praesent luctus libero erat, nec consectetur leo ullamcorper sit amet. Aliquam erat volutpat. Proin nisi ante, egestas sit amet facilisis ac, vestibulum a nisi. In hac habitasse platea dictumst. Praesent vel mauris malesuada, efficitur nibh ut, varius mauris. Aenean egestas eget diam a consequat. Proin eget ultrices lorem. Aliquam varius lacus neque, sed hendrerit risus hendrerit non. Nunc sit amet quam in libero condimentum");   
            funcionarioTesteOK.cadastrarEquipamento(equipamentoNotOK);
        }
        catch (Exception ex) {
            erro = ex;
        }
        
        assertNotNull(erro);
    }
  
    @Test
    public void testRegistrarFormaPagamento() throws Exception {
        System.out.println("Teste Registrar Forma Pagamento");
        funcionarioTesteOK.cadastrarFuncionario(funcionarioTesteOK);
        funcionarioTesteOK.cadastrarFormaPagamento(pagamentoTesteOK);
        
        FormaPagamento busca = (FormaPagamento) Persistencia.buscar(FormaPagamento.class, pagamentoTesteOK.getId());
       
        assertEquals(pagamentoTesteOK.getId(), busca.getId());
    }
    
    @Test
    public void testAtualizarFormaPagamento() throws Exception {
        System.out.println("Teste Atualizar Forma Pagamento");
        funcionarioTesteOK.cadastrarFuncionario(funcionarioTesteOK);
        funcionarioTesteOK.cadastrarFormaPagamento(pagamentoTesteOK);
        
        pagamentoTesteOK.setDescricao("Descrição alterada");
        funcionarioTesteOK.cadastrarFormaPagamento(pagamentoTesteOK);
        
        FormaPagamento busca = (FormaPagamento) Persistencia.buscar(FormaPagamento.class, pagamentoTesteOK.getId());
       
        assertEquals("Descrição alterada", busca.getDescricao());
    }
    
    @Test
    public void testRegistrarFormaPagamentoErrado() throws Exception {
        System.out.println("Teste Registrar Forma Pagamento");
        funcionarioTesteOK.cadastrarFuncionario(funcionarioTesteOK);
        
        FormaPagamento formaPagamentoNotOK = new FormaPagamento();
        Exception erro = null;

        try {
            
            formaPagamentoNotOK.setNome(null);
            formaPagamentoNotOK.setDescricao(null);

            funcionarioTesteOK.cadastrarFormaPagamento(formaPagamentoNotOK);
        }
        catch (Exception ex) {
            erro = ex;
        }        
        
        try {
            
            formaPagamentoNotOK.setNome("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur massa neque, dictum id ante blandit, placerat faucibus lorem. Pellentesque sagittis lacus turpis, id elementum turpis semper et. Vivamus sodales elementum quam, ac vulputate quam bibendum finibus. Praesent luctus libero erat, nec consectetur leo ullamcorper sit amet. Aliquam erat volutpat. Proin nisi ante, egestas sit amet facilisis ac, vestibulum a nisi. In hac habitasse platea dictumst. Praesent vel mauris malesuada, efficitur nibh ut, varius mauris. Aenean egestas eget diam a consequat. Proin eget ultrices lorem. Aliquam varius lacus neque, sed hendrerit risus hendrerit non. Nunc sit amet quam in libero condimentum");
            formaPagamentoNotOK.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur massa neque, dictum id ante blandit, placerat faucibus lorem. Pellentesque sagittis lacus turpis, id elementum turpis semper et. Vivamus sodales elementum quam, ac vulputate quam bibendum finibus. Praesent luctus libero erat, nec consectetur leo ullamcorper sit amet. Aliquam erat volutpat. Proin nisi ante, egestas sit amet facilisis ac, vestibulum a nisi. In hac habitasse platea dictumst. Praesent vel mauris malesuada, efficitur nibh ut, varius mauris. Aenean egestas eget diam a consequat. Proin eget ultrices lorem. Aliquam varius lacus neque, sed hendrerit risus hendrerit non. Nunc sit amet quam in libero condimentum");
        
            funcionarioTesteOK.cadastrarFormaPagamento(formaPagamentoNotOK);
        }
        catch (Exception ex) {
            erro = ex;
        }   
        
        assertNotNull(erro);
    }
    
    @Test
    public void testValidarLocacaoErrado() throws Exception {
        System.out.println("Teste Registrar Forma Pagamento");
        funcionarioTesteOK.cadastrarFuncionario(funcionarioTesteOK);
        
        Exception erro = null;
        
        Locacao locacaoNotOK = new Locacao();
        
        locacaoNotOK.setFuncionario(null);
        locacaoNotOK.setDataLocacao(null);
        locacaoNotOK.setDataDevolucao(null);
        locacaoNotOK.setStatus(null);
        locacaoNotOK.setValorDiaria(-1);      
        locacaoNotOK.setTotalLocacao(-1);
        locacaoNotOK.setMultaAtraso(-1);
                
        try {
            funcionarioTesteOK.fazerLocacao(locacaoNotOK);
        }
          catch (Exception ex) {
            erro = ex;
        }   
        
        assertNotNull(erro);
    }
    
    @Test
    public void testValidarPagamentoErrado() throws Exception {
        System.out.println("Teste Registrar Forma Pagamento");
        funcionarioTesteOK.cadastrarFuncionario(funcionarioTesteOK);
        
        Pagamento PagamentoNotOK = new Pagamento();
        Exception erro = null;

        PagamentoNotOK.setId(-1);
        PagamentoNotOK.setFormaPagamento(null);
        PagamentoNotOK.setReferencia(null);    
        PagamentoNotOK.setParcela(-1);
        PagamentoNotOK.setTotalParcelas(-1);     
        PagamentoNotOK.setPendente(true);   
        PagamentoNotOK.setDataPagamento(null);        
  
        try {
            Validacao.validarPagamento(PagamentoNotOK);
        }
        catch (Exception ex) {
            erro = ex;
        }        
        
        assertNotNull(erro);
    }
}
