import processing.core.*; 
public class Bullet extends main{
	
    float x,y;
    int speedY = 8; //sets speed for bullet
    PApplet parent;
 
	    Bullet(int x,PApplet p) {
	    	parent = p ;
	    	this.x = x+49 ;
	    	y = 680 ;
	    }
	 
	    public void draw() 
	    {
	    	parent.fill(255,0,0); //fills the bullet with a red 
	    	parent.rect(x,y,4,4); //creates bullet at given x,y 4x4
	    	y -=speedY; //bullets move speed
	    }
	   
   }
    
class alienBullet extends main{     

	float x, y;
    int speedY=4; //sets speed for bullet
    PImage Bullet; //allows image of the alienbullet to be brought in
    PApplet parent;
 
	    alienBullet(float x,float y,PApplet p) {
	    	parent = p;
	        this.x = x ; //spawns bullet at random alien x
	        this.y = y ; //spawns bullet at lowest alien point.
	    }
	 
	    public void draw() 
	    {
	    	parent.fill(0,255,0); //fills the bullet with a green 
	    	parent.rect(x,y,4,4); //creates alienbullet at given x,y 4x4
	      y +=speedY; //bullets move speed
	    }  
    }