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
public class Pagamento implements Serializable{

    public Pagamento() {
    }

    public Pagamento(int codigo, String descricao, Float preco, int parcelas, LocalDateTime diaPagamento) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.parcelas = parcelas;
        this.diaPagamento = diaPagamento;
    }
    
    
    private int codigo;
    private String descricao;
    private Float preco;
    private int parcelas;
    private Pedido pedido = new Pedido();
    private LocalDateTime diaPagamento;

    public LocalDateTime getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(LocalDateTime diaPagamento) {
        this.diaPagamento = diaPagamento;
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

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    
}