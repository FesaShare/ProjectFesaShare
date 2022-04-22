/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.fesa_share.dao;

import br.edu.cefsa.fesa_share.exception.PersistenciaException;
import br.edu.cefsa.fesa_share.models.Fila;
import br.edu.cefsa.fesa_share.models.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class FilaDAO implements GenericoDAO<Fila> {

    @Override
    public List<Fila> listar() throws PersistenciaException {
        List<Fila> fila = new ArrayList();
        String sql = "SELECT * FROM FESASHARE.DBO.FILA";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                fila.add(new Fila(result.getInt("FilaID"), 
                                            result.getInt("PedidoID"),
                                            result.getInt("Posicao"),
                                            result.getString("Descricao"),
                                            result.getDate("DataPrevista").toLocalDate()));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(FilaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return fila;
    }

    @Override
    public boolean inserir(Fila e) throws PersistenciaException {
        String sql = "INSERT INTO FESASHARE.DBO.FILA (PedidoID,Posicao,Descricao,DataPrevista) VALUES (?)";
       boolean inserido = false;

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getPedido().getCodigo());
            pStatement.setInt(2, e.getPosicao());
            pStatement.setString(3, e.getDescricao());
            pStatement.setDate(4, (java.sql.Date) Date.from(e.getDataPrevista().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            
            //-------------Inserir para datas---------------------//
            
            pStatement.execute();
            inserido = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilaDAO.class.getName()).log(Level.SEVERE, null, ex);
            inserido = false;
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados"); 
        } catch (SQLException ex) {
            Logger.getLogger(FilaDAO.class.getName()).log(Level.SEVERE, null, ex);
            inserido = false;
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(FilaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return inserido;
    }

    @Override
    public void alterar(Fila e) throws PersistenciaException {
        String sql = "UPDATE FESASHARE.DBO.FILA SET POSICAO=?, DESCRICAO=?, DATAPREVISTA=? WHERE FILAID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getPosicao());
            pStatement.setString(2, e.getDescricao());
            pStatement.setDate(3, (java.sql.Date) Date.from(e.getDataPrevista().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pStatement.setInt(4, e.getCodigo());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível conectar à base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(FilaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível enviar o comando para a base de dados!");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(FilaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void remover(Fila e) throws PersistenciaException {
        String sql = "DELETE FROM FESASHARE.DBO.FILA WHERE FILAID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível conectar à base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(FilaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível enviar o comando para a base de dados!");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(FilaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Fila listarPorID(Fila e) throws PersistenciaException {
        String sql = "SELECT * FROM FESASHARE.DBO.FILA WHERE FilaID = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {

                e.setCodigo(result.getInt("FilaID"));
                PedidoDAO dao = new PedidoDAO();
                //e.setPedido(result.getObject(dao.listarPorID()));
                e.setPosicao(result.getInt("Posicao"));
                e.setDescricao(result.getString("Descricao"));
                e.setDataPrevista(result.getDate("DataPrevista").toLocalDate());
            //-------------Inserir para datas---------------------//
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(FilaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return e;
    }

}