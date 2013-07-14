package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

import base.TronWorld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Tronmageddon implements Runnable {
	static PrintWriter sout = null;

	/**
	 * Execution point for client-side app.
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Grid g = new BoundedGrid(46, 94);
		TronWorld a = new TronWorld(g);
		a.show();
		
		int x = 0;
		int y = 0;
		
		try
		{
			Socket s = new Socket("192.168.12.170", 9002);
			a.SetSocket(s);
			BufferedReader stdin = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String stdinLine = stdin.readLine();
			ArrayList<Location> occupied = new ArrayList<Location>();
			
			while((stdinLine = stdin.readLine()) != null && s.isConnected()){
				String[] p = stdinLine.split(" ");
				if(p[0].equals("."))
				{
					occupied = g.getOccupiedLocations();
					for (Location o : occupied) {
						g.remove(o);
					}
					Bug b = new Bug(new Color(Integer.parseInt(p[4]), Integer.parseInt(p[5]), Integer.parseInt(p[6])));
					b.setDirection(Integer.parseInt(p[3]));
					g.put(new Location(Integer.parseInt(p[2]), Integer.parseInt(p[1])), b);
				}
				a.show();
				System.out.println(stdinLine);
			}
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
			System.exit(-1);
			
		}
	}
	
	public void run() {
		
	}

}
