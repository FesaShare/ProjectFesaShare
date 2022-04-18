/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.fesa_share.dao;

import br.edu.cefsa.fesa_share.exception.PersistenciaException;
import br.edu.cefsa.fesa_share.models.Reputacao;
import br.edu.cefsa.fesa_share.models.Usuario;
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
public class UsuarioDAO implements GenericoDAO<Usuario>{

    @Override
    public List<Usuario> listar() throws PersistenciaException {
        List<Usuario> usuario = new ArrayList();
        String sql = "SELECT * FROM FESASHARE.DBO.USUARIO";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                usuario.add(new Usuario(result.getInt("UsuarioID"),
                                                result.getString("Nome"),
                                                (Reputacao) result.getObject("Reputacao"),
                                                result.getString("Senha"), 
                                                result.getString("Email"), 
                                                result.getString("Telefone"),
                                                result.getString("endereco")));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuario;
    }

    @Override
    public boolean inserir(Usuario e) throws PersistenciaException {
        String sql = "INSERT INTO FESASHARE.DBO.USUARIO (Nome, Senha, Email, Telefone, Endereco) VALUES (?)";
       boolean inserido = false;

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, e.getNome());
            pStatement.setString(2, e.getSenha());
            pStatement.setString(3, e.getEmail());
            pStatement.setString(4, e.getTelefone());
            pStatement.setString(5, e.getEndereco());
            pStatement.execute();
            inserido = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            inserido = false;
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados"); 
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            inserido = false;
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return inserido;
    }

    @Override
    public void alterar(Usuario e) throws PersistenciaException {
        String sql = "UPDATE FESASHARE.DBO.USUARIO SET Nome=?"
                                                    + "Senha=?"
                                                    + "Email=?"
                                                    + "Telefone=?"
                                                    + "Endereco=? WHERE USUARIOID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, e.getNome());
            pStatement.setString(2, e.getSenha());
            pStatement.setString(3, e.getEmail());
            pStatement.setString(4, e.getTelefone());
            pStatement.setString(5, e.getEndereco());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível conectar à base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível enviar o comando para a base de dados!");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void remover(Usuario e) throws PersistenciaException {
        String sql = "DELETE FROM FESASHARE.DBO.USUARIO WHERE USUARIOID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível conectar à base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível enviar o comando para a base de dados!");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Usuario listarPorID(Usuario e) throws PersistenciaException {
        String sql = "SELECT * FROM FESASHARE.DBO.USUARIO WHERE USUARIOID = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                e.setCodigo(result.getInt("UsuarioID"));
                e.setNome(result.getString("Nome"));
                e.setSenha(result.getString("Senha"));
                e.setEmail(result.getString("Email"));
                e.setTelefone(result.getString("Telefone"));
                e.setEndereco(result.getString("Endereco"));
                e.setReputacao((Reputacao) result.getObject("Reputacao"));
                
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return e;
    }
    
}
