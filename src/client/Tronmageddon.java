package client;

import java.awt.Color;
import java.util.*;

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
		ActorBug player = new ActorBug();
		world.add(player);
		world.show();
	}
}
