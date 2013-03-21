package client;

import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;

public class Trail extends Flower{
	
	public Color trailColor = Color.BLACK;
	
	public Trail(){
		setColor(trailColor);
	}
	public Trail(Color theColor){
		trailColor = theColor;
		setColor(trailColor);
	}
	public void act(){
		setColor(getColor());
	}
}
