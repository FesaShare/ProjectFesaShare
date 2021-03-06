/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.fesa_share.dao;

import br.edu.cefsa.fesa_share.exception.PersistenciaException;
import br.edu.cefsa.fesa_share.models.Pedido;
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
public class PedidoDAO implements GenericoDAO<Pedido> {

    @Override
    public List<Pedido> listar() throws PersistenciaException {
        List<Pedido> pedidos = new ArrayList();
        String sql = "SELECT * FROM FESASHARE.DBO.PEDIDO";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                pedidos.add(new Pedido(result.getInt("PedidoID"), 
                                            result.getInt("ProdutoID"),
                                            result.getInt("LocatarioID"),
                                            result.getInt("LocadorID"),
                                            result.getDouble("PrecoAluguel"),
                                            result.getInt("PagamentoID"),
                                            result.getString("DataPedido"),
                                            result.getString("DataPrevistaFim")));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pedidos;
    }

    @Override
    public boolean inserir(Pedido e) throws PersistenciaException {
        String sql = "INSERT INTO FESASHARE.DBO.PEDIDOS (DESCRICAO) VALUES (?)";
       boolean inserido = false;

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getProdutoID());
            pStatement.setInt(2, e.getLocatarioID());
            pStatement.setInt(3, e.getLocadorID());
            pStatement.setDouble(4, e.getPrecoAluguel());
            pStatement.setInt(5, e.getPagamentoID());
            pStatement.setString(6, e.getDataPedido());
            pStatement.setString(7, e.getDataDevolucao());
            //-------------Inserir para datas---------------------//
            
            pStatement.execute();
            inserido = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            inserido = false;
            throw new PersistenciaException("N??o foi poss??vel carregar o driver de conex??o com a base de dados"); 
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            inserido = false;
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return inserido;
    }

    @Override
    public void alterar(Pedido e) throws PersistenciaException {
        String sql = "UPDATE FESASHARE.DBO.PEDIDOS SET PRECO=? WHERE PAGAMENTOID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setDouble(1, e.getPrecoAluguel());
            pStatement.setInt(2, e.getCodigo());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("N??o foi poss??vel conectar ?? base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("N??o foi poss??vel enviar o comando para a base de dados!");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void remover(Pedido e) throws PersistenciaException {
        String sql = "DELETE FROM FESASHARE.DBO.PEDIDOS WHERE PAGAMENTOID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("N??o foi poss??vel conectar ?? base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("N??o foi poss??vel enviar o comando para a base de dados!");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Pedido listarPorID(Pedido e) throws PersistenciaException {
        String sql = "SELECT * FROM FESASHARE.DBO.PEDIDOS WHERE PedidoID = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {

                e.setCodigo(result.getInt("PedidoID"));
                e.setPrecoAluguel(result.getFloat("Preco"));
            //-------------Inserir para datas---------------------//
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return e;
    }
    
    public List<Pedido> listarPorLocatario(int codigo) throws PersistenciaException, SQLException {
        List<Pedido> pedidos = new ArrayList();
        String sql = "WITH added_row_number AS (" +
                    "SELECT *, ROW_NUMBER() OVER(PARTITION BY PRODUTOID ORDER BY DATAPEDIDO ASC) AS" +
                    "row_number" +
                    "FROM PEDIDO" +
                    ")" +
                    "SELECT PedidoID, ProdutoID, LocatarioID, LocadorID, PrecoAluguel, " +
                    "PagamentoID, DataPedido, DataPrevistaInicio, DataPrevistaFim" +
                    "FROM added_row_number" +
                    "WHERE row_number =1 AND LocatarioID = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, codigo);
            ResultSet result = pStatement.executeQuery();  
            System.out.println(result);
            if (result.next()) {
                pedidos.add(new Pedido(result.getInt("PedidoID"), 
                                            result.getInt("ProdutoID"),
                                            result.getInt("LocatarioID"),
                                            result.getInt("LocadorID"),
                                            result.getDouble("PrecoAluguel"),
                                            result.getInt("PagamentoID"),
                                            result.getString("DataPedido"),
                                            result.getString("DataPrevistaFim")));
                
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
        return pedidos;
    }
    
    public List<Pedido> listarPorLocador(int codigo) throws PersistenciaException {
        List<Pedido> pedidos = new ArrayList();
        String sql = "WITH added_row_number AS (" +
                    "SELECT *, ROW_NUMBER() OVER(PARTITION BY PRODUTOID ORDER BY DATAPEDIDO ASC) AS" +
                    "row_number" +
                    "FROM PEDIDO" +
                    ")" +
                    "SELECT PedidoID, ProdutoID, LocatarioID, LocadorID, PrecoAluguel, " +
                    "PagamentoID, DataPedido, DataPrevistaInicio, DataPrevistaFim" +
                    "FROM added_row_number" +
                    "WHERE row_number =1 AND LocadorID = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, codigo);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                pedidos.add(new Pedido(result.getInt("PedidoID"), 
                                            result.getInt("ProdutoID"),
                                            result.getInt("LocatarioID"),
                                            result.getInt("LocadorID"),
                                            result.getDouble("PrecoAluguel"),
                                            result.getInt("PagamentoID"),
                                            result.getString("DataPedido"),
                                            result.getString("DataPrevistaFim")));
                
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
        return pedidos;
    }
}
