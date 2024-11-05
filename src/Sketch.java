import processing.core.PApplet;
import processing.event.KeyEvent;

public class Sketch extends PApplet {

    /** Represents one ball */
    private Ball ball1;
    /**made total 4 balls */
    private Ball ball2;
    private Ball ball3;
    private Ball ball4;

    
/**create 4 bubbles */
    private Bubble bubble1;
    private Bubble bubble2;
    private Bubble bubble3;
    private Bubble bubble4;
/**create 4 snowflakes */
    private Snowflake snowflake1;
    private Snowflake snowflake2;
    private Snowflake snowflake3;
    private Snowflake snowflake4;
    /**Changed the background color */
    private int backgroundColor = color(10, 180, 255);
    
    
/**Set the gravity mode off */
    private boolean gravityMode = false;





    /**
     * This method can only be used to change the window size. It runs before the
     * window is created.
     */
    public void settings() {
        size(500, 700);
    }

    /**
     * Runs once at the beginning of the program, after the window is created. Use
     * this to initialize the sketch.
     */
    public void setup() {
        /**where the ball is constructed, radius, x position, y postion, x speed, y speed */
        ball1 = new Ball(this, 19, 250, 250, -13, 15);
        /**Setting the color of the ball (red, green, blue) */
        ball1.setColors(color(255,0,0),color(0));

      
        ball2 = new Ball(this, 25, 29, 29, 7, -8);
        ball2.setColors(color(255,125,0),color(0));
        ball3 = new Ball(this, 40, 112, 40, -3, 5);
        ball3.setColors(color(255,255,0),color(0));
        ball4 = new Ball(this, 50, 222, 61, 3, -1);
        ball4.setColors(color(0,255,0),color(0));

        /**where the bubble is constructed, radius, x position, y postion, x speed, y speed */
        bubble1 = new Bubble(this, 45, 6,3, -3,-3);
        bubble1.setColors(256,0);
        bubble2 = new Bubble(this, 25, 6,3, -1,-1);
        bubble2.setColors(256,0);
        bubble3 = new Bubble(this, 10, 6,3, -2,-4);
        bubble3.setColors(256,0);
        bubble4 = new Bubble(this, 30, 6,3, 1,-2);
        bubble4.setColors(256,0);

        /**where the snowflakes is constructed, radius, x position, y postion, x speed, y speed */
        /**snowflake color is white */
        snowflake1 = new Snowflake(this, 30, 6,5, -1,2);
        snowflake1.setColors(color(255,255,255),color(255));
        snowflake2 = new Snowflake(this, 45, 13,3, 0,5);
        snowflake2.setColors(color(255,255,255),color(255));

        snowflake3 = new Snowflake(this, 50, 3,1, -2,3);
        snowflake3.setColors(color(255,255,255),color(255));

        snowflake4 = new Snowflake(this, 25, 9,9, 2,7);
        snowflake4.setColors(color(255,255,255),color(255));

        
    }

    /**
     * This method runs over and over and over, approximately 60 times per second!
     * By moving objects a tiny bit each frame, you can get the appearance of
     * movement.
     */
    public void draw() {

        background(backgroundColor);
       
        
        ball1.draw();
        ball1.move();
        /**draw if the gravity mode is actve */
        ball1.gravity(gravityMode);
        

        ball2.draw();
        ball2.move();
        ball2.gravity(gravityMode);


        ball3.draw();
        ball3.move();
        ball3.gravity(gravityMode);


        ball4.draw();
        ball4.move();
        ball4.gravity(gravityMode);


        /**Check if the collision happens with other balls*/
       ball1.checkCollision(ball2);
       ball1.checkCollision(ball3);
       ball1.checkCollision(ball4);
       ball2.checkCollision(ball3);
       ball2.checkCollision(ball4);
       ball3.checkCollision(ball4);


        bubble1.draw();
        bubble1.move();
        
        bubble2.draw();
        bubble2.move();

        bubble3.draw();
        bubble3.move();

        bubble4.draw();
        bubble4.move();



        snowflake1.draw();
        snowflake1.move();

        snowflake2.draw();
        snowflake2.move();
     
        snowflake3.draw();
        snowflake3.move();

        snowflake4.draw();
        snowflake4.move();
    }
    
    /**When key is pressed, color changes permenantly */
    /**learned from https://processing.org/reference/keyPressed_.html */
  public void keyPressed(){
    /**if key a,b,c,d is pressed, color changes(graivty mode still off)(blue, purble, white, black)
     * but color changes back when they collide
     */
    if(key == 'a'){        
    ball1.setColors(color(0,0,255),color(0));
    gravityMode = false;
    }

    if(key == 'b'){        
        ball2.setColors(color(102,0,153),color(0));
        gravityMode = false;
    }

    
    if(key == 'c'){        
        ball3.setColors(color(255,255,255),color(0));
        gravityMode = false;
    }

    if(key == 'd'){        
        ball4.setColors(color(0,0,0),color(0));
        gravityMode = false;
    }
    
/** while pressing the space, the gravity mode is on */
    if(key == ' '){
        gravityMode = true;

        

    }
    
  }
  /** When spacebar key is released balls go to its original speed*/
  public void keyReleased(){
    if(key == ' '){
    gravityMode = false;
    ball1.originalSpeed();
    ball2.originalSpeed();
    ball3.originalSpeed();
    ball4.originalSpeed();}
    

    
  }
  /**When mouse is pressed,  */
  public void mousePressed(){
    bubble1.mousePressed(mouseX, mouseY);
    bubble2.mousePressed(mouseX, mouseY);
    bubble3.mousePressed(mouseX, mouseY);
    bubble4.mousePressed(mouseX, mouseY);

  }
  /**When mouse is dragged */
public void mouseDragged(){
    bubble1.mouseDragged(mouseX, mouseY);
    bubble2.mouseDragged(mouseX, mouseY);
    bubble3.mouseDragged(mouseX, mouseY);
    bubble4.mouseDragged(mouseX, mouseY);

}
/**when mouse is released */
public void mouseReleased(){
    bubble1.mouseReleased();
    bubble2.mouseReleased();

    bubble3.mouseReleased();

    bubble4.mouseReleased();

}


    /** All processing sketches have to use this main method. Don't touch this! */
    public static void main(String[] args) {
        PApplet.main("Sketch");
    }

}