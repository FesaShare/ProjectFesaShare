/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.fesa_share.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author lasou
 */
public class ManipularImagem {
    public static byte[] getImgBytes(BufferedImage image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{
            ImageIO.write(image, "JPEG", baos);
        }catch (IOException ex){
            
        }
        InputStream is = new ByteArrayInputStream(baos.toByteArray());
        return baos.toByteArray();
    }
    
    //Método que exibe imagens na tela
    //Recebe o label que queremos exibir e a imagem como array de bytes
    public static void exibeImagemLabel(byte[] minhaimagem, javax.swing.JLabel label){
        if (minhaimagem!=null)
        {
            InputStream input = new ByteArrayInputStream(minhaimagem);
            try{
                BufferedImage imagem = ImageIO.read(input);
                label.setIcon(new ImageIcon(imagem));
            }
            catch(IOException ex){
            }
        }
        else {
            label.setIcon(null);
        }
    }
}
