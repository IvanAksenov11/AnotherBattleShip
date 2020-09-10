package battleship;

public class Battleship extends Ship {
    @Override
    public String getShipType() {
        return "battleship";
    }

    Battleship(){
        length = 4;
        for (int i = 0; i< 4; i++)
            hit[i] = false;
    }
}
