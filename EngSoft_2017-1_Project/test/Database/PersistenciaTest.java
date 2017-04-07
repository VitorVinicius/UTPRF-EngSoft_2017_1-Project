/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

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
    
    public PersistenciaTest() {
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
        
    }
    
    @After
    public void tearDown() {
    }

/** Teste de Persistencia
* 
* Código - Nome          - Descrição                                                                                     - Critério de teste
*  [S01]  - TestSalvar01  - Testa o método < Persistencia.salvar > para classe < Locatario >                              - Compara o Id criado com o Id salvo no banco de dados.
*  [S02]  - TestSalvar02  - Testa o método < Persistencia.salvar > para classe < Funcionario >                            - Compara o Id criado com o Id salvo no banco de dados. 
* 
*  [B01]  - TestBuscar01  - Testa o método < Persistencia.buscar > para classe < Locatario >                              - Compara o Id buscado com o Id salvo no banco de dados.
*  [B02]  - TestBuscar02  - Testa o método < Persistencia.buscar > para classe < Funcionario >                            - Compara o Id buscado com o Id salvo no banco de dados.
* 
*  [L01]! - TestBuscarLista01 - Testa o método < Persistencia.buscar > para a classe < Locatario > em busca de listas     - Busca a lista do número de registros , Salva um novo registro, busca uma nova lista e compara se a lista foi atualizada.
*  [L02]! - TestBuscarLista01 - Testa o método < Persistencia.buscar > para a classe < Funcionario > em busca de listas   - Busca a lista do número de registros , Salva um novo registro, busca uma nova lista e compara se a lista foi atualizada.
*       ! -> Checar comando mySql // Minha intenção era consultar o número de registros total de cada classe, adicionar mais um e consultar novamente e comparar, porém sempre retorna o tamanho total da tabela. < Marcos Felipe >.
* 
*  [R01]  - TestRemover01 - Testa o método < Persistencia.remover > para a classe < Locatario >                           - Salva, remove e busca um registro no banco de dados, compara o objeto buscado com NULL.
*  [R02]  - TestRemover01 - Testa o método < Persistencia.remover > para a classe < Funcionario >                         - Salva, remove e busca um registro no banco de dados, compara o objeto buscado com NULL.
* 
*  [A01]  - TestAtualizar01 - Testa o método < Persistencia.atualizar > para a classe < Locatario >                       - Salva, Atualiza, busca e compara um resgistro no banco de dados.
*  [A02]  - TestAtualizar02 - Testa o método < Persistencia.atualizar > para a classe < Funcionario >                     - Salva, Atualiza, busca e compara um resgistro no banco de dados.
*/
    
    @Test
    public void TestSalvar01() throws Exception {
        System.out.println("[S01]");
        Locatario locatarioTeste = new Locatario();
        locatarioTeste.setNome("Locatario de Teste");
        
        Locatario salvo = (Locatario) Persistencia.salvar(locatarioTeste);
        
        assertEquals(locatarioTeste.getId(), salvo.getId());
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
    public void TestBuscar01() throws Exception {
        System.out.println("[B01]");
        Locatario locatarioTeste = new Locatario();
        locatarioTeste.setNome("Locatario de Teste");
             
        Locatario salvo = (Locatario) Persistencia.salvar(locatarioTeste);
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
    public void TestBuscarLista01() throws Exception {
        System.out.println("[L01]");       
        List<Object> lista = Persistencia.buscar("select loc from Locatario as loc");
        int qnt = lista.size();
        
        Locatario locatarioTeste = new Locatario();
        locatarioTeste.setNome("Locatario de Teste");
        
        Locatario salvo = (Locatario) Persistencia.salvar(locatarioTeste);
        
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
    public void TestRemover01() throws Exception {
        System.out.println("[R01]");
        Locatario locatarioTeste = new Locatario();
        locatarioTeste.setNome("Locatario de Teste");
             
        Locatario salvo = (Locatario) Persistencia.salvar(locatarioTeste);
        Persistencia.remover(locatarioTeste);
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
    public void TestAtualizar01() throws Exception {
        System.out.println("[A01]");
        Locatario locatarioTeste = new Locatario();
        locatarioTeste.setNome("Locatario de Teste");
        
        locatarioTeste.setNome("Locatario Desatualizado");
             
        Locatario salvo = (Locatario) Persistencia.salvar(locatarioTeste);
        
        locatarioTeste.setNome("Locatario Atualizado");
        Persistencia.atualizar(locatarioTeste);
        
        Locatario busca = (Locatario) Persistencia.buscar(Locatario.class, salvo.getId());
 
        assertSame("Locatario Atualizado", busca.getNome());
    }
    
    @Test
    public void TestAtualizar02() throws Exception {
        System.out.println("[A02]");
        Funcionario funcionarioTeste = new Funcionario();
        funcionarioTeste.setNome("Funcionario de Teste");

        funcionarioTeste.setNome("Funcionario Desatualizado");
             
        Locatario salvo = (Locatario) Persistencia.salvar(funcionarioTeste);
        
        funcionarioTeste.setNome("Funcionario Atualizado");
        Persistencia.atualizar(funcionarioTeste);
        
        Locatario busca = (Locatario) Persistencia.buscar(Locatario.class, salvo.getId());
 
        assertSame("Funcionario Atualizado", busca.getNome());
    }
}