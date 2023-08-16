package edu.gonzaga.BasicGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import edu.gonzaga.Board;
import edu.gonzaga.Hand;
import edu.gonzaga.CardDeck.Card;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;




public class CardButton extends JButton implements PropertyChangeListener{
    private Board board;
    private Hand hand;
    private String name;
    int location;
    Card card;
    ImageIcon tmp;
    boolean pressed = false;
    

    CardButton(Board b, Hand h, int n) {
        super("" + h.getNames()[n]);
        board = b;
        hand = h;
        location = n;
        name = h.getNames()[n];
        if(location == 2 || location == 3){
            tmp = new ImageIcon("GameArt/" + name + "Fliped.png");
        }
        else{
            tmp = new ImageIcon("GameArt/" + name + ".png");
        }
        this.setIcon(tmp);
        this.setFont(this.getFont().deriveFont(0f));
        this.setBackground(new Color(0, 0, 0, 0)); // Set the background color to transparent
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        hand.addPropertyChangeListener(this::propertyChange);
        addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    board.cardButtonPressed(location);
                    changeBorder();
                }
            }
        );
        //setupCallback();
    }

    private void changeBorder(){
        if(pressed){
            this.setBorder(BorderFactory.createLineBorder(Color.GREEN,4));
            this.setBorderPainted(true);
            pressed = true;
        }
        else{
            this.setBorderPainted(false);
            pressed = false;
        }
    }

    public void propertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();
        switch (location){
            case 0:
                if ("spot0".equals(propertyName)) {
                    //System.out.println(("DieView sees value changed to: " + e.getNewValue()));
                    card = ((Card)e.getNewValue());
                    name = card.getName();
                    this.setIcon(new ImageIcon("GameArt/" + name + ".png"));
                    this.setOpaque(false);
                    this.setContentAreaFilled(false);
                    this.setBorderPainted(false);
                    this.setText(name);
                }
                break;
            case 1:
                if ("spot1".equals(propertyName)) {
                    //System.out.println(("DieView sees value changed to: " + e.getNewValue()));
                    card = ((Card)e.getNewValue());
                    name = card.getName();
                    this.setIcon(new ImageIcon("GameArt/" + name + ".png"));
                    this.setOpaque(false);
                    this.setContentAreaFilled(false);
                    this.setBorderPainted(false);
                    this.setText(name);
                }
                break;
            case 2:
                if ("spot2".equals(propertyName)) {
                    //System.out.println(("DieView sees value changed to: " + e.getNewValue()));
                    card = ((Card)e.getNewValue());
                    name = card.getName();
                    this.setIcon(new ImageIcon("GameArt/" + name + "Fliped.png"));
                    this.setOpaque(false);
                    this.setContentAreaFilled(false);
                    this.setBorderPainted(false);
                    this.setText(name);
                }
                break;
            case 3:
                if ("spot3".equals(propertyName)) {
                    //System.out.println(("DieView sees value changed to: " + e.getNewValue()));
                    card = ((Card)e.getNewValue());
                    name = card.getName();
                    this.setIcon(new ImageIcon("GameArt/" + name + "Fliped.png"));
                    this.setOpaque(false);
                    this.setContentAreaFilled(false);
                    this.setBorderPainted(false);
                    this.setText(name);
                } 
                break;
            case 4:
                if ("inter".equals(propertyName)) {
                    //System.out.println(("DieView sees value changed to: " + e.getNewValue()));
                    card = ((Card)e.getNewValue());
                    name = card.getName();
                    this.setIcon(new ImageIcon("GameArt/" + name + ".png"));
                    this.setOpaque(false);
                    this.setContentAreaFilled(false);
                    this.setBorderPainted(false);
                    this.setText(name);
                } 
                break;
        }
    }

    public String getName(int i){
        return name;
    }

}
