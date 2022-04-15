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
public class Produto implements Serializable{
    //TODO: procurar como armazenar uma imagem e adiocionar o novo campo, get set e no construtor
    public Produto() {
    }

    public Produto(int codigo, String descricao, String consicao, String aluguel) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.consicao = consicao;
        this.aluguel = aluguel;
    }
    
    private int codigo;
    private String descricao;
    private String consicao;
    private String aluguel; //ALUGADO, DISPONIVEL, EM TRANSAÇÃO
    private Usuario usuario = new Usuario();
    private Categoria categoria = new Categoria();

    public Produto(int aInt, int aInt0, int aInt1, float aFloat, float aFloat0, String string, String string0, String string1, String string2, String string3, String string4) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConsicao() {
        return consicao;
    }

    public void setConsicao(String consicao) {
        this.consicao = consicao;
    }

    public String getAluguel() {
        return aluguel;
    }

    public void setAluguel(String aluguel) {
        this.aluguel = aluguel;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
}

