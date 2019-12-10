/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ativadi.model;

import Banco.BancoSingleton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Caio
 */
public class Professor {
    private int id;
    private String nome;

    public Professor(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Professor() {
    }
    

    public List<Professor> getAllProfessores() throws SQLException, ClassNotFoundException{
        ResultSet response = null;
        BancoSingleton banco = BancoSingleton.getInstance();
        String sql = "SELECT * FROM professor;";
        if (banco.getConexao()== null) {
           
            banco.conectar();
        }
        Statement sessao = banco.getConexao().createStatement();
        response = sessao.executeQuery(sql);
        List<Professor> professores = new ArrayList<>();
        while(response.next()){
            Professor professor = new Professor(response.getInt("id"), response.getString("nome"));
            professores.add(professor);
        }
        return professores;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
