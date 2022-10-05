import java.util.ArrayList;
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
            case "inventory" -> playerChoice = "i";
            case "take" -> {
                if (wordInput.length == 1){
                    System.out.println("Take what?");
                }
                else {
                    playerChoice = "t " + wordInput[1].toLowerCase();
                }
            }
            case "eat" -> {
                if (wordInput.length == 1){
                    System.out.println("Eat what?");
                }
                else {
                    playerChoice = "p " + wordInput[1].toLowerCase(); // p for spis
                }
            }
            case "drop" -> {
                if (wordInput.length == 1){
                    System.out.println("Drop what?");
                }
                else {
                    playerChoice = "d " + wordInput[1].toLowerCase();
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
            case "health" -> playerChoice = "h";
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

    public void noItem(String location){
        System.out.println("There is no such item in " + location);
    }

    public void inventory(ArrayList<Item> items){
        System.out.println("You are currently carrying:");
        if (items.isEmpty()){
            System.out.println("Nothing");
        }
        else {
            for (Item item : items) {
                System.out.println(item.getName());
            }
        }
    }

    public void currentHealth(int health){
        System.out.print("You currently have " + health + " health - ");
        if (health >= 10){
            System.out.println("You have good health, and are ready to fight");
        }
        else if (health > 6){
            System.out.println("You have good health, but you are not ready to fight");
        }
        else if (health > 3){
            System.out.println("You have bad health, and should proceed with caution");
        }
        else{
            System.out.println("You are almost dead, you should eat something!");
        }
    }
    public void noFood(){
        System.out.println("There is no such near you to eat");
    }

    public void cantEat(){
        System.out.println("You cannot eat that!");
    }

    public void ate(){
        System.out.println("You ate it.");
    }
}
