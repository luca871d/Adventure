public class Action {
    private PlayerChoice playerChoice;
    private String playerChoiceItem;

    public Action (PlayerChoice playerChoice, String playerChoiceItem){
        this.playerChoice = playerChoice;
        this.playerChoiceItem = playerChoiceItem;
    }

    public PlayerChoice getPlayerChoice() {
        return playerChoice;
    }

    public String getPlayerChoiceItem() {
        return playerChoiceItem;
    }
}
