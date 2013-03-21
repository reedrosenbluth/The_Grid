package server;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import base.TronWorld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class GameClientHandler implements Runnable {

	private TronWorld w;
	private Socket s;
	private PrintWriter out;
	private Bug b;
	
	public GameClientHandler(Socket s, TronmagServer ts, TronWorld w) throws IOException 
	{
		this.s = s;
		this.out = new PrintWriter(s.getOutputStream(), true);
		this.b = new Bug();
		w.add(b);
		this.w = w;
	}
	
	public void run() {
		
	}

}
