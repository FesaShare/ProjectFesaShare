/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.edu.cefsa.fesa_share.principal;

import br.edu.cefsa.fesa_share.dao.CategoriaDAO;
import br.edu.cefsa.fesa_share.dao.UsuarioDAO;
import br.edu.cefsa.fesa_share.exception.PersistenciaException;
import br.edu.cefsa.fesa_share.models.Categoria;
import br.edu.cefsa.fesa_share.models.Usuario;
import br.edu.cefsa.fesa_view.PaginaPrincipal;
import javax.swing.JFrame;

/**
 *
 * @author USUARIO
 */
public class Fesa_Share {

    public static void main(String[] args) throws PersistenciaException {
        System.out.println("Hello World!");
        Usuario usuario = new Usuario();
        usuario.setNome("Primeiro");
        usuario.setSenha("1234");
        usuario.setEmail("primeiro@teste.com");
        usuario.setTelefone("(11)98765-4321");
        usuario.setEndereco("Rua aleatorio, nº1");
        usuario.setReputacao(null);
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.inserir(usuario);
        
        
        PaginaPrincipal pgPrincipal = new PaginaPrincipal();
        pgPrincipal.setVisible(true);

    }
    
   
}
