package edu.gonzaga.BasicGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Options implements ActionListener
{

    JLabel optionsMenuLabel;
    JButton backButton;
    JFrame mainWindowFrame;
    String backgroundImageFileName;
    JPanel backGroundOptionsPanel;

    JButton lightWoodButton;
    JButton darkWoodButton;
    JButton stoneBackgroundButton;
    JButton colorfulBricksButton;


    Options()
    {
        mainWindowFrame = new GameFrame();
        optionsMenuLabel = new JLabel();
        backGroundOptionsPanel = createbackGroundOptionsPanel();

        optionsMenuLabel.setBounds(690, 100, 400, 100);
        optionsMenuLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
        optionsMenuLabel.setText("Options");

        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        backButton.setBounds(1410, 725, 100, 50);
        //backButton.addActionListener(this);
        backButton.setFocusable(false);
        backButton.setForeground(Color.BLACK);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == backButton)
                {
                    mainWindowFrame.dispose();
                }
            }
        });

        mainWindowFrame.add(optionsMenuLabel);
        mainWindowFrame.add(backButton);
        mainWindowFrame.add(backGroundOptionsPanel);

    }

    public JPanel createbackGroundOptionsPanel()
    {
        JPanel panel = new JPanel();
        panel.setBounds(500, 250, 400, 400);
        panel.setLayout(new GridLayout(2,2));
        darkWoodButton = createbackgroundButtons("darkWoodBackground.png");
        lightWoodButton = createbackgroundButtons("lightWood.jpg");
        stoneBackgroundButton = createbackgroundButtons("stoneBackground.jpg");
        colorfulBricksButton = createbackgroundButtons("colorfulBricks.png");


        panel.add(darkWoodButton);
        panel.add(lightWoodButton);
        panel.add(stoneBackgroundButton);
        panel.add(colorfulBricksButton);

        return panel;
    }

    public JButton createbackgroundButtons(String fileName)
    {
        JButton backgroundButton = new JButton();
        String filePath = new String();
        filePath += "GameArt/" + fileName;
        File imageFile = new File(filePath);
        ImageIcon backGroundButtonImageIcon = new ImageIcon(imageFile.getAbsolutePath());
        backgroundButton.setIcon(backGroundButtonImageIcon);
        backgroundButton.addActionListener(this);

        return backgroundButton;
    }

    public String getBackgroundImageFileName()
    {
        return backgroundImageFileName;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == lightWoodButton)
        {
            System.out.println("light wood button pressed");
            backgroundImageFileName = "lightWood.jpg";
            updateBackground("lightWood.jpg");
        }
        if (e.getSource() == darkWoodButton)
        {
            System.out.println("dark wood button pressed");
            backgroundImageFileName = "darkWoodBackground.png";
            updateBackground("darkWoodBackground.png");
        }
        if (e.getSource() == stoneBackgroundButton)
        {
            System.out.println("stoneBackgroundButton button pressed");
            backgroundImageFileName = "stoneBackground.jpg";
            updateBackground("stoneBackground.jpg");
        }
        if (e.getSource() == colorfulBricksButton)
        {
            System.out.println(" colorfulBricksButton button pressed");
            backgroundImageFileName = "colorfulBricks.png";
            updateBackground("colorfulBricks.png");
        }
    }

    public void updateBackground(String fileName)
    {
        //mainWindowFrame.getContentPane().removeAll();
        Image backgroundImage = new ImageIcon(fileName).getImage();
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        mainWindowFrame.setContentPane(backgroundPanel);
        mainWindowFrame.revalidate();
        mainWindowFrame.repaint();
    }
}