package edu.gonzaga;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import edu.gonzaga.CardDeck.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Hand (int size){
        Random random = new Random();
        int j = 0; 
        ArrayList<Integer> temp = new ArrayList<Integer>();
        while (j < size){
            int x = random.nextInt(16);
            if(temp.contains(x) != true){
                temp.add(x);
                j++;
            }
        }
        for (int i = 0; i < size; i++){
            switch(temp.get(i)) {
                case 0:
                    cards.add(new TigerCard("Tiger"));
                    break;
                case 1:
                    cards.add(new CrabCard("Crab"));
                    break;
                case 2:
                    cards.add(new MonkeyCard("Monkey"));
                    break;
                case 3:
                    cards.add(new CraneCard("Crane"));
                    break;
                case 4:
                    cards.add(new DragonCard("Dragon"));
                    break;
                case 5:
                    cards.add(new ElephantCard("Elephant"));
                    break;
                case 6:
                    cards.add(new MantisCard("Mantis"));
                    break;
                case 7:
                    cards.add(new BoarCard("Boar"));
                    break;
                case 8:
                    cards.add(new FrogCard("Frog"));
                    break;
                case 9:
                    cards.add(new GooseCard("Goose"));
                    break;
                case 10:
                    cards.add(new HorseCard("Horse"));
                    break;
                case 11:
                    cards.add(new EelCard("Eel"));
                    break;
                case 12:
                    cards.add(new RabbitCard("Rabbit"));
                    break;
                case 13:
                    cards.add(new RoosterCard("Rooster"));
                    break;
                case 14:
                    cards.add(new OxCard("Ox"));
                    break;
                case 15:
                    cards.add(new CobraCard("Cobra"));
                    break;
            }

        }
    }

    public void swap(Card playerCard){
        int location = -1;
        for(int i = 0; i < cards.size() - 1; i++){
            if (playerCard == cards.get(i)){
                location = i;
            }
        }
        Card oldCard = cards.get(location);
        cards.set(location, cards.get(cards.size() - 1));
        cards.set(cards.size() - 1, oldCard);
        Card newCard = cards.get(location);
        switch(location){
            case 0:
                this.pcs.firePropertyChange("spot0", oldCard, newCard);
                this.pcs.firePropertyChange("inter", newCard, oldCard);
                break;
            case 1:
                this.pcs.firePropertyChange("spot1", oldCard, newCard);
                this.pcs.firePropertyChange("inter", newCard, oldCard);
                break;
            case 2:
                this.pcs.firePropertyChange("spot2", oldCard, newCard);
                this.pcs.firePropertyChange("inter", newCard, oldCard);
                break;
            case 3:
                this.pcs.firePropertyChange("spot3", oldCard, newCard);
                this.pcs.firePropertyChange("inter", newCard, oldCard);
                break;
        }
    }
    public Card getCardAt(int location){
        return cards.get(location);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        String ret = "";
        ret += this.cards.toString();
        ret += "\n";
        return ret;
    }

    public String[] getNames() {
        String[] names = new String[cards.size()];
        for(Integer i = 0; i < cards.size(); i++)
            names[i] = cards.get(i).getName();
        return names;
    }

    public Card getCardByName(String name) {
        for(int i = 0; i < cards.size(); i++)
            if(name == cards.get(i).getName())
                return cards.get(i);
        //doesnt like me otherwise
        return cards.get(0);
    }

}