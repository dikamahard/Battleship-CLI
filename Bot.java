import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Bot {
    Board board;
    private List<Coordinate> availableCoord = new ArrayList<Coordinate>();

    public Bot(Board board) {
        this.board = board;
        this.generateCoord();
    }

    public void generateShip(){
        int size = 2;
        while (this.board.getOnShip().size() != 4) {

            Coordinate initCoord = getRandomCoord();
            int x = initCoord.getX();
            int y = initCoord.getY();
            Coordinate[] shipCoordinateH = this.board.constructShip(size, 'h', x, y);
            Coordinate[] shipCoordinateV = this.board.constructShip(size, 'v', x, y);

            if (checkCoordinateIsSafe(shipCoordinateH)) { // if ship h !collide
                this.board.setOnBoardShip(new Ship(size, x, y, 'h')); 
                // delete coord from availableCoord
                removeCoordsFromAvailable(shipCoordinateV);
                size++;
            }else if (checkCoordinateIsSafe(shipCoordinateV)) {   // if ship v !collide
                this.board.setOnBoardShip(new Ship(size, x, y, 'v'));
                removeCoordsFromAvailable(shipCoordinateH);
                size++;
            }
        }
    }

    private boolean checkCoordinateIsSafe(Coordinate[] shipCoordinates){
        for (Coordinate coord : shipCoordinates) {
            if (coord.getX() > 10 || coord.getY() > 10) {
                // array out of bound
                //System.err.println("out");
                return false;
            }

            if (this.board.getGrid()[coord.getX()-1][coord.getY()-1] != '\0') {
                // collision detected
                //System.err.println("col");
                return false;
            }
        }

        return true;
    }

    private Coordinate getRandomCoord() {
        Random rng = new Random();
        int index = rng.nextInt(availableCoord.size());
        return this.availableCoord.get(index);
        // then delete the coord from array
    }

    private void generateCoord() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.availableCoord.add(new Coordinate(i+1, j+1));
            }
        }
    }

    private void removeCoordsFromAvailable(Coordinate[] shipCoordinates) {
        for (Coordinate coord : shipCoordinates) {
            this.availableCoord.remove(coord);
        }
    }

}
