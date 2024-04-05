public class Board{

    // Rows and Columns
    private int rows;
    private int cols;
    private char[][] grid; //for the ship coordinate
    private Ship onBoardShip; // will be an array

    public Board(int rows, int cols){
        this.grid = new char[rows][cols];
        this.rows = rows;
        this.cols = cols;
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

        for (int i = 0; i < this.rows; i++) {
            System.out.print(String.format("%2d|", i+1));
            for (int j = 0; j < this.cols; j++) {
                // if there is a ship or bomb(by coordinate), draw accordingly *get data from grid
                if (onBoardShip.geCoordinateX() == j+1 && onBoardShip.geCoordinateY() == i+1) {
                    drawCell('S');
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

    private void update(int x, int y, char c){      // fill board with ship? or with bomb 
        //draw cell?
        // need data of ship and bomb on board 
        //ORRR this just change value on the 2d array grid, the drawing will be handle by drawBoard
        //this.grid[x][y] = c;
    }

    public void setOnBoardShip(Ship listShip) {
        this.onBoardShip = listShip;
        //this.update(rows, cols, 0);
    }


}
