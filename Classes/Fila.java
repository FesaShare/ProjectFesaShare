/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.fesa_share.models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author USUARIO
 */
public class Fila implements Serializable{

    public Fila() {
    }

    public Fila(int codigo, int posicao, String descricao, LocalDate dataPrevista) {
        this.codigo = codigo;
        this.posicao = posicao;
        this.descricao = descricao;
        this.dataPrevista = dataPrevista;
    }

     public Fila(int codigo, int pedidoID, int posicao, String descricao, LocalDate dataPrevista) {
         throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }
     
    
    private int codigo;
    private Pedido pedido = new Pedido();
    private int posicao;
    private String descricao;
    private LocalDate dataPrevista;

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(LocalDate dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}