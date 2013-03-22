package client;

import java.awt.Color;
import java.awt.event.KeyEvent;

import info.gridworld.actor.*;
import info.gridworld.grid.*;


public class Tronmageddon extends Actor{

	/**
	 * Execution point for client-side app.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		ActorWorld world = new ActorWorld();
//		
//		final Bug b = new Bug();
////		world.setGrid(new BoundedGrid<Actor>(42,95));
//		world.add(b);
////		
////		world.show();
//		
//		b.setDirection(0); 
//		// Uncomment once randomFlower() is implemented
//		//head.randomFlower();
//		
//		// Read this code below but don't worry too much about it
//		// It makes the snake head face a direction based
//		// on keyboard input.
//		java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager()
//			.addKeyEventDispatcher(new java.awt.KeyEventDispatcher() { 
//			public boolean dispatchKeyEvent(java.awt.event.KeyEvent event) { 
//				String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString(); 
////				if (key.equals("pressed UP")) 
////					b.setDirection(0); 
//				if (key.equals("pressed RIGHT")) 
//					b.setDirection(b.getDirection() + 90); 
////				if (key.equals("pressed DOWN")) 
////					b.setDirection(180); 
//				if (key.equals("pressed LEFT")) 
//					b.setDirection(b.getDirection() - 90); 
//				return true; 
//			}
//		});
//		
//		world.show(); 
    
	}
	
	public Location getLocation(Actor a){
		return a.getLocation();
	}
	
//	public void act(Bug b){
//		turn(b);
//	}
	
	public void act(final Bug b)
    {
		ActorWorld world = new ActorWorld();
		
	
//		world.setGrid(new BoundedGrid<Actor>(42,95));
		world.add(b);
//		
//		world.show();
		
		b.setDirection(0); 
		// Uncomment once randomFlower() is implemented
		//head.randomFlower();
		
		// Read this code below but don't worry too much about it
		// It makes the snake head face a direction based
		// on keyboard input.
		java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager()
			.addKeyEventDispatcher(new java.awt.KeyEventDispatcher() { 
			public boolean dispatchKeyEvent(java.awt.event.KeyEvent event) { 
				String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString(); 
//				if (key.equals("pressed UP")) 
//					b.setDirection(0); 
				if (key.equals("pressed RIGHT")) 
					b.setDirection(b.getDirection() + 90); 
//				if (key.equals("pressed DOWN")) 
//					b.setDirection(180); 
				if (key.equals("pressed LEFT")) 
					b.setDirection(b.getDirection() - 90); 
				return true; 
			}
		});
		
		world.show(); 
    }
}
