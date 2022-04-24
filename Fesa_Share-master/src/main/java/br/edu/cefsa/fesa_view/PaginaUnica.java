/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.cefsa.fesa_view;

import br.edu.cefsa.fesa_share.dao.CategoriaDAO;
import br.edu.cefsa.fesa_share.dao.ProdutoDAO;
import br.edu.cefsa.fesa_share.dao.UsuarioDAO;
import br.edu.cefsa.fesa_share.exception.PersistenciaException;
import br.edu.cefsa.fesa_share.models.Categoria;
import br.edu.cefsa.fesa_share.models.Produto;
import br.edu.cefsa.fesa_share.models.Usuario;
import br.edu.cefsa.fesa_share.util.DadosEstaticos;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author PC Novo
 */
public class PaginaUnica extends javax.swing.JFrame {
    
    int produtoAtual = 0;
    int numProdutos = 0;
    List<Produto> lista = new ArrayList<Produto>();
    List<Usuario> listaUsuarios = new ArrayList<Usuario>();
    List<Categoria> listaCategorias = new ArrayList<Categoria>();

    /**
     * Creates new form PaginaUnica
     */
    public PaginaUnica() {
        initComponents();
        
        if(lista.isEmpty())
        {
            carregaListaDeProdutos();
            carregaListaDeUsuarios();
            carregaListaDeCategorias();
        }
            
        
    }
    
    public void carregaListaDeProdutos()
    {
        ProdutoDAO prodDAO = new ProdutoDAO();
        List<Produto> listaPorUsuario;
        String categoria = cbCategoria.getSelectedItem()+"";
        lbNumProdutoAtual.setText(Integer.toString(produtoAtual + 1));
        
            try {

                    if(categoria.equals("Todos"))
                    {
                        lista = prodDAO.listar();
                        numProdutos = lista.size();
                        lbNumTotalProdutos.setText(Integer.toString(lista.size()));

                        atualizaDadosListaProdutos();
                    }

                    listaPorUsuario = prodDAO.listarPorUsuario(DadosEstaticos.usuarioLogado.getCodigo());


                } catch (PersistenciaException ex) {
                    Logger.getLogger(Publicacoes.class.getName()).log(Level.SEVERE, null, ex);
                }

    }
    
