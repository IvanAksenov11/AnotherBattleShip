package battleship;

public class Cruiser extends Ship {

    @Override
    public String getShipType() {
        return "cruiser";
    }

    Cruiser(){
        length = 3;
        for (int i = 0; i< 4; i++)
            hit[i] = false;
    }
}
