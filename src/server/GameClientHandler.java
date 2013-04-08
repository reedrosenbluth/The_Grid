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
		System.out.println("client connected");
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String inLine;
			while((inLine = in.readLine()) != null) 
			{
				if (inLine.equals("L")) {
					b.setDirection(b.getDirection() - 90);
				} 
				else if (inLine.equals("R")) {
					b.setDirection(b.getDirection() + 90);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		int x = b.getLocation().getCol();
		int y = b.getLocation().getRow();
		out.println("." + " " + x + " " + y + " " + b.getColor());
	}
	
	public Bug getBug() {
		return b;
	}

}
