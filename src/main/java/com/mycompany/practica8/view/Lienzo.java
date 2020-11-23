/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica8.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pabloantoniolopezmartin
 */
public class Lienzo extends JPanel {
    private  BufferedImage imagen=null;
   // @Override
    private JLabel label;
    public Lienzo(){
      label = new JLabel();  
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagen,0,0,null);
        
        if(!label.equals("")){
            g.drawString(label.getText(), (this.getWidth()/2)-label.getText().length()*3, this.getHeight()/2);
           
        }
    }
    public void setImage(BufferedImage imagen){
        this.imagen=imagen;
    }
    public BufferedImage getImage(){
        return imagen;
    }
    public void removeImage(){
        imagen=null;
    }
    public void addText(String texto){
        label.setText(texto);
        add(label);
        repaint();
    }
}
