import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class CannonType2 extends Actor
{
    private static final double CANNON_BALL_VELOCITY = 100.0;
    int shooting = 500;
    int cooldownShooting = 0;
    /**
     * Act - do whatever the Cannon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {       
        if (cooldownShooting<= 0) {
            shoot();
            cooldownShooting= shooting;
            }
        if (cooldownShooting > 0) {
                cooldownShooting--;
            }
         
            
        }
        public void shoot() {
            Vector2D cannonToMouse = new Vector2D(-1,0);
            
            cannonToMouse = Vector2D.multiply(cannonToMouse,CANNON_BALL_VELOCITY);  
            CannonBall newBall = new CannonBall();
            newBall.setVelocity(cannonToMouse);
            getWorld().addObject(newBall, getX(), getY());
            
            
        }
    }