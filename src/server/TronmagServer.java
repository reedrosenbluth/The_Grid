package server;

import info.gridworld.actor.Bug;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.io.IOException;
import java.util.*;

import base.TronWorld;


public class TronmagServer implements Runnable {
	
	TronWorld w;
	ArrayList<GameClientHandler> handlers;
	
	public TronmagServer() {
		Grid g = new BoundedGrid(46, 94);
		w = new TronWorld(g);
//		w.show();
		handlers = new ArrayList<GameClientHandler>();
		
		(new Thread(new Listener(w, handlers))).start();
	}

	public static void main(String[] args) {
		
		(new Thread(new TronmagServer())).start();
		
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
				w.step();
				for (GameClientHandler h : handlers) {
					Bug b = h.getBug();
					Location l = b.getLocation();
					int x = l.getCol();
					int y = l.getRow();
					int d = b.getDirection();
					int re = b.getColor().getRed();
					int gr = b.getColor().getGreen();
					int bl = b.getColor().getBlue();
					String location = String.format(". %d %d %d %d %d %d", x, y, d, re, gr, bl);
					sendToAll(location);
				}
//				w.show();
			} catch(Exception e) {
				
			}
		}
	}
	
	private void sendToAll(String msg) throws IOException
	{
		for(GameClientHandler gh : handlers) 
		{
			gh.send(msg);
		}
	}

}
