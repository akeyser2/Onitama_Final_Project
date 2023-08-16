package edu.gonzaga.BasicGUI;

import javax.swing.*;
import java.awt.*;



public class NewGame {
    String p1color;
    String p2color;
    ImageIcon[] pieceIcons;

    public NewGame(String c1, String c2){
        p1color = c1;
        p2color = c2;
        makeIconArray();
        BoardUI app = new BoardUI(pieceIcons);    // Create, then run GUI
        app.runGUI();
    }

    private void makeIconArray(){
        pieceIcons = new ImageIcon[6];
        pieceIcons[0] = new ImageIcon("GameArt/boardBackground.png");   // Empty space
        pieceIcons[1] = new ImageIcon("GameArt/" + p1color + ".png");                 // p1 pawn
        pieceIcons[2] = new ImageIcon("GameArt/" + p1color + "King.png");             // p1 king
        pieceIcons[3] = new ImageIcon("GameArt/" + p2color + ".png");                 // p2 pawn
        pieceIcons[4] = new ImageIcon("GameArt/" + p2color + "King.png");             // p2 king
        pieceIcons[5] = new ImageIcon("GameArt/possibleMove.png");      // possible move indicator
        for(int i = 0; i < pieceIcons.length; i++){
            pieceIcons[i] = new ImageIcon(pieceIcons[i].getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        }
    }
}