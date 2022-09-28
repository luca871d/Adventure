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
        String[] wordInput = input.split(" ", 2);
        switch (wordInput[0].toLowerCase()){
            case "go" -> {
                if (wordInput.length == 1){
                    System.out.println("Go where?");
                }
                else {
                    adventure.getPlayer().move(wordInput[1]);
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
