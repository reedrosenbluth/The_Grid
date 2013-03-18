package client;

import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class Tronmageddon {

	/**
	 * Execution point for client-side app.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		Bug b = new Bug();
		world.add(b);
		world.show();

	}

}
