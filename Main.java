
public class Main{
    
    public static void main(String[] args) {
        // for(int i = 0; i<10; i++){
        //     System.out.print(String.format("%-5s%-5s|", "|", ' '));
        // }
        // System.out.print("\n");
        // for(int i = 0; i<11; i++){
        //     System.out.print("==========");
        // }
        // System.out.print("\n");
        // for(int i = 0; i<10; i++){
        //     System.out.print(String.format("%-5s%-5s|", "|", '+'));
        // }
        // System.out.print("\n");
        // System.out.print(String.format("%-5s%-5d|", "|", 7));
        Board board = new Board(10,10);
        Ship kapal = new Ship(2, 2, 3 );  // x=2 y=3
        Ship kapal2 = new Ship(3, 9, 2 );  //2,3 should be error?? whats wrong.
        kapal.setDirection('h');
        kapal2.setDirection('v');

        Ship[] ships = {kapal, kapal2};
        board.setOnBoardShip(ships);
        //board.setOnBoardShip(new Ship[]{kapal2});
        board.drawBoard();
        
    }
}