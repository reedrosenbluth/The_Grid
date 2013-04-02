package server;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;

import java.io.*;
import java.net.*;
import java.util.*;

import base.TronWorld;


public class TronmagServer implements Runnable {
	
	TronWorld w;
	ArrayList<Socket> sockets = new ArrayList<Socket>();
	ArrayList<Bug> players = new ArrayList<Bug>();
	
	public TronmagServer() {
		Grid g = new BoundedGrid(100, 100);
		w = new TronWorld(g);
	}

	public static void main(String[] args) {
		(new Thread(new TronmagServer())).start();
	}
	
	public void run() {
		try 
		{
			ServerSocket s = new ServerSocket(9002);
			while(true) 
			{
				Socket c = s.accept();
				System.out.println("client connected");
				Bug b = new Bug();
				players.add(b);
				sockets.add(c);
				w.add(b);
				GameClientHandler gh = new GameClientHandler(c, b);
				(new Thread(gh)).start();
			}
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
