/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gerador;

import java.util.ArrayList;

/**
 *
 * @author cassi
 */
public class Acessos_DAO {
    
    public ArrayList<String> Apelido, Login, Senha;
    public int id;
    private String ConteudoQR;
    public Acessos_DAO() {
        this.Apelido = new ArrayList<>();
        this.Senha = new ArrayList<>();
        this.Login = new ArrayList<>();
    }
    
    public void addID(int ID){
        this.id = ID;
    }
    
    public int getID(){
        return id;
    }
    
    public void addApelido(String apelido){
        this.Apelido.add(apelido);
    }
    
    public void alteraApelido(int id,String apelido){
        this.Apelido.add(id, apelido);
    }
    
    public String getApelido(int i){
        return Apelido.get(i);
    }
    
    public void addLogin(String login){
        this.Login.add(login);
    }
    
    public void alterarLogin(int id, String login){
        this.Login.add(id, login);
    }
    
    public String getLogin(int i){
        return Login.get(i);
    }
    
    public void addSenha(String senha){
        this.Senha.add(senha);
    }
    
    public void alterarSenha(int id, String senha){
        this.Senha.add(id, senha);
    }
    
    public String getSenha(int i){
        return Senha.get(i);
    }
    
    public String getConteudoQR(){
        return ConteudoQR;
    }
    
    public void setConteudoQR(String conteudo){
        ConteudoQR = conteudo;
    }
}
