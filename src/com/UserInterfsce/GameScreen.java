package com.UserInterfsce;
import objectGame.Clouds;
import objectGame.EnemyManager;
import objectGame.Land;
import objectGame.MainCharacter;
import util.Resources;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import static java.lang.Thread.sleep;

@SuppressWarnings({"InfiniteLoopStatement", "BusyWait"})
public class GameScreen extends JPanel implements Runnable, KeyListener {

    public static final float GRAVITY = 0.1F;
    public static final float GROUND = 300;
    public static final int GAME_FIRST_STAGE = 0;
    public static final int GAME_PLAY_STAGE = 1;
    public static final int GAME_OVER_STAGE = 2;


    //DECLARATION OF EACH GAME OBJECTS:-
    private final MainCharacter mainCharacter;
    private final Thread thread;
    private final Land land;
    private final Clouds clouds;
    private final EnemyManager enemiesManager;

    private int gameState =GAME_FIRST_STAGE;

    private final BufferedImage ImageGameOver;
    private final BufferedImage background,MainDino;
    private final BufferedImage ReplayImage;
    private int HighScore;
    private int PrevHighScore;
    public GameScreen()
    {
        thread = new Thread(this);
        mainCharacter = new MainCharacter();
        land = new Land();
        clouds = new Clouds();
        enemiesManager = new EnemyManager(mainCharacter);
        ImageGameOver = Resources.getResourceImage("Data/gameover_text.png");
        background = Resources.getResourceImage("Data/bg1.png");
        MainDino = Resources.getResourceImage("Data/maindino.png");
        ReplayImage = Resources.getResourceImage("Data/replay_button.png");
    }

    public void StartGame(){
        thread.start();
    }

    @Override
    public void run() {
        while(true){

            try {
                update();
                repaint();
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update()
    {
        switch(gameState)
        {
            case GAME_PLAY_STAGE ->
                    {

                        mainCharacter.update();                //Upgradation of main character;
                        land.update();                          //upgradation of land.
                        clouds.update();
                        enemiesManager.update();
                        if(!mainCharacter.getAlive())
                        {
                            gameState = GAME_OVER_STAGE;

                        }

                    }

        }

    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.decode("#f7f7f7"));
        g.fillRect(0,0,getWidth(),getHeight());

        g.drawImage(background,0,0,null);

        switch (gameState) {
            case GAME_FIRST_STAGE ->
            {

                g.drawImage(MainDino,190,20,null);
                mainCharacter.setY(255);
                g.drawString("\"Press \"UP Arrow\" to START\"",250,330);
            }
            case GAME_PLAY_STAGE ->
            {

                HighScore++;
                PrevHighScore = HighScore;
                clouds.draw(g);
                land.draw(g);
                mainCharacter.draw(g);
                enemiesManager.draw(g);
                g.drawString("High Score :" + PrevHighScore,550,50);

            }
            case GAME_OVER_STAGE ->
                    {
                        clouds.draw(g);
                        land.draw(g);
                        mainCharacter.draw(g);
                        enemiesManager.draw(g);
                        g.drawImage(ImageGameOver,240,200,null);
                        g.drawString("High Score :" + PrevHighScore,550,50);
                        GameReset();
                        HighScore = 0;
                        g.drawString("\"Press SPACE To Play Again\"",250,50);
                        g.drawImage(ReplayImage,320,225,null);
                    }
        }

    }

    public void GameReset()
    {

        mainCharacter.setAlive(true);

        mainCharacter.setX(50);
        mainCharacter.setY(255);
        enemiesManager.Reset();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case (int) KeyEvent.VK_DOWN ->
                    {
                        if(gameState == GAME_PLAY_STAGE)
                        {
                           mainCharacter.setSpeedY(10);


                        }
                    }
            case (int) KeyEvent.VK_UP ->
                    {

                        if (gameState == GAME_FIRST_STAGE) {
                            gameState = GAME_PLAY_STAGE;

                        }
                        else if (gameState == GAME_PLAY_STAGE) {
                                mainCharacter.jump();
                        }

                    }
            case (int) KeyEvent.VK_SPACE->
                    {
                        if (gameState == GAME_OVER_STAGE){
                            GameReset();
                            gameState = GAME_PLAY_STAGE;
                        }
                    }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
