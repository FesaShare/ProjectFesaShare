/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.edu.cefsa.fesa_share.principal;

import br.edu.cefsa.fesa_share.dao.CategoriaDAO;
import br.edu.cefsa.fesa_share.exception.PersistenciaException;
import br.edu.cefsa.fesa_share.models.Categoria;
import br.edu.cefsa.fesa_view.PaginaPrincipal;
import javax.swing.JFrame;

/**
 *
 * @author USUARIO
 */
public class Fesa_Share {

    public static void main(String[] args) throws PersistenciaException {
        System.out.println("Hello World!");
        Categoria categoria = new Categoria();
        categoria.setCodigo(2);
        categoria.setDescricao("Eletronicos");
        
        CategoriaDAO catDao = new CategoriaDAO();
        catDao.inserir(categoria);
        
        
        PaginaPrincipal pgPrincipal = new PaginaPrincipal();
        pgPrincipal.setVisible(true);

    }
    
   
}
