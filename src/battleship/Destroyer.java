package battleship;

public class Destroyer extends Ship {


    @Override
    public String getShipType() {
        return "destroyer";
    }

    Destroyer(){
        length = 2;
        for (int i = 0; i< 4; i++)
            hit[i] = false;
    }
}
