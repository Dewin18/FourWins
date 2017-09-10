package gameComponents;

import gameComponents.columnSelector.ColumnSelector;
import gameComponents.playField.PlayFieldHandler;
import gameComponents.scoreDisplay.ScoreDisplay;

public class ComponentTool implements ComponentObserver
{
    private ColumnSelector columnSelector;
    private PlayFieldHandler playFieldHandler;
    private ScoreDisplay scoreDisplay;
    
    public ComponentTool()
    {
        playFieldHandler = new PlayFieldHandler();
        columnSelector = new ColumnSelector(playFieldHandler);
        scoreDisplay = new ScoreDisplay();
        
        columnSelector.addObserver(this);
    }
    
    public PlayFieldHandler getPlayFieldHandler()
    {
        return playFieldHandler;
    }
    
    public ColumnSelector getColumnSelector()
    {
        return columnSelector;
    }
    
    public ScoreDisplay getScoreDisplay()
    {
        return scoreDisplay;
    }

    public void update()
    {
        int currentColumn = columnSelector.getCurrentColumn();
        
        playFieldHandler.placeToken(currentColumn);
    }
}
