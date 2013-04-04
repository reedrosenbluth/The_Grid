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

import base.TronWorld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Tronmageddon implements Runnable {

	/**
	 * Execution point for client-side app.
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Grid g = new BoundedGrid(100, 100);
		TronWorld a = new TronWorld(g);
		a.show();
		
		int x = 0;
		int y = 0;
		
		try
		{
			Socket s = new Socket("localhost", 9002);
			a.SetSocket(s);
			BufferedReader stdin = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String stdinLine = stdin.readLine();
			
			for(int i = 0; i < stdinLine.length(); i = i+4){
				
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
