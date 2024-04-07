import java.util.ArrayList;
import java.util.List;


public class Board{

    // Rows and Columns
    private int rows;
    private int cols;
    private char[][] grid; //for the ship coordinate
    private Ship[] onBoardShip; // OUTDATED, use below
    List<Ship> onShip = new ArrayList<Ship>();

    public Board(int rows, int cols){
        this.grid = new char[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public Ship[] getOnBoardShip() {
        return onBoardShip;
    }

    public List<Ship> getOnShip() {
        return onShip;
    }

    public char[][] getGrid() {
        return grid;
    }

    private void drawCell(char c){    // input params?
        // System.out.print("==========\n");
        // System.out.println(String.format("%-5s%-5s|", "|", ' '));   // can be changed to draw input param
        // System.out.print("==========");
        System.out.print(String.format("[%c]", c));
    
    }

    // drawboard algorithm
    // read data of ship coordinate and bomb coordinate on board, draw that coordinate accordingly
    public void drawBoard(){
        char c;
        System.out.print("    ");
        for (c = 'a'; c <= 'j'; c++) {
            System.out.print(String.format("%s  ", c));
        }
        System.out.println();

        // ship data
        //int extend;
        //grid[2-1][3-1] = 'x'; //DEBUG    
        for (int i = 0; i < this.rows; i++) {
            System.out.print(String.format("%2d|", i+1));
            for (int j = 0; j < this.cols; j++) {
                // if there is a ship or bomb(by coordinate), draw accordingly *get data from grid
                //if (onBoardShip[0].geCoordinateX() == j+1 && onBoardShip[0].geCoordinateY() == i+1) {
                if (this.grid[j][i] != '\0') {
                    drawCell(this.grid[j][i]);
                //}else if (onBoardShip.getDirection() == 'v') {
                    // draw ship vertically
                //}else if (onBoardShip.getDirection() == 'h') {
                    // draw horizontal
                }else { 
                    drawCell(' ');
                }
                
                
            }
            System.out.println("|");
            System.out.println("  +==============================+");
        }
    }

    public void drawInvisibleBoard(){
        char c;
        System.out.print("    ");
        for (c = 'a'; c <= 'j'; c++) {
            System.out.print(String.format("%s  ", c));
        }
        System.out.println();
 
        for (int i = 0; i < this.rows; i++) {
            System.out.print(String.format("%2d|", i+1));
            for (int j = 0; j < this.cols; j++) {
                // if there is a ship or bomb(by coordinate), draw accordingly *get data from grid
                //if (onBoardShip[0].geCoordinateX() == j+1 && onBoardShip[0].geCoordinateY() == i+1) {
                
                if (this.grid[j][i] == Ship.TYPE[0] || this.grid[j][i] == Ship.TYPE[1] || this.grid[j][i] == Ship.TYPE[2] || this.grid[j][i] == Ship.TYPE[3]) {     //check if grid is occupode by ship, then invisible
                    drawCell(' ');
                }else if (this.grid[j][i] != '\0') {
                    drawCell(this.grid[j][i]);
                }else { 
                    drawCell(' ');
                }            
            }
            System.out.println("|");
            System.out.println("  +==============================+");
        }
    }
    private void update(int x, int y, char c){      // fill board with ship? or with bomb 
        //draw cell?
        // need data of ship and bomb on board 
        //ORRR this just change value on the 2d array grid, the drawing will be handle by drawBoard
        this.grid[x][y] = c;
    }


    //TODO: Refactor into using list and only input 1 by 1 with collide check outside
    /* 
    public void setOnBoardShip(Ship[] shipList) {
        //this.onBoardShip = shipList;
        // set all data ship to grid
        for (Ship ship : shipList) {

            Coordinate[] shipCoordinates = constructShip(
                ship.getSize(), 
                ship.getDirection(), 
                ship.getCoordinateX(), 
                ship.getCoordinateY()
            );

            if (checkNoCollideShip(ship)) {
                for (Coordinate coord : shipCoordinates) {
                    this.update(coord.getX()-1, coord.getY()-1, ship.getType());
                }
            }else {
                System.out.println("ERROR SHIP COLLIDED OR OUT OF BOUND");
            }
           
        }
        //this.update(rows, cols, 0);
    }*/

    // refactor result, check collide on the outside
    public void setOnBoardShip(Ship ship) {

        Coordinate[] shipCoordinate = constructShip(
            ship.getSize(), 
            ship.getDirection(), 
            ship.getCoordinateX(), 
            ship.getCoordinateY()
        );
        // add ship to onboardship list and grid
        this.onShip.add(ship);
        for (Coordinate coord : shipCoordinate) {
            this.update(coord.getX()-1, coord.getY()-1, ship.getType());
        }

    }

    //func to check if ship placement collide and 
    // and array out of bound?
    public boolean checkNoCollideShip(Ship newShip) {        
        // get newly build ship coord
        int x = newShip.getCoordinateX();
        int y = newShip.getCoordinateY();
        int size = newShip.getSize();
        char direction = newShip.getDirection();

        Coordinate[] newShipCoord = constructShip(size, direction, x, y);
        
        // compare new with current
        for (Coordinate coord : newShipCoord) {
            if (coord.getX() > 10 || coord.getY() > 10) {
                // array out of bound
                System.err.println("out");
                return false;
            }

            if (this.grid[coord.getX()-1][coord.getY()-1] != '\0') {
                // collision detected
                System.err.println("col");
                return false;
            }
        }

        return true;
    }

    //func buildship
    public Coordinate[] constructShip(int size, char direction, int x, int y) {
        Coordinate[] resulCoordinates = new Coordinate[size];
        switch (direction) {
            case 'v':
                int i = 0;
                while (i < size) {
                    resulCoordinates[i] = new Coordinate(x, y);
                    y++;
                    i++;
                }
                break;
            case 'h':
                int it = 0;
                while (it < size) {
                    resulCoordinates[it] = new Coordinate(x, y);
                    x++;
                    it++;
                }
                break;
            default:
                break;
        }

        return resulCoordinates;
    }


    //func dropBomb
    public void dropBomb(int coordX, int coordY) {
        int x = coordX-1;
        int y = coordY-1;
        // check array bound


        // drop bomb (if there is ship print * else X)
        // error handling bombing the same area OR error handling outside this func?
        if (this.grid[x][y] == '\0') {
            update(x, y, 'X');
            // return true?
        }else if (this.grid[x][y] == 'X' || this.grid[x][y] == '*') {// should be outside
            System.err.println("Grid Already Bombed");
            //return false?
        }else {
            update(x, y, '*');
            // return true?
        }
    }

    // TODO: win con
    public boolean isWin() {
        int toDestroy = 0;
        int destroyed = 0;
        for (Ship ship : onShip) {
            toDestroy += ship.getSize();
        }

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {  
                if (this.grid[j][i] == '*') {
                    destroyed++;
                }              
            }
        }

        if(destroyed == toDestroy){
            return true;
        }

        return false;
    }


}
