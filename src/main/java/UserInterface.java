import java.util.Scanner;

public class UserInterface {
    public void startUp(){
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        String input;
        //while (!exit){
        input = sc.nextLine();
        String[] wordInput = input.split(" ", 3);
        switch (wordInput[0].toLowerCase()){
            //missing case wordInput.len = 1
            case "go" -> directions(wordInput[1].toLowerCase());
            case "exit" -> System.out.println("exiting");
            case "help" -> System.out.println("helping");
            case "look" -> System.out.println("looking");
            default -> System.out.println("X. Type \"help\" for help");
        }

        //}

        //Test
        System.out.println(input);
        for (String word: wordInput){
            System.out.println(word);
        }
    }
    //switch-case for directions
    private void directions(String dir){
        switch (dir){
            case "north" -> System.out.println("going north");
            case "east" -> System.out.println("going east");
            case "west" -> System.out.println("going west");
            case "south" -> System.out.println("going south");
            default -> System.out.println("unknown direction");
        }
    }
}
