
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kashish
 */
public class frame1 extends javax.swing.JFrame {

    
    public static int zoomtype=0;
    public static int scale = 2;
    private ArrayList<JCheckBox> zooms = new ArrayList<>();
    private ZoomPane z1,z2;
    /**
     * Creates new form frame1
     */
    public frame1() {
        initComponents();
        
        zooms.add(defaultZoom);
        zooms.add(replicateZoom);
        zooms.add(interpolateZoom);
        
        
//        orgImgLabel.
        
//        jScrollPane1.getHorizontalScrollBar().setUnitIncrement(16);
//        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
    }
    
    public static int[][][] getPixels(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        int[][][] result = new int[height][width][4];
        for (int x = 0; x < image.getHeight(); x++) {
            for (int y = 0; y < image.getWidth(); y++) {
                Color c = new Color(image.getRGB(x, y), true);
                result[x][y][0] = c.getRed();
                result[x][y][1] = c.getGreen();
                result[x][y][2] = c.getBlue();
                result[x][y][3] = c.getAlpha();
            }
        }
        
        return result;
    }
    
    public static BufferedImage getImageObjectReplication(int[][][] pixelValues){
        BufferedImage image = new BufferedImage(pixelValues[0].length*scale, pixelValues.length*scale, BufferedImage.TYPE_INT_ARGB);
        
        for (int i = 0; i < pixelValues[0].length; i++) {
            for (int j = 0; j < pixelValues.length; j++) {
                Color c= new Color(pixelValues[i][j][0],pixelValues[i][j][1],pixelValues[i][j][2],pixelValues[i][j][3]);
//                image.s
                int i1=scale*i,j1=scale*j;
//                Color c = new Color(red[i][j], green[i][j], blue[i][j]);
                for(int x=0;x<scale;x++){
                    for(int y=0;y<scale;y++){
                        image.setRGB(i1+x, j1+y, c.getRGB());
//                        image.setRGB(j1+1, i1+1, c.getRGB());
//                        image.setRGB(j1, i1+1, c.getRGB());
//                        image.setRGB(j1+1, i1, c.getRGB());
                    }
                }
                
//                image.
            }
        }
        
        return image;
    }

