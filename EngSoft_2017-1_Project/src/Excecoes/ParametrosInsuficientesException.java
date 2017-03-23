/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excecoes;

/**
 *
 * @author Vitor
 */
public class ParametrosInsuficientesException extends Exception {
    public ParametrosInsuficientesException(){
        super();
    }
    public ParametrosInsuficientesException(String msg){
        super(msg);
    }
    public ParametrosInsuficientesException(String msg,Exception innerException){
        super(msg,innerException);
    }
}
