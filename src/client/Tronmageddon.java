package client;

import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.*;
import info.gridworld.grid.*;


public class Tronmageddon {

	/**
	 * Execution point for client-side app.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		
		Bug b = new Bug();
		world.setGrid(new BoundedGrid<Actor>(42,95));
		world.add(b);
		
		
		world.show();
	}
	
	public Location getLocation(Actor a){
		return a.getLocation();
	}
}
