package gameComponents.scoreDisplay;

public class Score
{
    private int playerOneScore;
    private int playerTwoScore;
    
    public Score()
    {
        playerOneScore = 0;
        playerTwoScore = 0;
    }
    
    public int getPlayerOneScoreValue()
    {
        return playerOneScore;
    }
    
    public int getPlayerTwoScoreValue()
    {
        return playerTwoScore;
    }
    
    public String getPlayerOneScoreText()
    {
        return String.valueOf(playerOneScore);
    }
    
    public String getPlayerTwoScoreText()
    {
        return String.valueOf(playerTwoScore);
    }
    
    public void increasePlayerOneScore()
    {
        playerOneScore++;
    }
    
    public void increasePlayerTwoScore()
    {
        playerTwoScore++;
    }
}
