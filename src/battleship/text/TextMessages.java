package battleship.text;

public final class TextMessages {

    private static final String HOW_TO_PLAY = "<html>Guess the position of the enemy battlehship<br/> and hit it three times "
            + "to sink it.<br/>"
            + " But beware! You have only three shots!<br/>Miss three times and the game is over.</html>";

    private static final String WIN_MESSAGE = "<html>You have sunk the enemy ship!<br>"
            + "Click \"Restart\" to play again.</html>";

    private static final String LOSE_MESSAGE = "<html>You have failed to sink the enemy ship!<br/>"
            + "Click \"Restart\" to play again.</html>";

    private static final String STATS_SAVED = "You stats have been saved.";
    
    private static final String CREDITS = "<html>Made by: Yaser, Samin<br/>"
            + "Under the Supervision of<br/>"
            + "SAZZAD HOSSAIN<br/>"
            + "Assistant Professor, AIUB<br/>";
    
    private static final String FILE_DELETED = "<html>'Stats.txt' file has been deleted.<br/>"
            + "Please close the Stats window to refresh.</htmk>";
    
    private static final String GITHUB_LINK = "https://github.com/F00dCHAiN/Battleship.git";

    public static String getHowToPlayText() {
        return HOW_TO_PLAY;
    }

    public static String getWinMessage() {
        return WIN_MESSAGE;
    }

    public static String getLoseMessage() {
        return LOSE_MESSAGE;
    }

    public static String getStatsSaved() {
        return STATS_SAVED;
    }
    
    public static String getCredits() {
        return CREDITS;
    }
    
    public static String getGitLink() {
        return GITHUB_LINK;
    }
    
    public static String getFileDeletedMessage(){
        return FILE_DELETED;
    }
}





