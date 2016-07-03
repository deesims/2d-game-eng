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
public abstract class AbstractGame 
{
    public abstract void update(GameContainer gc, float dt);
    public abstract void render(GameContainer gc, Renderer r); 
}
