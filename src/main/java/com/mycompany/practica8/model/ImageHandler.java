/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica8.model;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import com.mycompany.practica8.model.*;
import com.mycompany.practica8.view.Lienzo;
import javax.swing.JLabel;
/**
 *
 * @author pabloantoniolopezmartin
 */
    public class ImageHandler {
        
    private static Dimension dim;
    
    public static Dimension openImage(File fichero, Boolean resize, Lienzo lienzo){
        try{
            BufferedImage image= ImageIO.read(fichero);
            System.out.println(image.getWidth());
            System.out.println(image.getHeight());
            BufferedImage aux;
            if(resize){
               aux=checkSize(image);
               image=aux;
            }
            System.out.println(image.getWidth());
             System.out.println(image.getHeight());
            if(dim==null){
            dim= new Dimension(image.getWidth(),image.getHeight());
            }
            lienzo.setImage(image);
            return dim;
        }catch(Exception e){
             return null;
        }
    }
    public static void setText(String texto,Lienzo lienzo){
        lienzo.addText(texto);
        
        
    }
    private static BufferedImage checkSize(BufferedImage image){
        if(image.getWidth()>1024 || image.getHeight()>768 ){
            double widthCoeficient= image.getWidth()/1024.;
            double heightCoeficient= image.getHeight()/768;
            image= rescale(image, widthCoeficient, heightCoeficient);
              System.out.println("a");
        }else{
            dim=new Dimension(image.getWidth(),image.getHeight());
        }
      
        System.out.println(dim.getWidth());
             System.out.println(dim.getHeight());
        return image;
    } 
    
    private static BufferedImage rescale(BufferedImage image, double widthCoeficient, double heightCoeficient){
        BufferedImage before = image;
        int w = before.getWidth();
        int h = before.getHeight();
        double coeficient;
        BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        if(widthCoeficient>heightCoeficient){
           coeficient=widthCoeficient;
        }else{
           coeficient=heightCoeficient;
        }
        at.scale(1/coeficient, 1/coeficient);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        after = scaleOp.filter(before, after);
        int newWidth = new Double(image.getWidth() * 1/coeficient).intValue();
        int newHeight = new Double(image.getHeight() * 1/coeficient).intValue();
        dim = new Dimension(newWidth,newHeight);
        return after;
    }

    public static void saveImage(String path, Lienzo lienzo) throws IOException {
        BufferedImage bi = checkSize(lienzo.getImage());
        System.out.println(bi.getWidth());
        File outputfile = new File(path);
        ImageIO.write(bi, "png", outputfile);
    }
   
    public static Dimension applyThreshold(File fichero, Integer umbral, Boolean resize, Lienzo lienzo) throws IOException {
        nu.pattern.OpenCV.loadShared(); System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat mat= Imgcodecs.imread(fichero.getAbsolutePath()); 
        mat= umbralizar(mat,umbral);    
        BufferedImage image=(BufferedImage) HighGui.toBufferedImage(mat);
        if(resize){
            lienzo.setImage(checkSize(image));  
            return dim;
        
        }else{
            lienzo.setImage(image); 
            return new Dimension(image.getWidth(),image.getHeight());
        } 
        
       
    }
    
    private static  Mat umbralizar(Mat imagen_original, Integer umbral) { // crear dos imágenes en niveles de gris con el mismo
        // crear dos imágenes en niveles de gris con el mismo        
        // tamaño que la original
        Mat imagenGris = new Mat(imagen_original.rows(),
                                imagen_original.cols(),
                                CvType.CV_8U);
        
        Mat imagenUmbralizada = new Mat(imagen_original.rows(),
                                        imagen_original.cols(), 
                                        CvType.CV_8U);
        
        // convierte a niveles de grises la imagen original
        Imgproc.cvtColor(imagen_original,imagenGris, Imgproc.COLOR_BGR2GRAY);

        // umbraliza la imagen:
        // - píxeles con nivel de gris > umbral se ponen a 1 
        // - píxeles con nivel de gris <= umbra se ponen a 0
        Imgproc.threshold(imagenGris,
                          imagenUmbralizada, 
                          umbral,
                          255,
                          Imgproc.THRESH_BINARY);
        return imagenUmbralizada;

        }
}

