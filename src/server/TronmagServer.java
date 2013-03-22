package server;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;

import java.io.*;
import java.net.*;
import java.util.*;

import base.TronWorld;


public class TronmagServer implements Runnable {
	
	TronWorld w;
	ArrayList<Bug> players = new ArrayList<Bug>();
	
	public TronmagServer() {
		w = new TronWorld();
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
