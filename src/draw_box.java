
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kashish
 */
public class draw_box extends JPanel {
    
    private int x,y;
    
    void drawing(int x, int y){
        this.x=x;
        this.y=y;
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 20, 20);
    }
    
}
