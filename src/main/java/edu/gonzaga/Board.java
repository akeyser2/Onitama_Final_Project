package edu.gonzaga;

import java.lang.management.PlatformManagedObject;
import java.util.ArrayList;



import javax.swing.ImageIcon;

import edu.gonzaga.BasicGUI.EndScreen;
import edu.gonzaga.CardDeck.Card;

public class Board {
    private String[][] boardStartValues = {{"b","0","0","0","r"},{"b","0","0","0","r"},{"B","0","0","0","R"},{"b","0","0","0","r"},{"b","0","0","0","r"}};
    private Square[][] board;
    private int size;
    private ArrayList<Coordinate> destinations = new ArrayList<Coordinate>();
    private Hand hand;
    private Card curCard;
    private Coordinate curPiece;
    private char curPlayer = 'r';
    private int lastPlayer = 2;
    private Boolean cardSelected = false;
    private Boolean pieceSelected = false;
    private ImageIcon[] pieceIcons;


    public Board(int size, Hand h, ImageIcon[] arr){
        this.hand = h;
        this.size = size;
        this.pieceIcons = arr;
        this.board = new Square[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                board[i][j] = new Square(arr);
            }
        }
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                this.board[i][j].setPiece(boardStartValues[i][j]);
            }
        }
    }

    public Board(int size, Hand h){
        this.hand = h;
        this.size = size;  

        this.board = new Square[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                board[i][j] = new Square();
            }
        }
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                this.board[i][j].setPiece(boardStartValues[i][j]);
            }
        }
    }

    public boolean checkValidMove(Coordinate pieceCoord, Coordinate destCoord){
        int x1 = pieceCoord.getX();
        int y1 = pieceCoord.getY();
        int x2 = destCoord.getX();
        int y2 = destCoord.getY();
        //no movement
        if (pieceCoord == destCoord)
            return false;
        //out of bounds
        if (x1 >= size || x1 < 0)
            return false;
        if (y1 >= size || y1 < 0)
            return false;
        if (x2 >= size || x2 < 0)
            return false;
        if (y2 >= size || y2 < 0)
            return false;
        //same team
        if (board[x1][y1].getPiece() == board[x2][y2].getPiece())
            return false;
        if (board[x1][y1].getPlayer() == board[x2][y2].getPlayer())
            return false;
        return true;
    }

    public void makeMove(Coordinate destCoord){
        if (checkValidMove(curPiece, destCoord)){
            String piece = board[curPiece.getX()][curPiece.getY()].getPiece();
            //String dest = board[destCoord.getX()][destCoord.getY()].getPiece();
            board[destCoord.getX()][destCoord.getY()].setPiece(piece);
            board[curPiece.getX()][curPiece.getY()].setPiece("0");
        }
    }

    public void generateDestinations(){
        destinations.clear();
        int x1 = curPiece.getX();
        int y1 = curPiece.getY();
        if (board[x1][y1].getPlayer() == 2){
            for (int i = 0; i < curCard.getInvMoves().size(); i++){
                Coordinate temp = new Coordinate(x1 + curCard.getMoves().get(i).getX(), y1 + curCard.getMoves().get(i).getY());
                destinations.add(temp);
            }
        }
        else if (board[x1][y1].getPlayer() == 1){
            for (int i = 0; i < curCard.getMoves().size(); i++){
                Coordinate temp = new Coordinate(x1 + curCard.getInvMoves().get(i).getX(), y1 + curCard.getInvMoves().get(i).getY());
                destinations.add(temp);
            }
        }
        else{
            System.out.println("Choose a different spot?");
        }
        //find invalid destinations
        //ArrayList<Coordinate> invalids = new ArrayList<Coordinate>();
        for (int i = 0; i < destinations.size(); i++){
            if(checkValidMove(curPiece, destinations.get(i)) != true){
                destinations.remove(i);
                i = i-1;
            }
        }
        // //remove invalid destinations
        // for (int i = 0; i < invalids.size(); i++){
        //     destinations.remove(invalids.get(i));
        // }
    }

    public boolean isPiece(Coordinate cord){
        if(getBoardVal(cord) == "0"){
            return false;
        }
        return true;
    }

    public ArrayList<Coordinate> getDest(){
        return destinations;
    }
    
    public void chooseDestination(int choice){
        if(destinations.isEmpty() != true)
            makeMove(destinations.get(choice));
    }
    public void setCurCard(Card newCurCard) {
        this.curCard = newCurCard;
    }
