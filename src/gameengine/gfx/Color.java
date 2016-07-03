/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine.gfx;

/**
 *
 * @author Alex
 */
public class Color {
    
    
    public static Color BLACK = new Color(1,0,0,0);
    public float a, r, g, b;
    
    
    public Color(float a, float r, float g, float b){
        this.a = a;
        this.r = r;
        this.g = g;
        this.b = b; 
    }
}
