/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.fesa_share.dao;

import br.edu.cefsa.fesa_share.exception.PersistenciaException;
import br.edu.cefsa.fesa_share.models.Solicitacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class SolicitacaoDAO implements GenericoDAO<Solicitacao> {

    @Override
    public List<Solicitacao> listar() throws PersistenciaException {
        /*Parei na metade*/
        List<Solicitacao> solicitacao = new ArrayList();
        String sql = "SELECT * FROM FESASHARE.DBO.SOLICITACAO";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                solicitacao.add(new Solicitacao(result.getInt("SolicitacaoID"),
                                                result.getInt("ProdutoID"),
                                                result.getInt("LocatarioID"),
                                                result.getInt("LocadorID"),
                                                result.getInt("QuantidadeDias"),
                                                result.getFloat("ValorAPagar"))); 
                                                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return solicitacao;
    }

    @Override
    public boolean inserir(Solicitacao e) throws PersistenciaException {
        String sql = "INSERT INTO FESASHARE.DBO.SOLICITACAO (ProdutoID, LocatarioID, LocadorID, QuantidadeDias, ValorAPagar) VALUES (?)";
       boolean inserido = false;

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getProduto().getCodigo());
            pStatement.setInt(2, e.getLocador().getCodigo());
            pStatement.setInt(3, e.getLocatario().getCodigo());
            pStatement.setInt(4, e.getQtdDias());
            pStatement.setFloat(5, e.getValor());
            pStatement.execute();
            inserido = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            inserido = false;
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados"); 
        } catch (SQLException ex) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            inserido = false;
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return inserido;
    }

    @Override
    public void alterar(Solicitacao e) throws PersistenciaException {
        String sql = "UPDATE FESASHARE.DBO.SOLICITACAO SET QUANTIDADEDIAS=?, VALORAPAGAR=? WHERE PAGAMENTOID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getQtdDias());
            pStatement.setFloat(2, e.getValor());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível conectar à base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível enviar o comando para a base de dados!");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void remover(Solicitacao e) throws PersistenciaException {
        String sql = "DELETE FROM FESASHARE.DBO.SOLICITACAO WHERE SOLICITACAOID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível conectar à base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível enviar o comando para a base de dados!");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Solicitacao listarPorID(Solicitacao e) throws PersistenciaException {
        String sql = "SELECT * FROM FESASHARE.DBO.SOLICITACAO WHERE SOLICITACAOID = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                e.setCodigo(result.getInt("SolicitacaoID"));
                e.setQtdDias(result.getInt("QuantidadeDias"));
                e.setValor(result.getFloat("ValorAPagar"));
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return e;
    }
    
    
}