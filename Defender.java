import processing.core.*;
public class Defender extends main{
	int x,y;
	public boolean shoot = true;
	int shootPrevent = 0;
	PImage defender; //renders image for the defender 
	PApplet parent;
	public int lives = 3 ;

	    Defender(PApplet p)
	    {
	      parent = p;
	      x= 400;
	      y=640;
	    }
	    
	    public void render()
	    {
	      if(lives==3){     
	      defender = parent.loadImage("Images/defender3.png"); //defender with 3 lives 
	      }
	      if(lives==2){
	      defender = parent.loadImage("Images/defender2.png"); //defender with 2 lives
	      }
	      if(lives==1){
	      defender = parent.loadImage("Images/defender1.png"); //defender with 1 lives
	      }       
	      parent.image(defender,x,y); //spawns invader
	      shooting(); //allows for keypresses and movements
	    }
	    
	    public void shooting() 
	    {     
  
	       shootPrevent++; //shoot prevention begins counting up
	       if( shootPrevent >= 30 ) //if shoot prevention is below 30, player cant shoot
	           { 
	           shoot=true; //allows the defender to shoot when the prevention gets to 30
	           } //player cant shoot until reaches 30, prevents spam
	    }
	    
	    public void life()
	    { //function to remove player lives
	    	lives--; //removes one life from defender.lives
		}
}
