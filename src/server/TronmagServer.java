package server;

import info.gridworld.actor.Bug;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;

import java.util.*;

import base.TronWorld;


public class TronmagServer implements Runnable {
	
	TronWorld w;
	ArrayList<GameClientHandler> handlers;
	
	public TronmagServer() {
		Grid g = new BoundedGrid(46, 94);
		w = new TronWorld(g);
		w.show();
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
				w.show();
//				for (GameClientHandler h : handlers) {
//					Bug b = h.getBug();
//					b.act();
//					System.out.println(b.toString());
//					
//				}
			} catch(Exception e) {
				
			}
		}
	}

}
