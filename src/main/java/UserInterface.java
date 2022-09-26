import java.util.Scanner;

public class UserInterface {
    public void startUp(Room currentRoom){
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        String input;
        while (!exit){
            System.out.println("Enter next command");
            input = sc.nextLine();
            String[] wordInput = input.split(" ", 3);
            switch (wordInput[0].toLowerCase()){
                case "go" -> directions(wordInput);
                case "exit" -> exit = exiting();
                case "help" -> System.out.println("helping");
                case "look" -> lookAround(currentRoom);
                default -> System.out.println("X. Type \"help\" for help");
            }
        }
    }
    //switch-case for directions
    private void directions(String[] input){
        String dir;
        if (input.length > 1){
            dir = input[1];
        }
        else {
            dir = "invalid";
        }
        switch (dir){
            case "north" -> System.out.println("going north");
            case "east" -> System.out.println("going east");
            case "west" -> System.out.println("going west");
            case "south" -> System.out.println("going south");
            default -> System.out.println("unknown direction");
        }
    }

    private void lookAround(Room currentRoom){
        System.out.println("looking around");
        String[] roomDetails = currentRoom.lookAround();
        for (String detail: roomDetails){
            System.out.println(detail);
        }
    }
    public boolean exiting(){
        System.out.println("exiting");
        return true;
    }
}
