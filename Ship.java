public class Ship {
    private int size;
    private char direction; // v or h
    private Coordinate coord;
    private static final String[] TYPE = {"D", "C", "B", "A"};  // size2, size3, size4, size5. For printing the ship looks in board
    private class Coordinate{
        private int x;
        private int y;

        private Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    };

    public Ship(int size, int x, int y) {
        this.size = size;
        this.coord = new Coordinate(x, y); // position on board
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

    public String getType() {
        return Ship.TYPE[this.size - 2];
    }

    public char getDirection() {
        return direction;
    }

    public int geCoordinateX(){
        return this.coord.x;
    }

    public int geCoordinateY(){
        return this.coord.y;
    }
}
