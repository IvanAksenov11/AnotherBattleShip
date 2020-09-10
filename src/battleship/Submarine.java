package battleship;

public class Submarine extends Ship{


    @Override
    public String getShipType() {
        return "submarine";
    }

    Submarine(){
        length = 1;
        for (int i = 0; i< 4; i++)
            hit[i] = false;
    }
}
