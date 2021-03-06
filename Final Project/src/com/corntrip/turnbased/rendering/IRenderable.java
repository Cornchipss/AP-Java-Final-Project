/*
 * Anthony Tornetta & Troy Cope | P5 | 3/31/18
 * This is our own work: ACT & TC
 * Something that can be rendered on a scene
 */

package com.corntrip.turnbased.rendering;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Anything that can be rendered in the world should implement this interface
 */
public interface IRenderable
{
	/**
	 * Draws the object at a position on the window
	 * @param gc The main game's container
	 * @param gfx The Graphics object to use to draw
	 * @throws SlickException Potentially thrown when drawing
	 */
	public void render(GameContainer gc, Graphics gfx) throws SlickException;
	
	/**
	 * Draws the object at a specified position on the window
	 * @param gc The main game's container
	 * @param gfx The Graphics object to use to draw
	 * @param offsetX The offset on the x axis to use when drawing the object
	 * @param offsetY The offset on the y axis to use when drawing the object
	 * @throws SlickException Potentially thrown when drawing
	 */
	public void render(GameContainer gc, Graphics gfx, float offsetX, float offsetY) throws SlickException;
}
