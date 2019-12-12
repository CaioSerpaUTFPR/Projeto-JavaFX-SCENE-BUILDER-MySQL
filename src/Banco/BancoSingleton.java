/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import ativadi.model.Professor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Caio
 */
public class BancoSingleton { 
    private Connection conexao;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/ativadi";
    private String user = "root";
    private String senha = "";
    private static BancoSingleton instancia = new BancoSingleton();
    
    private BancoSingleton() {
      
    }
     public static BancoSingleton getInstance() {
        return instancia;
    }
    
    
    public void conectar() throws SQLException, ClassNotFoundException{
        Class.forName(getDriver());
        setConexao(DriverManager.getConnection(getUrl(), getUser(), getSenha()));
    }
    public void fecharConexao() throws SQLException{
        getConexao().close();
    }
    public boolean executarSQL(String sql) throws SQLException, ClassNotFoundException {
        if (getConexao()== null) {
           
            conectar();
        }
        Statement sessao = getConexao().createStatement();
        sessao.executeUpdate(sql);
        return true;
    }
    public ResultSet executarSQLRetorno(String sql) throws SQLException, ClassNotFoundException {
        ResultSet response = null;
        if (getConexao()== null) {
           
            conectar();
        }
        Statement sessao = getConexao().createStatement();
        response = sessao.executeQuery(sql);
        return response;
    }
    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
