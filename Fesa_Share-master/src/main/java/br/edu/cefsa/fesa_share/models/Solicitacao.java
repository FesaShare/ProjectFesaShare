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
public class Solicitacao implements Serializable{

    public Solicitacao() {
    }

    public Solicitacao(int codigo, int qtdDias, Float valor) {
        this.codigo = codigo;
        this.qtdDias = qtdDias;
        this.valor = valor;
    }
    
    
    public int codigo;
    public Produto produto = new Produto();
    public Usuario locador = new Usuario();
    public Usuario locatario = new Usuario();
    public int qtdDias;
    public Float valor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public int getQtdDias() {
        return qtdDias;
    }

    public void setQtdDias(int qtdDias) {
        this.qtdDias = qtdDias;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
    
    public Float CalculaAluguel(Produto produto, Float precoTotal, int qtdDias){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}