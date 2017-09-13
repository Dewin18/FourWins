package gameComponents.playField;

import java.awt.Graphics;
import javax.swing.JPanel;

public class PlayFieldHandler extends JPanel
{
    private static final long serialVersionUID = 1L;
    private PlayFieldScreen playFieldScreen;
    private PlayField playField;
    private DrawText startText;

    public PlayFieldHandler()
    {
        playFieldScreen = new PlayFieldScreen();
        playField = (PlayField) new PlayFieldImpl();
        startText = new StartText("Player 1 Start!", 140, 350);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        drawPlayFieldScreen(g);

        if (startTextIsVisible())
        {
            startText.draw(g);
        }
    }

    private boolean startTextIsVisible()
    {
        return (startText.getTextVisibilityValue() > 20);
    }

    private void drawPlayFieldScreen(Graphics g)
    {
        playFieldScreen.draw(g);
    }

    public void placeToken(int position)
    {
        int currentPlayer = playField.getCurrentPlayer();

        playField.placeTokenIfValidColumn(position);
        playFieldScreen.updateScreen(position, currentPlayer);
    }

    public boolean tokenPlacedAnimation()
    {
        return playFieldScreen.tokenPlacedAnimation();
    }
    
    public int getCurrentPlayer()
    {
        return playField.getCurrentPlayer();
    }
    
    public boolean isVictory()
    {
        return playField.isVicotry();
    }
    
    public void resetTokenList()
    {
        playFieldScreen.getTokens().clear();
    }
    
    public void resetColumns()
    {
        playFieldScreen.initColumns();
        playFieldScreen.initColumnMap();
    }
    
    public void resetVicotry()
    {
        playField.setVictoryFalse();
    }
}
