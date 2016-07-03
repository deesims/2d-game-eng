package gameengine; 

import gameengine.gfx.Color;
import gameengine.gfx.Image;
import java.awt.image.DataBufferByte;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Renderer {
    
    
    private int width, height;
    private byte[] pixels; 
    
    
    public Renderer(GameContainer gc){
        width = gc.getWidth();
        height = gc.getHeight();
        pixels = ((DataBufferByte)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
    }
    
    
    public void setPixel(int x, int y, Color c){
        if(x < 0 || x >= width || y < 0 || y >= height || c.a==0){
            return;
        }
        
        int index = (x + y * width) * 4; // generator for 2 dimensional array to input into 1 dimensional array
        pixels[index] = (byte)((c.a*255f) + 0.5f);
        pixels[index + 1] = (byte)((c.b*255f) + 0.5f);
        pixels[index + 2] = (byte)((c.g*255f) + 0.5f);
        pixels[index + 3] = (byte)((c.r*255f) + 0.5f);
        
    }
    
    
    public void clear(){
        for(int x=0; x<width; x++){
            for(int y=0; y<height; y++){
                setPixel(x,y, Color.BLACK); //normal cyan colour
                //setPixel(x,y,1,(float)Math.random(), (float)Math.random(), (float)Math.random()); //static tv
            }
        }
    }
    
    
    public void drawImage(Image image, int offX, int offY){
        for(int x = 0; x< image.width; x++){
            for(int y=0; y< image.height; y++){
                setPixel(x + offX, y + offY, image.pixels[x+y * image.width]);
            }
        }
    }
}
