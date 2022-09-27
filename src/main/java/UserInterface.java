import java.util.Scanner;

public class UserInterface {
    public char startUp(Room currentRoom){
        char playerChoice = 'c';
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("Enter next command");
        input = sc.nextLine();
        String[] wordInput = input.split(" ", 3);
        switch (wordInput[0].toLowerCase()){
            case "go" -> {
                String dir;
                if (wordInput.length > 1){
                    dir = wordInput[1];
                }
                else {
                    dir = "invalid";
                }
                switch (dir){
                    case "north" -> {
                        if (currentRoom.nHasRoom()) {
                            System.out.println("going north");
                            playerChoice = 'n';
                        }
                        else {
                            System.out.println("You cannot go that way");
                        }
                    }
                    case "east" -> {
                        if (currentRoom.eHasRoom()) {
                            System.out.println("going east");
                            playerChoice = 'e';
                        }
                        else {
                            System.out.println("You cannot go that way");
                        }
                    }
                    case "west" -> {
                        if (currentRoom.wHasRoom()) {
                            System.out.println("going west");
                            playerChoice = 'w';
                        }
                        else {
                            System.out.println("You cannot go that way");
                        }
                    }
                    case "south" -> {
                        if (currentRoom.sHasRoom()) {
                            System.out.println("going south");
                            playerChoice = 's';
                        }
                        else {
                            System.out.println("You cannot go that way");
                        }
                    }
                    default -> System.out.println("unknown direction");
                }
            }
            case "exit" -> {
                playerChoice = 'x';
                System.out.println("exiting");
            }
            case "help" -> System.out.println("helping");
            case "look" -> lookAround(currentRoom);
            default -> System.out.println("X. Type \"help\" for help");
        }
        return playerChoice;
    }

    private void lookAround(Room currentRoom){
        System.out.println("looking around");
        String[] roomDetails = currentRoom.lookAround();
        for (String detail: roomDetails){
            System.out.println(detail);
        }
    }
}
