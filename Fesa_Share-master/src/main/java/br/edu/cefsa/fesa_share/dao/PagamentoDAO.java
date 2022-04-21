/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.fesa_share.dao;

import br.edu.cefsa.fesa_share.exception.PersistenciaException;
import br.edu.cefsa.fesa_share.models.Pagamento;
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
public class PagamentoDAO implements GenericoDAO<Pagamento>{

    @Override
    public List<Pagamento> listar() throws PersistenciaException {
        List<Pagamento> pagamentos = new ArrayList();
        String sql = "SELECT * FROM FESASHARE.DBO.PAGAMENTO";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                pagamentos.add(new Pagamento(result.getInt("PagamentoID"),
                                                result.getInt("PedidoID"),
                                                result.getString("Descricao"), 
                                                result.getFloat("Preco"), 
                                                result.getInt("Parcelas"),
                                                result.getString("DiaPagamento")));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pagamentos;
    }

    @Override
    public boolean inserir(Pagamento e) throws PersistenciaException {
       String sql = "INSERT INTO FESASHARE.DBO.PAGAMENTO (DESCRICAO) VALUES (?)";
       boolean inserido = false;

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getPedido().getCodigo());
            pStatement.setString(2, e.getDescricao());
            pStatement.setFloat(3, e.getPreco());
            pStatement.setInt(4, e.getParcelas());
            pStatement.setString(5, e.getDiaPagamento());
            pStatement.execute();
            inserido = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            inserido = false;
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados"); 
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            inserido = false;
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return inserido;
    }

    @Override
    public int alterar(Pagamento e) throws PersistenciaException {
        String sql = "UPDATE FESASHARE.DBO.PAGAMENTO SET PRECO=? WHERE PAGAMENTOID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setFloat(1, e.getPreco());
            pStatement.setInt(2, e.getCodigo());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível conectar à base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível enviar o comando para a base de dados!");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void remover(Pagamento e) throws PersistenciaException {
        String sql = "DELETE FROM FESASHARE.DBO.PAGAMENTO WHERE PAGAMENTOID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível conectar à base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível enviar o comando para a base de dados!");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Pagamento listarPorID(Pagamento e) throws PersistenciaException {
        String sql = "SELECT * FROM FESASHARE.DBO.PAGAMENTO WHERE PagamentoID = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                e.setCodigo(result.getInt("PedidoID"));
                e.setDescricao(result.getString("Descricao"));
                e.setPreco(result.getFloat("Preco"));
                e.setParcelas(result.getInt("Parcelas"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return e;
    }
    
}
