package edu.gonzaga.CardDeck;

import edu.gonzaga.Coordinate;

public class DragonCard extends Card{

    public DragonCard(String name) {
        super(name);
        color = "red";
        Coordinate move1 = new Coordinate(-2,1);
        Coordinate move2 = new Coordinate(-1,-1);
        Coordinate move3 = new Coordinate(1,-1);
        Coordinate move4 = new Coordinate(2,1);
        Coordinate invMove1 = new Coordinate(2,-1);
        Coordinate invMove2 = new Coordinate(1,1);
        Coordinate invMove3 = new Coordinate(-1,1);
        Coordinate invMove4 = new Coordinate(-2,-1);

        moves.add(move1);
        moves.add(move2);
        moves.add(move3);
        moves.add(move4);
        invMoves.add(invMove1);
        invMoves.add(invMove2);
        invMoves.add(invMove3);
        invMoves.add(invMove4);
    }

}
