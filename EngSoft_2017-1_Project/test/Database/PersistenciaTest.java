/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Classes.Concessionaria;
import Classes.Equipamento;
import Classes.Funcionario;
import Classes.Locatario;
import java.util.List;
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
public class PersistenciaTest {
    Persistencia persistencia;
    
    Locatario locatarioTesteOK;
    Locatario locatarioTesteNOTOK;
    
    public PersistenciaTest() {
        persistencia = new Persistencia();
    }
    
    @BeforeClass
    public static void setUpClass()  throws Exception {
        Persistencia.estabelecerConexao();
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception  {
        Persistencia.encerrarConexao();
    }
    
    @Before
    public void setUp(){
        // Cadastro de Locátario correto
        locatarioTesteOK = new Locatario();
            locatarioTesteOK.setNome("Funcionário de teste correto");
            locatarioTesteOK.setCpf("123.456.789-00");
            locatarioTesteOK.setInscricaoEstadual("123.45678-9");
            locatarioTesteOK.setCnpj("12.345.6789/0001-23");
            //locatarioTesteOK.setDataNascimento((12341212);
            locatarioTesteOK.setRua("Avenida de teste");
            locatarioTesteOK.setNumero(123456789);
            locatarioTesteOK.setCep("12345-000");
            locatarioTesteOK.setBairro("Bairro de teste");
            locatarioTesteOK.setCidade("Cidade de teste");
            locatarioTesteOK.setUf("UF");
            //locatarioTesteOK.setStatus(0);
            locatarioTesteOK.setTelefonePrincipal("(12)91234-5678");
            locatarioTesteOK.setTelefone2("(12)91234-5678");
            locatarioTesteOK.setEmailPrincipal("teste1.teste@teste.com");
            locatarioTesteOK.setEmail2("teste2.teste@teste.com");
        // --------------------------------------------- //
        // Cadastro de Locátario incorreto
        locatarioTesteNOTOK = new Locatario();
            locatarioTesteNOTOK.setNome(null);
            locatarioTesteNOTOK.setCpf(null);
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
        // --------------------------------------------- //
        
    }
    
    @After
    public void tearDown() {
    }

/** Teste de Persistencia
* 
* Código - Nome          - Descrição                                                                                     - Critério de teste
*  [S00]  - TestSalvar00  - Testa o método < Persistencia.salvar > em caso de falha.                                      - Compara o Id criado com o Id salvo no banco de dados.
*  [S01]*  - TestSalvar01  - Testa o método < Persistencia.salvar > para classe < Locatario >                             - Compara o Id criado com o Id salvo no banco de dados.
*  [S02]  - TestSalvar02  - Testa o método < Persistencia.salvar > para classe < Funcionario >                            - Compara o Id criado com o Id salvo no banco de dados. 
*  [S03]  - TestSalvar03  - Testa o método < Persistencia.salvar > para classe < Equipamento >                            - Compara o Id criado com o Id salvo no banco de dados.
*  [S04]  - TestSalvar04  - Testa o método < Persistencia.salvar > para classe < Concessionaria >                         - Compara o Id criado com o Id salvo no banco de dados.
* 
*  [B01]*  - TestBuscar01  - Testa o método < Persistencia.buscar > para classe < Locatario >                              - Compara o Id buscado com o Id salvo no banco de dados.
*  [B02]  - TestBuscar02  - Testa o método < Persistencia.buscar > para classe < Funcionario >                            - Compara o Id buscado com o Id salvo no banco de dados.
*  [B03]  - TestBuscar03  - Testa o método < Persistencia.buscar > para classe < Equipamento >                            - Compara o Id buscado com o Id salvo no banco de dados.
*  [B04]  - TestBuscar04  - Testa o método < Persistencia.buscar > para classe < Concessionaria >                         - Compara o Id buscado com o Id salvo no banco de dados.
* 
*  [L01]*  - TestBuscarLista01 - Testa o método < Persistencia.buscar > para a classe < Locatario > em busca de listas     - Busca a lista do número de registros , Salva um novo registro, busca uma nova lista e compara se a lista foi atualizada.
*  [L02]  - TestBuscarLista02 - Testa o método < Persistencia.buscar > para a classe < Funcionario > em busca de listas   - Busca a lista do número de registros , Salva um novo registro, busca uma nova lista e compara se a lista foi atualizada.
*  [L03]  - TestBuscarLista03 - Testa o método < Persistencia.buscar > para a classe < Equipamento > em busca de listas      - Busca a lista do número de registros , Salva um novo registro, busca uma nova lista e compara se a lista foi atualizada.
*  [L04]  - TestBuscarLista04 - Testa o método < Persistencia.buscar > para a classe < Concessionaria > em busca de listas   - Busca a lista do número de registros , Salva um novo registro, busca uma nova lista e compara se a lista foi atualizada.
*   
*  [R01]*  - TestRemover01 - Testa o método < Persistencia.remover > para a classe < Locatario >                           - Salva, remove e busca um registro no banco de dados, compara o objeto buscado com NULL.
*  [R02]  - TestRemover01 - Testa o método < Persistencia.remover > para a classe < Funcionario >                         - Salva, remove e busca um registro no banco de dados, compara o objeto buscado com NULL.
*  [R03]  - TestRemover01 - Testa o método < Persistencia.remover > para a classe < Equipamento >                           - Salva, remove e busca um registro no banco de dados, compara o objeto buscado com NULL.
*  [R04]  - TestRemover01 - Testa o método < Persistencia.remover > para a classe < Concessionaria >                         - Salva, remove e busca um registro no banco de dados, compara o objeto buscado com NULL.
* 
*  [A01]*  - TestAtualizar01 - Testa o método < Persistencia.atualizar > para a classe < Locatario >                       - Salva, Atualiza, busca e compara um resgistro no banco de dados.
*  [A02]  - TestAtualizar02 - Testa o método < Persistencia.atualizar > para a classe < Funcionario >                     - Salva, Atualiza, busca e compara um resgistro no banco de dados.
*  [A03]  - TestAtualizar01 - Testa o método < Persistencia.atualizar > para a classe < Equipamento >                       - Salva, Atualiza, busca e compara um resgistro no banco de dados.
*  [A04]  - TestAtualizar02 - Testa o método < Persistencia.atualizar > para a classe < Concessionaria >                     - Salva, Atualiza, busca e compara um resgistro no banco de dados.
*
*/
   
    
    @Test
    public void TestSalvar00() throws Exception {
        System.out.println("[S00]");
        
        Locatario salvo = (Locatario) Persistencia.salvar(locatarioTesteNOTOK);
        
        assertEquals(locatarioTesteNOTOK.getId(), salvo.getId());
    }
    
    @Test
    public void TestSalvar01() throws Exception {
        System.out.println("[S01]");
        
        Locatario salvo = (Locatario) Persistencia.salvar(locatarioTesteOK);
        
        assertEquals(locatarioTesteOK.getId(), salvo.getId());
    }
    
    @Test
    public void TestSalvar02() throws Exception {
        System.out.println("[S02]");
        Funcionario funcionarioTeste = new Funcionario();
        funcionarioTeste.setNome("Funcionario de Teste");
        
        Funcionario salvo = (Funcionario) Persistencia.salvar(funcionarioTeste);

        assertEquals(funcionarioTeste.getId(), salvo.getId());
    }

    @Test
    public void TestSalvar03() throws Exception {
        System.out.println("[S03]");
        Equipamento equipamentoTeste = new Equipamento();
        equipamentoTeste.setNome("Equipamento de Teste");
        equipamentoTeste.setSerie("Série de Teste");
        
        Equipamento salvo = (Equipamento) Persistencia.salvar(equipamentoTeste);

        assertEquals(equipamentoTeste.getId(), salvo.getId());
    }
    
    @Test
    public void TestSalvar04() throws Exception {
        System.out.println("[S04]");
        Concessionaria ConcessionariaTeste = new Concessionaria();
        ConcessionariaTeste.setNomeResponsavel("Responsável pela Concessionaria de Teste");
        
        Concessionaria salvo = (Concessionaria) Persistencia.salvar(ConcessionariaTeste);

        assertEquals(ConcessionariaTeste.getId(), salvo.getId());
    }
    
    @Test
    public void TestBuscar01() throws Exception {
        System.out.println("[B01]");
             
        Locatario salvo = (Locatario) Persistencia.salvar(locatarioTesteOK);
        Locatario busca = (Locatario) Persistencia.buscar(Locatario.class, salvo.getId());
        
        assertEquals(salvo.getId(), busca.getId());
    }
    
    @Test
    public void TestBuscar02() throws Exception {
        System.out.println("[B02]");
        Funcionario funcionarioTeste = new Funcionario();
        funcionarioTeste.setNome("Funcionario de Teste");
             
        Funcionario salvo = (Funcionario) Persistencia.salvar(funcionarioTeste);
        Funcionario busca = (Funcionario) Persistencia.buscar(Funcionario.class, salvo.getId());
        
        assertEquals(salvo.getId(), busca.getId());
    }
    
     @Test
    public void TestBuscar03() throws Exception {
        System.out.println("[B03]");
        Equipamento equipamentoTeste = new Equipamento();
        equipamentoTeste.setNome("Equipamento de Teste");
        equipamentoTeste.setSerie("Serie de Teste");
        
        Equipamento salvo = (Equipamento) Persistencia.salvar(equipamentoTeste);
        Equipamento busca = (Equipamento) Persistencia.buscar(Equipamento.class, salvo.getId());
        
        assertEquals(salvo.getId(), busca.getId());
    }

     @Test
    public void TestBuscar04() throws Exception {
        System.out.println("[B04]");
        Concessionaria concessionariaTeste = new Concessionaria();
        concessionariaTeste.setNome("Concessionaria de Teste");
             
        Concessionaria salvo = (Concessionaria) Persistencia.salvar(concessionariaTeste);
        Concessionaria busca = (Concessionaria) Persistencia.buscar(Concessionaria.class, salvo.getId());
        
        assertEquals(salvo.getId(), busca.getId());
    }
    
    @Test
    public void TestBuscarLista01() throws Exception {
        System.out.println("[L01]");       
        List<Object> lista = Persistencia.buscar("select loc from Locatario as loc");
        int qnt = lista.size();
        
        Locatario salvo = (Locatario) Persistencia.salvar(locatarioTesteOK);
        
        List<Object> listNew = Persistencia.buscar("select loc from Locatario as loc");
        int qntNew = listNew.size();

        assertEquals(qntNew,qnt+1);     
    }
    
    @Test
    public void TestBuscarLista02() throws Exception {
        System.out.println("[L02]");
        List<Object> lista = Persistencia.buscar("select loc from Locatario as loc");
        int qnt = lista.size();
        
        Funcionario funcionarioTeste = new Funcionario();
        funcionarioTeste.setNome("Funcionario de Teste");
             
        Funcionario salvo = (Funcionario) Persistencia.salvar(funcionarioTeste);
        
        List<Object> listNew = Persistencia.buscar("select loc from Locatario as loc");
        int qntNew = listNew.size();

        assertEquals(qntNew,qnt+1);     
    }
    
    @Test
    public void TestBuscarLista03() throws Exception {
        System.out.println("[L03]");
        List<Object> lista = Persistencia.buscar("select loc from Equipamento as loc");
        int qnt = lista.size();
        
        Equipamento equipamentoTeste = new Equipamento();
        equipamentoTeste.setNome("Equipamento de Teste");
        equipamentoTeste.setSerie("Série de Teste"); 
        
        Equipamento salvo = (Equipamento) Persistencia.salvar(equipamentoTeste);
        
        List<Object> listNew = Persistencia.buscar("select loc from Equipamento as loc");
        int qntNew = listNew.size();

        assertEquals(qntNew,qnt+1);     
    }
    
    @Test
    public void TestBuscarLista04() throws Exception {
        System.out.println("[L04]");
        List<Object> lista = Persistencia.buscar("select loc from Locatario as loc");
        int qnt = lista.size();
        
        Concessionaria ConcessionariaTeste = new Concessionaria();
        ConcessionariaTeste.setNome("Concessionaria de Teste");
             
        Concessionaria salvo = (Concessionaria) Persistencia.salvar(ConcessionariaTeste);
        
        List<Object> listNew = Persistencia.buscar("select loc from Locatario as loc");
        int qntNew = listNew.size();

        assertEquals(qntNew,qnt+1);     
    }

    @Test
    public void TestRemover01() throws Exception {
        System.out.println("[R01]");
             
        Locatario salvo = (Locatario) Persistencia.salvar(locatarioTesteOK);
        Persistencia.remover(locatarioTesteOK);
        Locatario busca = (Locatario) Persistencia.buscar(Locatario.class, salvo.getId());
        
        //assertEquals(salvo.getId(), busca.getId());
        assertNull(busca);
    }
    
    @Test
    public void TestRemover02() throws Exception {
        System.out.println("[R02]");
        Funcionario funcionarioTeste = new Funcionario();
        funcionarioTeste.setNome("Funcionario de Teste");
             
        Funcionario salvo = (Funcionario) Persistencia.salvar(funcionarioTeste);
        Persistencia.remover(funcionarioTeste);
        Funcionario busca = (Funcionario) Persistencia.buscar(Funcionario.class, salvo.getId());
        
        //assertEquals(salvo.getId(), busca.getId());
        assertNull(busca);
    }

    @Test
    public void TestRemover03() throws Exception {
        System.out.println("[R03]");
        Equipamento equipamentoTeste = new Equipamento();
        equipamentoTeste.setNome("Equipamento de Teste");
        equipamentoTeste.setSerie("Serie de Teste");
        
        Equipamento salvo = (Equipamento) Persistencia.salvar(equipamentoTeste);
        Persistencia.remover(equipamentoTeste);
        Equipamento busca = (Equipamento) Persistencia.buscar(Equipamento.class, salvo.getId());
        
        //assertEquals(salvo.getId(), busca.getId());
        assertNull(busca);
    }

    @Test
    public void TestRemover04() throws Exception {
        System.out.println("[R04]");
        Concessionaria ConcessionariaTeste = new Concessionaria();
        ConcessionariaTeste.setNome("Concessionaria de Teste");
             
        Concessionaria salvo = (Concessionaria) Persistencia.salvar(ConcessionariaTeste);
        Persistencia.remover(ConcessionariaTeste);
        Concessionaria busca = (Concessionaria) Persistencia.buscar(Funcionario.class, salvo.getId());
        
        //assertEquals(salvo.getId(), busca.getId());
        assertNull(busca);
    }
    
    @Test
    public void TestAtualizar01() throws Exception {
        System.out.println("[A01]");
        
        locatarioTesteOK.setNome("Locatario Desatualizado");
             
        Locatario salvo = (Locatario) Persistencia.salvar(locatarioTesteOK);
        
        locatarioTesteOK.setNome("Locatario Atualizado");
        Persistencia.atualizar(locatarioTesteOK);
        
        Locatario busca = (Locatario) Persistencia.buscar(Locatario.class, salvo.getId());
 
        assertSame("Locatario Atualizado", busca.getNome());
    }
    
    @Test
    public void TestAtualizar02() throws Exception {
        System.out.println("[A02]");
        Funcionario funcionarioTeste = new Funcionario();

        funcionarioTeste.setNome("Funcionario Desatualizado");
             
        Locatario salvo = (Locatario) Persistencia.salvar(funcionarioTeste);
        
        funcionarioTeste.setNome("Funcionario Atualizado");
        Persistencia.atualizar(funcionarioTeste);
        
        Locatario busca = (Locatario) Persistencia.buscar(Locatario.class, salvo.getId());
 
        assertSame("Funcionario Atualizado", busca.getNome());
    }

    @Test
    public void TestAtualizar03() throws Exception {
        System.out.println("[A03]");
        Equipamento equipamentoTeste = new Equipamento();

        equipamentoTeste.setNome("Equipamento Desatualizado");
        equipamentoTeste.setSerie("Serie de teste");
             
        Equipamento salvo = (Equipamento) Persistencia.salvar(equipamentoTeste);
        
        equipamentoTeste.setNome("Equipamento Atualizado");
        Persistencia.atualizar(equipamentoTeste);
        
        Equipamento busca = (Equipamento) Persistencia.buscar(Equipamento.class, salvo.getId());
 
        assertSame("Equipamento Atualizado", busca.getNome());
    }
    
    @Test
    public void TestAtualizar04() throws Exception {
        System.out.println("[A04]");
        Concessionaria concessionariaTeste = new Concessionaria();
        
        concessionariaTeste.setNome("Concessionaria Desatualizado");
             
        Concessionaria salvo = (Concessionaria) Persistencia.salvar(concessionariaTeste);
        
        concessionariaTeste.setNome("Concessionaria Atualizado");
        Persistencia.atualizar(concessionariaTeste);
        
        Concessionaria busca = (Concessionaria) Persistencia.buscar(Locatario.class, salvo.getId());
 
        assertSame("Concessionaria Atualizado", busca.getNome());
    }  
}