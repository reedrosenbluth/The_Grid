package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

public class TronWorld extends ActorWorld {
	
	PrintWriter sout = null;
	PrintWriter sin = null;
	
	 public TronWorld(Grid<Actor> grid) {
	        super(grid);
	 }
	 

	public void SetSocket(Socket s) throws IOException{
		sout = new PrintWriter(s.getOutputStream(), true);
	}
	
	public boolean keyPressed(String description, Location loc) {
		if(description.equals("LEFT")) {
			sout.println("L");
		} else if(description.equals("RIGHT")) {
			sout.println("R");
		} else if(description.equals("UP")) {
		} else if(description.equals("DOWN")) {
		} else return false;
		return true; 
	}

}