/* 
    public void setCurCard(Card curCard) {
        if(hand.whosHand(curCard) == curPlayer) {
            this.curCard = curCard;
            cardSelected = true;
        }
    }
*/
    public void setCurPiece(Coordinate newCurPiece){
        if (curPiece != null){
            Square temp1 = getSquare(curPiece);
            temp1.setSelected(false);
        }
        this.curPiece = newCurPiece;
        Square temp = getSquare(curPiece);
        temp.setSelected(true);
    }

    public Integer getNumDest() {
        return destinations.size();
    }

    public Square getSquare(Coordinate cord){
        return board[cord.getX()][cord.getY()];
    }

    private String getBoardVal(Coordinate cord){
        return board[cord.getX()][cord.getY()].getPiece();
    }

    private int getPlayer(Coordinate cord){
        return board[cord.getX()][cord.getY()].getPlayer();
    }

    /*
    public Icon getPlayer1Icon(){
        return player1Icon;
    }

    public Icon getPlayer2Icon(){
        return player2Icon;
    }
    */
    public void boardButtonPressed(Coordinate cord){
        if(isPiece(cord) && getPlayer(cord) != lastPlayer){ // if the button press is a peice
            if(curPiece == null){ // if there is no current peice 
                setCurPiece(cord); // current peice = the button press
            }  
            else if(getSquare(cord).getPlayer() == getSquare(curPiece).getPlayer()){ // if there already is a current piece only change if a piece from the same team is selected
                setCurPiece(cord);
                for(int i = 0; i < destinations.size(); i++){
                    Square temp = getSquare(destinations.get(i));
                    temp.setPossible(false);
                }
            }
        }
        else if (!isPiece(cord) || getPlayer(cord) == lastPlayer) { // if the square is not a piece and if possible moves have been generated move current peice to the button press (need to allow captures still)
                if (getSquare(cord).getPossible()){
                    lastPlayer = getPlayer(curPiece);
                    makeMove(cord);
                    for(int i = 0; i < destinations.size(); i++){
                        Square temp = getSquare(destinations.get(i));
                        temp.setPossible(false);
                    }
                    getSquare(curPiece).setSelected(false);
                    curPiece = null;
                    hand.swap(curCard);
                    curCard = null;
                    if (checkWin() != 0){
                        System.out.print("player");
                        System.out.print(checkWin());
                        System.out.println(" Wins!");
                        new EndScreen(checkWin());
                    }
                }
            }
        if(curCard != null && curPiece != null){ // if there is a card and a piece selected generate destinations and set the squares at those locations to possible 
            generateDestinations();
            for(int i = 0; i < destinations.size(); i++){
                Square temp = getSquare(destinations.get(i));
                temp.setPossible(true);
            }
        }
    }


    public void cardButtonPressed(int location){
        for(int i = 0; i < destinations.size(); i++){
            Square temp = getSquare(destinations.get(i));
            temp.setPossible(false);
        }
        if(lastPlayer == 2 && location < 2){
            setCurCard(hand.getCardAt(location));
        }
        if(lastPlayer == 1 && location > 1 && location < 4){
            setCurCard(hand.getCardAt(location));
        }
        if(curCard != null && curPiece != null){ // if there is a card and a piece selected generate destinations and set the squares at those locations to possible 
            generateDestinations();
            for(int i = 0; i < destinations.size(); i++){
                Square temp = getSquare(destinations.get(i));
                temp.setPossible(true);
            }
        }
    }

    public int checkWin(){
        boolean found = false;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (board[i][j].getPiece() == "R"){
                    found = true;
                }
            }
        }
        if (found == false){
            return 2;
        }
        found = false;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (board[i][j].getPiece() == "B"){
                    found = true;
                }
            }
        }
        if (found == false){
            return 1;
        }
        if(board[2][0].getPiece() == "R"){
            return 1;
        }
        if(board[2][4].getPiece() == "B"){
            return 2;
        }
        return 0;
    }


    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i < board.length; i++){
            ret+= "\n";
            for (int j = 0; j <board[i].length; j++){
                ret += board[j][i];
                ret += ",";
            }
        }
        return ret;//
    }

    public Square[][] getBoard() {
        return board;
    }

    public Card getCard() {
        return curCard;
    }

    public Boolean isCardSelected() {
        return cardSelected;
    }

    public Boolean isPieceSelected() {
        return pieceSelected;
    }


}
