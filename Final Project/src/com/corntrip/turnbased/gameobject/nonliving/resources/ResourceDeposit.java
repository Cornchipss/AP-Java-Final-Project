package com.corntrip.turnbased.gameobject.nonliving.resources;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.corntrip.turnbased.gameobject.GameObject;
import com.corntrip.turnbased.util.Resources;

public class ResourceDeposit extends GameObject
{
	private Image img;
	
	public ResourceDeposit(float startX, float startY, float w, float h)
	{
		super(startX, startY, w, h);
		
		img = Resources.getImage("deposit");
	}

	@Override
	public void render(GameContainer gc, Graphics gfx, float offsetX, float offsetY) throws SlickException
	{		
		img.draw(getX() - offsetX, getY() - offsetY);
	}
}
