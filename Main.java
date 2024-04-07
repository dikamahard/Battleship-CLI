import java.util.Scanner;

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

        /* 
        Board board = new Board(10,10);
        Ship kapal = new Ship(2, 3, 3, 'h');  // x=2 y=3
        Ship kapal2 = new Ship(3, 10, 8, 'v');  //2,3 should be error?? whats wrong.
        Ship kapal3 = new Ship(4, 1, 1, 'v');
        Ship kapal4 = new Ship(5, 1, 10, 'h');

        Ship[] ships = {kapal, kapal2, kapal3, kapal4};
        board.setOnBoardShip(ships);


        //board.setOnBoardShip(new Ship[]{kapal2});
        //board.dropBomb(10, 11);

        Scanner input = new Scanner(System.in);


        while (true) {
            board.drawBoard();
            int coord = input.nextInt();
            int x = Integer.parseInt(Integer.toString(coord).substring(0, 1));
            int y = Integer.parseInt(Integer.toString(coord).substring(1));
            board.dropBomb(x, y);
        }*/
/* 
        Scanner input = new Scanner(System.in);
        Bot bot = new Bot(new Board(10, 10));
        bot.generateShip();
        while (!bot.board.isDestroyed()) {
            
            bot.board.drawBoard();
            bot.board.drawInvisibleBoard();
            int coord = input.nextInt();
            int x = Integer.parseInt(Integer.toString(coord).substring(0, 1));
            int y = Integer.parseInt(Integer.toString(coord).substring(1));
            bot.board.dropBomb(x, y);
        }

        System.out.println("CONGRATS");*/

        Scanner input = new Scanner(System.in);
        Bot bot = new Bot(new Board(10, 10));
        bot.generateShip();
        GameFunc.titleBanner();
        while (!bot.board.isDestroyed()) {
            //bot.board.drawBoard();
            bot.board.drawInvisibleBoard();

            System.out.println(">> Type the chosen grid to drop the bomb (ex: a1)");
            System.out.print(">> ");
            String grid = input.nextLine();
            Coordinate coord = GameFunc.coordinateConverter(grid);
            bot.board.dropBomb(coord.getX(), coord.getY());
        }
        GameFunc.congrats();

    }
}