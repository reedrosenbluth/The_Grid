package client;

import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;

public class ActorBug extends Bug{
	
	private Color actorColor = Color.BLACK;
	
	public ActorBug(){
		setColor(actorColor);
	}
	public ActorBug(Color actorBugColor){
		actorColor = actorBugColor;
		setColor(actorColor);
	}
	public void move(){
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        Trail trail = new Trail(getColor());
        trail.putSelfInGrid(gr, loc);
	}
	public void act(){
		if(canMove()){
			turn();
			move();
		}
		else{
			
		}
	}
	public void turn(){
		java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new java.awt.KeyEventDispatcher() {
			
			public boolean dispatchKeyEvent(java.awt.event.KeyEvent event) {
				String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString();
				if (key.equals("pressed UP"))
					setDirection(0);
				if (key.equals("pressed RIGHT"))
					setDirection(90);
				if (key.equals("pressed DOWN"))
					setDirection(180);
				if (key.equals("pressed LEFT"))
					setDirection(270);
				return true;
			}
		});
	}
}
