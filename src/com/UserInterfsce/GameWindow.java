package com.UserInterfsce;
import util.Resources;
import javax.swing.*;

public class GameWindow extends JFrame {

    private final GameScreen gameScreen;


    public GameWindow ()       //constructor
    {
        super("Dino Run");    //Title of our game
        setSize(700,400);   // Dimentions of the game window
        setLocation(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameScreen = new GameScreen();
        add(gameScreen);
        addKeyListener(gameScreen);
    }

    public void StartGame(){
        gameScreen.StartGame();
    }
    public static void main(String[] args)
    {

        GameWindow gw = new GameWindow();
        gw.setVisible(true);
        gw.StartGame();
        Resources.playMusic("Data/T-REX-Dolby.wav" , "data/honor-and-sword-main-11222.wav");
    }

}
