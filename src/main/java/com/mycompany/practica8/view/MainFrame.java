/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica8.view;

import com.mycompany.practica8.model.ImageHandler;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import static java.util.Locale.filter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author pabloantoniolopezmartin
 */
public class MainFrame extends javax.swing.JFrame {
    private JFileChooser fc;
    private String language;
    private File fichero;
    private boolean resize = true;
    private FileNameExtensionFilter filter;
    private ButtonGroup buttonGroup;
    private boolean spanish=true;
    private String infoDialogMessage;
    private String initialMessage;
    private String wantToExit;
    private String exit;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        initialConfig("Spanish");
    }
    private void initialConfig(String language){
        this.language=language;
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        if(language.equals("English")){spanish=false;}
        fc = new JFileChooser();
        buttonGroup = new ButtonGroup();
        spanishMenu.setSelected(true);
        applyThresholdMenu.setEnabled(false);
        saveImageMenu.setEnabled(false);
        setLanguage("Spanish");
        setDropTarget();
        initialDisplay();
       

    }
    private void initializeButtonGroup(){
        buttonGroup.add(spanishMenu);
        buttonGroup.add(englishMenu);
    }
    private void initialDisplay(){
        VentanaInterna vInterna= new VentanaInterna();
        vInterna.setTitle("Bienvenido");
        ImageHandler.setText(initialMessage,vInterna.getLienzo());    
        escritorio.add(vInterna);  
        vInterna.setVisible(true);
          
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openImageMenu = new javax.swing.JMenuItem();
        saveImageMenu = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        applyThresholdMenu = new javax.swing.JMenuItem();
        settingsMenu = new javax.swing.JMenu();
        languageMenu = new javax.swing.JMenu();
        spanishMenu = new javax.swing.JRadioButtonMenuItem();
        englishMenu = new javax.swing.JRadioButtonMenuItem();
        autoResizeMenu = new javax.swing.JCheckBoxMenuItem();
        helpMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        escritorio.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                escritorioComponentRemoved(evt);
            }
        });

        fileMenu.setText("File");

        openImageMenu.setText("Open image");
        openImageMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openImageMenuActionPerformed(evt);
            }
        });
        fileMenu.add(openImageMenu);

        saveImageMenu.setText("Save image");
        saveImageMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImageMenuActionPerformed(evt);
            }
        });
        fileMenu.add(saveImageMenu);

        jMenuBar1.add(fileMenu);

        editMenu.setText("Edit");

        applyThresholdMenu.setText("Aply threshold");
        applyThresholdMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyThresholdMenuActionPerformed(evt);
            }
        });
        editMenu.add(applyThresholdMenu);

        jMenuBar1.add(editMenu);

        settingsMenu.setText("Ajustes");

        languageMenu.setText("Language");

        spanishMenu.setSelected(true);
        spanishMenu.setText("Spanish");
        spanishMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spanishMenuActionPerformed(evt);
            }
        });
        languageMenu.add(spanishMenu);

        englishMenu.setSelected(true);
        englishMenu.setText("English");
        englishMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                englishMenuActionPerformed(evt);
            }
        });
        languageMenu.add(englishMenu);

        settingsMenu.add(languageMenu);

        autoResizeMenu.setSelected(true);
        autoResizeMenu.setText("Auto resize");
        autoResizeMenu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                autoResizeMenuItemStateChanged(evt);
            }
        });
        settingsMenu.add(autoResizeMenu);

        jMenuBar1.add(settingsMenu);

        helpMenu.setText("Help");
        helpMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openImageMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openImageMenuActionPerformed
        setFileChooser();
        int res = fc.showOpenDialog(null);
        if(res==JFileChooser.APPROVE_OPTION){
           openImageActions(fc.getSelectedFile());
        }
    }//GEN-LAST:event_openImageMenuActionPerformed
    
    private void applyThresholdMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyThresholdMenuActionPerformed
        try {
               String n= JOptionPane.showInputDialog(this,"Introduzca el umbral [0-255]","0");
                int num;
                if(n!=null){
                    if(n.equals("")){n="0";}
                    if(Integer.parseInt(n)>255){num=255;
                    }else if(Integer.parseInt(n)<0){num=0;
                    }else{num=Integer.parseInt(n);}
                    VentanaInterna ventana = (VentanaInterna) escritorio.getSelectedFrame();
                    try {
                        VentanaInterna vInterna= new VentanaInterna();
                        vInterna.setTitle("Thresholdized ("+num+") "+fichero.getName());
                        escritorio.add(vInterna);        
                        Dimension dimension= ImageHandler.applyThreshold(fichero,num,resize,vInterna.getLienzo());
                        vInterna.setSize(dimension);
                        vInterna.setLocation(ventana.getX()+20, ventana.getY()+20);
                        vInterna.setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    applyThresholdMenu.setSelected(false);
                }   
            } catch (java.lang.NumberFormatException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_applyThresholdMenuActionPerformed
    
    private void setLanguage(String language){
        if(language.equals("Spanish")){
           fileMenu.setText("Archivo");
           openImageMenu.setText("Abrir imagen");
           saveImageMenu.setText("Guardar imagen");
           editMenu.setText("Editar");
           applyThresholdMenu.setText("Umbralización");
           helpMenu.setText("Ayuda");
           languageMenu.setText("Idioma");
           spanishMenu.setText("Español");
           englishMenu.setText("English"); 
           infoDialogMessage="En el menú Archivo podrá abrir o guardar una imagen\n"
                           + "En el menú Editar podrá aplicar el umbralizado\n"
                           + "En el menú Ajustes podrá cambiar el idioma de la aplicación\n"
                           + "Por defecto las imágenes son reescaladas a la resolución 1024x768 (puede desactivarlo en el menú Ajustes) ";
           initialMessage="Arrastre o abra una imagen (Archivo > Abrir imagen)";
           settingsMenu.setText("Ajustes");
           autoResizeMenu.setText("Redimensión automática");
            wantToExit="¿Desea salir?";
            exit="Salir";
        }else if(language.equals("English")){
            fileMenu.setText("File");
            openImageMenu.setText("Open image");
            saveImageMenu.setText("Save image");
            editMenu.setText("Edit");
            applyThresholdMenu.setText("Aplicar Umbralizado");
            helpMenu.setText("Help");
            languageMenu.setText("Language");
            spanishMenu.setText("Español");
            englishMenu.setText("English");    
            infoDialogMessage="Use the File menu to open and save an image\n"
                           + "Use the Edit menu to apply the threshold\n"
                           + "Use the Settings menu to switch the language \n"
                           + "By default, images are resized to 1024x768 (it can be desactivated in the Settings menu)";
            initialMessage="Drop or open an image (File > Open image)";
            settingsMenu.setText("Settings");
            autoResizeMenu.setText("Automatic resize");
            wantToExit="Do you want to Exit ?";
            exit="Exit";
        }
    }
        
    private void saveImageMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveImageMenuActionPerformed
       int res = fc.showSaveDialog(null);
        if(res==JFileChooser.APPROVE_OPTION){
           try {
                VentanaInterna ventana = (VentanaInterna) escritorio.getSelectedFrame();
               ImageHandler.saveImage(fc.getSelectedFile().getAbsolutePath(),ventana.getLienzo());
           } catch (IOException ex) {
               Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }//GEN-LAST:event_saveImageMenuActionPerformed

    private void englishMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_englishMenuActionPerformed
       setLanguage("English");
    }//GEN-LAST:event_englishMenuActionPerformed

    private void spanishMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spanishMenuActionPerformed
       setLanguage("Spanish");
    }//GEN-LAST:event_spanishMenuActionPerformed

    private void escritorioComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_escritorioComponentRemoved
       if(escritorio.getAllFrames().length<1){
           applyThresholdMenu.setEnabled(false);
           saveImageMenu.setEnabled(false);
       }
    }//GEN-LAST:event_escritorioComponentRemoved

    private void helpMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMenuMouseClicked
        JOptionPane.showMessageDialog(this, infoDialogMessage,helpMenu.getText(),1);
    }//GEN-LAST:event_helpMenuMouseClicked

    private void autoResizeMenuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_autoResizeMenuItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
              resize=true;
          }else if(evt.getStateChange() == ItemEvent.DESELECTED){
              resize=false;
          }
    }//GEN-LAST:event_autoResizeMenuItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int result = JOptionPane.showConfirmDialog(this,wantToExit, exit,JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        }else if (result == JOptionPane.NO_OPTION){
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
        }
          
    }//GEN-LAST:event_formWindowClosing
    
    private void setFileChooser() {
        fc.setAcceptAllFileFilterUsed(false);
        filter = new FileNameExtensionFilter("Imágenes (png, jpg, jpeg, bmp)","png","jpg","jpeg","bmp");
        fc.addChoosableFileFilter(filter);
    }

    private void setDropTarget() {
        escritorio.setDropTarget(new DropTarget(){
            public synchronized void drop(DropTargetDropEvent evt){
                try{
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    List<File> droppedFiles = (List<File>)
                        evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                    for (File file: droppedFiles){
                        openImageActions(file);
                    }
                }catch(Exception e){}
            }
        });
        
    }

    private void openImageActions(File file){
        fichero=file;
        if(escritorio.getAllFrames()!=null){
            escritorio.removeAll();
            escritorio.repaint();
        }
        VentanaInterna vInterna= new VentanaInterna();
        vInterna.setTitle(file.getName());
        escritorio.add(vInterna);
        Dimension dimension=ImageHandler.openImage(file,resize,vInterna.getLienzo());
        vInterna.setSize(dimension);
        saveImageMenu.setEnabled(true);
        vInterna.setVisible(true);
        applyThresholdMenu.setEnabled(true);
    }


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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem applyThresholdMenu;
    private javax.swing.JCheckBoxMenuItem autoResizeMenu;
    private javax.swing.JMenu editMenu;
    private javax.swing.JRadioButtonMenuItem englishMenu;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu languageMenu;
    private javax.swing.JMenuItem openImageMenu;
    private javax.swing.JMenuItem saveImageMenu;
    private javax.swing.JMenu settingsMenu;
    private javax.swing.JRadioButtonMenuItem spanishMenu;
    // End of variables declaration//GEN-END:variables

}
