/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.cefsa.fesa_share.models;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author MKarrer
 */
public class Imagem implements Serializable {

    private Integer codigo;
    private String nome;
    private byte[] conteudo;
    private String caminho;

    public Imagem(long aLong, String string, byte[] bytes, String caminho) {
        
    }
    
     public void setCodigo(int id) {
        this.codigo = id;
    }
     
    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }


    public Imagem() {
    }

    public Imagem(String nome, byte[] conteudo) {
        this.nome = nome;
        this.conteudo = conteudo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }
    
    @Override
	public String toString()
	{
            return this.getCodigo() + " " + this.getNome() + " " +
                   Arrays.toString(this.getConteudo())+ " " + this.getCaminho();
        }
}