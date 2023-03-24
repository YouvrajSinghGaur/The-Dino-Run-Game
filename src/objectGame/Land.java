package objectGame;
import util.Resources;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static com.UserInterfsce.GameScreen.GROUND;

public class Land{
    private final List<ImageLand> listImage;
    private final BufferedImage imageLand1;
    private final BufferedImage imageLand2;
    private final BufferedImage imageLand3;
    private final Random random;


    public Land()
    {
        random = new Random();
        imageLand1 = Resources.getResourceImage("Data/land111.png");
        imageLand2 = Resources.getResourceImage("Data/land111.png");
        imageLand3 = Resources.getResourceImage("Data/land111.png");
        listImage = new ArrayList<>();
        int numOfLandReq = 700/imageLand1.getWidth()+50;        //this variable holds the total req number of image to fill the gameWindow.

        for(int i = 0 ;i<numOfLandReq ; i++)
        {
            ImageLand imageLand = new ImageLand();   //Object of class ImageLand created.
            imageLand.posX = i * imageLand1.getWidth();   //variable of class ImageLand is accessed via object of class.
            imageLand.image = getImageLand();                        //variable of class ImageLand is accessed via object of class.
            listImage.add(imageLand);                            //adding image.

        }
    }

    public void update(){

        for (ImageLand imageLand : listImage) {
                imageLand.posX -=10;

        }

        ImageLand FirstElement = listImage.get(0);
        if(FirstElement.posX + imageLand1.getWidth() < 0)
        {
            listImage.remove(0);
            FirstElement.posX = listImage.get(listImage.size() - 1).posX + imageLand1.getWidth();
            listImage.add(FirstElement);

        }
    }

    public void draw(Graphics g)
    {
        for (ImageLand imageLand:listImage) {
            g.drawImage(imageLand.image,imageLand.posX,(int) GROUND - 20 ,null);
        }
    }

    public BufferedImage getImageLand()      //for creating random draw of land images
    {
        int i = random.nextInt(10);
        switch (i) {
            case 0 -> {
                return imageLand1;
            }
            case 1 -> {
                return imageLand3;
            }
            default -> {
                return imageLand2;
            }
        }
    }

    public static class ImageLand {
        int posX;      //this variable will chance the update of length of land images.
        BufferedImage image;
    }
}
