package test;

import gameengine.AbstractGame;
import gameengine.GameContainer;
import gameengine.Input;
import gameengine.Renderer;
import gameengine.gfx.Image;
import java.awt.event.KeyEvent;



public class Game extends AbstractGame {
    
    private Image image = new Image("/test.png");

    public static void main(String args[]){
        GameContainer gc = new GameContainer(new Game());
        gc.start();
    }
    
    
    @Override
    public void update(GameContainer gc, float dt){
        if(Input.isKeyReleased(KeyEvent.VK_A)){
            System.out.println("Hello");
        }
    }
    
    @Override 
    public void render(GameContainer gc, Renderer r){
        r.drawImage(image,50,50);
    }



}


