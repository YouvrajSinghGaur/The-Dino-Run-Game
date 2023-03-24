package objectGame;
import util.Resources;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Cactus extends Enemy{

    private BufferedImage image;
    private int posX;
    private final int posY;
    private final Rectangle rect;

    public Cactus(MainCharacter mainCharacter)
    {
        image  = Resources.getResourceImage("Data/cactus111.png");
        posX = 650;
        posY = 250;
        rect = new Rectangle();
        //injected MainCharacter
    }

    public void update()
    {
        posX -=10;

        rect.x = posX;
        rect.y = posY;
        rect.width = image.getWidth();
        rect.height = image.getHeight();
    }
    @Override
    public Rectangle getBound()
    {
        return rect;
    }


    @Override
    public void draw(Graphics g)
    {
        g.drawImage(image, posX,posY,null);
    }

    public void setX(int x)
    {
        posX = x;
    }

    public void setImage(BufferedImage image)
    {
        this.image = image;
    }

    @Override
    public boolean isOutOfScreen()
    {
      return(posX + image.getWidth() < 0);
    }

}
