class Ball {

    /*
     * In Processing, the Sketch works a lot like the World in the turtles. You
     * can't
     * draw a ball without knowing which sketch to draw it on, so you always need to
     * specify the sketch for a Ball object.
     */

    /** The sketch that the ball is inside */
    private Sketch s;
    /** the radius of the ball */
    private float radius;
    private float x;
    private float y;
    /** The number of pixels the ball moves right per frame */
    private float xSpeed;
    /** The number of pixels the ball moves down per frame */
    private float ySpeed;
    /** The color of the inside of the ball */
    private int fillColor;
    /** The color of the outside of the ball */
    private int borderColor;
    /** set the original speed for the ball */ 
    private float originalSpeedX;
    private float originalSpeedY;


    /** Empty constructor to keep the defaults. Only sets up our link. */
    public Ball(Sketch sketch) {
        s = sketch;
        radius = 20;
        x = 100;
        y = 100;
        xSpeed = 2;
        ySpeed = -1;
        fillColor = s.color(255, 100, 100);
        borderColor = s.color(0, 0, 0);
     
    }

    /** Fully specified constructor to allow changes to size, position, speed */
    /** Does NOT allow changing color! Need to use setColors() for that. */
    public Ball(Sketch sketch, float radius, float x, float y, float xspeed, float yspeed) {
        this.s = sketch;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.xSpeed = xspeed;
        this.ySpeed = yspeed;
        /**original speed of the ball */
        this.originalSpeedX = xSpeed;
        this.originalSpeedY = ySpeed;
    
    }

    // Accessors (getters) go here

    public float getRadius() {
        return radius;
    }

    public float getDiameter() {
        return radius * 2;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
  
    // Setters that you need go here - by default, only colors

    public void setColors(int fill, int border) {
        borderColor = border;
        fillColor = fill;
    }

    /**
     * Draws the ball on the given sketch
     */
    public void draw() {
        s.stroke(borderColor);
        s.fill(fillColor);
        s.circle(x, y, radius * 2);
    }

    /**
     * Moves the ball so that the next time it draws it will be in a different place
     */
    public void move() {
       
        x = x + xSpeed;
        y = y + ySpeed;
    
        if (x > s.width - radius || x < radius) {
            xSpeed = -xSpeed;
        }
        if (y > s.height - radius || y < radius) {
            ySpeed = -ySpeed;
        }
    }
    /**understand the method above from chatGPT and made the code below
     * https://docs.google.com/document/d/1hxcFrMkHzBWcJ0b0dUpVcNeqSf3lqUx3fQWpVr84_wY/edit?tab=t.0
     */
    /** making a gravity mode */
    public void gravity(boolean gravityMode){
      /**if gravity mode */
        if(gravityMode){
    /** I set the xSpped 0 so when gravity mode is true, the ball stop moving horizontally, and only moving vertically */
            xSpeed = 0;
            /**I added y speed 0.3 everytime. as the positive sign for yspeed makes the ball goes down, so while the gravity mode is true, 
             * y speed will keep adding, and accelerate to the ground */
            ySpeed += 0.3;
         /** as the position changing through the number of speed, the position should be y(initial position) + ySpeed(changing position) so we can see it moving
         */ 
            y = y + ySpeed;

            /** the 'y > s.height - radius' represents when the ball hits the ground, I made y speed getting multiplied by -0.7, so it can go upward, looking like
             * as it is bouncing.
             * in here, I found the error that the ball sinks, so I had to set that at last, y = s.height - radius;(minimum point in the screen that ball can go)

             */
            if(y > s.height - radius ){ 
            ySpeed *= -0.7;
            y = s.height - radius;

        
            }
            /**in here I found a error that sometimes ball goes through the wall(left and right). 
             * So, I made the ball can not exist through the wall(similar method as above)
             */
            if(x > s.width - radius || x < radius){
                x = s.width - radius;
                x = radius;
            }
           
           
        }
        


    
    }
    
    /**Checking the collision 
     * https://processing.org/reference/dist_.html
     * and got help from my brother
    */
    public boolean checkCollision(Ball other){
        /**Calculatint the distance between the cnetrs of the 
         * two ball objects(this and other)
         */
        /**this.x and this.y are the coordinates of the current Ball, while other.x
         * and other.y are the coordinates of the other Ball
         */
        float distance = s.dist(this.x, this.y, other.x, other.y);
        /** This checks if the distance between the cneters of the two balls is less than
         * the sum of their radii
         */
        /**if collision is detected */
        if(distance<this.radius + other.radius){
            /**change color */
            this.setColors(s.color(s.random(255),s.random(255),s.random(255)), s.color(0));
            other.setColors(s.color(s.random(255),s.random(255),s.random(255)), s.color(0));
            return true;
        }
        /**else false */
        return false;
    }
    /** This is for when I release the space, the ball goes back to its original speed */
    public void originalSpeed(){
        xSpeed = originalSpeedX;
        ySpeed = originalSpeedY;
    }
    
    
    
    }
    

    

 
  




    
       
    
    
    
    
    
    
    
    
    
   

