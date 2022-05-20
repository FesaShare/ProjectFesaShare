/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.cefsa.fesa_view;

import br.edu.cefsa.fesa_share.dao.ProdutoDAO;
import br.edu.cefsa.fesa_share.exception.PersistenciaException;
import br.edu.cefsa.fesa_share.models.Produto;
import br.edu.cefsa.fesa_share.util.DadosEstaticos;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lasou
 */
public class Publicacoes extends javax.swing.JFrame {
    
    boolean meusProdutos = false;
    int produtoAtual = 0;
    int numProdutos = 0;
    int numPag = 0;
    int pagAtual = 1;
    ProdutoDAO prodDAO = new ProdutoDAO();
    List<Produto> lista = new ArrayList<Produto>();;


    /**
     * Creates new form Publicacoes
     */
    public Publicacoes() {
        initComponents();
        
        if(lista.isEmpty())
        {
            carregaListaProdutos();
        }
        
        if(meusProdutos)
        {
            btnAltera1.setVisible(true);
            btnAltera2.setVisible(true);
            btnAltera3.setVisible(true);
        }
        else
        {
            btnAltera1.setVisible(false);
            btnAltera2.setVisible(false);
            btnAltera3.setVisible(false);
        }
 
    }
    
    public void carregaListaProdutos()
    {
        try {
            
            if(meusProdutos)
            {
                lista.clear();
                lista = prodDAO.listarPorUsuario(DadosEstaticos.usuarioLogado.getCodigo());
                //lbTeste.setText("Com filtro");
                txtPub.setText("Minhas Publicações");
                atualizaDadosListaProdutos();
            }
            else
            {
                lista.clear();
                lista = prodDAO.listar();
                //lbTeste.setText("Sem filtro");
                txtPub.setText("Todas as publicações");
                atualizaDadosListaProdutos();
            }
                
                
            lbQtdProdutos.setText(Integer.toString(lista.size()));
               
        } catch (PersistenciaException ex) {
            Logger.getLogger(Publicacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void atualizaDadosListaProdutos()
    {
         numPag = Math.round(lista.size() / 3);
            if(lista.size() % 3 > 0)
                numPag = numPag + 1;
            lbNumPag.setText(Integer.toString(numPag));

        lbPagAtual.setText(Integer.toString(pagAtual));
        
        if(produtoAtual < lista.size())
        {
            lbProduto1.setText(lista.get(produtoAtual).getTitulo());
            lbDescricao1.setText(lista.get(produtoAtual).getDescricao());
            lbCondicao1.setText(lista.get(produtoAtual).getCondicao());
            lbPreco1.setText(Double.toString(lista.get(produtoAtual).getPrecoTotal()));
            
            if(produtoAtual + 1 < lista.size())
            {
                lbProduto2.setText(lista.get(produtoAtual + 1).getTitulo());
                lbDescricao2.setText(lista.get(produtoAtual + 1).getDescricao());
                lbCondicao2.setText(lista.get(produtoAtual + 1).getCondicao());
                lbPreco2.setText(Double.toString(lista.get(produtoAtual + 1).getPrecoTotal()));
            }
            else
            {
                lbProduto2.setText("");
                lbDescricao2.setText("");
                lbCondicao2.setText("");
                lbPreco2.setText("");
            }
            
            if(produtoAtual + 2 < lista.size())
            {
                lbProduto3.setText(lista.get(produtoAtual + 2).getTitulo());
                lbDescricao3.setText(lista.get(produtoAtual + 2).getDescricao());
                lbCondicao3.setText(lista.get(produtoAtual + 2).getCondicao());
                lbPreco3.setText(Double.toString(lista.get(produtoAtual + 1).getPrecoTotal()));
            }
            else
            {
                lbProduto3.setText("");
                lbDescricao3.setText("");
                lbCondicao3.setText("");
                lbPreco3.setText("");
            }

        }
        
        if(lista.size() == 0)
        {
            lbProduto1.setText("");
            lbDescricao1.setText("");
            lbCondicao1.setText("");
            lbPreco1.setText("");
            lbProduto2.setText("");
            lbDescricao2.setText("");
            lbCondicao2.setText("");
            lbPreco2.setText("");
            lbProduto3.setText("");
            lbDescricao3.setText("");
            lbCondicao3.setText("");
            lbPreco3.setText("");
            txtPub.setText("Você não tem nenhuma publicação");
        }
        
        if(meusProdutos)
        {
            btnAltera1.setVisible(true);
            btnAltera2.setVisible(true);
            btnAltera3.setVisible(true);
        }
        else
        {
            btnAltera1.setVisible(false);
            btnAltera2.setVisible(false);
            btnAltera3.setVisible(false);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        bg = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        cab = new javax.swing.JPanel();
        txtBuscarProduto2 = new javax.swing.JTextField();
        jButton34 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        txtPub = new javax.swing.JLabel();
        prod1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbProduto1 = new javax.swing.JLabel();
        lbDescricao1 = new javax.swing.JLabel();
        lbCondicao1 = new javax.swing.JLabel();
        lbPreco1 = new javax.swing.JLabel();
        lbProduto4 = new javax.swing.JLabel();
        lbProduto5 = new javax.swing.JLabel();
        lbProduto6 = new javax.swing.JLabel();
        lbProduto7 = new javax.swing.JLabel();
        jButton33 = new javax.swing.JButton();
        btnAltera1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lbProduto2 = new javax.swing.JLabel();
        lbCondicao2 = new javax.swing.JLabel();
        lbDescricao2 = new javax.swing.JLabel();
        lbPreco2 = new javax.swing.JLabel();
        lbProduto8 = new javax.swing.JLabel();
        lbProduto11 = new javax.swing.JLabel();
        lbProduto9 = new javax.swing.JLabel();
        lbProduto10 = new javax.swing.JLabel();
        jButton35 = new javax.swing.JButton();
        btnAltera2 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        lbProduto3 = new javax.swing.JLabel();
        lbPreco3 = new javax.swing.JLabel();
        lbDescricao3 = new javax.swing.JLabel();
        lbCondicao3 = new javax.swing.JLabel();
        jButton32 = new javax.swing.JButton();
        lbProduto12 = new javax.swing.JLabel();
        lbProduto14 = new javax.swing.JLabel();
        lbProduto15 = new javax.swing.JLabel();
        lbProduto13 = new javax.swing.JLabel();
        btnAltera3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lbPagAtual = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbNumPag = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        lbQtdProdutos = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(40, 40, 40));
        jPanel1.setForeground(new java.awt.Color(220, 220, 220));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton1)
                .addContainerGap(304, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jButton1)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(40, 40, 40));
        setResizable(false);

        bg.setBackground(new java.awt.Color(40, 40, 40));

        jPanel13.setBackground(new java.awt.Color(40, 40, 40));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setBackground(new java.awt.Color(60, 60, 60));
        jButton2.setForeground(new java.awt.Color(220, 220, 220));
        jButton2.setText("Ver Minhas Publicações");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(60, 60, 60));
        jButton3.setForeground(new java.awt.Color(220, 220, 220));
        jButton3.setText("Chat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(60, 60, 60));
        jButton4.setForeground(new java.awt.Color(220, 220, 220));
        jButton4.setText("Histórico");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(60, 60, 60));
        jButton7.setForeground(new java.awt.Color(220, 220, 220));
        jButton7.setText("Minha Reputação");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(60, 60, 60));
        jButton12.setForeground(new java.awt.Color(220, 220, 220));
        jButton12.setText("Politicas de fila");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(60, 60, 60));
        jButton13.setForeground(new java.awt.Color(220, 220, 220));
        jButton13.setText("Politicas de devolução");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(60, 60, 60));
        jButton14.setForeground(new java.awt.Color(220, 220, 220));
        jButton14.setText("Politicas de cancelamento");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(60, 60, 60));
        jButton15.setForeground(new java.awt.Color(220, 220, 220));
        jButton15.setText("Encerrar conta");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(60, 60, 60));
        jButton11.setForeground(new java.awt.Color(220, 220, 220));
        jButton11.setText("Nova Publicação");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(60, 60, 60));
        jButton5.setForeground(new java.awt.Color(220, 220, 220));
        jButton5.setText("Ver Todas as Publicações");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton15)
                .addContainerGap())
        );

        cab.setBackground(new java.awt.Color(40, 40, 40));

        txtBuscarProduto2.setBackground(new java.awt.Color(70, 70, 70));
        txtBuscarProduto2.setForeground(new java.awt.Color(220, 220, 220));
        txtBuscarProduto2.setText("Buscar");

        jButton34.setBackground(new java.awt.Color(60, 60, 60));
        jButton34.setForeground(new java.awt.Color(220, 220, 220));
        jButton34.setText("Buscar");
        jButton34.setToolTipText("");

        jButton17.setBackground(new java.awt.Color(60, 60, 60));
        jButton17.setForeground(new java.awt.Color(220, 220, 220));
        jButton17.setText("Sair");
        jButton17.setToolTipText("");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jPanel14.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        jLabel8.setText("Imagem Logo");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel8)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(31, 31, 31))
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(220, 220, 220));
        jLabel12.setText("Publicações:");

        jButton18.setBackground(new java.awt.Color(60, 60, 60));
        jButton18.setForeground(new java.awt.Color(220, 220, 220));
        jButton18.setText("Quem Somos");

        jButton6.setBackground(new java.awt.Color(60, 60, 60));
        jButton6.setForeground(new java.awt.Color(220, 220, 220));
        jButton6.setText("Sobre");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(60, 60, 60));
        jButton19.setForeground(new java.awt.Color(220, 220, 220));
        jButton19.setText("Alugue já!");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        txtPub.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPub.setForeground(new java.awt.Color(220, 220, 220));
        txtPub.setText("..");

        javax.swing.GroupLayout cabLayout = new javax.swing.GroupLayout(cab);
        cab.setLayout(cabLayout);
        cabLayout.setHorizontalGroup(
            cabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(cabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(cabLayout.createSequentialGroup()
                        .addComponent(txtBuscarProduto2, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cabLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPub)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        cabLayout.setVerticalGroup(
            cabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cabLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(cabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(txtPub))
                            .addGroup(cabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton18)
                                .addComponent(jButton6)
                                .addComponent(jButton19))
                            .addComponent(jButton17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscarProduto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton34))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        prod1.setBackground(new java.awt.Color(40, 40, 40));
        prod1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        prod1.setMaximumSize(new java.awt.Dimension(418, 150));
        prod1.setMinimumSize(new java.awt.Dimension(418, 150));
        prod1.setName(""); // NOI18N

        jPanel12.setBackground(new java.awt.Color(230, 230, 230));
        jPanel12.setMaximumSize(new java.awt.Dimension(160, 138));
        jPanel12.setMinimumSize(new java.awt.Dimension(160, 138));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Img1");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel13)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(55, 55, 55))
        );

        lbProduto1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbProduto1.setForeground(new java.awt.Color(220, 220, 220));
        lbProduto1.setText("Produto 1");

        lbDescricao1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbDescricao1.setForeground(new java.awt.Color(220, 220, 220));
        lbDescricao1.setText("Descricao 1");

        lbCondicao1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbCondicao1.setForeground(new java.awt.Color(220, 220, 220));
        lbCondicao1.setText("Condição 1");

        lbPreco1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbPreco1.setForeground(new java.awt.Color(220, 220, 220));
        lbPreco1.setText("Preço 1");

        lbProduto4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbProduto4.setForeground(new java.awt.Color(220, 220, 220));
        lbProduto4.setText("Produto    :");

        lbProduto5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbProduto5.setForeground(new java.awt.Color(220, 220, 220));
        lbProduto5.setText("Descrição :");

        lbProduto6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbProduto6.setForeground(new java.awt.Color(220, 220, 220));
        lbProduto6.setText("Condição :");

        lbProduto7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbProduto7.setForeground(new java.awt.Color(220, 220, 220));
        lbProduto7.setText("Preço :  R$");

        jButton33.setBackground(new java.awt.Color(60, 60, 60));
        jButton33.setForeground(new java.awt.Color(220, 220, 220));
        jButton33.setText("Ver Produto");
        jButton33.setToolTipText("");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        btnAltera1.setBackground(new java.awt.Color(60, 60, 60));
        btnAltera1.setForeground(new java.awt.Color(220, 220, 220));
        btnAltera1.setText("Alterar Produto");
        btnAltera1.setToolTipText("");
        btnAltera1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltera1jButton31ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout prod1Layout = new javax.swing.GroupLayout(prod1);
        prod1.setLayout(prod1Layout);
        prod1Layout.setHorizontalGroup(
            prod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prod1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(prod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbProduto5)
                    .addComponent(lbProduto6)
                    .addComponent(lbProduto7)
                    .addComponent(lbProduto4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(prod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(prod1Layout.createSequentialGroup()
                        .addComponent(lbProduto1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(prod1Layout.createSequentialGroup()
                        .addComponent(lbPreco1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(prod1Layout.createSequentialGroup()
                        .addGroup(prod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbDescricao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbCondicao1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAltera1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        prod1Layout.setVerticalGroup(
            prod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prod1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(prod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(prod1Layout.createSequentialGroup()
                        .addGroup(prod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(prod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbProduto1)
                                .addComponent(lbProduto4))
                            .addComponent(jButton33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(prod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDescricao1)
                            .addComponent(lbProduto5)
                            .addComponent(btnAltera1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(prod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCondicao1)
                            .addComponent(lbProduto6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(prod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPreco1)
                            .addComponent(lbProduto7)))
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(40, 40, 40));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setMaximumSize(new java.awt.Dimension(418, 150));
        jPanel5.setMinimumSize(new java.awt.Dimension(418, 150));
        jPanel5.setName(""); // NOI18N

        jPanel19.setBackground(new java.awt.Color(230, 230, 230));
        jPanel19.setMaximumSize(new java.awt.Dimension(160, 138));
        jPanel19.setMinimumSize(new java.awt.Dimension(160, 138));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setText("Img2");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel19)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(55, 55, 55))
        );

        lbProduto2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbProduto2.setForeground(new java.awt.Color(220, 220, 220));
        lbProduto2.setText("Produto 2");

        lbCondicao2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbCondicao2.setForeground(new java.awt.Color(220, 220, 220));
        lbCondicao2.setText("Condição 2");

        lbDescricao2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbDescricao2.setForeground(new java.awt.Color(220, 220, 220));
        lbDescricao2.setText("Descricao 2");

        lbPreco2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbPreco2.setForeground(new java.awt.Color(220, 220, 220));
        lbPreco2.setText("Preço 2");

        lbProduto8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbProduto8.setForeground(new java.awt.Color(220, 220, 220));
        lbProduto8.setText("Preço :  R$");

        lbProduto11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbProduto11.setForeground(new java.awt.Color(220, 220, 220));
        lbProduto11.setText("Produto    :");

        lbProduto9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbProduto9.setForeground(new java.awt.Color(220, 220, 220));
        lbProduto9.setText("Condição :");

        lbProduto10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbProduto10.setForeground(new java.awt.Color(220, 220, 220));
        lbProduto10.setText("Descrição :");

        jButton35.setBackground(new java.awt.Color(60, 60, 60));
        jButton35.setForeground(new java.awt.Color(220, 220, 220));
        jButton35.setText("Ver Produto");
        jButton35.setToolTipText("");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35jButton31ActionPerformed(evt);
            }
        });

        btnAltera2.setBackground(new java.awt.Color(60, 60, 60));
        btnAltera2.setForeground(new java.awt.Color(220, 220, 220));
        btnAltera2.setText("Alterar Produto");
        btnAltera2.setToolTipText("");
        btnAltera2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltera2jButton31ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbProduto10)
                    .addComponent(lbProduto9)
                    .addComponent(lbProduto8)
                    .addComponent(lbProduto11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbProduto2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbPreco2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbCondicao2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDescricao2, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAltera2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lbProduto10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbProduto9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbProduto8))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbProduto2)
                                .addComponent(lbProduto11))
                            .addComponent(jButton35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDescricao2)
                            .addComponent(btnAltera2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCondicao2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPreco2))
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(40, 40, 40));
        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel18.setMaximumSize(new java.awt.Dimension(418, 150));
        jPanel18.setMinimumSize(new java.awt.Dimension(418, 150));
        jPanel18.setName(""); // NOI18N

        jPanel17.setBackground(new java.awt.Color(230, 230, 230));
        jPanel17.setMaximumSize(new java.awt.Dimension(160, 138));
        jPanel17.setMinimumSize(new java.awt.Dimension(160, 138));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("Img3");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel18)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(55, 55, 55))
        );

        lbProduto3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbProduto3.setForeground(new java.awt.Color(220, 220, 220));
        lbProduto3.setText("Produto 3");

        lbPreco3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbPreco3.setForeground(new java.awt.Color(220, 220, 220));
        lbPreco3.setText("Preço 3");

        lbDescricao3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbDescricao3.setForeground(new java.awt.Color(220, 220, 220));
        lbDescricao3.setText("Descricao 3");

        lbCondicao3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbCondicao3.setForeground(new java.awt.Color(220, 220, 220));
        lbCondicao3.setText("Condição 3");

        jButton32.setBackground(new java.awt.Color(60, 60, 60));
        jButton32.setForeground(new java.awt.Color(220, 220, 220));
        jButton32.setText("Ver Produto");
        jButton32.setToolTipText("");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        lbProduto12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbProduto12.setForeground(new java.awt.Color(220, 220, 220));
        lbProduto12.setText("Preço :  R$");

        lbProduto14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbProduto14.setForeground(new java.awt.Color(220, 220, 220));
        lbProduto14.setText("Descrição :");

        lbProduto15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbProduto15.setForeground(new java.awt.Color(220, 220, 220));
        lbProduto15.setText("Produto    :");

        lbProduto13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbProduto13.setForeground(new java.awt.Color(220, 220, 220));
        lbProduto13.setText("Condição :");

        btnAltera3.setBackground(new java.awt.Color(60, 60, 60));
        btnAltera3.setForeground(new java.awt.Color(220, 220, 220));
        btnAltera3.setText("Alterar Produto");
        btnAltera3.setToolTipText("");
        btnAltera3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltera3jButton31ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbProduto13)
                    .addComponent(lbProduto12)
                    .addComponent(lbProduto15)
                    .addComponent(lbProduto14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(lbProduto3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(lbPreco3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbCondicao3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDescricao3, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAltera3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(lbProduto13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbProduto12))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbProduto3)
                                .addComponent(lbProduto15))
                            .addComponent(jButton32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDescricao3)
                            .addComponent(lbProduto14)
                            .addComponent(btnAltera3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCondicao3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPreco3))
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(220, 220, 220));
        jLabel16.setText("Página");

        lbPagAtual.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbPagAtual.setForeground(new java.awt.Color(220, 220, 220));
        lbPagAtual.setText("1");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(220, 220, 220));
        jLabel14.setText("de");

        lbNumPag.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbNumPag.setForeground(new java.awt.Color(220, 220, 220));
        lbNumPag.setText("1");

        jButton10.setBackground(new java.awt.Color(60, 60, 60));
        jButton10.setForeground(new java.awt.Color(220, 220, 220));
        jButton10.setText("Anterior");
        jButton10.setToolTipText("");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(60, 60, 60));
        jButton16.setForeground(new java.awt.Color(220, 220, 220));
        jButton16.setText("Próxima");
        jButton16.setToolTipText("");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        lbQtdProdutos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbQtdProdutos.setForeground(new java.awt.Color(220, 220, 220));
        lbQtdProdutos.setText("... ");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(220, 220, 220));
        jLabel17.setText("Foram encontrados");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(220, 220, 220));
        jLabel15.setText("produtos publicados no Fesa Share");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbQtdProdutos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbPagAtual)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNumPag))
                            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(prod1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton16))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(prod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton10)
                        .addComponent(jButton16))
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(lbQtdProdutos)
                        .addComponent(jLabel17))
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbPagAtual)
                        .addComponent(jLabel14)
                        .addComponent(jLabel16)
                        .addComponent(lbNumPag)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(lista.size() > produtoAtual + 3)
        {
            produtoAtual = produtoAtual + 3;
            if(pagAtual < numPag)
            pagAtual++;
        }
        else if(lista.size() > produtoAtual + 2)
        {
            produtoAtual = produtoAtual + 2;
            if(pagAtual < numPag)
            pagAtual++;
        }

        carregaListaProdutos();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if(produtoAtual - 3 > 0)
        {
            produtoAtual = produtoAtual - 3;
            if(pagAtual > 0)
            pagAtual--;
        }
        else if(produtoAtual - 2 > 0)
        {
            produtoAtual = produtoAtual - 2;
            if(pagAtual > 0)
            pagAtual--;
        }

        carregaListaProdutos();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        PaginaUnica pg = new PaginaUnica();
        pg.setVisible(true);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Sobre pgSobre = new Sobre();
        pgSobre.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Publicacoes.this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        meusProdutos = false;
        carregaListaProdutos();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        NovaPublicacao pgPubli = new NovaPublicacao();
        pgPubli.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // Inserir aqui a exclusão da conta
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        PoliticasDeCancelamento pgCancela = new PoliticasDeCancelamento();
        pgCancela.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        PoliticasDeDevolucao pgDevolucao = new PoliticasDeDevolucao();
        pgDevolucao.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        PoliticasDeFila pgFila = new PoliticasDeFila();
        pgFila.setVisible(true);
        Publicacoes.this.dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Reputacao pgReputacao = new Reputacao();
        pgReputacao.setVisible(true);
        Publicacoes.this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Historico pgHistorico = new Historico();
        pgHistorico.setVisible(true);
        Publicacoes.this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    //Minhas publicações
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        meusProdutos = true;
        carregaListaProdutos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        PaginaProduto pgProduto = new PaginaProduto();
        pgProduto.setVisible(true);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        PaginaProduto pgProduto = new PaginaProduto();
        pgProduto.setVisible(true);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton35jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35jButton31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton35jButton31ActionPerformed

    private void btnAltera1jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltera1jButton31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAltera1jButton31ActionPerformed

    private void btnAltera2jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltera2jButton31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAltera2jButton31ActionPerformed

    private void btnAltera3jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltera3jButton31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAltera3jButton31ActionPerformed
    
   
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
            java.util.logging.Logger.getLogger(Publicacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Publicacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Publicacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Publicacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Publicacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnAltera1;
    private javax.swing.JButton btnAltera2;
    private javax.swing.JButton btnAltera3;
    private javax.swing.JPanel cab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbCondicao1;
    private javax.swing.JLabel lbCondicao2;
    private javax.swing.JLabel lbCondicao3;
    private javax.swing.JLabel lbDescricao1;
    private javax.swing.JLabel lbDescricao2;
    private javax.swing.JLabel lbDescricao3;
    private javax.swing.JLabel lbNumPag;
    private javax.swing.JLabel lbPagAtual;
    private javax.swing.JLabel lbPreco1;
    private javax.swing.JLabel lbPreco2;
    private javax.swing.JLabel lbPreco3;
    private javax.swing.JLabel lbProduto1;
    private javax.swing.JLabel lbProduto10;
    private javax.swing.JLabel lbProduto11;
    private javax.swing.JLabel lbProduto12;
    private javax.swing.JLabel lbProduto13;
    private javax.swing.JLabel lbProduto14;
    private javax.swing.JLabel lbProduto15;
    private javax.swing.JLabel lbProduto2;
    private javax.swing.JLabel lbProduto3;
    private javax.swing.JLabel lbProduto4;
    private javax.swing.JLabel lbProduto5;
    private javax.swing.JLabel lbProduto6;
    private javax.swing.JLabel lbProduto7;
    private javax.swing.JLabel lbProduto8;
    private javax.swing.JLabel lbProduto9;
    private javax.swing.JLabel lbQtdProdutos;
    private javax.swing.JPanel prod1;
    private javax.swing.JTextField txtBuscarProduto2;
    private javax.swing.JLabel txtPub;
    // End of variables declaration//GEN-END:variables
}
