package Gerador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConexao {
    
    private Connection conn = null;
    public ResultSet rs;
    
    public boolean conectar(){
        try{
            String url = "jdbc:sqlite:dbsqlite.db";
            this.conn = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        System.out.println("Conectou");
        return true;
    }
    public boolean desconctar(){
        try{
            if (this.conn.isClosed() == false){
                this.conn.close();
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        System.out.println("desconectou");
        return true;
    }
    public boolean insert(String tabela, String[] colunas, String[] valores){
        System.out.println("inserindo");
        try{
            Statement stmt = this.conn.createStatement();
            String colunaString = String.join(",", colunas);
            String valorString = String.join(",", valores);
            String query = "INSERT INTO " + tabela + " (" + colunaString + ") VALUES (" + valorString + ")";
            stmt.executeUpdate(query);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean update(String tabela, String colunaAtualizar, String valorAtualizar, String colunaCondicao, String valorCondicao){
        System.out.println("atualizando");
        try{
            Statement stmt = this.conn.createStatement();
            String query = "UPDATE " + tabela + " SET " + colunaAtualizar + " = " + valorAtualizar + " WHERE " + colunaCondicao + " = " + valorCondicao;
            System.out.println(query);
            stmt.executeUpdate(query);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ResultSet select(String tabela, String[] colunas, String condicao){
        try{
            Statement stmt = this.conn.createStatement();
            String colunaString = (colunas != null && colunas.length > 0) ? String.join(",", colunas) : "*";
            String query = "SELECT " + colunaString + " FROM " + tabela;
            if (condicao != null && !condicao.isEmpty()){
                query += " WHERE " + condicao;
            }
            rs = stmt.executeQuery(query);
            return rs;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public boolean createTableIfNotExists(String tabela, String[] colunas) {
        try {
            Statement stmt = this.conn.createStatement();
            String colunaString = String.join(",", colunas);
            String query = "CREATE TABLE IF NOT EXISTS " + tabela + " (" + colunaString  + ")";
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
