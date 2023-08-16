package edu.gonzaga.BasicGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowToPlay implements ActionListener
{

    JLabel howToPlayLabel;
    JButton backButton;
    JTextArea instructionsTextArea;
    JFrame mainWindowFrame;


    HowToPlay()
    {
        howToPlayLabel = new JLabel();
        mainWindowFrame = new GameFrame();


        howToPlayLabel.setBounds(690, 0, 400, 100);
        howToPlayLabel.setFont(new Font("MV Boli", Font.BOLD, 40));
        howToPlayLabel.setText("How to play");
        howToPlayLabel.setForeground(Color.BLACK);



        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFont(new Font("MV Boli", Font.BOLD, 15));
        backButton.setBounds(1410, 725, 100, 50);
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        backButton.setForeground(Color.BLACK);

        instructionsTextArea = new JTextArea();
        instructionsTextArea.setFont(new Font("MV Boli", Font.BOLD, 18));
        instructionsTextArea.setEditable(false);
        instructionsTextArea.setPreferredSize(new Dimension(600, 400));
        instructionsTextArea.setBounds(50, 90, 1430, 800);
        instructionsTextArea.setLineWrap(true);
        instructionsTextArea.setWrapStyleWord(true);
        String instructionString = new String();
        instructionString += "Onitama is an elegant and simple game that captures the essence of martial arts. Each game is quick, usually 15 minutes in length.\n\n Combat at Onitama is simple and elegant, as befits a contest between two Masters. You and your opponent will take turns.\n\n On your turn, examine and choose one of the two Move cards in front of you. Then, select one of your pawns (student or master) and examine the available options. (The square grid will show you the way). Once you have decided where to move, select that location and move to the next player's turn.\n\n The black square in the middle of a card represents the space your chosen pawn occupies. The gray spaces show where your pawn can move, relative to its starting position. You can move your pawn to any one of the spaces indicated. Other pawns (yours or your opponents) and Temple Arches do not block the movement of your pawn across the board.\n\n After a turn has been completed, the card you used will be exchanged with the intermediate card on the left side of the board. This will now be the card that your opponent will get after their turn. This keeps repeating throughout the game, so be careful which card you’re giving to your opponent. \n How do you win?\n\n There are two ways to prove that your Art is stronger — the Way of the Stone or the Way of the Stream:\n To win in the Way of the Stone, you must capture your opponent’s Master pawn.\n To win in the Way of the Stream, you must move your own Master pawn into your opponent’s Temple Arch space.\n\n Neither path to victory is easy! You will need careful strategy to achieve your goals.";


        instructionsTextArea.setText(instructionString);
        instructionsTextArea.setForeground(Color.BLACK);
        instructionsTextArea.setOpaque(false);


        mainWindowFrame.add(howToPlayLabel);
        mainWindowFrame.add(backButton);
        mainWindowFrame.add(instructionsTextArea);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == backButton)
        {
            mainWindowFrame.dispose();
        }
    }
}
