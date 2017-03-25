/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Excecoes.ConfiguracoesException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
/**
 *
 * @author Vitor
 */

public class Propiedades {
    private static Properties prop;
    private static final String CAMINHO_ARQUIVO_CONFIGURACAO = "locadora.cfg";
    public static Boolean checarArquivoExiste(){
         File f = new File(CAMINHO_ARQUIVO_CONFIGURACAO);
        if(f.exists() && f.isFile()) { 
            return true;
        }
        return false;
    } 
    
    public static void carregarOuGerarArquivo() throws ConfiguracoesException{
        
       if(!checarArquivoExiste()){
            OutputStream output = null;

              try {

                      output = new FileOutputStream(CAMINHO_ARQUIVO_CONFIGURACAO);
                      prop = new Properties();
                      prop.store(output, "Arquivo de configuração");

              } catch (IOException io) {
                      throw new Excecoes.ConfiguracoesException("Erro ao carregar configurações: "+ io.getMessage(),io);

              } finally {
                      if (output != null) {
                              try {
                                      output.close();
                              } catch (IOException e) {
                                  throw new Excecoes.ConfiguracoesException("Erro ao carregar configurações: "+ e.getMessage(),e);
                              }
                      }

              }
       }
       else{
            InputStream input = null;

            try {

                    input = new FileInputStream(CAMINHO_ARQUIVO_CONFIGURACAO);
                    if(prop == null)
                        prop = new Properties();
                    prop.load(input);

            } catch (IOException io) {
                    throw new Excecoes.ConfiguracoesException("Erro ao carregar configurações: "+ io.getMessage(),io);
            } finally {
                    if (input != null) {
                            try {
                                    input.close();
                            } catch (IOException e) {
                                            throw new Excecoes.ConfiguracoesException("Erro ao carregar configurações: "+ e.getMessage(),e);
                            }
                    }

            }
       }
    }
    
    public static void setPropiedade(String nome,String valor) throws ConfiguracoesException{
        
       if(!checarArquivoExiste()){
           throw new Excecoes.ConfiguracoesException("O arquivo de configuração ainda não foi gerado.");
       }
        
	OutputStream output = null;

	try {

		output = new FileOutputStream(CAMINHO_ARQUIVO_CONFIGURACAO);
                prop.setProperty(nome, valor);

		// save properties to project root folder
		prop.store(output, null);

	} catch (IOException io) {
                    throw new Excecoes.ConfiguracoesException("Erro ao escrever configuração '"+nome+"': "+ io.getMessage(),io);
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
                            throw new Excecoes.ConfiguracoesException("Erro ao escrever configuração '"+nome+"': "+ e.getMessage(),e);

			}
		}

	}
    
    }
    
    public static String getPropiedade(String nome) throws ConfiguracoesException{
        if(!checarArquivoExiste()){
           throw new Excecoes.ConfiguracoesException("O arquivo de configuração ainda não foi gerado.");
        }
        return prop.getProperty(nome);
    }

}
