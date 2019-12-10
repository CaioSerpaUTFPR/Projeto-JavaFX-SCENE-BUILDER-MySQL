/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Caio
 */
public class ConfigurarBD {
      public static void main( String args[] ) throws SQLException, ClassNotFoundException {
        BancoSingleton banco = BancoSingleton.getInstance();
        String[] sql;
        
        String filename = "C:\\Users\\Caio\\Documents\\NetBeansProjects\\AtivaDI\\src\\Banco\\Tabelas_Banco.txt";
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader in = new BufferedReader (fr);
            String aux;
            String lido="";
        while( (aux=in.readLine())!= null )
            lido += aux;
        in.close ();  
        sql = lido.split("#");
   
        //PERCORRE SQL[] E EXECUTA AS SQL NA CLASSE BANCO
        for (String sql1 : sql) {
            banco.executarSQL(sql1);
        }
        }catch( IOException e ) {
            System.out.println ("Erro na leitura");
        }
    } 
}
