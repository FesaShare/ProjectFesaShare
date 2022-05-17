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
public class Pendencia implements Serializable{

    public Pendencia() {
    }

    public Pendencia(int codigo, LocalDate dataPendencia) {
        this.codigo = codigo;
        this.dataPendencia = dataPendencia;
    }
    
    private int codigo;
    private Aluguel aluguel = new Aluguel();
    private Usuario usuario = new Usuario();
    private LocalDate dataPendencia;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataPendencia() {
        return dataPendencia;
    }

    public void setDataPendencia(LocalDate dataPendencia) {
        this.dataPendencia = dataPendencia;
    }
    
    public Float CalculaJuros(Float preco, LocalDate dataPendencia){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}