        public static BufferedImage getImageObjectInterpolation(int[][][] pixelValues){
        BufferedImage image = new BufferedImage(pixelValues.length*scale, pixelValues[0].length*scale, BufferedImage.TYPE_INT_ARGB);
        
        for (int i = 0; i < pixelValues.length; i++) {
            for (int j = 0; j < pixelValues[0].length; j++) {
//                int pix[][] = new int[4][4];
//                pix[0] = pixelValues[i][j];
//                pix[1] = pixelValues[i+1][j];
//                pix[2] = pixelValues[i][j+1];
//                pix[3] = pixelValues[i+1][j+1];
                Color c= new Color(pixelValues[i][j][0],pixelValues[i][j][1],pixelValues[i][j][2],pixelValues[i][j][3]);
                Color c1,c2,c3;
                if(i<pixelValues[0].length -1)
                    c1= new Color(pixelValues[i+1][j][0],pixelValues[i+1][j][1],pixelValues[i+1][j][2],pixelValues[i+1][j][3]);
                else c1=c;
                if(j<pixelValues.length - 1)
                    c2= new Color(pixelValues[i][j+1][0],pixelValues[i][j+1][1],pixelValues[i][j+1][2],pixelValues[i][j+1][3]);
                else c2=c;
                if(i<pixelValues[0].length -1 && j<pixelValues.length - 1)
                    c3= new Color(pixelValues[i+1][j+1][0],pixelValues[i+1][j+1][1],pixelValues[i+1][j+1][2],pixelValues[i+1][j+1][3]);
                else c3=c;
//                image.s
                int i1=scale*i,j1=scale*j;
//                int weights[] = new int[4];
//                Color c = new Color(red[i][j], green[i][j], blue[i][j]);
                for(int x=0;x<scale;x++){
                    for(int y=0;y<scale;y++){
//                        weights[0] = (scale*2-y-x);
//                        weights[1] = (scale-y+x);
//                        weights[2] = (scale+y-x);
//                        weights[3] = (y+x);
//                        int w[]=new int[4];
//                        for(int i=0;i<4;i++){
//                            w[i] = 
//                        }
                        if(x==0){
                            if(y==0)image.setRGB(i1+x,j1+y,c.getRGB());
                            if(y==0)image.setRGB(i1+x,j1+y,c2.getRGB());
//                            else if(y)
                        }
                        if(y==scale-1){
                            if(y==0)image.setRGB(i1+x,j1+y,c1.getRGB());
                            if(y==scale-1)image.setRGB(i1+x,j1+y,c3.getRGB());
                        }
                        int w1 = (scale-x);
                        int w2 = (scale-y);
                        int rgb = (int)(((x+y)*c3.getRGB() + (scale-x + y)*c1.getRGB() + (scale-y+x)*c2.getRGB() + (scale*2-x-y)*c.getRGB())/(4*scale));
                        image.setRGB(i1+x,j1+y,rgb );
                    }
                }
//                image.setRGB(j1, i1, c.getRGB());
//                image.setRGB(j1+1, i1+1, (c.getRGB() + c3.getRGB())/2);
//                image.setRGB(j1, i1+1, (c.getRGB() + c1.getRGB())/2);
//                image.setRGB(j1+1, i1, (c.getRGB() + c2.getRGB())/2);
//                image.
            }
        }
        
        return image;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jPanel3 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        effectImgLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orgImgLabel = new javax.swing.JLabel();
        chooseImgbtn = new javax.swing.JButton();
        defaultZoom = new javax.swing.JCheckBox();
        replicateZoom = new javax.swing.JCheckBox();
        interpolateZoom = new javax.swing.JCheckBox();
        scaleText = new java.awt.TextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        effectImgLabel.setText("Effect Image");
        jScrollPane1.setViewportView(effectImgLabel);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setRightComponent(jPanel4);

        orgImgLabel.setText("Original Image");
        jScrollPane2.setViewportView(orgImgLabel);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setLeftComponent(jPanel5);

        chooseImgbtn.setText("Choose Image");
        chooseImgbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImgbtnActionPerformed(evt);
            }
        });

        defaultZoom.setText("default");
        defaultZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultZoomActionPerformed(evt);
            }
        });

        replicateZoom.setText("replication");
        replicateZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replicateZoomActionPerformed(evt);
            }
        });

        interpolateZoom.setText("interpolation");
        interpolateZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interpolateZoomActionPerformed(evt);
            }
        });

        scaleText.setText("textField1");
        scaleText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chooseImgbtn)
                        .addGap(18, 18, 18)
                        .addComponent(defaultZoom)
                        .addGap(18, 18, 18)
                        .addComponent(replicateZoom)
                        .addGap(18, 18, 18)
                        .addComponent(interpolateZoom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scaleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chooseImgbtn)
                        .addComponent(defaultZoom)
                        .addComponent(replicateZoom)
                        .addComponent(interpolateZoom))
                    .addComponent(scaleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseImgbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImgbtnActionPerformed
        // TODO add your handling code here:
//        JFileChooser imgChooser = new JFileChooser();
//        imgChooser.showOpenDialog(null);
//        File f = imgChooser.getSelectedFile();
//        String imgAdr = f.get
//        ImageIcon imgIcon = new ImageIcon(f.getAbsolutePath());
        ImageIcon imgIcon = new ImageIcon("/Users/Kashish/Documents/sem7/dia/test_images/download.jpeg");
        orgImgLabel.setIcon(imgIcon);
        orgImgLabel.setText("");
        effectImgLabel.setIcon(imgIcon);
        effectImgLabel.setText("");
        
//        free();
//        z1.ZOOM_AREA=0;
//        z2.ZOOM_AREA=0;
        if(z1!=null){
            z1.ma=null;
        }
        if(z2!=null)z2.ma=null;
        
        z1 = new ZoomPane(orgImgLabel);
        z2 = new ZoomPane(effectImgLabel);
        
//        z1.

        
    }//GEN-LAST:event_chooseImgbtnActionPerformed

    private void defaultZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultZoomActionPerformed
        // TODO add your handling code here:
        
        zoomtype = 0;
        setZoomCheckBox();
        
    }//GEN-LAST:event_defaultZoomActionPerformed

    private void replicateZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replicateZoomActionPerformed
        // TODO add your handling code here:
        zoomtype=1;
        setZoomCheckBox();
    }//GEN-LAST:event_replicateZoomActionPerformed

    private void interpolateZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interpolateZoomActionPerformed
        // TODO add your handling code here:
        zoomtype=2;
        setZoomCheckBox();
        
    }//GEN-LAST:event_interpolateZoomActionPerformed

    private void scaleTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleTextActionPerformed
        // TODO add your handling code here:
                scale = Integer.parseInt(scaleText.getText());

    }//GEN-LAST:event_scaleTextActionPerformed

    
    private void setZoomCheckBox(){
        
        for(JCheckBox c: zooms){
            c.setSelected(false);
        }
        
        switch(zoomtype){
            case 0:
                defaultZoom.setSelected(true);
                break;
            case 1:
                replicateZoom.setSelected(true);
                break;
            case 2:
                interpolateZoom.setSelected(true);
                break;
        }
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
            java.util.logging.Logger.getLogger(frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseImgbtn;
    private javax.swing.JCheckBox defaultZoom;
    private javax.swing.JLabel effectImgLabel;
    private javax.swing.JCheckBox interpolateZoom;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JLabel orgImgLabel;
    private javax.swing.JCheckBox replicateZoom;
    private java.awt.TextField scaleText;
    // End of variables declaration//GEN-END:variables
}
