package battleship;

public class EmptySea extends Ship {

    EmptySea(){
        length = 1;
    }

    @Override
    public boolean shootAt(int row, int column){
        return  false;
    }

    @Override
    public boolean isSunk(){
        return false;
    }

    @Override
    public String getShipType() {
        return null;
    }

    @Override
    public String toString(){
        if(hit[0])
            return "-";
        else
            return ".";
    }
}
