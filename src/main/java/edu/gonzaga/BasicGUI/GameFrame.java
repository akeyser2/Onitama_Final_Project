package edu.gonzaga.BasicGUI;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame
{
    GameFrame()
    {
        this.setVisible(true);//this makes the frame visible
        //this.setSize(600,600);//sets x & y dimensions
        this.setTitle("Onitama");//setting title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//what happens when we close the window
        this.setResizable(true);//we can change whether frame may be resized

        Image backgroundImage = new ImageIcon("GameArt/darkWoodBackground.png").getImage();
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        this.setContentPane(backgroundPanel);
        
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon windoWIconImage = new ImageIcon("GameArt/orange.png");
        this.setIconImage(windoWIconImage.getImage());

    }

    public void updateBackground(String fileName)
    {
        Image backgroundImage = new ImageIcon(fileName).getImage();
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        this.setContentPane(backgroundPanel);
    }
}
