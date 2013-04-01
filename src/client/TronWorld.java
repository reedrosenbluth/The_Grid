package client;

import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.world.World;

public class TronWorld<T> extends World<T> {
	public TronWorld() {
		super(new UnboundedGrid());
	}
	
	public boolean keyPressed(String description, Location loc) {
		if(description.equals("LEFT")) {
			System.out.println("Turn left");
		} else if(description.equals("RIGHT")) {
			System.out.println("Turn right");
		} else if(description.equals("UP")) {
		} else if(description.equals("DOWN")) {
		} else return false;
		return true; 
	}
}
