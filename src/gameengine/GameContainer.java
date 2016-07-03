package gameengine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class GameContainer implements Runnable {
    

    private Thread thread;
    private AbstractGame game;
    private Window window; 
    private Renderer renderer;
    private Input input;
    
    
    private int width = 320, height = 240; 
    private float scale = 2.0f; 
    private String title = "Java Engine 1.0 by deesims"; 
    private boolean isRunning = false; 
    private double frameCap = 1.0 / 60.0; 


    public GameContainer(AbstractGame game)
    {
        this.game = game; 
    }
    
    
    int getWidth(){
        return width;
    }
    
    int getHeight(){
        return height;
    }
    
    float getScale(){
        return scale; 
    }
    
    Window getWindow(){
        return window; 
    }
    
    String getTitle(){
        return title; 
    }
    
    public void setWidth(int x){
        width = x; 
    }
    
    public void setHeight(int x){
        height = x; 
    }
    
    public void setScale(float x){
        scale = x; 
    }
    
    public void setTitle(String s){
        title = s; 
    }
    
    public void start()
    {
        if (isRunning)
            return;
        
        
        window = new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);
        
        thread = new Thread(this);
        thread.run();
    }
    
    public void stop()
    {
        if (!isRunning)
            return; 
        
        isRunning = false; 
    }
    
    public void run() 
    {    
        isRunning = true; 
        
        
        double firstTime = 0; 
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0; 
        double unprocessedTime = 0; 
        double frameTime = 0; 
        int frames = 0; 
        
        while(isRunning)
        {
            
            boolean render = true;
            
            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime; 
            lastTime = firstTime; 
            
            unprocessedTime += passedTime; 
            frameTime += passedTime; 
            
            while(unprocessedTime >= frameCap)
            {
                game.update(this, (float)frameCap);
                input.update();
                unprocessedTime -= frameCap;  
                render = true; 
                
                if (frameTime >= 1){
                    frameTime = 0;
                    System.out.println(frames);
                    frames = 0; 
                }
            }
            
            if(render)
            {
                renderer.clear();
                game.render(this,renderer);
                window.update();
                frames++;
                
            } else 
            {
                try 
                {
                    Thread.sleep(1);
                   
                } catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block 
                    e.printStackTrace();
                }
            }
        }
        
        cleanUp();
            
         
    }
    
    private void cleanUp(){
        window.cleanUp();
    }
}
