package edu.gonzaga;

public class Coordinate implements Comparable<Coordinate> {
    int [] coords = new int [2];
    String compair;

    public Coordinate(int x, int y){
        coords[0] = x;
        coords[1] = y;
        compair += x;
        compair += y;
    }

    public int getX(){
        return coords[0];
    }

    public int getY(){
        return coords[1];
    }

    @Override
    public String toString() {
        String ret = "(";
        ret += this.coords[0];
        ret += ",";
        ret += this.coords[1];
        ret += ")";
        return ret;
    }

    @Override
    public int compareTo(Coordinate otherCord) {
        return this.toString().compareTo(otherCord.toString());
    }
}
