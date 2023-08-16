package edu.gonzaga.CardDeck;

import edu.gonzaga.Coordinate;

public class TigerCard extends Card{

    public TigerCard(String name) {
        super(name);
        color = "blue";
        Coordinate move1 = new Coordinate(0,2);
        Coordinate move2 = new Coordinate(0,-1);
        Coordinate invMove1 = new Coordinate(0,-2);
        Coordinate invMove2 = new Coordinate(0,1);

        moves.add(move1);
        moves.add(move2);
        invMoves.add(invMove1);
        invMoves.add(invMove2);
    }

}
