package gameComponents.playField;

public interface PlayField
{
    public void placeTokenIfValidColumn(int column);
    
    public boolean isValidColumn(int column);
    
    public boolean isPlayFieldFull();
    
    public int[][] getField();
    
    public int getCurrentPlayer();
    
    public boolean isVicotry();
    
    public void writeOnConsole(int[][] playField);
    
    public void setVictoryFalse();
    
    public void disablePlayFieldIsFull();
}
