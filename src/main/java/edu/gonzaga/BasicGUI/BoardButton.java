package edu.gonzaga.BasicGUI;

import javax.swing.*;

import edu.gonzaga.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class BoardButton extends JButton implements PropertyChangeListener {
    
    Square squareToView;
    String text;
    Board board;
    Coordinate cord;
    boolean border;
    boolean selected;
    ImageIcon[] pieceIcons;


    public BoardButton(Board b, Coordinate c, ImageIcon[] arr) {
        super("");
        board = b;
        cord = c;
        pieceIcons = arr;
        squareToView = board.getSquare(cord);
        text = squareToView.toString();
        //icon = getSquareIcon(text);
        //this.setIcon(icon);
        this.setText(text);
        this.setFont(this.getFont().deriveFont(0f));
        switch(text){
            case "0":
                this.setIcon(pieceIcons[0]);
                break;
            case "r":
                this.setIcon(pieceIcons[1]);
                break;
            case "R":
                this.setIcon(pieceIcons[2]);
                break;
            case "b":
                this.setIcon(pieceIcons[3]);
                break;
            case "B":
                this.setIcon(pieceIcons[4]);
                break;
        }
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        squareToView.addPropertyChangeListener(this::propertyChange);
        addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        board.boardButtonPressed(cord);
                }
            }
        );
    }

    private Icon getSquareIcon(String piece){
        switch(text){
            case "r":
                return pieceIcons[1];
            case "R":
                return pieceIcons[2];
            case "b":
                return pieceIcons[3];
            case "B":
                return pieceIcons[4];
        }
        return pieceIcons[0];
    }


    public void propertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();
        if ("squarePiece".equals(propertyName)) {
            //System.out.println(("DieView sees value changed to: " + e.getNewValue()));
            text = e.getNewValue().toString();
            System.out.println(text);
            this.setIcon(getSquareIcon(text));
            this.setText(text);
            //this.setIcon(icon);
            this.setHorizontalTextPosition(SwingConstants.CENTER);
            this.setVerticalTextPosition(SwingConstants.CENTER);
        }
        if ("possible".equals(propertyName)) {
            border = ((boolean)e.getNewValue());
            if(border){
                //this.setBackground(Color.BLACK);
                //this.setIcon(pieceIcons[5]);
                this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
                this.setBorderPainted(true);
            }
            else{
                //this.setBackground(null);
                this.setBorderPainted(false);
                //this.setIcon(pieceIcons[0]);
            }
        }
        if ("selected".equals(propertyName)) {
            selected = ((boolean)e.getNewValue());
            if(selected){
                //this.setBackground(Color.BLUE);
                this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
                this.setBorderPainted(true);
                
            }
            else{
                //this.setBackground(null);
                this.setBorderPainted(false);
            }
        }
    }

}
