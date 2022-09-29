import java.util.Scanner;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);

    public String startUp(){
        String playerChoice = "c";
        String input;
        System.out.println("Enter next command");
        input = sc.nextLine();
        String[] wordInput = input.split(" ", 2);
        switch (wordInput[0].toLowerCase()){
            case "go" -> {
                if (wordInput.length == 1){
                    System.out.println("Go where?");
                }
                else {
                    switch (wordInput[1].toLowerCase()) {
                        case "north" -> playerChoice = "n";
                        case "east" -> playerChoice = "e";
                        case "west" -> playerChoice = "w";
                        case "south" -> playerChoice = "s";
                        default -> System.out.println("Unknown direction");
                    }
                }
            }
            case "take" -> {
                if (wordInput.length == 1){
                    System.out.println("Take what?");
                }
                else {
                    playerChoice = "t " + wordInput[1].toLowerCase();
                }
            }
            case "exit" -> {
                playerChoice = "x";
                System.out.println("exiting");
            }
            case "help" -> {
                System.out.println("Go north/east/west/south: move to another room");
                System.out.println("Look: get description of current room");
                System.out.println("Exit: exit game");
            }
            case "look" -> playerChoice = "l";
            default -> System.out.println("X. Type \"help\" for help");
        }
        return playerChoice;
    }

    public void lookAround(Room currentRoom){
        String[] roomDetails = currentRoom.lookAround();
        System.out.print("You are in ");
        for (String detail: roomDetails){
            System.out.println(detail);
        }

    }

    public void cantMove(){
        System.out.println("You cannot go that way");
    }

    public void noItem(){
        System.out.println("There is no such item");
    }
}
