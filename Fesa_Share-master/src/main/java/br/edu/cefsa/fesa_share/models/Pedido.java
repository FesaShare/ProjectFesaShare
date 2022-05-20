/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.fesa_share.models;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author USUARIO
 */
public class Pedido implements Serializable{
    
    private int codigo;
    private int chatID;
    private int produtoID;
    private int locadorID;
    private int locatarioID;        
    private int pagamentoID;
    private double precoAluguel;
    private String dataPedido;
    private String dataDevolucao;


    Pedido() {
    }

    public Pedido(int codigo, int produtoID, int locatarioID, int locadorID, double precoAluguel, int pagamentoID, String data_pedido, String data_devolucao) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        this.codigo = codigo;
        this.locatarioID = locatarioID;
        this.locadorID = locadorID;
        this.produtoID = produtoID;
        this.pagamentoID = pagamentoID;
        this.precoAluguel = precoAluguel;
        this.dataPedido = data_pedido;
        this.dataDevolucao = data_devolucao;
    
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    
    public double getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(double precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public int getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

    public int getLocadorID() {
        return locadorID;
    }

    public void setLocadorID(int locadorID) {
        this.locadorID = locadorID;
    }

    public int getLocatarioID() {
        return locatarioID;
    }

    public void setLocatarioID(int locatarioID) {
        this.locatarioID = locatarioID;
    }

    public int getPagamentoID() {
        return pagamentoID;
    }

    public void setPagamentoID(int pagamentoID) {
        this.pagamentoID = pagamentoID;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
 
    
}