import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class MyWorld extends World
{
    private long lastFrameTimeMS;
    private double timeStepDuration;
    private GreenfootSound gameMusic;

    public MyWorld()
    {    
        super(800, 600, 1, false); 

        lastFrameTimeMS = System.currentTimeMillis();
        timeStepDuration = 1.0 / 60; // seems to be the default
        prepare();
        gameMusic =  new  GreenfootSound("3.wav");
    }

    public void started()
    {
        lastFrameTimeMS = System.currentTimeMillis();
    }

    public void act()
    {
        timeStepDuration = (System.currentTimeMillis() - lastFrameTimeMS) / 1000.0;
        lastFrameTimeMS = System.currentTimeMillis();
    }

    public double getTimeStepDuration()
    {
        return timeStepDuration;
    }


    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Cannon cannon =  new  Cannon();
        addObject(cannon, 95, 92);
        Cannon cannon2 =  new  Cannon();
        addObject(cannon2, 321, 277);
        CannonType2 cannon3 =  new  CannonType2();
        addObject(cannon3, 692, 107);
        CannonType2 cannon4 =  new  CannonType2();
        addObject(cannon4, 708, 478);
        CannonType3 cannon5 =  new  CannonType3();
        addObject(cannon5, 497, 52);
        cannon3.setLocation(730, 171);
        cannon2.setLocation(289, 316);
        
        FinishLocation finishLocation =  new  FinishLocation();
        addObject(finishLocation, 75, 324);
        Ladybug hero =  new  Ladybug();
        addObject(hero, 720, 286);
        hero.setLocation(731, 298);
        hero.setLocation(709, 282);
        removeObject(hero);
        addObject(hero, 711, 302);
        hero.setLocation(722, 39);
        cannon3.setRotation(180);
        cannon4.setLocation(737, 479);
        cannon4.setRotation(180);
        cannon5.setRotation(90);
        
        hero.setRotation(180);
        hero.setLocation(742, 58);
        hero.setLocation(734, 54);
    }
    
    /**
     * 
     */
    public void started2()
    {
        gameMusic.playLoop();
    }

    /**
     * 
     */
    public void stopped()
    {
        gameMusic.stop();
    }
}
