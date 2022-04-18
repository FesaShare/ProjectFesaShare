/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.fesa_share.dao;

import br.edu.cefsa.fesa_share.exception.PersistenciaException;
import br.edu.cefsa.fesa_share.models.Produto;
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
public class ProdutoDAO implements GenericoDAO<Produto>{

    @Override
    public List<Produto> listar() throws PersistenciaException {
       List<Produto> pedidos = new ArrayList();
        String sql = "SELECT * FROM FESASHARE.DBO.PRODUTO";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                pedidos.add(new Produto(result.getInt("ProdutoID"), 
                                            result.getInt("UsuarioID"),
                                            result.getInt("CategoriaID"),
                                            result.getFloat("Preco_total"),
                                            result.getFloat("Preco_Aluguel"),
                                            result.getString("Condicao"),
                                            result.getString("Descricao"),
                                            result.getString("Aluguel_Status"),
                                            result.getString("ImagemId"),
                                            result.getString("Detalhes"),
                                            result.getString("Tempo_Uso")));
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
        return pedidos;
    }

    @Override
    public boolean inserir(Produto e) throws PersistenciaException {
         String sql = "INSERT INTO FESASHARE.DBO.PRODUTO (DESCRICAO) VALUES (?)";
       boolean inserido = false;

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            pStatement.setInt(2, e.getUsuario().getCodigo());
            pStatement.setInt(3, e.getCategoria().getCodigo());
            pStatement.setString(4, e.getAluguel()); // Criar modelo/método para calcular preço total
            pStatement.setString(5, e.getAluguel());  // Criar modelo/método para mostrar preço unitário
            pStatement.setString(6, e.getConsicao());
            pStatement.setString(7, e.getAluguel()); // Aluguel Status
            pStatement.setString(8, e.getAluguel()); // Imagem Id
            pStatement.setString(9, e.getAluguel()); // Detalhes
            pStatement.setString(10, e.getAluguel()); // Tempo de Uso
            //-------------Inserir para datas---------------------//
            
            pStatement.execute();
            inserido = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            inserido = false;
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados"); 
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            inserido = false;
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return inserido;
    }

    @Override
    public void alterar(Produto e) throws PersistenciaException {
         String sql = "UPDATE FESASHARE.DBO.PRODUTO SET PRECO=? WHERE PAGAMENTOID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, e.getDescricao());
            pStatement.setInt(2, e.getCodigo());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível conectar à base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível enviar o comando para a base de dados!");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void remover(Produto e) throws PersistenciaException {
        String sql = "DELETE FROM FESASHARE.DBO.PRODUTOS WHERE PAGAMENTOID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível conectar à base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível enviar o comando para a base de dados!");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Produto listarPorID(Produto e) throws PersistenciaException {
        String sql = "SELECT * FROM FESASHARE.DBO.PRODUTOS WHERE PedidoID = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {

                e.setCodigo(result.getInt("ProdutoID"));
                e.setDescricao(result.getString("Descricao"));
            //-------------Inserir para datas---------------------//
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
        return e;
    }
    
    public Produto listarPorCategoria(Produto e) throws PersistenciaException {
        String sql = "SELECT * FROM FESASHARE.DBO.PRODUTOS WHERE CategoriaID = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCategoria().getCodigo());
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {

                e.setCodigo(result.getInt("ProdutoID"));
                e.setDescricao(result.getString("Descricao"));
            //-------------Inserir para datas---------------------//
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
        return e;
    }
    
    public Produto listarPorCondicao(Produto e) throws PersistenciaException {
        String sql = "SELECT * FROM FESASHARE.DBO.PRODUTOS WHERE Condicao = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, e.getCondicao());
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {

                e.setCodigo(result.getInt("ProdutoID"));
                e.setDescricao(result.getString("Descricao"));
            //-------------Inserir para datas---------------------//
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
        return e;
    }
    
    public Produto listarPorStatus(Produto e) throws PersistenciaException {
        String sql = "SELECT * FROM FESASHARE.DBO.PRODUTOS WHERE AluguelStatus = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, e.getAluguelStatus());
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {

                e.setCodigo(result.getInt("ProdutoID"));
                e.setDescricao(result.getString("Descricao"));
            //-------------Inserir para datas---------------------//
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
        return e;
    }
    
    public Produto listarPorDescricao(Produto e) throws PersistenciaException {
        String sql = "SELECT * FROM FESASHARE.DBO.PRODUTOS WHERE Descricao LIKE %?%";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, e.getDescricao());
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {

                e.setCodigo(result.getInt("ProdutoID"));
                e.setDescricao(result.getString("Descricao"));
            //-------------Inserir para datas---------------------//
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
        return e;
    }
}
