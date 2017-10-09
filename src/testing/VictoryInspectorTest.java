package testing;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Before;
import org.junit.Test;

import gameComponents.playField.PlayField;
import gameComponents.playField.PlayFieldHandler;
import gameComponents.playField.VictoryInspector;

public class VictoryInspectorTest
{
    private final int NO_PLAYER = 0;
    private final int PLAYER_ONE = 1;
    private final int PLAYER_TWO = 2;

    private PlayFieldHandler playFieldHandler;
    private PlayField playField;
    private int rows = 6;
    private int columns = 7;
    private VictoryInspector inspector;

    public VictoryInspectorTest()
    {
        init();
    }

    @Before
    public void init()
    {
        playFieldHandler = new PlayFieldHandler();
        playField = playFieldHandler.getPlayField();
        
        inspector = new VictoryInspector(rows, columns);
    }

    @Test
    public void testEmptyPlayFieldIsNoVictory()
    {
        assertFalse(inspector.checkAllCases(playField.getField()));
    }

    @Test
    public void testPlaceTokensInFirstColumn()
    {
        int row = 0;
        int col = 0;

        assertTrue(getPlayerFor(row + 5, col) == NO_PLAYER);

        playField.placeTokenIfValidColumn(0);

        assertTrue(getPlayerFor(row + 5, col) == PLAYER_ONE);

        placeTokensInFirstColumn();
        
        assertTrue(getPlayerFor(row + 5, col) == PLAYER_ONE);
        assertTrue(getPlayerFor(row + 4, col) == PLAYER_TWO);
        assertTrue(getPlayerFor(row + 3, col) == PLAYER_ONE);
        assertTrue(getPlayerFor(row + 2, col) == PLAYER_TWO);
        assertTrue(getPlayerFor(row + 1, col) == PLAYER_ONE);
        assertTrue(getPlayerFor(row + 0, col) == PLAYER_TWO);

        playField.placeTokenIfValidColumn(0);

        assertTrue(getPlayerFor(row, col) == PLAYER_TWO);
    }

    private void placeTokensInFirstColumn()
    {
        for(int i=0; i < 5; i++)
        {
            playField.placeTokenIfValidColumn(0); 
        }
    }

    private int getPlayerFor(int row, int column)
    {
        return playField.getField()[row][column];
    }
    
    @Test
    public void testFourEqualTokensInRowIsWin()
    {
        assertFalse(playFieldHandler.isVictory());
        
        playField.placeTokenIfValidColumn(0);
        playField.placeTokenIfValidColumn(0);
        playField.placeTokenIfValidColumn(1);
        playField.placeTokenIfValidColumn(1);
        playField.placeTokenIfValidColumn(2);
        playField.placeTokenIfValidColumn(2);
        playField.placeTokenIfValidColumn(3);
        
        assertTrue(playFieldHandler.isVictory());
    }

    @Test
    public void testFourEqualTokensInColumnIsWin()
    {
        assertFalse(playFieldHandler.isVictory());
        
        playField.placeTokenIfValidColumn(0);
        playField.placeTokenIfValidColumn(1);
        playField.placeTokenIfValidColumn(0);
        playField.placeTokenIfValidColumn(1);
        playField.placeTokenIfValidColumn(0);
        playField.placeTokenIfValidColumn(1);
        playField.placeTokenIfValidColumn(0);
        
        assertTrue(playFieldHandler.isVictory());
    }
    
    @Test
    public void testFourEqualTokensDiagonalIsWin()
    {
        assertFalse(playFieldHandler.isVictory());
        
        playField.placeTokenIfValidColumn(0);
        playField.placeTokenIfValidColumn(1);
        playField.placeTokenIfValidColumn(1);
        playField.placeTokenIfValidColumn(0);
        playField.placeTokenIfValidColumn(2);
        playField.placeTokenIfValidColumn(2);
        playField.placeTokenIfValidColumn(2);
      
        playField.placeTokenIfValidColumn(3);
        playField.placeTokenIfValidColumn(3);
        playField.placeTokenIfValidColumn(3);
        playField.placeTokenIfValidColumn(3);
     
        assertTrue(playFieldHandler.isVictory());
    }
}
