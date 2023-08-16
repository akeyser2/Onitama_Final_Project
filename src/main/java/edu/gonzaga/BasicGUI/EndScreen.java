package edu.gonzaga.BasicGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EndScreen extends JFrame implements ActionListener{
    
    int victor;
    JButton quitButton;
    GameFrame frame;
    JPanel endPanel;
    JLabel endTitleLabel;


    public static void main(String[] args)
    {
        new EndScreen(0);
    }

    public EndScreen(int num)
    {
        victor = num;
        setupGUI();
    }


    private void setupGUI(){
        frame = new GameFrame();
        endTitleLabel = new JLabel("Player " + victor + " Wins!");
        endPanel = new JPanel();
        quitButton = new JButton();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        

        endTitleLabel.setBounds(610, 250, 315, 150);
        endTitleLabel.setFont(new Font("MV Boli", Font.BOLD, 40));
        endTitleLabel.setBackground(Color.white);


        quitButton.setBounds(595, 395, 350, 150);
        quitButton.setText("Quit");
        quitButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        quitButton.setFocusable(false);
        quitButton.addActionListener(this);
        quitButton.setForeground(Color.BLACK);
        quitButton.setOpaque(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setBorderPainted(false);
        quitButton.setIcon(new ImageIcon("GameArt/QuitZM.png"));

        


        frame.add(endTitleLabel);
        frame.add(quitButton);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == quitButton)
        {
            System.exit(0);
        }
    }
}

