import java.util.Scanner;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);
    private Adventure adventure;

    public UserInterface (Adventure adventure){
        this.adventure = adventure;
    }
    
    public char startUp(Room currentRoom){
        char playerChoice = 'c';
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
                            lookAround(currentRoom);
                            playerChoice = 'n';
                        }
                        else {
                            System.out.println("You cannot go that way");
                        }
                    }
                    case "east" -> {
                        if (currentRoom.eHasRoom()) {
                            System.out.println("going east");
                            lookAround(currentRoom);
                            playerChoice = 'e';
                        }
                        else {
                            System.out.println("You cannot go that way");
                        }
                    }
                    case "west" -> {
                        if (currentRoom.wHasRoom()) {
                            System.out.println("going west");
                            lookAround(currentRoom);
                            playerChoice = 'w';
                        }
                        else {
                            System.out.println("You cannot go that way");
                        }
                    }
                    case "south" -> {
                        if (currentRoom.sHasRoom()) {
                            System.out.println("going south");
                            lookAround(currentRoom);
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
        String[] roomDetails = currentRoom.lookAround();
        System.out.println("You are in " + roomDetails[0]);
        System.out.println(roomDetails[1]);
    }
}
