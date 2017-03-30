/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Funcionario;
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
public class MainTest {
    
    public MainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFuncionario method, of class Main.
     */
    @Test
    public void testGetFuncionario() {
        System.out.println("getFuncionario");
        Funcionario expResult =  new Funcionario();
        Main.setFuncionario(expResult);
        Funcionario result = Main.getFuncionario();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFuncionario method, of class Main.
     */
    @Test
    public void testSetFuncionario() {
        System.out.println("setFuncionario");
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1);
        Main.setFuncionario(funcionario);
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Main.main(args);
    }
    @Test
    public void testMain2() throws Exception {
        System.out.println("main");
        String[] args = new String[]{"sdf"};
        Main.main(args);
    }
    
}
