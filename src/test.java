
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JFrame;
//import javax.swing.UIManager;
//import javax.swing.UnsupportedLookAndFeelException;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author Kashish
// */
//public class test {
//    
//}


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class test {

//  public static void main(String[] args) {
//    new test();
//  }

//  public test() {
//    EventQueue.invokeLater(new Runnable() {
//      @Override
//      public void run() {
//        try {
//          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//          ex.printStackTrace();
//        }
//
////        TestPane pane = new TestPane();
//        ZoomPane zoomPane = new ZoomPane(pane);
//
//        JFrame frame = new JFrame("Testing");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(pane);
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//      }
//    });
//  }

  

//  public class TestPane extends JPanel {
//
//    private BufferedImage img;
//
//    public TestPane() {
//      try {
//        img = ImageIO.read(new File("/Users/Kashish/Documents/mdeical.jpeg"));
//      } catch (IOException ex) {
//        ex.printStackTrace();
//      }
//    }
//
//    @Override
//    public Dimension getPreferredSize() {
//      return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(), img.getHeight());
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//      super.paintComponent(g);
//      if (img != null) {
//        Graphics2D g2d = (Graphics2D) g.create();
//        int x = (getWidth() - img.getWidth()) / 2;
//        int y = (getHeight() - img.getHeight()) / 2;
//        g2d.drawImage(img, x, y, this);
//        g2d.dispose();
//      }
//    }
//
//  }

}
