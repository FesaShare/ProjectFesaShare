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
                                                result.getInt("QuantidadeDias"),
                                                result.getFloat("ValorAPagar"),
                                                result.getInt("LocadorID"),
                                                result.getInt("LocatarioID"))); 
                                                
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
            pStatement.setInt(1, e.getProdutoID());
            pStatement.setInt(2, e.getLocador().getCodigo());
            pStatement.setInt(3, e.getLocatario().getCodigo());
            pStatement.setInt(4, e.getQuantidadeDias());
            pStatement.setFloat(5, e.getValorAPagar());
            pStatement.execute();
            inserido = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            inserido = false;
            throw new PersistenciaException("N??o foi poss??vel carregar o driver de conex??o com a base de dados"); 
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
            pStatement.setInt(1, e.getQuantidadeDias());
            pStatement.setFloat(2, e.getValorAPagar());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("N??o foi poss??vel conectar ?? base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("N??o foi poss??vel enviar o comando para a base de dados!");
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
            throw new PersistenciaException("N??o foi poss??vel conectar ?? base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(SolicitacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("N??o foi poss??vel enviar o comando para a base de dados!");
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
                e.setQuantidadeDias(result.getInt("QuantidadeDias"));
                e.setValorAPagar(result.getFloat("ValorAPagar"));
                
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