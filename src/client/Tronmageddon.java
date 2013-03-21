package client;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;

import base.TronWorld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class Tronmageddon implements Runnable {

	private TronWorld w;
	private Socket s;
	
	private Tronmageddon(Socket s) {
		this.s = s;
	}
	
	public static void main(String[] args) {
		try {
			String host = "localhost";
			Socket s = new Socket(host, 9002);
			(new Thread(new Tronmageddon(s))).start();
		} 
		catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	public void run() {
		
	}

}
