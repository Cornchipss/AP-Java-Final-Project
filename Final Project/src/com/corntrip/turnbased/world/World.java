package com.corntrip.turnbased.world;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.corntrip.turnbased.rendering.IRenderable;
import com.corntrip.turnbased.util.Reference;

public class World implements IRenderable
{
	private final int WIDTH, HEIGHT;
	private Tile[][] tiles;
	
	public World(int width, int height)
	{
		WIDTH = width;
		HEIGHT = height;
		
		width /= Reference.TILE_DIMENSIONS;
		height /= Reference.TILE_DIMENSIONS;
		
		tiles = new Tile[width][height];
		
		for(int ty = 0; ty < tiles.length; ty++)
		{
			for(int tx = 0; tx < tiles[ty].length; tx++)
			{
				tiles[ty][tx] = new Tile(tx * Reference.TILE_DIMENSIONS, ty * Reference.TILE_DIMENSIONS, 
											Reference.TILE_DIMENSIONS, Reference.TILE_DIMENSIONS);
			}
		}
	}

	@Override
	public void render(GameContainer gc, Graphics gfx) throws SlickException
	{
		renderAt(gc, gfx, 0, 0);
	}

	@Override
	public void renderAt(GameContainer gc, Graphics gfx, float x, float y)
	{
		for(int ty = 0; ty < tiles.length; ty++)
		{
			for(int tx = 0; tx < tiles[ty].length; tx++)
			{
				try
				{
					tiles[ty][tx].render(gc, gfx);
				}
				catch(SlickException ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}
}
