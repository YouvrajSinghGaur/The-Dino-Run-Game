package objectGame;

import util.Animation;
import util.Resources;

import java.awt.*;

import static com.UserInterfsce.GameScreen.GRAVITY;
import static com.UserInterfsce.GameScreen.GROUND;

public class MainCharacter {
    private float x = 50;
    private float y = 255 ;
    private float speedY = 0;
    private final Animation characterRun;
    private final Rectangle rect;
    private boolean isAlive = true;

    public MainCharacter()
    {
        characterRun = new Animation(100);
        characterRun.addFrame(Resources.getResourceImage("Data/rex1.png"));
        characterRun.addFrame(Resources.getResourceImage("Data/rex2.png"));
        characterRun.addFrame(Resources.getResourceImage("Data/rex3.png"));
        characterRun.addFrame(Resources.getResourceImage("Data/rex4.png"));
        characterRun.addFrame(Resources.getResourceImage("Data/rex5.png"));
        characterRun.addFrame(Resources.getResourceImage("Data/rex6.png"));
        characterRun.addFrame(Resources.getResourceImage("Data/rex7.png"));
        characterRun.addFrame(Resources.getResourceImage("Data/rex8.png"));
        characterRun.addFrame(Resources.getResourceImage("Data/rex9.png"));
        characterRun.addFrame(Resources.getResourceImage("Data/rex10.png"));


        rect = new Rectangle();

    }

    public void update(){
        characterRun.update();
        if(y >= GROUND - characterRun.getFrame().getHeight())
        {
            speedY = 0;
            y = GROUND - characterRun.getFrame().getHeight();
        }
        else
        {
            speedY += GRAVITY + 1;
            y += speedY;
        }

        rect.x = (int) x;
        rect.y = (int) y;
        rect.width = characterRun.getFrame().getWidth();
        rect.height = characterRun.getFrame().getHeight();
    }

    public Rectangle getBound()
    {
        return rect;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.white);
       //g.drawRect((int) x,(int) y,characterRun.getFrame().getWidth(),characterRun.getFrame().getHeight());
        g.drawImage(characterRun.getFrame(), (int) x, (int) y,null);
    }

    public void jump()
    {
            speedY = -15;
            y += speedY;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }



    public void setY(float y) {
        this.y = y;
    }



    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public void setAlive(boolean alive)
    {
        isAlive = alive;
    }

    public boolean getAlive()
    {
        return isAlive;
    }
}
