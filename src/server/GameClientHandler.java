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

	private Bug b;
	private Socket s;
	private PrintWriter out;
	
	public GameClientHandler(Socket s, Bug b) throws IOException 
	{
		this.s = s;
		this.out = new PrintWriter(s.getOutputStream(), true);
		this.b = b;
	}
	
	public void run() {
		while(true) {
			b.act();
			System.out.println(b.toString());
		}
	}

}
