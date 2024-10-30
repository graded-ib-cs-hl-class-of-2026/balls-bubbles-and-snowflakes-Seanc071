import processing.core.PApplet;

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



    /**
     * This method can only be used to change the window size. It runs before the
     * window is created.
     */
    public void settings() {
        size(500, 500);
    }

    /**
     * Runs once at the beginning of the program, after the window is created. Use
     * this to initialize the sketch.
     */
    public void setup() {
        /**where the ball is constructed, radius, x position, y postion, x speed, y speed */
        ball1 = new Ball(this, 19, 55, 11, -13, 15);
        /**Setting the color of the ball (red, green, blue) */
        ball1.setColors(color(255,0,0),color(0));
        ball2 = new Ball(this, 25, 29, 29, 7, -8);
        ball2.setColors(color(255,125,0),color(0));
        ball3 = new Ball(this, 40, 112, 40, -3, 5);
        ball3.setColors(color(255,255,0),color(0));
        ball4 = new Ball(this, 50, 222, 61, 3, -1);
        ball4.setColors(color(0,255,0),color(0));

        /**where the bubble is constructed, radius, x position, y postion, x speed, y speed */
        bubble1 = new Bubble(this, 45, 6,3, -4,-8);
        bubble1.setColors(256,0);
        bubble2 = new Bubble(this, 25, 6,3, -1,-1);
        bubble2.setColors(256,0);
        bubble3 = new Bubble(this, 10, 6,3, -2,-4);
        bubble3.setColors(256,0);
        bubble4 = new Bubble(this, 30, 6,3, 1,-2);
        bubble4.setColors(256,0);

        /**where the snowflakes is constructed, radius, x position, y postion, x speed, y speed */
        snowflake1 = new Snowflake(this, 30, 6,5, -1,2);
        snowflake1.setColors(0,0);
        snowflake2 = new Snowflake(this, 45, 13,3, 0,5);
        snowflake2.setColors(0,0);
        snowflake3 = new Snowflake(this, 50, 3,1, -2,3);
        snowflake3.setColors(0,0);
        snowflake4 = new Snowflake(this, 25, 9,9, 2,7);
        snowflake4.setColors(0,0);
        
    }

    /**
     * This method runs over and over and over, approximately 60 times per second!
     * By moving objects a tiny bit each frame, you can get the appearance of
     * movement.
     */
    public void draw() {
        /**background size  */
        background(180, 180, 255);
        
        ball1.draw();
        ball1.move();

        ball2.draw();
        ball2.move();

        ball3.draw();
        ball3.move();

        ball4.draw();
        ball4.move();



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

    /** All processing sketches have to use this main method. Don't touch this! */
    public static void main(String[] args) {
        PApplet.main("Sketch");
    }
}
