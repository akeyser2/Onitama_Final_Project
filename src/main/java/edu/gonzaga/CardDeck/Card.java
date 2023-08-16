package edu.gonzaga.CardDeck;

import java.util.ArrayList;

import edu.gonzaga.Coordinate;

public abstract class Card {
    protected ArrayList<Coordinate> moves = new ArrayList<Coordinate>();
    protected ArrayList<Coordinate> invMoves = new ArrayList<Coordinate>();
    protected String cardName;
    protected String color;

    public Card(String name) {
        this.cardName = name;      
    } 

    public ArrayList<Coordinate> getMoves(){
        return moves;
    }

    public ArrayList<Coordinate> getInvMoves(){
        return invMoves;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return cardName;
    }

    @Override
    public String toString() {
        String ret = "Card name: ";
        ret += this.cardName;
        ret += "\nmoves : ";
        ret += this.moves.toString();
        ret += "\ninvMoves : ";
        ret += this.invMoves;
        ret += "\n";
        return ret;
    }
}
