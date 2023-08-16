package edu.gonzaga.BasicGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame implements ActionListener
{
    JButton newGameButton;
    JButton instructionsButton;
    JButton optionsButton;
    JButton quitButton;
    GameFrame frame;
    JPanel startMenuPanel;
    JLabel gameTitleLabel;

    public static void main(String[] args)
    {
        new GameMenu();
    }

    GameMenu()
    {
        frame = new GameFrame();
        gameTitleLabel = new JLabel("Onitama: A two player strategy game");
        startMenuPanel = new JPanel();
        newGameButton = new JButton();
        instructionsButton = new JButton();
        optionsButton = new JButton();
        quitButton = new JButton();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


        gameTitleLabel.setBounds(345, 100, 700, 300);
        gameTitleLabel.setFont(new Font("MV Boli", Font.BOLD, 20));



        newGameButton.setBounds(630, 320, 300, 150);
        newGameButton.setText("New Game");
        newGameButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        newGameButton.setFocusable(false);
        newGameButton.addActionListener(this);
        
        
        instructionsButton.setBounds(630, 420, 300, 150);
        instructionsButton.setText("How to play");
        instructionsButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        instructionsButton.setFocusable(false);
        instructionsButton.addActionListener(this);
        instructionsButton.setForeground(Color.BLACK);


        quitButton.setBounds(630, 520, 300, 150);
        quitButton.setText("Quit");
        quitButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        quitButton.setFocusable(false);
        quitButton.addActionListener(this);
        quitButton.setForeground(Color.BLACK);
        


        frame.add(gameTitleLabel);
        frame.add(newGameButton);
        frame.add(optionsButton);
        frame.add(instructionsButton);
        frame.add(quitButton);
        frame.setVisible(true);

        newGameButton.setOpaque(false);
        newGameButton.setContentAreaFilled(false);
        newGameButton.setBorderPainted(false);
        newGameButton.setIcon(new ImageIcon("GameArt/NewGameZM.png"));
        instructionsButton.setOpaque(false);
        instructionsButton.setContentAreaFilled(false);
        instructionsButton.setBorderPainted(false);
        instructionsButton.setIcon(new ImageIcon("GameArt/RulesZM.png"));
        optionsButton.setOpaque(false);
        optionsButton.setContentAreaFilled(false);
        optionsButton.setBorderPainted(false);
        optionsButton.setIcon(new ImageIcon("GameArt/OptionsZM.png"));
        quitButton.setOpaque(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setBorderPainted(false);
        quitButton.setIcon(new ImageIcon("GameArt/QuitZM.png"));
        gameTitleLabel.setIcon(new ImageIcon("GameArt/OnitamaZ.png"));
        gameTitleLabel.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == newGameButton)
        {
            CharacterSelect c = new CharacterSelect();
        }
        if (e.getSource() == instructionsButton)
        {
            HowToPlay h = new HowToPlay();
        }
        // if (e.getSource() == optionsButton)
        // {
        //     s = new Options();
        // }
        if (e.getSource() == quitButton)
        {
            System.exit(0);
        }
    }
}