
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
        Ship kapal2 = new Ship(3, 3, 2 );
        kapal.setDirection('v');
        kapal2.setDirection('h');

        Ship[] ships = {kapal, kapal2};

        board.setOnBoardShip(kapal);

        board.drawBoard();
        
    }
}