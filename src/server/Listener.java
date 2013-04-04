package server;

import info.gridworld.actor.Bug;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import base.TronWorld;

public class Listener implements Runnable {
	
	TronWorld w;
	ArrayList<GameClientHandler> handlers;
	
	public Listener(TronWorld w, ArrayList<GameClientHandler> handlers) {
		this.w = w;
		this.handlers = handlers;
	}

	
	public void run() {
		try 
		{
			ServerSocket s = new ServerSocket(9002);
			while(true) 
			{
				Socket c = s.accept();
				Bug b = new Bug();
				w.add(b);
				GameClientHandler gh = new GameClientHandler(c, b);
				handlers.add(gh);
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