    public void carregaListaDeUsuarios()
    {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            listaUsuarios = usuarioDAO.listar();

        } catch (PersistenciaException ex) {
            Logger.getLogger(PaginaUnica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void carregaListaDeCategorias()
    {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        
        try {
            listaCategorias = categoriaDAO.listar();
        } catch (PersistenciaException ex) {
            Logger.getLogger(PaginaUnica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void atualizaDadosListaProdutos()
    {
        if(produtoAtual < lista.size())
        {
            btn1_lbTituloProduto.setText(lista.get(produtoAtual).getTitulo());
            btn1_lbDescricaoProduto.setText(lista.get(produtoAtual).getDescricao());
            btn1_lbCondicoesProduto.setText(lista.get(produtoAtual).getCondicao());
            btn1_lbPrecoProduto.setText(Double.toString(lista.get(produtoAtual).getPrecoTotal()));
            btn1_lbNomeProprietario.setText(obtemNomeUsuario(lista.get(produtoAtual).getUsuarioID()));
            btn1_lbContatoProprietario.setText(obtemContatoUsuario(lista.get(produtoAtual).getUsuarioID()));
            btn1_lbCategoriaProduto.setText(obtemCategoria(lista.get(produtoAtual).getCategoriaID()));
        }
        
    }
    
    public String obtemCategoria(int id)
    {
        String cat = "";

            for(Categoria c : listaCategorias)
            {
                if(c.getCodigo() == id)
                {
                    cat = c.getDescricao();
                    break;
                }
            }

        return cat;
    }
    
    public String obtemNomeUsuario(int id)
    {
        String nomeUsuario = "";

            for(Usuario u : listaUsuarios)
            {
                if(u.getCodigo() == id)
                {
                    nomeUsuario = u.getNome();
                    break;
                }
            }

        return nomeUsuario;
    }
    
        public String obtemContatoUsuario(int id)
    {
        String contatoUsuario = "";

            for(Usuario u : listaUsuarios)
            {
                if(u.getCodigo() == id)
                {
                    contatoUsuario = u.getEmail();
                    break;
                }
                    
            }

        return contatoUsuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgTelaUnica = new javax.swing.JPanel();
        sidepanelTelaUnica = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        monitorExibicao = new javax.swing.JPanel();
        painelListaGeral = new javax.swing.JPanel();
        btn1ListaProdutosFoto = new javax.swing.JPanel();
        btn1_jLabel17 = new javax.swing.JLabel();
        btn1_jLabel14 = new javax.swing.JLabel();
        btn1_jLabel12 = new javax.swing.JLabel();
        btn1_jLabel15 = new javax.swing.JLabel();
        btn1_lbTituloProduto = new javax.swing.JLabel();
        btn1_lbDescricaoProduto = new javax.swing.JLabel();
        btn1_lbCondicoesProduto = new javax.swing.JLabel();
        btn1_lbPrecoProduto = new javax.swing.JLabel();
        btn1_jLabel20 = new javax.swing.JLabel();
        btn1_lbNomeProprietario = new javax.swing.JLabel();
        btn1_jLabel21 = new javax.swing.JLabel();
        btn1_lbContatoProprietario = new javax.swing.JLabel();
        btn1_navegarFotoEsquerda2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btn1_jLabel13 = new javax.swing.JLabel();
        btn1_lbFotoAtual = new javax.swing.JLabel();
        btn1_jLabel18 = new javax.swing.JLabel();
        btn1_lbTotalFotos = new javax.swing.JLabel();
        btn1_navegarFotoDireita = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        navegarProdutoEsquerda = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbNumProdutoAtual = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbNumTotalProdutos = new javax.swing.JLabel();
        navegarProdutoDireita = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btn1_jLabel16 = new javax.swing.JLabel();
        btn1_lbCategoriaProduto = new javax.swing.JLabel();
        btnAlugarProduto = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        btnVerReputacao = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        painelSuperior = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lbTituloDaTela = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        bgTelaUnica.setBackground(new java.awt.Color(255, 255, 255));

        sidepanelTelaUnica.setBackground(new java.awt.Color(64, 43, 100));
        sidepanelTelaUnica.setMaximumSize(new java.awt.Dimension(400, 580));
        sidepanelTelaUnica.setMinimumSize(new java.awt.Dimension(400, 580));
        sidepanelTelaUnica.setPreferredSize(new java.awt.Dimension(400, 580));

        jPanel1.setBackground(new java.awt.Color(64, 43, 100));
        jPanel1.setMaximumSize(new java.awt.Dimension(226, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(226, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(226, 50));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(240, 240, 240));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("Ver Lista de Produtos Geral");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(64, 43, 100));
        jPanel2.setMaximumSize(new java.awt.Dimension(226, 50));
        jPanel2.setMinimumSize(new java.awt.Dimension(226, 50));
        jPanel2.setName(""); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(226, 50));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(240, 240, 240));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Ver Meus Produtos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(64, 43, 100));
        jPanel3.setMaximumSize(new java.awt.Dimension(226, 50));
        jPanel3.setMinimumSize(new java.awt.Dimension(226, 50));
        jPanel3.setPreferredSize(new java.awt.Dimension(226, 50));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(240, 240, 240));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Anunciar um Produto");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(64, 43, 100));
        jPanel4.setMaximumSize(new java.awt.Dimension(226, 50));
        jPanel4.setMinimumSize(new java.awt.Dimension(226, 50));
        jPanel4.setPreferredSize(new java.awt.Dimension(226, 50));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(240, 240, 240));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Acessar Chat");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(15, 15, 15))
        );

        jLabel1.setBackground(new java.awt.Color(240, 240, 240));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Fesa Share");

