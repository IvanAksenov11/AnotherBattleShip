package battleship;

public abstract class Ship {

    private int bowRow;
    private int bowColumn;
    protected int length;
    private boolean horizontal;
    protected boolean [] hit = new boolean[4];

    public int getLength(){
        return length;
    }
    public abstract String getShipType();

    public int getBowRow() { return bowRow; }
    public int getBowColumn() { return bowColumn; }
    public boolean isHorizontal() { return horizontal; }

    public void setBowRow (int row) { bowRow = row; }
    public void setBowColumn (int bowColumn) { this.bowColumn = bowColumn; }
    public void setHorizontal (boolean horizontal) { this.horizontal = horizontal; }

    public boolean okToPlaceShipAt (int row, int column, boolean horizontal, Ocean ocean){
        if (horizontal) {
            if(column + length - 1 > 9){
                return false;
            }
            else {
                for (int i = column; i < column + length; i++){
                    if(ocean.isOccupied(row, i))
                        return false;
                }
            }
        } else {
            if(row + length - 1 > 9)
                return false;
            else {
                for (int i = row; i < row + length; i++) {
                    if (ocean.isOccupied(i, column))
                        return false;
                }
            }
        }
        return true;
    }

    public void placeShipAt (int row, int column, boolean horizontal, Ocean ocean) throws IllegalArgumentException {
        if(okToPlaceShipAt(row, column, horizontal, ocean)){
            if (horizontal){
                for (int i = column; i < column + this.length; i++){
                    ocean.ships[row][i] = this;
                }
            }
            else{
                for (int i = row; i< row + length; i++) {
                    ocean.ships[i][column] = this;
                }
            }
            setBowRow(row);
            setBowColumn(column);
            setHorizontal(horizontal);
        }
        else throw new IllegalArgumentException();
    }

    public boolean shootAt (int row, int column){
        if(getBowColumn() == column && bowRow <= row && row < bowRow + length){
            hit[row - bowRow] = true;
            return true;
        }
        if (getBowRow() == row && bowColumn <= column && column< bowRow + length){
            hit[column - bowColumn] = true;
            return true;
        }
        return false;
    }

    public boolean isSunk(){
        for (int i = 0; i < length; i++ ){
            if (hit[i]) {
            }
            else return false;
        }
        return true;
    }

    private int counter = 0;

    @Override
    public String toString() {
        if (isSunk()){
            return "x";
        } else{
            if (hit[counter++ % length]){
                return "S";
            }
            else return ".";
        }
    }
}
