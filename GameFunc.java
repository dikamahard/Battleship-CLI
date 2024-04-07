public final class GameFunc {
    
    public static Coordinate coordinateConverter(String grid){
        String alphabet = "";
        String number = "";

        for (char c : grid.toCharArray()) {
            if (Character.isLetter(c)) {
                // If character is an alphabet, add it to the alphabet variable
                alphabet += c;
            } else if (Character.isDigit(c)) {
                // If character is a digit, add it to the number variable
                number += c;
            }
        }

        //convert the alphabet to int x amd number to int y
        int x = Character.toLowerCase(alphabet.charAt(0)) - 'a' + 1;
        int y = Integer.parseInt(number);
        return new Coordinate(x, y);
    }
    
    public static void titleBanner(){
    System.out.println("______________________________________________________________________");  
    System.out.println(" ____       _   _   _           _     _              ____ _     ___");
    System.out.println("| __ ) __ _| |_| |_| | ___  ___| |__ (_)_ __        / ___| |   |_ _|"); 
    System.out.println("|  _ \\/ _` | __| __| |/ _ \\/ __| '_ \\| | '_ \\ _____| |   | |    | |"); 
    System.out.println("| |_)| (_| | |_| |_| |  __/\\__ \\ | | | | |_) |_____| |___| |___ | |"); 
    System.out.println("|____/\\__,_|\\__|\\__|_|\\___||___/_| |_|_| .__/       \\____|_____|___|");
    System.out.println("                                        |_|                          ");
    System.out.println("______________________________________________________________________");  
    System.out.println();
    }

    public static void congrats(){
        System.out.println(" /$$     /$$                        /$$      /$$ /$$$$$$ /$$   /$$       /$$ /$$ /$$");
        System.out.println("|  $$   /$$/                       | $$  /$ | $$|_  $$_/| $$$ | $$      | $$| $$| $$");
        System.out.println(" \\  $$ /$$//$$$$$$  /$$   /$$      | $$ /$$$| $$  | $$  | $$$$| $$      | $$| $$| $$");
        System.out.println("  \\  $$$$//$$__  $$| $$  | $$      | $$/$$ $$ $$  | $$  | $$ $$ $$      | $$| $$| $$");
        System.out.println("   \\  $$/| $$  \\ $$| $$  | $$      | $$$$_  $$$$  | $$  | $$  $$$$      |__/|__/|__/");
        System.out.println("    | $$ | $$  | $$| $$  | $$      | $$$/ \\  $$$  | $$  | $$\\  $$$");
        System.out.println("    | $$ |  $$$$$$/|  $$$$$$/      | $$/   \\  $$ /$$$$$$| $$ \\  $$       /$$ /$$ /$$");
        System.out.println("    |__/  \\______/  \\______/       |__/     \\__/|______/|__/  \\__/      |__/|__/|__/");
    }

    public static void loose(){
        System.out.println("Y88b   d88P                     888");
        System.out.println(" Y88b d88P                      888");
        System.out.println("  Y88o88P                       888");
        System.out.println("   Y888P  .d88b.  888  888      888      .d88b.   .d88b.  .d8888b   .d88b.");
        System.out.println("    888  d88\"\"88b 888  888      888     d88\"\"88b d88\"\"88b 88K      d8P  Y8b");
        System.out.println("    888  888  888 888  888      888     888  888 888  888 \"Y8888b. 88888888");
        System.out.println("    888  Y88..88P Y88b 888      888     Y88..88P Y88..88P      X88 Y8b.");
        System.out.println("    888   \"Y88P\"   \"Y88888      88888888 \"Y88P\"   \"Y88P\"   88888P'  \"Y8888\"");
    }
                                                                                     
                                                                                     
}
