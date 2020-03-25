package battleship.text;

public final class TextMessages {

    private static final String howToPlayText = "<html>Guess the position of the enemy battlehship<br/> and hit it three times "
            + "to sink it.<br/>"
            + " But beware! You have only three shots!<br/>Miss three times and the game is over.</html>";

    private static final String winMessage = "<html>You have sunk the enemy ship!<br>"
            + "Click \"Restart\" to play again.</html>";

    private static final String loseMessage = "<html>You have failed to sink the enemy ship!<br/>"
            + "Click \"Restart\" to play again.</html>";

    private static final String statsSaved = "You stats have been saved";
    
    private static final String credits = "<html>Made by: Yaser, Samin<br/>"
            + "Under the Supervision of<br/>"
            + "SAZZAD HOSSAIN<br/>"
            + "Assistant Professor, AIUB<br/>";
    
    private static final String gitLink = "https://github.com/F00dCHAiN/Battleship.git";

    public static String getHowToPlayText() {
        return howToPlayText;
    }

    public static String getWinMessage() {
        return winMessage;
    }

    public static String getLoseMessage() {
        return loseMessage;
    }

    public static String getStatsSaved() {
        return statsSaved;
    }
    
    public static String getCredits() {
        return credits;
    }
    
    public static String getGitLink() {
        return gitLink;
    }
}



