/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excecoes;

import java.io.IOException;

/**
 *
 * @author Vitor
 */
public class ConfiguracoesException extends Exception {

    public ConfiguracoesException(String msg, IOException innerException) {
        super(msg,innerException);
    }

    public ConfiguracoesException(String msg) {
        super(msg);
    }
    
}
