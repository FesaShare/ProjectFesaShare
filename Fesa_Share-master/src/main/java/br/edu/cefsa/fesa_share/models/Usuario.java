/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.fesa_share.models;

import java.io.Serializable;

/**
 *
 * @author USUARIO
 */
public class Usuario implements Serializable {

    public Usuario() {
    }

    public Usuario(int codigo, String nome, String senha, String email, String telefone, String endereco, Reputacao reputacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.reputacao = reputacao;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }


    private int codigo;
    private String nome;
    private Reputacao reputacao;
    private String senha;
    private String email;
    private String telefone;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Reputacao getReputacao() {
        return reputacao;
    }

    public void setReputacao(Reputacao reputacao) {
        this.reputacao = reputacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    @Override
	public String toString()
	{
            return this.getCodigo() + " " + this.getNome()+ " " + this.getSenha() + " " +
                   this.getEmail()+ " " + this.getTelefone()+ " " +this.getEndereco();
        }
        
        
}