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
public class Inquerito implements Serializable{

    public Inquerito() {
    }

    public Inquerito(int codigo, Byte bo) {
        this.codigo = codigo;
        this.bo = bo;
    }
    
    private int codigo;
    private Aluguel aluguel = new Aluguel();
    private Pendencia pendencia = new Pendencia();
    private Usuario usuario = new Usuario();
    private Byte bo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public Pendencia getPendencia() {
        return pendencia;
    }

    public void setPendencia(Pendencia pendencia) {
        this.pendencia = pendencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Byte getBo() {
        return bo;
    }

    public void setBo(Byte bo) {
        this.bo = bo;
    }
    
    
}