package objectGame;
import util.Resources;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Clouds {

    private final BufferedImage cloudImage;
    private final List<Cloud> clouds;


    public Clouds()
    {
        cloudImage = Resources.getResourceImage("Data/new.png");
        clouds = new ArrayList<>();

        Cloud cloud1 = new Cloud();
        cloud1.posX1 = 100;
        cloud1.posX2 = 600;
        cloud1.posX3 = 400;
        cloud1.posX4 = 120;
        cloud1.posY1 = 50;
        cloud1.posY2 = 100;
        cloud1.posY3 = 150;
        cloud1.posY4 = 180;

        clouds.add(cloud1);   //added to arraylist of clouds.
    }

    public void update()
    {
        for (Cloud cloud : clouds )
        {
            cloud.posX1 -=0.5;
            cloud.posX2 -=0.5;
            cloud.posX3 -=1.25;
            cloud.posX4 -=1;
        }

        Cloud firstCloud = clouds.get(0);
        if(firstCloud.posX1 + cloudImage.getWidth() < 0)
        {
            clouds.remove(firstCloud);
            firstCloud.posX1 = 700;
            clouds.add(firstCloud);

        }
        Cloud secondCloud = clouds.get(0);
        if(secondCloud.posX2 + cloudImage.getWidth() < 0)
        {
            clouds.remove(secondCloud);
            secondCloud.posX2 = 700;
            clouds.add(secondCloud);
        }
        Cloud thirdCloud = clouds.get(0);
        if(thirdCloud.posX3 + cloudImage.getWidth() < 0)
        {
            clouds.remove(thirdCloud);
            thirdCloud.posX3 = 700;
            clouds.add(thirdCloud);
        }
        Cloud forthCloud = clouds.get(0);
        if(forthCloud.posX4 + cloudImage.getWidth() < 0)
        {
            clouds.remove(forthCloud);
            forthCloud.posX4 = 700;
            clouds.add(forthCloud);
        }


    }

    public void draw(Graphics g)
    {
        for (Cloud cloud : clouds)
        {
            g.drawImage(cloudImage,(int) cloud.posX1,(int) cloud.posY1,null);
            g.drawImage(cloudImage,(int) cloud.posX2,(int) cloud.posY2,null);
            g.drawImage(cloudImage,(int) cloud.posX3,(int) cloud.posY3,null);
            g.drawImage(cloudImage,(int) cloud.posX4,(int) cloud.posY4,null);
        }
    }

    //now to make clouds move
    private static class Cloud
    {
        float posX1;
        float posX2;
        float posX3;
        float posX4;
        float posY1;
        float posY2;
        float posY3;
        float posY4;
    }
}
