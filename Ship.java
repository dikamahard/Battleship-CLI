public class Ship {
    private int size;
    private char direction; // v or h
    private Coordinate coord;
    public static final char[] TYPE = {'D', 'C', 'B', 'A'};  // size2, size3, size4, size5. For printing the ship looks in board

    public Ship(int size, int x, int y) {
        this.size = size;
        this.coord = new Coordinate(x, y); // position on board
    }

    public Ship(int size, int x, int y, char direction) {
        this.size = size;
        this.coord = new Coordinate(x, y); // position on board
        this.direction = direction;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public char getType() {
        return Ship.TYPE[this.size - 2];
    }

    public char getDirection() {
        return direction;
    }

    public int getCoordinateX(){
        return this.coord.getX();
    }

    public int getCoordinateY(){
        return this.coord.getY();
    }
}
