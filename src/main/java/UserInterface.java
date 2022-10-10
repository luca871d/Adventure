import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);

    public Action startUp(){
        PlayerChoice playerChoice = PlayerChoice.CONTINUE;
        String playerChoiceItem = "";
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
                        case "north" -> playerChoice = PlayerChoice.NORTH;
                        case "east" -> playerChoice = PlayerChoice.EAST;
                        case "west" -> playerChoice = PlayerChoice.WEST;
                        case "south" -> playerChoice = PlayerChoice.SOUTH;
                        default -> System.out.println("Unknown direction");
                    }
                }
            }
            case "inventory" -> playerChoice = PlayerChoice.INVENTORY;
            case "take" -> {
                if (wordInput.length == 1){
                    System.out.println("Take what?");
                }
                else {
                    playerChoice = PlayerChoice.TAKE;
                    playerChoiceItem = wordInput[1].toLowerCase();
                }
            }
            case "eat" -> {
                if (wordInput.length == 1){
                    System.out.println("Eat what?");
                }
                else {
                    playerChoice = PlayerChoice.EAT;
                    playerChoiceItem = wordInput[1].toLowerCase();
                }
            }
            case "equip" -> {
                if (wordInput.length == 1){
                    System.out.println("Equip what?");
                }
                else {
                    playerChoice = PlayerChoice.EQUIP;
                    playerChoiceItem = wordInput[1].toLowerCase();
                }
            }
            case "drop" -> {
                if (wordInput.length == 1){
                    System.out.println("Drop what?");
                }
                else {
                    playerChoice = PlayerChoice.DROP;
                    playerChoiceItem = wordInput[1].toLowerCase();
                }
            }
            case "exit" -> {
                playerChoice = PlayerChoice.EXIT;
                System.out.println("exiting");
            }
            case "help" -> {
                System.out.println("Go north/east/west/south: move to another room");
                System.out.println("Look: get description of current room");
                System.out.println("Exit: exit game");
            }
            case "look" -> playerChoice = PlayerChoice.LOOK;
            case "health" -> playerChoice = PlayerChoice.HEALTH;
            default -> System.out.println("X. Type \"help\" for help");
        }
        return new Action(playerChoice,playerChoiceItem);
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

    public void cantEquip(){
        System.out.println("You cannot equip that");
    }

    public void equip(){
        System.out.println("You have equipped a weapon");
    }
}
