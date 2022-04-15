/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.fesa_share.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author USUARIO
 */
public class Conexao {

    /*private final ResourceBundle BUNDLE = ResourceBundle.getBundle("derb", new Locale("pt", "BR"));*/
    private static Conexao conexao;
    String url = "jdbc:sqlserver://fesashare354.database.windows.net:1433;databaseName=FesaShare";
    String portNumber = "1433";
    String userName = "fesa_admin";
    String passName = "F3$4_2022";
        
    private Conexao() {
    }

    public static Conexao getInstance() {
        if (conexao == null) {
            conexao = new Conexao();
        }
        return conexao;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       /* Connection connection = DriverManager.getConnection(BUNDLE.getString("url"), BUNDLE.getString("usuario"), BUNDLE.getString("senha"));*/
        Connection connection = DriverManager.getConnection(url,userName, passName);
        return connection;
    }
    
}
