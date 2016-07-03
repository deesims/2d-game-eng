package gameengine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
/**
 *
 * @author Alex
 */
public class Window {
    
    
    private JFrame frame; 
    private Canvas canvas; 
    private BufferedImage image; 
    private Graphics g; 
    private BufferStrategy bs; 
    
    
    public Window(GameContainer gc){
        image = new BufferedImage(gc.getWidth(), gc.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        canvas = new Canvas();
        Dimension s = new Dimension((int)(gc.getWidth() * gc.getScale()), (int)(gc.getHeight() * gc.getScale()));
        canvas.setPreferredSize(s);
        canvas.setMaximumSize(s);
        canvas.setPreferredSize(s);
        
        frame = new JFrame(gc.getTitle());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setBackground(Color.BLACK);
        
        canvas.createBufferStrategy(1);
        bs = canvas.getBufferStrategy();
        g = bs.getDrawGraphics();
        
        
    }
    public void update(){
        g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null); 
        bs.show();     
    }
    
    public void cleanUp(){
        g.dispose();
        bs.dispose();
        image.flush();
        frame.dispose();
    }
    
    Canvas getCanvas(){
        return canvas; 
    }
    
    BufferedImage getImage(){
        return image; 
    }
    
}
