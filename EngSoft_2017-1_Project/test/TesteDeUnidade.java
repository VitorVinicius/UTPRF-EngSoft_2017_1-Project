/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class TesteDeUnidade {
    
    public TesteDeUnidade() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("@BeforeClass");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("@BeforeClass");
    }
    
    @Before
    public void setUp() {
        System.out.println("@Before");
    }
    
    @After
    public void tearDown() {
        System.out.println("@After");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void teste01() {
        System.out.println("teste1");
    }
    @Test
    public void teste02() {
        System.out.println("teste2");
    }
    @Test
    public void teste03() {
        System.out.println("teste3");
    }
    @Test
    public void teste04() {
        System.out.println("teste4");
    }
}
