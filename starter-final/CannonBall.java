import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* Write a description of class CannonBall here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class CannonBall extends Actor
{
     public Point2D position;
     public Vector2D velocity;
     public Vector2D acceleration;
    
    private static final double GRAVITY = 0 * 200; // 200 pixels is 1 meter
    
    public CannonBall()
    {
        position = null;
        velocity = new Vector2D(0.0, 0.0);
        acceleration = new Vector2D(0.0, GRAVITY);
    }
    
    public void act() 
    {
        updatePhysics();
        Actor Ladybug = getOneIntersectingObject(Ladybug.class);
        if (Ladybug != null) {
            World world = getWorld();
            world.removeObject(Ladybug);
        }
        if (isGameLost()) {
            transitionToGameOver();
        }
    }    
    
    public void setVelocity(Vector2D newValue)
    {
        velocity = newValue;
    }
    
    public void updatePhysics()
    {
        // Initial position
        if (position == null)
        {
            position = new Point2D(getX(), getY());
        }
        
        // Get time step duration
        MyWorld world = (MyWorld) getWorld();
        double dt = world.getTimeStepDuration();
        
        // Update velocity
        Vector2D velocityVariation = Vector2D.multiply(acceleration, dt);
        velocity = Vector2D.add(velocity, velocityVariation);

        // Update position
        Vector2D positionVariation = Vector2D.multiply(velocity, dt);
        position.add(positionVariation);
        
        // Set new actor position
        setLocation((int) position.getX(), (int) position.getY());        
    }
    /**
     * 
     */
    public boolean isGameLost()
    {
        World world = getWorld();
        if (world.getObjects(Ladybug.class).isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 
     */
    public void transitionToGameOver()
    {
        World crabWorld = getWorld();
        World gameOverWorld =  new GameOverWorld();
        crabWorld.stopped();
        Greenfoot.setWorld(gameOverWorld);
        gameOverWorld.started();
    }
}
