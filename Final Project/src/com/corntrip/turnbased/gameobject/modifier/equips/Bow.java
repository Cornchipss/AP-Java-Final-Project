package com.corntrip.turnbased.gameobject.modifier.equips;

import org.newdawn.slick.Image;

import com.corntrip.turnbased.gameobject.Entity;
import com.corntrip.turnbased.gameobject.modifier.equips.weaponUtil.Arrows;

public class Bow extends Weapon
{

	public Bow(Entity owner, Image a)
	{
		setOwner(owner);
		tier = 1;
		setDamage((float)(tier*4.212));
	}
	
	@Override
	public void attack() 
	{//needs an image
		new Arrows(getOwner().getX(), getOwner().getY(), getOwner().getWidth(), getOwner().getHeight(), getOwner().getWorld(), this, null);
	}

	@Override
	public Bow upgrade() 
	{
		tier++;
		return new Bow(getOwner(), null);
	}
}
