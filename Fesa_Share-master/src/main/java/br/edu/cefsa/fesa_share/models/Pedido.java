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
    private int solicitacaoID;
    private Chat chat = new Chat();
    private Produto produto;
    private Usuario locador = new Usuario();
    private Usuario locatario = new Usuario();        
    private Pagamento pagamento;
    private Float precoAluguel;
    private String dataPedido;
    private Fila fila = new Fila();

    public Pedido(int codigo, int solicitacaoID, Produto produto, Pagamento pagamento, Float precoAluguel, String dataPedido) {
        this.codigo = codigo;
        this.solicitacaoID = solicitacaoID;
        this.produto = produto;
        this.pagamento = pagamento;
        this.precoAluguel = precoAluguel;
        this.dataPedido = dataPedido;
    }

    Pedido() {
    }

    public Pedido(int codigo, int produtoID, int locatarioID, int locadorID, int pagamentoID, float preco, String data_pedido, String data_devolucao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getSolicitacaoID() {
        return solicitacaoID;
    }

    public void setSolicitacaoID(int solicitacaoID) {
        this.solicitacaoID = solicitacaoID;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
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

    public Float getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(Float precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    
    
}