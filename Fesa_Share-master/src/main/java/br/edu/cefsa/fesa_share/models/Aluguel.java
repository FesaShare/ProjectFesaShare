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
public class Aluguel implements Serializable{

    public Aluguel() {
    }

    public Aluguel(int codigo, LocalDateTime dataEmprestimo, LocalDateTime dataDevolucao, String status, String consideracoes, Chat chat, Inquerito inquerito) {
        this.codigo = codigo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.consideracoes = consideracoes;
        this.chat = chat;
        this.inquerito = inquerito;
    }
    
    private int codigo;
    private Pedido pedido = new Pedido();
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;
    private String status;
    private String consideracoes;
    private Chat chat;
    private Inquerito inquerito;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConsideracoes() {
        return consideracoes;
    }

    public void setConsideracoes(String consideracoes) {
        this.consideracoes = consideracoes;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Inquerito getInquerito() {
        return inquerito;
    }

    public void setInquerito(Inquerito inquerito) {
        this.inquerito = inquerito;
    }
    
    public void finalizaAluguel(LocalDateTime dataDevolucao){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}