        jPanel5.setBackground(new java.awt.Color(64, 43, 100));
        jPanel5.setMaximumSize(new java.awt.Dimension(226, 50));
        jPanel5.setMinimumSize(new java.awt.Dimension(226, 50));
        jPanel5.setName(""); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(226, 50));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(240, 240, 240));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Ver histórico");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(15, 15, 15))
        );

        jPanel6.setBackground(new java.awt.Color(64, 43, 100));
        jPanel6.setMaximumSize(new java.awt.Dimension(226, 50));
        jPanel6.setMinimumSize(new java.awt.Dimension(226, 50));
        jPanel6.setName(""); // NOI18N
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(240, 240, 240));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Minha Reputação");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addGap(15, 15, 15))
        );

        jPanel7.setBackground(new java.awt.Color(64, 43, 100));
        jPanel7.setMaximumSize(new java.awt.Dimension(226, 50));
        jPanel7.setMinimumSize(new java.awt.Dimension(226, 50));
        jPanel7.setName(""); // NOI18N
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(240, 240, 240));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Preciso de Ajuda");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel8)
                .addGap(15, 15, 15))
        );

        jPanel8.setBackground(new java.awt.Color(64, 43, 100));
        jPanel8.setMaximumSize(new java.awt.Dimension(226, 50));
        jPanel8.setMinimumSize(new java.awt.Dimension(226, 50));
        jPanel8.setName(""); // NOI18N
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(240, 240, 240));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Nos Avalie");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout sidepanelTelaUnicaLayout = new javax.swing.GroupLayout(sidepanelTelaUnica);
        sidepanelTelaUnica.setLayout(sidepanelTelaUnicaLayout);
        sidepanelTelaUnicaLayout.setHorizontalGroup(
            sidepanelTelaUnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidepanelTelaUnicaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(131, 131, 131))
            .addGroup(sidepanelTelaUnicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidepanelTelaUnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        sidepanelTelaUnicaLayout.setVerticalGroup(
            sidepanelTelaUnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepanelTelaUnicaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        monitorExibicao.setBackground(new java.awt.Color(101, 58, 176));
        monitorExibicao.setMaximumSize(new java.awt.Dimension(983, 460));
        monitorExibicao.setMinimumSize(new java.awt.Dimension(983, 460));

        painelListaGeral.setBackground(new java.awt.Color(101, 58, 176));
        painelListaGeral.setMaximumSize(new java.awt.Dimension(983, 460));
        painelListaGeral.setMinimumSize(new java.awt.Dimension(983, 460));
        painelListaGeral.setName(""); // NOI18N
        painelListaGeral.setPreferredSize(new java.awt.Dimension(983, 460));

        btn1ListaProdutosFoto.setBackground(new java.awt.Color(124, 93, 176));
        btn1ListaProdutosFoto.setToolTipText("");

        javax.swing.GroupLayout btn1ListaProdutosFotoLayout = new javax.swing.GroupLayout(btn1ListaProdutosFoto);
        btn1ListaProdutosFoto.setLayout(btn1ListaProdutosFotoLayout);
        btn1ListaProdutosFotoLayout.setHorizontalGroup(
            btn1ListaProdutosFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );
        btn1ListaProdutosFotoLayout.setVerticalGroup(
            btn1ListaProdutosFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btn1_jLabel17.setBackground(new java.awt.Color(240, 240, 240));
        btn1_jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_jLabel17.setForeground(new java.awt.Color(240, 240, 240));
        btn1_jLabel17.setText("Título:");

        btn1_jLabel14.setBackground(new java.awt.Color(240, 240, 240));
        btn1_jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_jLabel14.setForeground(new java.awt.Color(240, 240, 240));
        btn1_jLabel14.setText("Descrição:");

        btn1_jLabel12.setBackground(new java.awt.Color(240, 240, 240));
        btn1_jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        btn1_jLabel12.setText("Condições:");

        btn1_jLabel15.setBackground(new java.awt.Color(240, 240, 240));
        btn1_jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_jLabel15.setForeground(new java.awt.Color(240, 240, 240));
        btn1_jLabel15.setText("Valor diário: R$");

        btn1_lbTituloProduto.setBackground(new java.awt.Color(240, 240, 240));
        btn1_lbTituloProduto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_lbTituloProduto.setForeground(new java.awt.Color(240, 240, 240));
        btn1_lbTituloProduto.setText("..");

        btn1_lbDescricaoProduto.setBackground(new java.awt.Color(240, 240, 240));
        btn1_lbDescricaoProduto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_lbDescricaoProduto.setForeground(new java.awt.Color(240, 240, 240));
        btn1_lbDescricaoProduto.setText("..");

        btn1_lbCondicoesProduto.setBackground(new java.awt.Color(240, 240, 240));
        btn1_lbCondicoesProduto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_lbCondicoesProduto.setForeground(new java.awt.Color(240, 240, 240));
        btn1_lbCondicoesProduto.setText("..");

        btn1_lbPrecoProduto.setBackground(new java.awt.Color(240, 240, 240));
        btn1_lbPrecoProduto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_lbPrecoProduto.setForeground(new java.awt.Color(240, 240, 240));
        btn1_lbPrecoProduto.setText("..");

        btn1_jLabel20.setBackground(new java.awt.Color(240, 240, 240));
        btn1_jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_jLabel20.setForeground(new java.awt.Color(240, 240, 240));
        btn1_jLabel20.setText("Nome do Locador:");

        btn1_lbNomeProprietario.setBackground(new java.awt.Color(240, 240, 240));
        btn1_lbNomeProprietario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_lbNomeProprietario.setForeground(new java.awt.Color(240, 240, 240));
        btn1_lbNomeProprietario.setText("..");

        btn1_jLabel21.setBackground(new java.awt.Color(240, 240, 240));
        btn1_jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_jLabel21.setForeground(new java.awt.Color(240, 240, 240));
        btn1_jLabel21.setText("Contato do Locador:");

        btn1_lbContatoProprietario.setBackground(new java.awt.Color(240, 240, 240));
        btn1_lbContatoProprietario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_lbContatoProprietario.setForeground(new java.awt.Color(240, 240, 240));
        btn1_lbContatoProprietario.setText("..");

        btn1_navegarFotoEsquerda2.setBackground(new java.awt.Color(64, 43, 100));
        btn1_navegarFotoEsquerda2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn1_navegarFotoEsquerda2.setMaximumSize(new java.awt.Dimension(52, 54));
        btn1_navegarFotoEsquerda2.setMinimumSize(new java.awt.Dimension(52, 54));
        btn1_navegarFotoEsquerda2.setName(""); // NOI18N
        btn1_navegarFotoEsquerda2.setPreferredSize(new java.awt.Dimension(52, 54));
        btn1_navegarFotoEsquerda2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn1_navegarFotoEsquerdaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn1_navegarFotoEsquerdaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn1_navegarFotoEsquerdaMouseExited(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(240, 240, 240));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(240, 240, 240));
        jLabel18.setText("<");

        javax.swing.GroupLayout btn1_navegarFotoEsquerda2Layout = new javax.swing.GroupLayout(btn1_navegarFotoEsquerda2);
        btn1_navegarFotoEsquerda2.setLayout(btn1_navegarFotoEsquerda2Layout);
        btn1_navegarFotoEsquerda2Layout.setHorizontalGroup(
            btn1_navegarFotoEsquerda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn1_navegarFotoEsquerda2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        btn1_navegarFotoEsquerda2Layout.setVerticalGroup(
            btn1_navegarFotoEsquerda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn1_navegarFotoEsquerda2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addContainerGap())
        );

        btn1_jLabel13.setBackground(new java.awt.Color(240, 240, 240));
        btn1_jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_jLabel13.setForeground(new java.awt.Color(240, 240, 240));
        btn1_jLabel13.setText("Exibindo foto");

        btn1_lbFotoAtual.setBackground(new java.awt.Color(240, 240, 240));
        btn1_lbFotoAtual.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_lbFotoAtual.setForeground(new java.awt.Color(240, 240, 240));
        btn1_lbFotoAtual.setText("...");

        btn1_jLabel18.setBackground(new java.awt.Color(240, 240, 240));
        btn1_jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_jLabel18.setForeground(new java.awt.Color(240, 240, 240));
        btn1_jLabel18.setText("de");

        btn1_lbTotalFotos.setBackground(new java.awt.Color(240, 240, 240));
        btn1_lbTotalFotos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_lbTotalFotos.setForeground(new java.awt.Color(240, 240, 240));
        btn1_lbTotalFotos.setText("...");

        btn1_navegarFotoDireita.setBackground(new java.awt.Color(64, 43, 100));
        btn1_navegarFotoDireita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn1_navegarFotoDireita.setMaximumSize(new java.awt.Dimension(52, 54));
        btn1_navegarFotoDireita.setMinimumSize(new java.awt.Dimension(52, 54));
        btn1_navegarFotoDireita.setName(""); // NOI18N
        btn1_navegarFotoDireita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn1_navegarFotoDireitaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn1_navegarFotoDireitaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn1_navegarFotoDireitaMouseExited(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(240, 240, 240));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(240, 240, 240));
        jLabel19.setText(">");

        javax.swing.GroupLayout btn1_navegarFotoDireitaLayout = new javax.swing.GroupLayout(btn1_navegarFotoDireita);
        btn1_navegarFotoDireita.setLayout(btn1_navegarFotoDireitaLayout);
        btn1_navegarFotoDireitaLayout.setHorizontalGroup(
            btn1_navegarFotoDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn1_navegarFotoDireitaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel19)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        btn1_navegarFotoDireitaLayout.setVerticalGroup(
            btn1_navegarFotoDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn1_navegarFotoDireitaLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addContainerGap())
        );

        navegarProdutoEsquerda.setBackground(new java.awt.Color(64, 43, 100));
        navegarProdutoEsquerda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        navegarProdutoEsquerda.setMaximumSize(new java.awt.Dimension(52, 54));
        navegarProdutoEsquerda.setMinimumSize(new java.awt.Dimension(52, 54));
        navegarProdutoEsquerda.setName(""); // NOI18N
        navegarProdutoEsquerda.setPreferredSize(new java.awt.Dimension(52, 54));
        navegarProdutoEsquerda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navegarProdutoEsquerdaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                navegarProdutoEsquerdaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                navegarProdutoEsquerdaMouseExited(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(240, 240, 240));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(240, 240, 240));
        jLabel23.setText("<");

        javax.swing.GroupLayout navegarProdutoEsquerdaLayout = new javax.swing.GroupLayout(navegarProdutoEsquerda);
        navegarProdutoEsquerda.setLayout(navegarProdutoEsquerdaLayout);
        navegarProdutoEsquerdaLayout.setHorizontalGroup(
            navegarProdutoEsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navegarProdutoEsquerdaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel23)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        navegarProdutoEsquerdaLayout.setVerticalGroup(
            navegarProdutoEsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navegarProdutoEsquerdaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addContainerGap())
        );

        jLabel24.setBackground(new java.awt.Color(240, 240, 240));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(240, 240, 240));
        jLabel24.setText("Exibindo Produto");

        lbNumProdutoAtual.setBackground(new java.awt.Color(240, 240, 240));
        lbNumProdutoAtual.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNumProdutoAtual.setForeground(new java.awt.Color(240, 240, 240));
        lbNumProdutoAtual.setText("...");

        jLabel25.setBackground(new java.awt.Color(240, 240, 240));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(240, 240, 240));
        jLabel25.setText("de");

        lbNumTotalProdutos.setBackground(new java.awt.Color(240, 240, 240));
        lbNumTotalProdutos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNumTotalProdutos.setForeground(new java.awt.Color(240, 240, 240));
        lbNumTotalProdutos.setText("...");

        navegarProdutoDireita.setBackground(new java.awt.Color(64, 43, 100));
        navegarProdutoDireita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        navegarProdutoDireita.setMaximumSize(new java.awt.Dimension(52, 54));
        navegarProdutoDireita.setMinimumSize(new java.awt.Dimension(52, 54));
        navegarProdutoDireita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel12MouseExited(evt);
            }
        });

        jLabel27.setBackground(new java.awt.Color(240, 240, 240));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(240, 240, 240));
        jLabel27.setText(">");

        javax.swing.GroupLayout navegarProdutoDireitaLayout = new javax.swing.GroupLayout(navegarProdutoDireita);
        navegarProdutoDireita.setLayout(navegarProdutoDireitaLayout);
        navegarProdutoDireitaLayout.setHorizontalGroup(
            navegarProdutoDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navegarProdutoDireitaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel27)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        navegarProdutoDireitaLayout.setVerticalGroup(
            navegarProdutoDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navegarProdutoDireitaLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addContainerGap())
        );

        btn1_jLabel16.setBackground(new java.awt.Color(240, 240, 240));
        btn1_jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_jLabel16.setForeground(new java.awt.Color(240, 240, 240));
        btn1_jLabel16.setText("Categoria:");

        btn1_lbCategoriaProduto.setBackground(new java.awt.Color(240, 240, 240));
        btn1_lbCategoriaProduto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn1_lbCategoriaProduto.setForeground(new java.awt.Color(240, 240, 240));
        btn1_lbCategoriaProduto.setText("..");

        btnAlugarProduto.setBackground(new java.awt.Color(64, 43, 100));
        btnAlugarProduto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAlugarProduto.setMaximumSize(new java.awt.Dimension(52, 54));
        btnAlugarProduto.setMinimumSize(new java.awt.Dimension(52, 54));
        btnAlugarProduto.setName(""); // NOI18N
        btnAlugarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlugarProdutoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAlugarProdutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAlugarProdutoMouseExited(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(240, 240, 240));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(240, 240, 240));
        jLabel28.setText("Alugar Produto");

        javax.swing.GroupLayout btnAlugarProdutoLayout = new javax.swing.GroupLayout(btnAlugarProduto);
        btnAlugarProduto.setLayout(btnAlugarProdutoLayout);
        btnAlugarProdutoLayout.setHorizontalGroup(
            btnAlugarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAlugarProdutoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel28)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        btnAlugarProdutoLayout.setVerticalGroup(
            btnAlugarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAlugarProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnVerReputacao.setBackground(new java.awt.Color(64, 43, 100));
        btnVerReputacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVerReputacao.setMaximumSize(new java.awt.Dimension(52, 54));
        btnVerReputacao.setMinimumSize(new java.awt.Dimension(52, 54));
        btnVerReputacao.setName(""); // NOI18N
        btnVerReputacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerReputacaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVerReputacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVerReputacaoMouseExited(evt);
            }
        });

        jLabel29.setBackground(new java.awt.Color(240, 240, 240));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(240, 240, 240));
        jLabel29.setText("Ver Reputação do Locador");

        javax.swing.GroupLayout btnVerReputacaoLayout = new javax.swing.GroupLayout(btnVerReputacao);
        btnVerReputacao.setLayout(btnVerReputacaoLayout);
        btnVerReputacaoLayout.setHorizontalGroup(
            btnVerReputacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnVerReputacaoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnVerReputacaoLayout.setVerticalGroup(
            btnVerReputacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnVerReputacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelListaGeralLayout = new javax.swing.GroupLayout(painelListaGeral);
        painelListaGeral.setLayout(painelListaGeralLayout);
        painelListaGeralLayout.setHorizontalGroup(
            painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelListaGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelListaGeralLayout.createSequentialGroup()
                        .addComponent(btn1ListaProdutosFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelListaGeralLayout.createSequentialGroup()
                                .addComponent(btn1_jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn1_lbTituloProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelListaGeralLayout.createSequentialGroup()
                                .addComponent(btn1_jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn1_lbCategoriaProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(painelListaGeralLayout.createSequentialGroup()
                                .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(painelListaGeralLayout.createSequentialGroup()
                                            .addComponent(btn1_jLabel15)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btn1_lbPrecoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(painelListaGeralLayout.createSequentialGroup()
                                            .addComponent(btn1_jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btn1_lbCondicoesProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelListaGeralLayout.createSequentialGroup()
                                            .addComponent(btn1_jLabel14)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btn1_lbDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelListaGeralLayout.createSequentialGroup()
                                            .addComponent(btn1_jLabel21)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btn1_lbContatoProprietario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(painelListaGeralLayout.createSequentialGroup()
                                            .addComponent(btn1_jLabel20)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btn1_lbNomeProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelListaGeralLayout.createSequentialGroup()
                                .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(painelListaGeralLayout.createSequentialGroup()
                                        .addGap(0, 19, Short.MAX_VALUE)
                                        .addComponent(btnVerReputacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAlugarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(painelListaGeralLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(navegarProdutoEsquerda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel24)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbNumProdutoAtual)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbNumTotalProdutos)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(navegarProdutoDireita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(38, 38, 38))))
                    .addGroup(painelListaGeralLayout.createSequentialGroup()
                        .addComponent(btn1_navegarFotoEsquerda2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btn1_jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn1_lbFotoAtual)
                        .addGap(17, 17, 17)
                        .addComponent(btn1_jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(btn1_lbTotalFotos)
                        .addGap(46, 46, 46)
                        .addComponent(btn1_navegarFotoDireita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        painelListaGeralLayout.setVerticalGroup(
            painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelListaGeralLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelListaGeralLayout.createSequentialGroup()
                        .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn1_jLabel17)
                            .addComponent(btn1_lbTituloProduto))
                        .addGap(12, 12, 12)
                        .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn1_jLabel14)
                            .addComponent(btn1_lbDescricaoProduto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn1_jLabel12)
                            .addComponent(btn1_lbCondicoesProduto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn1_jLabel15)
                            .addComponent(btn1_lbPrecoProduto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn1_lbCategoriaProduto)
                            .addComponent(btn1_jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn1_lbNomeProprietario)
                            .addComponent(btn1_jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn1_jLabel21)
                            .addComponent(btn1_lbContatoProprietario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAlugarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerReputacao, javax.swing.GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)))
                    .addComponent(btn1ListaProdutosFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelListaGeralLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn1_jLabel13)
                            .addComponent(btn1_lbFotoAtual)
                            .addComponent(btn1_jLabel18)
                            .addComponent(btn1_lbTotalFotos)))
                    .addGroup(painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(navegarProdutoDireita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelListaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(lbNumProdutoAtual)
                            .addComponent(jLabel25)
                            .addComponent(lbNumTotalProdutos))
                        .addComponent(navegarProdutoEsquerda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btn1_navegarFotoEsquerda2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1_navegarFotoDireita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout monitorExibicaoLayout = new javax.swing.GroupLayout(monitorExibicao);
        monitorExibicao.setLayout(monitorExibicaoLayout);
        monitorExibicaoLayout.setHorizontalGroup(
            monitorExibicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelListaGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        monitorExibicaoLayout.setVerticalGroup(
            monitorExibicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelListaGeral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        painelSuperior.setBackground(new java.awt.Color(64, 43, 100));
        painelSuperior.setMaximumSize(new java.awt.Dimension(569, 131));
        painelSuperior.setMinimumSize(new java.awt.Dimension(569, 131));

        jTextField1.setBackground(new java.awt.Color(124, 93, 176));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField1.setCaretColor(new java.awt.Color(250, 250, 250));

        jLabel10.setBackground(new java.awt.Color(240, 240, 240));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("Buscar Produto");

        lbTituloDaTela.setBackground(new java.awt.Color(240, 240, 240));
        lbTituloDaTela.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTituloDaTela.setForeground(new java.awt.Color(240, 240, 240));
        lbTituloDaTela.setText("..");

        jLabel22.setBackground(new java.awt.Color(240, 240, 240));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(240, 240, 240));
        jLabel22.setText("Selecionar Categoria:");

        cbCategoria.setBackground(new java.awt.Color(255, 255, 255));
        cbCategoria.setEditable(true);
        cbCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbCategoria.setForeground(new java.awt.Color(124, 93, 176));
        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Eletrônico", "Esporte e Lazer", "Livros", "Instrumentos Musicais" }));

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addComponent(lbTituloDaTela)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSuperiorLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSuperiorLayout.createSequentialGroup()
                        .addComponent(lbTituloDaTela)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSuperiorLayout.createSequentialGroup()
                        .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout bgTelaUnicaLayout = new javax.swing.GroupLayout(bgTelaUnica);
        bgTelaUnica.setLayout(bgTelaUnicaLayout);
        bgTelaUnicaLayout.setHorizontalGroup(
            bgTelaUnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgTelaUnicaLayout.createSequentialGroup()
                .addComponent(sidepanelTelaUnica, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgTelaUnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(monitorExibicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgTelaUnicaLayout.setVerticalGroup(
            bgTelaUnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgTelaUnicaLayout.createSequentialGroup()
                .addGroup(bgTelaUnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sidepanelTelaUnica, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addGroup(bgTelaUnicaLayout.createSequentialGroup()
                        .addComponent(painelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monitorExibicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bgTelaUnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bgTelaUnica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void setColor(JPanel panel)
    {
        panel.setBackground(new Color(124,93,176));
    }
    
    void resetColor(JPanel panel)
    {
        panel.setBackground(new Color(64,43,100));
    }
    
    //Lista Geral
    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        setColor(jPanel1);           
    }//GEN-LAST:event_jPanel1MouseEntered
    
    //Meus Produtos
    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        resetColor(jPanel1); 
        
    }//GEN-LAST:event_jPanel1MouseExited

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        // TODO add your handling code here:
        setColor(jPanel2); 
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        // TODO add your handling code here:
        resetColor(jPanel2); 
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        // TODO add your handling code here:
        setColor(jPanel3); 
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        // TODO add your handling code here:
        resetColor(jPanel3);
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        // TODO add your handling code here:
        setColor(jPanel4); 
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        // TODO add your handling code here:
        resetColor(jPanel4); 
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        // TODO add your handling code here:
        setColor(jPanel5); 
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        // TODO add your handling code here:
        resetColor(jPanel5); 
    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        // TODO add your handling code here:
        setColor(jPanel6); 
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        // TODO add your handling code here:
        resetColor(jPanel6); 
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        // TODO add your handling code here:
        setColor(jPanel7); 
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        // TODO add your handling code here:
        resetColor(jPanel7); 
    }//GEN-LAST:event_jPanel7MouseExited

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        // TODO add your handling code here:
        setColor(jPanel8); 
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        // TODO add your handling code here:
        resetColor(jPanel8); 
    }//GEN-LAST:event_jPanel8MouseExited

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        lbTituloDaTela.setText("Bem vindo " + DadosEstaticos.usuarioLogado.getNome()+" Lista de Produtos Geral");
        painelListaGeral.setVisible(true);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
        lbTituloDaTela.setText("Lista de Produtos do Usuário " + DadosEstaticos.usuarioLogado.getNome());
        painelListaGeral.setVisible(false);
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseExited
            resetColor(navegarProdutoDireita);// TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseExited

    private void jPanel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseEntered
          setColor(navegarProdutoDireita);          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseEntered

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        if(produtoAtual < numProdutos)   
            produtoAtual++;
        
        lbNumProdutoAtual.setText(Integer.toString(produtoAtual));
        atualizaDadosListaProdutos();

            // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseClicked

    private void navegarProdutoEsquerdaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navegarProdutoEsquerdaMouseExited
        // TODO add your handling code here:
        resetColor(navegarProdutoEsquerda);  
    }//GEN-LAST:event_navegarProdutoEsquerdaMouseExited

    private void navegarProdutoEsquerdaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navegarProdutoEsquerdaMouseEntered
           setColor(navegarProdutoEsquerda);         // TODO add your handling code here:
    }//GEN-LAST:event_navegarProdutoEsquerdaMouseEntered

    private void navegarProdutoEsquerdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navegarProdutoEsquerdaMouseClicked
        if(produtoAtual >= 1)
            produtoAtual--; 
        
        lbNumProdutoAtual.setText(Integer.toString(produtoAtual));
        atualizaDadosListaProdutos();

    }//GEN-LAST:event_navegarProdutoEsquerdaMouseClicked

    private void btn1_navegarFotoDireitaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1_navegarFotoDireitaMouseExited
        // TODO add your handling code here:
        resetColor(btn1_navegarFotoDireita);
    }//GEN-LAST:event_btn1_navegarFotoDireitaMouseExited

    private void btn1_navegarFotoDireitaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1_navegarFotoDireitaMouseEntered
        // TODO add your handling code here:
        setColor(btn1_navegarFotoDireita);
    }//GEN-LAST:event_btn1_navegarFotoDireitaMouseEntered

    private void btn1_navegarFotoDireitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1_navegarFotoDireitaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn1_navegarFotoDireitaMouseClicked

    private void btn1_navegarFotoEsquerdaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1_navegarFotoEsquerdaMouseExited
        // TODO add your handling code here:
        resetColor(btn1_navegarFotoEsquerda2);
    }//GEN-LAST:event_btn1_navegarFotoEsquerdaMouseExited

    private void btn1_navegarFotoEsquerdaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1_navegarFotoEsquerdaMouseEntered
        // TODO add your handling code here:
        setColor(btn1_navegarFotoEsquerda2);
    }//GEN-LAST:event_btn1_navegarFotoEsquerdaMouseEntered

    private void btn1_navegarFotoEsquerdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1_navegarFotoEsquerdaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn1_navegarFotoEsquerdaMouseClicked

    private void btnAlugarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlugarProdutoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlugarProdutoMouseClicked

    private void btnAlugarProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlugarProdutoMouseEntered
        setColor(btnAlugarProduto);       // TODO add your handling code here:
    }//GEN-LAST:event_btnAlugarProdutoMouseEntered

    private void btnAlugarProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlugarProdutoMouseExited
        resetColor(btnAlugarProduto);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlugarProdutoMouseExited

    private void btnVerReputacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerReputacaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerReputacaoMouseClicked

    private void btnVerReputacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerReputacaoMouseEntered
         setColor(btnVerReputacao);        
    }//GEN-LAST:event_btnVerReputacaoMouseEntered

    private void btnVerReputacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerReputacaoMouseExited
        // TODO add your handling code here:
        resetColor(btnVerReputacao);
    }//GEN-LAST:event_btnVerReputacaoMouseExited
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaginaUnica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaUnica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaUnica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaUnica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaUnica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgTelaUnica;
    private javax.swing.JPanel btn1ListaProdutosFoto;
    private javax.swing.JLabel btn1_jLabel12;
    private javax.swing.JLabel btn1_jLabel13;
    private javax.swing.JLabel btn1_jLabel14;
    private javax.swing.JLabel btn1_jLabel15;
    private javax.swing.JLabel btn1_jLabel16;
    private javax.swing.JLabel btn1_jLabel17;
    private javax.swing.JLabel btn1_jLabel18;
    private javax.swing.JLabel btn1_jLabel20;
    private javax.swing.JLabel btn1_jLabel21;
    private javax.swing.JLabel btn1_lbCategoriaProduto;
    private javax.swing.JLabel btn1_lbCondicoesProduto;
    private javax.swing.JLabel btn1_lbContatoProprietario;
    private javax.swing.JLabel btn1_lbDescricaoProduto;
    private javax.swing.JLabel btn1_lbFotoAtual;
    private javax.swing.JLabel btn1_lbNomeProprietario;
    private javax.swing.JLabel btn1_lbPrecoProduto;
    private javax.swing.JLabel btn1_lbTituloProduto;
    private javax.swing.JLabel btn1_lbTotalFotos;
    private javax.swing.JPanel btn1_navegarFotoDireita;
    private javax.swing.JPanel btn1_navegarFotoEsquerda;
    private javax.swing.JPanel btn1_navegarFotoEsquerda1;
    private javax.swing.JPanel btn1_navegarFotoEsquerda2;
    private javax.swing.JPanel btnAlugarProduto;
    private javax.swing.JPanel btnVerReputacao;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbNumProdutoAtual;
    private javax.swing.JLabel lbNumTotalProdutos;
    private javax.swing.JLabel lbTituloDaTela;
    private javax.swing.JPanel monitorExibicao;
    private javax.swing.JPanel navegarProdutoDireita;
    private javax.swing.JPanel navegarProdutoEsquerda;
    private javax.swing.JPanel painelListaGeral;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JPanel sidepanelTelaUnica;
    // End of variables declaration//GEN-END:variables
}
