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

    public Solicitacao(int codigo, int qtdDias, float valor, int locadorID, int locatarioID) {
    }
    
    public int codigo;
    public int ProdutoID;
    public Usuario Locatario;
    public Usuario Locador;
    public int QuantidadeDias;
    public float ValorAPagar;

    public Solicitacao(int codigo, int ProdutoID, Usuario Locatario, Usuario Locador, int QuantidadeDias, float ValorAPagar) {
        this.codigo = codigo;
        this.ProdutoID = ProdutoID;
        this.Locatario = Locatario;
        this.Locador = Locador;
        this.QuantidadeDias = QuantidadeDias;
        this.ValorAPagar = ValorAPagar;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getProdutoID() {
        return ProdutoID;
    }

    public void setProdutoID(int ProdutoID) {
        this.ProdutoID = ProdutoID;
    }

    public Usuario getLocatario() {
        return Locatario;
    }

    public void setLocatario(Usuario Locatario) {
        this.Locatario = Locatario;
    }

    public Usuario getLocador() {
        return Locador;
    }

    public void setLocador(Usuario Locador) {
        this.Locador = Locador;
    }

    public int getQuantidadeDias() {
        return QuantidadeDias;
    }

    public void setQuantidadeDias(int QuantidadeDias) {
        this.QuantidadeDias = QuantidadeDias;
    }

    public float getValorAPagar() {
        return ValorAPagar;
    }

    public void setValorAPagar(float ValorAPagar) {
        this.ValorAPagar = ValorAPagar;
    }

    
    public float CalculaAluguel(Produto produto, Float precoTotal, int qtdDias){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}