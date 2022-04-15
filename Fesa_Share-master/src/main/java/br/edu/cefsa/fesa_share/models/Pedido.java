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
public class Pedido implements Serializable{

    public Pedido() {
    }

    public Pedido(int codigo, Float preco, Pagamento pagamento) {
        this.codigo = codigo;
        this.preco = preco;
        this.pagamento = pagamento;
    }
    
    private int codigo;
    private Float preco;
    private Produto produto = new Produto();
    private Usuario locador = new Usuario();
    private Usuario locatario = new Usuario();        
    private Pagamento pagamento;

    public Pedido(int aInt, int aInt0, int aInt1, int aInt2, float aFloat, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Usuario getLocador() {
        return locador;
    }

    public void setLocador(Usuario locador) {
        this.locador = locador;
    }

    public Usuario getLocatario() {
        return locatario;
    }

    public void setLocatario(Usuario locatario) {
        this.locatario = locatario;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
    
}
