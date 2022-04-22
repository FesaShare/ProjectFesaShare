/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.edu.cefsa.fesa_share.principal;

import br.edu.cefsa.fesa_share.dao.CategoriaDAO;
import br.edu.cefsa.fesa_share.dao.ImagemDAO;
import br.edu.cefsa.fesa_share.dao.ProdutoDAO;
import br.edu.cefsa.fesa_share.dao.UsuarioDAO;
import br.edu.cefsa.fesa_share.exception.PersistenciaException;
import br.edu.cefsa.fesa_share.models.Categoria;
import br.edu.cefsa.fesa_share.models.Imagem;
import br.edu.cefsa.fesa_share.models.Produto;
import br.edu.cefsa.fesa_share.models.Usuario;
import br.edu.cefsa.fesa_view.Login;
import br.edu.cefsa.fesa_view.PaginaPrincipal;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Fesa_Share {

    public static void main(String[] args) throws PersistenciaException {
        System.out.println("Hello World!");
       // Usuario usuario = new Usuario();
       // UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        //Para testar a inserção
       /* usuario.setNome("removido será");
        usuario.setSenha("sf");
        usuario.setEmail("vsfte.com");
        usuario.setTelefone("(11)98765-4321");
        usuario.setEndereco("Rua sf, nº1");
        usuario.setReputacao(null);
        
        if (usuarioDAO.inserir(usuario))
            System.out.println("Aluno adicionado com sucesso, com id: " + usuario.getCodigo());
        
        
         //Para testar o listar:
        List<Usuario> lista = usuarioDAO.listar();
        for (int i = 0; i < lista.size(); i++) {
            Usuario u = new Usuario();
            u.setNome(lista.get(i).getNome());
            System.out.println(u.getNome());
        }
        */
        //Para testar o listar por ID
        /*Usuario listado = usuarioDAO.listarPorID(usuario);
        System.out.println(listado.getNome() + '-' + listado.getCodigo());*/
        
        //Para testar o delete
        //usuarioDAO.remover(usuario);
        
        //Testando insert de Produto
        /*Produto prod = new Produto();
        ProdutoDAO prodDAO = new ProdutoDAO();
        prod.setUsuarioID(33);
        prod.setCategoriaID(6);
        prod.setPrecoTotal(100.5);
        prod.setCondicao("Veio");
        prod.setTitulo("Arduino");
        prod.setDescricao("Arduino meia boca");
        prod.setAluguelStatus("Disponivel");
        prod.setImagemID(2);
        prod.setDetalhes("Ano 2010");
        prod.setTempoUso(12);
        
        if ( prodDAO.inserir(prod))
            System.out.println("Produto adicionado com sucesso, com id: " + prod.getCodigo()); */
        //Testando Alterar de Produto
        /*prod.setDetalhes("Acabei de derrubar no chão");
        prodDAO.alterar(prod);*/
        //Testando Remover de Produto
        //prodDAO.remover(prod);
        
        //Para testar o listar por ID
        //List<Produto> listado = prodDAO.listarPorCategoria(prod);
        /*
        ProdutoDAO prodDAO = new ProdutoDAO();
        List<Produto> lista = prodDAO.listarPorCategoria(6);
        lista.forEach(produto -> System.out.println(produto.getDescricao()));
        */
        /*
        ProdutoDAO prodDAO = new ProdutoDAO();
        List<Produto> lista = prodDAO.listarPorCondicao("Novo");
        lista.forEach(produto -> System.out.println(produto.getDescricao()));
        */
        /*///Com erro
        ProdutoDAO prodDAO = new ProdutoDAO();
        List<Produto> lista = prodDAO.listarPorDescricao("Arduino");
        lista.forEach(produto -> System.out.println(produto.getDescricao())); */
         /*
        ProdutoDAO prodDAO = new ProdutoDAO();
        List<Produto> lista = prodDAO.listarPorStatus("Disponivel");
        lista.forEach(produto -> System.out.println(produto.getDescricao()));
        */
         
        Login pgLogin = new Login();
        pgLogin.setVisible(true);
        
        //PaginaPrincipal pgPrincipal = new PaginaPrincipal();
        //pgPrincipal.setVisible(true);

        ImagemDAO dao = new ImagemDAO();
        
        List<Imagem> imegens = dao.listar();
        imegens.forEach(System.out::println);
    }
}
