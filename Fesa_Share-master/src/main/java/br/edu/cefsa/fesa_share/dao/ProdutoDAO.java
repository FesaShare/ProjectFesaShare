/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.fesa_share.dao;

import br.edu.cefsa.fesa_share.exception.PersistenciaException;
import br.edu.cefsa.fesa_share.models.Produto;
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
public class ProdutoDAO implements GenericoDAO<Produto>{

    @Override
    public List<Produto> listar() throws PersistenciaException {
       List<Produto> produtos = new ArrayList();
        String sql = "SELECT * FROM FESASHARE.DBO.PRODUTO";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                produtos.add(new Produto(result.getInt("ProdutoID"), 
                                            result.getInt("UsuarioID"),
                                            result.getInt("CategoriaID"),
                                            result.getDouble("PrecoTotal"),
                                            result.getString("Condicao"),
                                            result.getString("Titulo"),
                                            result.getString("Descricao"),
                                            result.getString("AluguelStatus"),
                                            result.getInt("ImagemID"),
                                            result.getString("Detalhes"),
                                            result.getInt("TempoUso")));
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
        return produtos;
    }

    @Override
    public boolean inserir(Produto e) throws PersistenciaException {
         String sql = "INSERT INTO FESASHARE.DBO.PRODUTO (UsuarioID,CategoriaID, PrecoTotal,"
                 + " Condicao, Titulo, Descricao, AluguelStatus,ImagemID,Detalhes,TempoUso) "
                 + "VALUES (?,?,?,?,?,?,?,?,?,?)";
       boolean inserido = false;

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getUsuarioID());
            pStatement.setInt(2, e.getCategoriaID());
            pStatement.setDouble(3, e.getPrecoTotal()); // Criar modelo/m??todo para calcular pre??o total
            pStatement.setString(4, e.getCondicao());  // Criar modelo/m??todo para mostrar pre??o unit??rio
            pStatement.setString(5, e.getTitulo());
            pStatement.setString(6, e.getDescricao()); 
            pStatement.setString(7, e.getAluguelStatus()); 
            pStatement.setInt(8, e.getImagemID()); 
            pStatement.setString(9, e.getDetalhes()); 
            pStatement.setInt(10, e.getTempoUso());
            //-------------Inserir para datas---------------------//
            
            pStatement.execute();
            inserido = true;
            
            String sql2 = "select top 1 ProdutoID from FESASHARE.DBO.PRODUTO order by ProdutoID desc"; 
            PreparedStatement pStatement2 = connection.prepareStatement(sql2);
            ResultSet result = pStatement2.executeQuery();
            if (result.next())
            {
                e.setCodigo(result.getInt(1));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            inserido = false;
            throw new PersistenciaException("N??o foi poss??vel carregar o driver de conex??o com a base de dados"); 
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
         String sql = "UPDATE FESASHARE.DBO.PRODUTO SET UsuarioID=?, CategoriaID=?,"
                 + "PrecoTotal=?,Condicao=?,Titulo=?,"
                 + "Descricao=?,AluguelStatus=?,"
                 + "ImagemID=?,Detalhes=?,TempoUso=? WHERE ProdutoID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
             pStatement.setInt(1, e.getUsuarioID());
            pStatement.setInt(2, e.getCategoriaID());
            pStatement.setDouble(3, e.getPrecoTotal()); 
            pStatement.setString(4, e.getCondicao());  
            pStatement.setString(5, e.getTitulo());
            pStatement.setString(6, e.getDescricao()); 
            pStatement.setString(7, e.getAluguelStatus()); 
            pStatement.setInt(8, e.getImagemID()); 
            pStatement.setString(9, e.getDetalhes()); 
            pStatement.setInt(10, e.getTempoUso());
            pStatement.setInt(11, e.getCodigo());
            pStatement.execute();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("N??o foi poss??vel conectar ?? base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("N??o foi poss??vel enviar o comando para a base de dados!");
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
        String sql = "DELETE FROM FESASHARE.DBO.PRODUTO WHERE ProdutoID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("N??o foi poss??vel conectar ?? base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("N??o foi poss??vel enviar o comando para a base de dados!");
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
        String sql = "SELECT * FROM FESASHARE.DBO.PRODUTO WHERE ProdutoID = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, e.getCodigo());
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                
                e.setCodigo(result.getInt("ProdutoID"));
                e.setUsuarioID(result.getInt("UsuarioID"));
                e.setCategoriaID(result.getInt("CategoriaID"));
                e.setPrecoTotal(result.getDouble("PrecoTotal"));
                e.setCondicao(result.getString("Condicao"));
                e.setTitulo(result.getString("Titulo"));
                e.setDescricao(result.getString("Descricao"));
                e.setAluguelStatus(result.getString("AluguelStatus"));
                e.setImagemID(result.getInt("ImagemID"));
                e.setDetalhes(result.getString("Detalhes"));
                e.setTempoUso(result.getInt("TempoUso"));
                
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
    
    public List<Produto> listarPorFiltro(String condicao, int categoria, String titulo) throws PersistenciaException {
        List<Produto> produtos = new ArrayList();
        String sql = "EXEC sp_filtro_produto @ICONDICAO = ?, @ICATEGORIA = ?, @ITITULO = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, condicao);
            pStatement.setInt(2, categoria);
            pStatement.setString(3, titulo);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                produtos.add(new Produto(result.getInt("ProdutoID"), 
                                            result.getInt("UsuarioID"),
                                            result.getInt("CategoriaID"),
                                            result.getDouble("PrecoTotal"),
                                            result.getString("Condicao"),
                                            result.getString("Titulo"),
                                            result.getString("Descricao"),
                                            result.getString("AluguelStatus"),
                                            result.getInt("ImagemID"),
                                            result.getString("Detalhes"),
                                            result.getInt("TempoUso")));
            }
            //-------------Inserir para datas---------------------//
            
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
        return produtos;
    }
    
    public List<Produto> listarPorUsuario(int ID) throws PersistenciaException {
        List<Produto> produtos = new ArrayList();
        String sql = "SELECT * FROM FESASHARE.DBO.PRODUTO WHERE UsuarioID = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, ID);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                produtos.add(new Produto(result.getInt("ProdutoID"), 
                                            result.getInt("UsuarioID"),
                                            result.getInt("CategoriaID"),
                                            result.getDouble("PrecoTotal"),
                                            result.getString("Condicao"),
                                            result.getString("Titulo"),
                                            result.getString("Descricao"),
                                            result.getString("AluguelStatus"),
                                            result.getInt("ImagemID"),
                                            result.getString("Detalhes"),
                                            result.getInt("TempoUso")));
            }
            //-------------Inserir para datas---------------------//
            
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
        return produtos;
    }
    
    public List<Produto> listarPorCategoria(int cat) throws PersistenciaException {
        List<Produto> produtos = new ArrayList();
        String sql = "SELECT * FROM FESASHARE.DBO.PRODUTO WHERE CategoriaID = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, cat);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                produtos.add(new Produto(result.getInt("ProdutoID"), 
                                            result.getInt("UsuarioID"),
                                            result.getInt("CategoriaID"),
                                            result.getDouble("PrecoTotal"),
                                            result.getString("Condicao"),
                                            result.getString("Titulo"),
                                            result.getString("Descricao"),
                                            result.getString("AluguelStatus"),
                                            result.getInt("ImagemID"),
                                            result.getString("Detalhes"),
                                            result.getInt("TempoUso")));
            }
            //-------------Inserir para datas---------------------//
            
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
        return produtos;
    }
}
