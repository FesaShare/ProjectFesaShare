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
    
    private int codigo;
    private int usuarioID;
    private int categoriaID;
    private double precoTotal;
    private String condicao;
    private String titulo;
    private String descricao;
    private String aluguelStatus; //ALUGADO, DISPONIVEL, EM TRANSAÇÃO
    private int imagemID;
    private String detalhes;
    private int tempoUso;

    public Produto(int codigo, int usuarioID, int categoriaID, double precoTotal, String condicao, String titulo, String descricao, String aluguelStatus, int imagemID, String detalhes, int tempoUso) {
        this.codigo = codigo;
        this.usuarioID = usuarioID;
        this.categoriaID = categoriaID;
        this.precoTotal = precoTotal;
        this.condicao = condicao;
        this.titulo = titulo;
        this.descricao = descricao;
        this.aluguelStatus = aluguelStatus;
        this.imagemID = imagemID;
        this.detalhes = detalhes;
        this.tempoUso = tempoUso;
    }
    
    public Produto() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAluguelStatus() {
        return aluguelStatus;
    }

    public void setAluguelStatus(String aluguelStatus) {
        this.aluguelStatus = aluguelStatus;
    }

    public int getImagemID() {
        return imagemID;
    }

    public void setImagemID(int imagemID) {
        this.imagemID = imagemID;
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
    
    @Override
	public String toString()
	{
            return this.getCodigo() + " " + this.getTitulo()+ " " + this.getDescricao()+ " " + 
                   this.getDetalhes()+ " " + this.getUsuarioID() + " " + this.getCategoriaID()+ " " + 
                   this.getAluguelStatus()+ " " + this.getImagemID()+ " " + this.getPrecoTotal()+ " " + 
                    this.getTempoUso();
        }
    
    public Float depreciacao(Float precoTotal, int tempoUso){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void mudaStatusProduto(){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}