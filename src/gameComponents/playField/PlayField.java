package gameComponents.playField;

public interface PlayField
{
    void placeTokenIfValidColumn(int column);
    
    boolean isValidColumn(int column);

    boolean isPlayFieldFull();

    int[][] getField();
    
    int getCurrentPlayer();
    
    boolean isVictory();
    
    void writeOnConsole(int[][] playField);
    
    void setVictoryFalse();
    
    void disablePlayFieldIsFull();
}
