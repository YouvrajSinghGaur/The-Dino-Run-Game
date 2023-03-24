package objectGame;
import util.Resources;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyManager
{
    private final List<Enemy> enemies;
    private final Random random;

    private final BufferedImage imageCactus1;
    private final BufferedImage imageCactus2;
    private final BufferedImage imageCactus3;
    private final MainCharacter mainCharacter;

    public EnemyManager(MainCharacter mainCharacter)            //MainCharacter class and its object is injected as a parameter.
    {
        this.mainCharacter = mainCharacter;
        enemies = new ArrayList<>();
        imageCactus1  = Resources.getResourceImage("Data/cactus111.png");
        imageCactus2  = Resources.getResourceImage("Data/cactus2222.png");
        imageCactus3  = Resources.getResourceImage("Data/cactus333.png");
        random = new Random();

        enemies.add(getRandomCactus());

    }

    public void update()
    {
        for(Enemy e : enemies)
        {
            e.update();
            if(e.getBound().intersects(mainCharacter.getBound()))
            {
                mainCharacter.setAlive(false);
            }
        }
        Enemy FirstEnemy = enemies.get(0);
        if(FirstEnemy.isOutOfScreen())
        {
            enemies.remove(FirstEnemy);
            enemies.add(getRandomCactus());
        }

    }

    public void draw(Graphics g)
    {
    for(Enemy e : enemies)
    {
        e.draw(g);
    }
    }

    private Cactus getRandomCactus()
    {
        Cactus cactus;
        cactus = new Cactus(mainCharacter);
        cactus.setX(700);
        if(random.nextBoolean())
        {
            cactus.setImage(imageCactus1);
        }
        else if (random.nextBoolean())
        {
            cactus.setImage(imageCactus2);
        }
        else
        {
            cactus.setImage(imageCactus3);
        }
        return cactus;
    }

    public void Reset()
    {
        enemies.clear();
        enemies.add(getRandomCactus());

    }


}
