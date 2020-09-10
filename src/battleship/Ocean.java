package battleship;

import static java.lang.System.out;
import java.util.Random;

public class Ocean {
    static Random rnd = new Random();
    Ship[][] ships = new Ship[10][10];
    int shotsFired = 0;
    int hitCount = 0;
    int shipsSunk = 0;

    public Ocean() {
        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i].length; j++)
                ships[i][j] = new EmptySea();
        }
    }

    public int getShotsFired(){ return shotsFired; }
    public int getHitCount() { return hitCount; }
    public int getShipsSunk() {return shipsSunk; }
    public Ship[][] getShipsArray(){
        return ships;
    }

    public boolean isGameOver(){
        return shipsSunk == 10;
    }

    boolean isOccupied(int row, int column) {
        for (int i = row - 1; i <= row + 1; i++){
            if (i < 0 || i > 9)
                continue;
            for (int j = column - 1; j <= column + 1; j++){
                if(j<0 || j>9)
                    continue;
                if (ships[i][j].getShipType() == null) {
                    continue;
                }
                return true;
            }
        }
        return  false;
    }

    private void placeShipRandomly(Ship ship) {
        while (true) {
            try {
                ship.placeShipAt(rnd.nextInt(10), rnd.nextInt(10), rnd.nextBoolean(), this);
                break;
            } catch (IllegalArgumentException ignored) { }
        }
    }

    public void placeAllShipsRandomly(){
        placeShipRandomly(new Battleship());

        for (int i = 0; i < 2; i++){
            placeShipRandomly(new Cruiser());
        }

        for(int i = 0; i < 3; i++){
            placeShipRandomly(new Destroyer());
        }

        for (int i = 0; i < 4; i++){
            placeShipRandomly(new Submarine());
        }
    }



    public boolean shootAt(int row, int column){
        shotsFired++;
        if (ships[row][column].getShipType() == null  || ships[row][column].isSunk()) {
            if(ships[row][column].getShipType() == null)
                ships[row][column].hit[0] = true;
            return false;
        }
        else {
            if (ships[row][column].isHorizontal()){
                ships[row][column].hit[column - ships[row][column].getBowColumn()] = true;
                hitCount++;
            }
            else {
                ships[row][column].hit[row - ships[row][column].getBowRow()] = true;
                hitCount++;
            }
            if (ships[row][column].isSunk())
                shipsSunk++;
            return true;
        }
    }

    public void print() {
         out.print(" ");
         for (int i = 0; i < 10; i++)
             out.print(i);
         out.println();
         for (int i = 0; i < 10; i++) {
             out.print(i);
             for (int j = 0; j < 10; j++) {
                 out.print(ships[i][j].toString());
             }
             out.println();
         }
    }

    public void printInfo(){
        out.println("number of shots: " + shotsFired);
        out.println("number of hits: " + hitCount);
        out.println("number of ships sunk: " + shipsSunk);
    }
}
