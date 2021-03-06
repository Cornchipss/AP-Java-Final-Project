/*
 * Anthony Tornetta & Troy Cope | P5 | 3/31/18
 * This is our own work: ACT & TC
 * Creates a new World object based off an image
 */

package com.corntrip.turnbased.world;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;

import com.corntrip.turnbased.gameobject.living.Enemy;
import com.corntrip.turnbased.gameobject.living.Player;
import com.corntrip.turnbased.gameobject.nonliving.Tree;
import com.corntrip.turnbased.gameobject.nonliving.Wall;
import com.corntrip.turnbased.gameobject.nonliving.resources.GoldResource;
import com.corntrip.turnbased.gameobject.nonliving.resources.ResourceDeposit;
import com.corntrip.turnbased.gameobject.nonliving.resources.ResourceGenerator;
import com.corntrip.turnbased.gameobject.nonliving.townhall.Townhall;
import com.corntrip.turnbased.util.Reference;
import com.corntrip.turnbased.util.Resources;

public class WorldLoader
{
	public static World generateWorldFromImage(BufferedImage img, GameContainer gc)
	{
		//intialization of a world
		World world = new World(img.getWidth() * Reference.TILE_DIMENSIONS, img.getHeight() * Reference.TILE_DIMENSIONS);
		
		final int w = Reference.TILE_DIMENSIONS, h = Reference.TILE_DIMENSIONS;
		
		List<Enemy> enemies = new ArrayList<>();
		
		//scanning of the map's image and comparing of each individual color
		for(int y = 0; y < img.getHeight(); y++)
		{
			for(int x = 0; x < img.getWidth(); x++)
			{
				Color c = new Color(img.getRGB(x, y));
				
				//all squares and in terms of tiles
				final float actualX = x * w;
				final float actualY = y * h;
				
				//big if statementes to generate all the items from the paint image
				//basically compares color code to the drawn map
				if(c.equals(Reference.RESOURCE_SPAWN_POINT_KEY))
				{
					world.addObject(new ResourceGenerator(actualX, actualY, w * 2, h * 2, world, 10000, 
							new GoldResource(actualX + w / 2, actualY + h / 2, w, h)));
				}
				else if(c.equals(Reference.TREE_SPAWN_KEY))
				{
					world.addObject(new Tree(actualX, actualY, w * 2, h * 3));
				}
				else if(c.equals(Reference.WALL_SPAWN_KEY))
				{
					world.addObject(new Wall(actualX, actualY, w, h, 
										Resources.getImage("wall")));
				}
				else if(c.equals(Reference.TOWN_HALL_KEY))
				{
					world.setTownhall(new Townhall(actualX, actualY, w * 4, h * 4));
				}
				else if(c.equals(Reference.PLAYER_KEY))
				{
					world.setPlayer(new Player(actualX, actualY, w, h, world, gc.getInput()));
				}
				else if(c.equals(Reference.DEPOSIT_KEY))
				{
					world.addObject(new ResourceDeposit(actualX, actualY, w, h));
				}
			}
		}
		
		//sets all the enemies to the player
		for(Enemy e : enemies)
		{
			e.setTarget(world.getPlayer());
		}
		
		return world;
	}
}
