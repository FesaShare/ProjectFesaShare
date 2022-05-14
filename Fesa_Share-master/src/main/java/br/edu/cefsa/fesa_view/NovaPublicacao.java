/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.cefsa.fesa_view;

import br.edu.cefsa.fesa_share.dao.ImagemDAO;
import br.edu.cefsa.fesa_share.dao.ProdutoDAO;
import br.edu.cefsa.fesa_share.exception.PersistenciaException;
import br.edu.cefsa.fesa_share.models.Categoria;
import br.edu.cefsa.fesa_share.models.Imagem;
import br.edu.cefsa.fesa_share.models.Produto;
import br.edu.cefsa.fesa_share.models.Usuario;
import br.edu.cefsa.fesa_share.util.ManipularImagem;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author lasou
 */
public class NovaPublicacao extends javax.swing.JFrame {

    /**
     * Creates new form NovaPublicacao
     */

    String caminho;
    public NovaPublicacao() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelImagem = new javax.swing.JLabel();
        jButtonAddImagem = new javax.swing.JButton();
        jTextFieldPath = new javax.swing.JTextField();
        jButtonEnviar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCondicaoProduto = new javax.swing.JTextField();
        txtTituloProduto = new javax.swing.JTextField();
        txtDescricaoProduto = new javax.swing.JTextField();
        txtPrecoAluguelProduto = new javax.swing.JTextField();
        jButtonEnviar1 = new javax.swing.JButton();
        jButtonEnviar2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbCategoriasProduto = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtDetalhesProduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonAddImagem.setText("Adicionar Imagem");
        jButtonAddImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddImagemActionPerformed(evt);
            }
        });

        jButtonEnviar.setText("Enviar");
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jLabel3.setText("Título");

        jLabel4.setText("Descrição");

        jLabel5.setText("Preço / Dia");

        jLabel6.setText("Condição");

        jButtonEnviar1.setText("Salvar");
        jButtonEnviar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviar1ActionPerformed(evt);
            }
        });

        jButtonEnviar2.setText("Cancelar");
        jButtonEnviar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviar2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Categoria");

        cbCategoriasProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Livro", "Kit Eletronica", "Instrumento Musical", "Esportes / Lazer" }));
        cbCategoriasProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriasProdutoActionPerformed(evt);
            }
        });

        jLabel8.setText("Detalhes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonEnviar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEnviar1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEnviar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonAddImagem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDetalhesProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtPrecoAluguelProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                                        .addComponent(txtDescricaoProduto, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCondicaoProduto)
                                        .addComponent(txtTituloProduto, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(cbCategoriasProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTituloProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecoAluguelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCondicaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDetalhesProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategoriasProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddImagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEnviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEnviar1)
                    .addComponent(jButtonEnviar2)))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nova Publicacao");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(499, 623));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddImagemActionPerformed
        JFileChooser arquivo =  new JFileChooser();
        arquivo.setDialogTitle("Selecione uma imagem");
        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        int opc = arquivo.showOpenDialog(this);
        if(opc == JFileChooser.APPROVE_OPTION){
            File file = new File("caminho");
            file = arquivo.getSelectedFile(); // Recebe o caminho
            String filename = file.getAbsolutePath();
            this.caminho = filename;
            jTextFieldPath.setText(filename);
            
            ImageIcon imagem = new ImageIcon(arquivo.getSelectedFile().getPath());
            
            jLabelImagem.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(jLabelImagem.getWidth(), jLabelImagem.getHeight(), Image.SCALE_DEFAULT)));
        }
    }//GEN-LAST:event_jButtonAddImagemActionPerformed

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        try{
            
            Imagem img = new Imagem();
            img.setCaminho(this.caminho);
            img.setNome("Nova");
            
            
            ImagemDAO dao = new ImagemDAO();
            boolean foi = dao.inserir(img);
            System.out.println("Estou aqui");
            if (foi)
            {
                JOptionPane.showMessageDialog(rootPane, "Imagem enviada com sucesso");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Imagem enviada com sucesso");
            }
        }
        catch (Exception ex){
           // 
        }
    }//GEN-LAST:event_jButtonEnviarActionPerformed
    
    //Salvar Produto
    private void jButtonEnviar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviar1ActionPerformed
       Produto p = new Produto();
       Usuario u = new Usuario();
       Categoria c = new Categoria();
       u.setCodigo(33);
       c.setCodigo(6);
       p.setUsuarioID(33);
       p.setCategoriaID(6);
       p.setTitulo(txtTituloProduto.getText());
       p.setDescricao(txtDescricaoProduto.getText());
       p.setCondicao(txtCondicaoProduto.getText());
       p.setPrecoTotal(Double.parseDouble(txtPrecoAluguelProduto.getText()));
       p.setAluguelStatus("Disponível");
       p.setImagemID(2);
       p.setDetalhes(txtDetalhesProduto.getText());
       
       ProdutoDAO pDAO = new ProdutoDAO();
       
        try {
            pDAO.inserir(p);
            JOptionPane.showMessageDialog(null, "Produto Inserido com sucesso");
            NovaPublicacao.this.dispose();
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o produto na base de dados " + ex);
            Logger.getLogger(NovaPublicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jButtonEnviar1ActionPerformed

    private void jButtonEnviar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEnviar2ActionPerformed

    private void cbCategoriasProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriasProdutoActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriasProdutoActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(NovaPublicacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovaPublicacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovaPublicacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovaPublicacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovaPublicacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbCategoriasProduto;
    private javax.swing.JButton jButtonAddImagem;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JButton jButtonEnviar1;
    private javax.swing.JButton jButtonEnviar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldPath;
    private javax.swing.JTextField txtCondicaoProduto;
    private javax.swing.JTextField txtDescricaoProduto;
    private javax.swing.JTextField txtDetalhesProduto;
    private javax.swing.JTextField txtPrecoAluguelProduto;
    private javax.swing.JTextField txtTituloProduto;
    // End of variables declaration//GEN-END:variables
}
