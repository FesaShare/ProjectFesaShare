/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.fesa_share.validacao;

import br.edu.cefsa.fesa_share.dao.Conexao;
import br.edu.cefsa.fesa_share.dao.ProdutoDAO;
import br.edu.cefsa.fesa_share.models.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class ValidacaoAluguel {
    public static int isAlugado(String status, Produto e){
        int count = 0;
        if("Alugado".equals(status)){
            String sql = "SELECT COUNT(*) AS QTD FROM FESASHARE.DBO.ALUGUEL WHERE ProdutoID = ?";
            Connection connection = null;
             
            try {
                connection = Conexao.getInstance().getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql);
                pStatement.setInt(1, e.getCodigo());
                ResultSet result = pStatement.executeQuery();
                if(result.next()){
                    count = result.getInt(1); 
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return count;
    }
    
    public static int isDisponivel(String status, Produto e){
        int count = 0;
        if("Disponível".equals(status)){
            String sql = "SELECT COUNT(*) AS QTD FROM FESASHARE.DBO.ALUGUEL WHERE ProdutoID = ?";
            Connection connection = null;
             
            try {
                connection = Conexao.getInstance().getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql);
                pStatement.setInt(1, e.getCodigo());
                ResultSet result = pStatement.executeQuery();
                if(result.next()){
                    count = result.getInt(1); 
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return count;
    }
}
