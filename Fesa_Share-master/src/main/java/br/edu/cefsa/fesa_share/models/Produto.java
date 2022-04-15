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

    public Produto(int codigo, String descricao, String condicao, String aluguelStatus, Float precoTotal, String detalhes, int tempoUso) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.condicao = condicao;
        this.aluguelStatus = aluguelStatus;
        this.precoTotal = precoTotal;
        this.detalhes = detalhes;
        this.tempoUso = tempoUso;
    }
    
        public Produto(int codigo, int usuarioID, int categoriaID, Float precoTotal, Float precoAluguel, String condicao, String descricao, String aluguelStatus, String imagemID, String detalhes, String tempoUso ) {

    }

    private int codigo;
    private String descricao;
    private String condicao;
    private String aluguelStatus; //ALUGADO, DISPONIVEL, EM TRANSAÇÃO
    private Float precoTotal;
    private String detalhes;
    private int tempoUso;
    private Usuario usuario = new Usuario();
    private Categoria categoria = new Categoria();

    

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public String getAluguelStatus() {
        return aluguelStatus;
    }

    public void setAluguelStatus(String aluguelStatus) {
        this.aluguelStatus = aluguelStatus;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public int getTempoUso() {
        return tempoUso;
    }

    public void setTempoUso(int tempoUso) {
        this.tempoUso = tempoUso;
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
        return condicao;
    }

    public void setConsicao(String consicao) {
        this.condicao = consicao;
    }

    public String getAluguel() {
        return aluguelStatus;
    }

    public void setAluguel(String aluguel) {
        this.aluguelStatus = aluguel;
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

    public Float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Float precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Float depreciacao(Float precoTotal, int tempoUso){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void mudaStatusProduto(){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}