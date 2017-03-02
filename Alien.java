import processing.core.*;  
public class Alien extends main{

  float x,y;
  int speedX = 1; //how fast aliens move on x, changes per level
  int moveDown = 50; ///determines how far down the screen aliens move when they hit the edge 
  PApplet parent;

  int counter = 0; //change alien style
  boolean missileDrop = true; //allows aliens to fire 
  int missileAllowance = 0; //prevents missile spam
  int missileLevel = 200; //sets how often missiles can be fired
  int colour = randomColour(); //gives the int colour a random colour from the function
	
	  Alien(int y,int x, PApplet p )
	  { 
		parent = p;
	    this.x = x;
	    this.y = y;
	  }
	  
	  int randomColour() //function to create different colour aliens
	  {
		return color( (int)random(255), (int)random(255), (int)random(255) ); //gives a random colour
	  }
		
  
	  public void render()
	  { 
	    alienDesign(); //calls upon alienDesign function
	    move(); //calls upon the move funcion
	  }
	       public void alienDesign() //aliens design
	       {
             
             parent.fill(colour); //makes the aliens the random colour specified
             
	         if(counter>=0 && counter<=50){ //alien style 1 between 0 & 50
	           alien1(); //displays alien style 1
	         }
	         else if(counter>50 && counter<=100){ //alien style 2 between 50 & 100
	           alien2(); //displays alien style 2
	         }
	         else{ //if neither of these conditions, will default
	           counter =0; //counter back to 0,sets back to start of counter
	         }
	         counter += 1; //counter will go up by one each time it runs
	       } 
	       
	       public void alien1() //style 1 alien
	       {
	          mouth1();  // mouth 1 rendering for style 1 alien
	          head();   // head rendering for style 1 alien
	          antenna1();  // antenna 1 rendering for style 1 alien
	       }
	       
	       public void alien2() //style 2 alien
	       {
	         mouth2(); // mouth 2 rendering for style 2 alien
	         head(); // head rendering for style 2 alien (head same for both styles)
	         antenna2(); // antenna 2 rendering for style 2 alien
	       }
	       
	       public void mouth1() //style 1
	         {
	            parent.rect(x,y+28,30,2); //base of mouth 
	            parent.rect(x,y+23,2,5); //left of mouth
	            parent.rect(x+28,y+23,2,5); //right of mouth
	         }  
	            
	       public void mouth2() //style 2
	        {   
	            parent.rect(x+5,y+28,20,2); //base of mouth
	            parent.rect(x+5,y+23,2,5); //left of mouth
	            parent.rect(x+23,y+23,2,5); //right of mouth
	        }
	       
	       public void head() //style 1 and 2
	         {
	            parent.rect(x+10,y+21,10,7); //neck
	            parent.rect(x+2,y+18,26,3); //bottom of head
	            parent.rect(x,y+10,2,8); //left of head
	            parent.rect(x+28,y+10,2,8); //right of head
	            parent.rect(x+2,y+7,26,3); //top of head
	            parent.rect(x+9,y+13,3,3); //left eye
	            parent.rect(x+18,y+13,3,3); //right eye
	         }
	       
	       public void antenna1() //style 1
	         {
	    	   parent.rect(x+14,y,2,20); // antenna middle
	    	   parent.rect(x+11,y,8,1); //top of antenna
	    	   parent.rect(x+3,y+1,2,2); //top of left ant
	    	   parent.rect(x+5,y+3,2,2); //middle of left ant
	    	   parent.rect(x+7,y+5,2,2); //bottom of left ant
	            
	    	   parent.rect(x+21,y+5,2,2); //bottom of right ant
	    	   parent.rect(x+23,y+3,2,2); //middle of right ant
	    	   parent.rect(x+25,y+1,2,2); //top of right ant
	         }  
	            
	       public void antenna2() //style 2
	         {  
	    	   parent.rect(x+14,y+7,2,20); // antenna middle
	    	   parent.rect(x+11,y+1,2,2); //top of left ant
	    	   parent.rect(x+9,y+3,2,2); //middle of left ant
	    	   parent.rect(x+7,y+5,2,2); //bottom of left ant
	    	   parent.rect(x+21,y+5,2,2); //bottom of right ant
	    	   parent.rect(x+19,y+3,2,2); //middle of right ant
	    	   parent.rect(x+17,y+1,2,2); //top of right ant
	         }
    
	   public void move()
	   {
		   x= x+speedX;
		   
		   if(x+30>800) //so right side of aliens hit screen edge
		   	{
			   speedX= speedX*(-1); //reverse speed, aliens move left
			   y+=moveDown; //move down
		   	}
		   
		   if(x<0) //aliens hit left edge of screen
		   	{
			   speedX= speedX*(-1); //aliens move right
			   y+=moveDown; //aliens move down screen
		   	}
	   } 
}
