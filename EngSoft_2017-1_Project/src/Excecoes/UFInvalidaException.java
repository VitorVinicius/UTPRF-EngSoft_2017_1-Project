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
public class UFInvalidaException extends Exception {
    public UFInvalidaException(String msg, Exception ex){
        super(msg,ex);
    }
}
