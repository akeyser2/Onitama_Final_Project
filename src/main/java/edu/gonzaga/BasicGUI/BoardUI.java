package edu.gonzaga.BasicGUI;

import edu.gonzaga.CardDeck.Card;
import edu.gonzaga.*;
import javax.swing.*;
import java.awt.*;

public class BoardUI {
    Hand hand;
    Board board;
    Boolean isPieceSelected = false;
    Boolean isCardSelected = false;
    Integer playerTurn = 1;

  
    JFrame mainWindowFrame;
    JPanel upperCardPanel;
    JPanel lowerCardPanel;
    JPanel intermediateCardPanel;
    JPanel boardPanel;


    JButton[][] boardButtons;
    CardButton[] cardButtons;
    ImageIcon[] pieceIcons;



    public BoardUI(ImageIcon[] arr){
        hand = new Hand(5);
        board = new Board(5, hand, arr);
        pieceIcons = arr;
        UIManager.put("Button.showMnemonics", Boolean.FALSE);
    }


    // GUI Setup
    void setupGUI() {

        // Image backgroundImage = new ImageIcon("GameArt/potentialBackgroundWood.png").getImage();
        // BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        // mainWindowFrame.setContentPane(backgroundPanel);


        //this.mainWindowFrame = new JFrame("Simple GUI Onitama");

        this.mainWindowFrame = new GameFrame();
        this.mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainWindowFrame.setLayout(null);

        this.boardPanel = new JPanel();
        this.upperCardPanel = new JPanel();
        this.intermediateCardPanel = new JPanel();
        this.lowerCardPanel = new JPanel();



        //this.boardPanel = genBoardPanel();
        genCardButtons();
        this.boardPanel = genBoardPanel();
        boardPanel.setBounds(525, 145, 500, 500);
        this.lowerCardPanel = genBottomCardPanel();
        lowerCardPanel.setBounds(475, 650, 600, 135);
        this.intermediateCardPanel.add(cardButtons[4]);
        intermediateCardPanel.setBounds(50, 315, 300, 180);
        intermediateCardPanel.setEnabled(false);

        // cardButtons[4].setClickable(false);
        // cardButtons[4].setFocusable(false);

        cardButtons[4].setFocusable(false);
        //cardButtons[4].setEnabled(false);
        
        intermediateCardPanel.setBorder(null);
        intermediateCardPanel.setOpaque(false);

        this.upperCardPanel = genTopCardPanel();
        upperCardPanel.setBounds(475, 5, 600, 135);

        mainWindowFrame.add(boardPanel);
        mainWindowFrame.add(upperCardPanel);
        mainWindowFrame.add(lowerCardPanel);
        mainWindowFrame.add(intermediateCardPanel);
        
    }


    // Makes the board
    private JPanel genBoardPanel() {

        JPanel newBoardPanel = new JPanel();
        //newBoardPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        // making array of buttons
        this.boardButtons = new BoardButton[5][5];
        for(int i=0; i < boardButtons.length; i++)
        {
            for(int j=0; j < boardButtons.length; j++)
            {
                Coordinate temp = new Coordinate(i, j);
                boardButtons[i][j] = new BoardButton(board, temp, pieceIcons);
                boardButtons[i][j].setFocusable(false);
                boardButtons[i][j].setFocusPainted(false);
                boardButtons[i][j].setBorderPainted(false);
            }
        }


        boardPanel.setLayout(new GridLayout(5,5));
        for(Integer i=0; i < boardButtons.length; i++)
            for(Integer j=0; j < boardButtons.length; j++)
                newBoardPanel.add(boardButtons[j][i]);

        // Tell panel to make a grid (like a spreadsheet) layout n rows, 2 columns
        newBoardPanel.setLayout(new GridLayout(5, 5));    // Making it pretty
        return newBoardPanel;

    }
    

    // //this is a temp way to display cards
    private void genCardButtons() {
        // making array of buttons
        this.cardButtons = new CardButton[5];
        for(Integer i=0; i < cardButtons.length; i++)
        {
            cardButtons[i] = new CardButton(board, hand, i);
            cardButtons[i].setFocusable(false);
        }

    }

    private JPanel genBottomCardPanel(){
        JPanel newCardPanel = new JPanel();
        newCardPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        newCardPanel.setBorder(null);
        newCardPanel.setOpaque(false);


        for(int i=0; i < 2; i++)
        {
            //cardButtons[i].setOpaque(false);
            newCardPanel.add(cardButtons[i]);
        }

        //Tell panel to make a grid (like a spreadsheet) layout n rows, 2 columns
        newCardPanel.setLayout(new GridLayout(1, 2));    // Making it pretty
        return newCardPanel;
    }

    private JPanel genTopCardPanel(){
        JPanel newCardPanel = new JPanel();
        newCardPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        newCardPanel.setBorder(null);
        newCardPanel.setOpaque(false);


        for(int i=2; i < 4; i++)
            newCardPanel.add(cardButtons[i]);

        //Tell panel to make a grid (like a spreadsheet) layout n rows, 2 columns
        newCardPanel.setLayout(new GridLayout(1, 2));    // Making it pretty
        return newCardPanel;
    }

    //runs GUI
    void runGUI() {
        System.out.println("Starting GUI app");
        setupGUI();

        // Run the main window - begins GUI activity
        mainWindowFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainWindowFrame.setVisible(true);
        System.out.println("Done in GUI app");
    }
    

}