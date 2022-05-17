/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.fesa_share.dao;

import br.edu.cefsa.fesa_share.exception.PersistenciaException;
import br.edu.cefsa.fesa_share.models.Reputacao;
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
public class ReputacaoDAO implements GenericoDAO<Reputacao>{

    @Override
    public List<Reputacao> listar() throws PersistenciaException {
        List<Reputacao> reputacoes = new ArrayList();
        String sql = "SELECT * FROM FESASHARE.DBO.REPUTACAO";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                reputacoes.add(new Reputacao(result.getInt("ReputacaoID"), 
                                            result.getString("Descricao")));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReputacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReputacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReputacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return reputacoes;
    }

    @Override
    public boolean inserir(Reputacao e) throws PersistenciaException {
        String sql = "INSERT INTO FESASHARE.DBO.REPUTACAO (DESCRICAO) VALUES (?)";
       boolean inserido = false;

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            pStatement.setString(2, e.getDescricao());
            
            pStatement.execute();
            inserido = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReputacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            inserido = false;
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados"); 
        } catch (SQLException ex) {
            Logger.getLogger(ReputacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            inserido = false;
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReputacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return inserido;
    }

    @Override
    public void alterar(Reputacao e) throws PersistenciaException {
        String sql = "UPDATE FESASHARE.DBO.REPUTACAO SET PRECO=? WHERE PAGAMENTOID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, e.getDescricao());
            pStatement.setInt(2, e.getCodigo());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReputacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível conectar à base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(ReputacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível enviar o comando para a base de dados!");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReputacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void remover(Reputacao e) throws PersistenciaException {
         String sql = "DELETE FROM FESASHARE.DBO.REPUTACAO WHERE PAGAMENTOID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível conectar à base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível enviar o comando para a base de dados!");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReputacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Reputacao listarPorID(Reputacao e) throws PersistenciaException {
         String sql = "SELECT * FROM FESASHARE.DBO.REPUTACAO WHERE PedidoID = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {

                e.setCodigo(result.getInt("PedidoID"));
                e.setDescricao(result.getString("Descricao"));
            //-------------Inserir para datas---------------------//
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReputacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReputacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReputacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return e;
    }
    
}
