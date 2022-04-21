/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.edu.cefsa.fesa_share.principal;

import br.edu.cefsa.fesa_share.dao.ProdutoDAO;
import br.edu.cefsa.fesa_share.dao.UsuarioDAO;
import br.edu.cefsa.fesa_share.exception.PersistenciaException;
import br.edu.cefsa.fesa_share.models.Produto;
import br.edu.cefsa.fesa_share.models.Usuario;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Fesa_Share {

    public static void main(String[] args) throws PersistenciaException {
        System.out.println("Hello World!");
        Usuario usuario = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
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
        Produto prod = new Produto();
        ProdutoDAO prodDAO = new ProdutoDAO();
        prod.setUsuarioID(33);
        prod.setCategoriaID(6);
        prod.setPrecoTotal(Float.MIN_NORMAL);
        prod.setCondicao("Novo");
        prod.setTitulo("Outro Arduino");
        prod.setDescricao("Arduino zero bala");
        prod.setAluguelStatus("Disponivel");
        prod.setImagemID(2);
        prod.setDetalhes("Ano 2015");
        prod.setTempoUso(2);
        
        if ( prodDAO.inserir(prod))
            System.out.println("Produto adicionado com sucesso, com id: " + prod.getCodigo());
        //Testando Alterar de Produto
        /*prod.setDetalhes("Acabei de derrubar no chão");
        prodDAO.alterar(prod);*/
        //Testando Remover de Produto
        //prodDAO.remover(prod);
        
        //Para testar o listar por ID
        //List<Produto> listado = prodDAO.listarPorCategoria(prod);
        
        /*Não terminei de testar ****
        List<Produto> listado2 = prodDAO.listarPorCategoria(prod);
        System.out.println(listado2.);
        for (int i = 0; i < listado2.size(); i++) {
            Produto p = new Produto();
            p.setTitulo(listado2.get(i).getTitulo());
            p.setDescricao(listado2.get(i).getDescricao());
            p.setDetalhes(listado2.get(i).getDetalhes());
            System.out.println(p.getDescricao());
            System.out.println(p.getDetalhes());
        }
        */
        
        
        /*
        PaginaPrincipal pgPrincipal = new PaginaPrincipal();
        pgPrincipal.setVisible(true);*/

    }
    
   
}
