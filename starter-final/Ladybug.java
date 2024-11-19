import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Ladybug extends Actor
{

    /**
     * Act - do whatever the Hero wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
         if (Greenfoot.isKeyDown("w") ) {
            setLocation(getX(), getY() - 4);
        }
        if (Greenfoot.isKeyDown("s")  ) {
            setLocation(getX(), getY() + 4);
        }
        if (Greenfoot.isKeyDown("a") ) {
            setLocation(getX() - 4, getY());
        }
        if (Greenfoot.isKeyDown("d") ) {
            setLocation(getX() + 4, getY());
        }
        Actor FinishLocation = getOneIntersectingObject(FinishLocation.class);
        if (FinishLocation != null) {
            World world = getWorld();
            world.removeObject(FinishLocation);
            
        }
        if (isGameWon()) {
            transitionToGameWorld();
        }
    }
    /**
     * 
     */
    public boolean isGameWon()
    {
        World world = getWorld();
        if (world.getObjects(FinishLocation.class).isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 
     */
    public void transitionToGameWorld()
    {
        World crabWorld = getWorld();
        crabWorld.stopped();
        World gameWonWorld =  new  GameWonWorld();
        gameWonWorld.started();
        Greenfoot.setWorld(gameWonWorld);
    }
    
    }

