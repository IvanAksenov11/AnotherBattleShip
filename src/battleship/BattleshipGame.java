package battleship;

import java.util.Scanner;
import static java.lang.System.out;

public class BattleshipGame {
    public static void main(String[] args){

        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();

        Ship[][] ships = ocean.getShipsArray();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(ships[i][j].getShipType() != null){
                    out.println(i + " " + j + " " + ships[i][j].getShipType());
                }
            }
        }

        Scanner scanner = new Scanner(System.in);

        out.println("Let's play Battleship game\nTwo take a shot input two numbers from 1 to 10 (coordinates of your shot)");

        while (!ocean.isGameOver()){
            ocean.print();
            ocean.printInfo();
            String[] coordinates = scanner.nextLine().split(" ");
            ocean.shootAt(Integer.parseInt(coordinates[0]) - 1, Integer.parseInt(coordinates[1]) - 1);
        }

        out.println("Congratulations!!!");

        ocean.print();
        ocean.printInfo();

    }
}
