import processing.core.*;
import java.util.*;
public class main extends PApplet{

	public static void main(String[] args) {
		PApplet.main("main");

	}
	public void settings(){
        size(800, 800);     
    }
	
		//Paul Melnyk, Programming
		//Space Invaders Assignment
		//Student Code - 14008771
PImage splashBackground,level1,level2,level3; //allows images for background to be loaded in

int gameMode = 0; //0=menu,1=lose state, 2=win state, 11-13= levels - allows for switch case

int Score; //holds the current score for the game
int bScore; //holds the best score for current play
int level; //levels range 1-3, change variables within

ArrayList <Bullet> Bullets = new ArrayList<Bullet>(); // allows creation of the bullets for defender
ArrayList <alienBullet>invBullet = new ArrayList <alienBullet>(); //allows invaders to shoot bullets

int xSize = 10; //allows for alien array, array variable = columns
int ySize = 4; //allows for alien array, array variable = rows
Alien[][] Aliens= new Alien[9][15]; // fixed array  for aliens 
int alienTotal = xSize * ySize ; //counts how many aliens on the screen,allows for game states

float randBulletX; //gives the alien bullet its random location for x
float randBulletY; //gives the alien bullet its random location for y

Defender defender; //allows the instance of defender to show
public void setup(){

  defender = new Defender(this);// instance of player
  splashBackground = loadImage("Images/SplashScreen.png"); //loads the background image 
  level1=loadImage("Images/level1.png"); //earth background for level1
  level2=loadImage("Images/level2.png"); //mars background for level2
  level3=loadImage("Images/level3.png"); //saturn background for level3
  alienArray(); //calls the alien array 
}
public void draw(){
switch (gameMode){ //switch for gamemode
        case 0: //main menu settings 
          image(splashBackground, 0, 0); //sets where image displays 
          fill(255); //sets white for text
          defender.lives=3; //sets lives to 3
          textSize(20); //sets text size for best score
          text("Best Score: "+bScore,660,15); //displays best score
          if(keyCode== ENTER ) //player presses enter
          {
              xSize = 10; //reset xSize for players who go to menu
              ySize = 4;  //resets ySize for players who go to menu
              gameMode =11; //sets to level 1
          } //enter sets gameMode to'PLAYING'-level1
        break; //ends the mode 
        
        case 1: //gameOver State
        fill(255); //sets color to white
      if(level==1){    //level 1 gameover state
       if(defender.lives>1){ //if player has more than 1 life
          gameMode=11; //goes back to level
          for(int i = 0; i<ySize; i++){ //loop for rows
            for (int j = 0; j<xSize; j++){ //loop for columns
               Aliens[i][j]=null; //clears before reset
                    }
                }
                setup(); //restarts setup
                defender.lives-=1; //takes lives down by 1
                invBullet.clear(); //resets bullets before carrying on game
                Score=0; //resets score
            if(bScore<Score){bScore=Score;} //sets high score
       }
      else{ //if player has 1 life
             textSize(20); //sets text size for options
             text("Game Over!",200,400); //displays game over
             text("Press Space To Go To Menu",200,420); //takes player back to menu, out of lives
             if(keyCode== ' '){ //press tab
                gameMode=0; //goes back to level
                invBullet.clear(); //resets bullets before carrying on game
                setup(); //resets level
                Score=0;}; //resets score
            if(bScore<Score){bScore=Score;} //sets high score
          }  
   }
   if(level==2){    //level 2 gameover state
       if(defender.lives>1){ //if player has more than 1 life
                gameMode=12; //goes back to level
                for(int i = 0; i<ySize; i++){ //loop for rows
                  for (int j = 0; j<xSize; j++){ //loop for columns
                      Aliens[i][j]=null; //clears before reset
                        }
                    }
                setup(); //restarts setup
                defender.lives-=1; //takes lives down by 1
                invBullet.clear(); //resets bullets before carrying on game
                Score=0; //resets score
            if(bScore<Score){bScore=Score;} //sets high score
       }
      else{ //if player has 1 life
             textSize(20); //sets text size for options
             text("Game Over!",200,400); //displays game over
             text("Press Space To Go To Menu",200,420); //takes player back to menu, out of lives
             if(keyCode== ' '){ //press tab
                gameMode=0; //goes back to level
                setup(); //resets level
                invBullet.clear(); //resets bullets before carrying on game
                Score=0;}; //resets score
            if(bScore<Score){bScore=Score;} //sets high score
          }  
   }
  if(level==3){    //level 3 gameover state
       if(defender.lives>1){ //if player has more than 1 life
                gameMode=13; //goes back to level
                for(int i = 0; i<ySize; i++){ //loop for rows
                  for (int j = 0; j<xSize; j++){ //loop for columns
                     Aliens[i][j]=null; //clears before reset
                        }
                  }
                setup(); //restarts setup
                defender.lives-=1; //takes lives down by 1
                invBullet.clear(); //resets bullets before carrying on game
                Score=0; //resets score
            if(bScore<Score){bScore=Score;} //sets high score
       }
      else{ //if player has 1 life
             textSize(20); //sets text size for options
             text("Game Over!",200,400); //displays game over
             text("Press Space To Go To Menu",200,420); //takes player back to menu, out of lives
             if(keyCode== ' '){ //press tab
                gameMode=0; //goes back to level
                setup(); //resets level
                invBullet.clear(); //resets bullets before carrying on game
                Score=0;}; //resets score
            if(bScore<Score){bScore=Score;} //sets high score
          }  
   }
break; //ends game Lose settings
   
case 2://Win State
       if(level==1){ //win state for level 1
        fill (255); //sets color to white
        text("You Fought Back The Invaders!",200,400); 
        text("Press Q To Progress To Protect Mars!",200,420);
        text("Press Space To Return To Menu",200,440);
       if(keyCode== ' '){ //press space
            gameMode=0; //goes to Menu
            setup(); //resets level
            invBullet.clear(); //resets bullets before carrying on game
            Score=0;}; //resets score
        if(bScore<Score){bScore=Score;} //sets high score
        if(key== 'q'){
          if(defender.lives<=2){defender.lives+=1;} //if lives are not at max(3) lives will gain 1 extra
          xSize=12; //columns will increase for level 2
          ySize=4; //row increase for level 2
          alienTotal=xSize*ySize;
          gameMode=12; //will send game into level 2
          setup(); //reset aliens
          invBullet.clear(); //resets bullets before carrying on game
          Score=0; //score set to 9
        }
      }
     if(level==2){ //win state for level 2
        fill (255); //sets color to white
        text("You Fought Back The Invaders!",200,400); 
        text("Press Q To Progress To The Protect Neptune",200,420);
        text("Press Space To Return To Menu",200,440);
       if(keyCode== ' '){ //press space
            gameMode=0; //goes to Menu
            setup(); //resets level
            invBullet.clear(); //resets bullets before carrying on game
            Score=0;}; //resets score
        if(bScore<Score){bScore=Score;} //sets high score
        if(key== 'q'){
          if(defender.lives<=2){defender.lives+=1;} //if lives not equal to max(3) player gains 1 life
          xSize=14; //increases column for last level
          ySize=8; //increase row for last level
          alienTotal=xSize*ySize;
          gameMode=13; //sends player to last level
          setup(); //resets setup
          invBullet.clear(); //resets bullets before carrying on game
          Score=0; //sets score to 0 
        }
      }
     if(level==3){ //win state for level 3
        fill (255); //sets color to white
        text("You Fought Back The Invaders,and Saved The Galaxy!",200,400); 
        text("Press Space To Return To Menu",200,420);
       if(keyCode== ' '){ //press space
            gameMode=0; //goes to Menu
            setup(); //resets level
            invBullet.clear(); //resets bullets before carrying on game
            Score=0;}; //resets score
        if(bScore<Score){bScore=Score;} //sets high score
      }
break; //ends game WIN settings
        
case 11: //game PLAYING settings for level 1
        level=1; //level equal to 1
        image(level1, 0, 0); //sets where image displays 
        fill(255); //sets text to white
        textSize(20); //sets text size
        text("Lives: "+defender.lives,3,770); //displays lives
        text("Level: "+level,3,790); //displays score
        text("Best Score: "+bScore,660,15); //displays best score
        text("Score: "+Score,660,35); //displays score
        defender.render(); //renders defender 
        drawAliens(); //draws aliens into game
        alienIsHit(); //checks if alien collides with bullet
        defControl(); //movement and firing for defender
        gamePlay(); //renders bullets
     if(alienTotal==0){gameMode=2;} //if all aliens are dead win state
     if(defender.lives==0){gameMode=1;} //if player is shot too much will send to gameOver 
break; //emds the case for level 1

case 12: //game PLAYING settings for level 2
        level=2; //level equal to 2
        image(level2, 0, 0); //sets where image displays
        fill(255); //sets text to white
        textSize(20); //sets text size
        text("Lives: "+defender.lives,3,770); //displays lives
        text("Level: "+level,3,790); //displays score
        text("Best Score: "+bScore,660,15); //displays best score
        text("Score: "+Score,660,35); //displays score
        defender.render(); //renders defender 
        drawAliens(); //draws aliens into game
        alienIsHit(); //checks if alien collides with bullet
        defControl(); //movement and firing for defender
        gamePlay(); //renders bullets
     if(alienTotal==0){gameMode=2;} //if all aliens are dead win state
     if(defender.lives==0){gameMode=1;}  //if player is shot too much will send to gameOver 
break; //ends the case for level 2

case 13: //game PLAYING settings for level 3
        level=3; //level equal to 2
        image(level3, 0, 0); //sets where image displays
        fill(255); //sets text to white
        textSize(20); //sets text size
        text("Lives: "+defender.lives,3,770); //displays lives
        text("Level: "+level,3,790); //displays score
        text("Best Score: "+bScore,660,15); //displays best score
        text("Score: "+Score,660,35); //displays score
        defender.render(); //renders defender 
        drawAliens(); //draws aliens into game
        alienIsHit(); //checks if alien collides with bullet
        defControl(); //movement and firing for defender
        gamePlay(); //renders bullets
     if(alienTotal==0){gameMode=2;} //if all aliens are dead win state
     if(defender.lives==0){gameMode=1;}  //if player is shot too much will send to gameOver 
break; //ends the case for level 3
    }   
}

public void gamePlay(){
	if(invBullet.size()==0){
        invBullet.add(new alienBullet(randBulletX,randBulletY,this));
	}
	  for (int i = 0; i < invBullet.size(); i++)//allows bullets to be created, finds how many bullets are in the array 
	    { 
	      alienBullet bullet = (alienBullet) invBullet.get(i); //allows bullet to run from ship
	      bullet.draw(); //draws bullet
	    }
	  for(int i=0;i<invBullet.size();i++) 
	  	{
		  if(bulletLow(invBullet.get(i))) //makes sure there is 1 bullet, sees if said bullet is too low
		  	{
			  invBullet.clear(); //if bullet is too low, will clear the array so another can be fired
		  	}
	  	}
	  for(int i=0;i<Bullets.size();i++) //loops to check all bullets
	  	{
		  if(bulletHigh(Bullets.get(i))) //sends the bullet to see if too high
		  	{
			  Bullets.remove(i); //if bullet too high it will be removed
		  	}
	  	}	  
    for(int i=0;i<invBullet.size();i++)
    	{ //loop to check all bullets
    	alienBullet bullet = invBullet.get(i); //defines said bulet as bullet
    		if(bullet.x>=defender.x && bullet.x<=defender.x+104 && bullet.y>=defender.y+101 && bullet.y<=defender.y+124 || //collision of main wings of ship
    		   bullet.x>=defender.x+22 && bullet.x<=defender.x+79 && bullet.y>=defender.y+80 && bullet.y<=defender.y+150 || //collision for center body of ship
    		   bullet.x>=defender.x+44 && bullet.x<=defender.x+57 && bullet.y>=defender.y+39 && bullet.y<=defender.y+158) //collision of main barrel of ship
    			{
      				invBullet.clear(); //if is colliding alienbullet will be cleared
      				defender.life(); //life function will run on defender- removes 1 life
      			}
    	}
}

public void alienArray(){ //creates the array
  for(int i=0;i<=ySize;i++){  //loops for the rows
    for(int j=0;j<=xSize;j++){ //loops for the columns
      Aliens[i][j]=(new Alien(i*35,j*35,this)); //puts alien in the array, in right position
    }
  }
}
  public void drawAliens(){ //allows for aliens to appear in levels
      for (int i = 0; i<ySize; i++){ //loops for rows 
        for(int j = 0; j<xSize;j++){ //loops for columns
        if(Aliens[i][j] != null){ //checks to see if the alien in given row/column is null
        Aliens[i][j].render(); //if not null will render the alien, prevents crashing, and give value for bullet x and y  
        randBulletX = Aliens[i][j].x + 15; //passes value for x from alien, addds 15 so spawns in centre of alien instance
        randBulletY = Aliens[i][j].y + 30; //passes value for y from alien, adds 30 so spawns at bottom of alien instance
		   if(Aliens[i][j].y+30>640){ //if aliens are alive and too low(close to ship)
			   gameMode = 1; //gameOver state, will check lives 
			   }
		   }
       }
    } 
}

