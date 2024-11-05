
class Bubble {

    //MISSING MANY INSTANCE VARIABLES
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
    private boolean isDragging = false;

/**constructor */
    public Bubble(Sketch sketch) {
        s = sketch;
        radius = 20;
        x = 100;
        y = 100;
        xSpeed = 2;
        ySpeed = -1;
        fillColor = s.color(255, 100, 100);
        borderColor = s.color(0, 0, 0);

    }                               
    public Bubble(Sketch sketch, float radius, float x, float y, float xspeed, float yspeed) {
        this.s = sketch;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.xSpeed = xspeed;
        this.ySpeed = yspeed;
    }

    // accessors for the radius, diameter, x, and y values 
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

    public void draw() {
        s.stroke(borderColor);
        s.fill(fillColor);
        s.circle(x, y, radius*2);
    }
    public void setColors(int fill, int border) {
        borderColor = border;
        fillColor = fill;
    }


    public void move() {
        if(!isDragging){
        x = x + xSpeed;
        y = y + ySpeed;
        if (x > s.width - radius) {
            x = radius;
        } else if(x < radius) {
            x = s.width - radius;
        } else if (y > s.height - radius) {
            y = radius;
        } else if (y < radius) {
            y = s.height - radius;
        }
    }}
    /**https://processing.org/reference/mousePressed_.html */
    //used the similar method with the collision 
    /** When mouse is pressed */
    public void mousePressed(float mouseX, float mouseY){
        /**calculates the distance between the mouse's current possision 
         * and the center of the bubble object
         */
        float distance = s.dist(mouseX, mouseY, x, y);
        /** if the distance of the mouse is less then the radius
         * the mouse dragging bubble is true
         */
        if(distance < radius){
            isDragging = true;
        }
        }
/**https://processing.org/reference/mouseDragged_.html */
    public void mouseDragged(float mouseX, float mouseY){
        if(isDragging){
            /** position changes as the mouse moves */
            x = mouseX;
            y = mouseY;
        }


    }
/**https://processing.org/reference/mouseReleased_.html */
    public void mouseReleased(){
        /**If mouse is released, dragging is false */
        isDragging = false;
    }
    }

 