package gameComponents.scoreDisplay;

public class Score
{
    private int playerOneScore;
    private int playerTwoScore;
    
    public Score(int playerOneScore, int playerTwoScore)
    {
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }
    
    public void increasePlayerOneScore()
    {
        playerOneScore++;
    }
    
    public void increasePlayerTwoScore()
    {
        playerTwoScore++;
    }
    
    @Override
    public String toString()
    {
        return playerOneScore + "  -  " + playerTwoScore;
    }
}