    public void alienIsHit(){ //function to see if alien should be shown
       for(int i = 0; i<ySize; i++){ //loops for the row
          for (int j = 0; j<xSize; j++){ //loops for the column
           for(int k = 0; k<Bullets.size();k++){ //checks for the bullets value
            if (Aliens[i][j] != null){ //checks to see if alien is alive
             if(alienIsDead(Bullets.get(k),Aliens[i][j])){ //runs alienIsDead with given alien and given bulley
                 alienRemove(i,j); //if alienIsDead returns true,alienRemove function will run on the alien
                 Bullets.remove(k); //will remove the bullet when interaction with alien
                }
            }
        }
     }
  }
}

  public void alienRemove( int i, int j){ //alien remove is passed i&j from alien is hit (alien interaction happens with)
    Aliens[i][j] = null; //makes said alien null
    Score+=1; //adds 1 to player score
    alienTotal-=1; //removes 1 from alienTotal, used to get into win and lose states
  }
  
public boolean alienIsDead(Bullet bullet,Alien alien){ //checks if alien and bullet collide
  if(bullet.y<=alien.y+30 && bullet.y>=alien.y && bullet.x>=alien.x && bullet.x<=alien.x+30) //checks the locations of instances
	  return true; //if collision occurs will return true
  		else
  	  return false; //if the collision has not happened will return false, alien stays alive
  }

public boolean bulletLow(alienBullet bullet){ //function to see where alien bullets are
	if(bullet.y>=800) //checks y location of given bullet
		return true; //if bullet offscreen true
			else
		return false; //if bullet onscreen will not delete
	}
public boolean bulletHigh(Bullet bullet){ //function to see if bullets from ship go too high when miss
	if(bullet.y<=0) //checks y location of given bullet
		return true; //if bullet offscreen true
			else
		return false; //if bullet onscreen will not delete
	}

public void defControl(){
	if (key == 'a' && keyPressed && defender.x >= 5 ) defender.x = defender.x-5; //moves left, only on key hold, prevents going off left side of screen
    if (key == 'd' && keyPressed && defender.x + 104 <= width ) defender.x = defender.x+5; //moves right, only on key hold, prevents going off right side of screen 
	if(key=='w' && keyPressed && defender.shoot){
        Bullets.add(new Bullet(defender.x,this));
        defender.shoot = false;  //sets can shoot to false
        defender.shootPrevent = 0; //sets shoot prevention to 0
	}
	  for (int i = 0; i < Bullets.size(); i++)//allows bullets to be created, finds how many bullets are in the array 
	    { 
	      Bullet bullet = (Bullet) Bullets.get(i); //allows bullet to run from ship
	      bullet.draw(); //draws bullet
	    }
}

}
