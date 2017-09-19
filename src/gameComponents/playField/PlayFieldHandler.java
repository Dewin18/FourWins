package gameComponents.playField;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PlayFieldHandler extends JPanel
{
    private static final long serialVersionUID = 1L;
    private PlayFieldScreen playFieldScreen;
    private PlayField playField;
    private DrawText startText;
    private DrawText fullText;

    public PlayFieldHandler()
    {
        playFieldScreen = new PlayFieldScreen();
        playField = (PlayField) new PlayFieldImpl();
        startText = new StartText("Player 1 Start!", 150, 350);
        fullText = new StartText("FULL!!!", 250, 350);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        drawPlayFieldScreen(g);

        if (startTextIsVisible())
        {
            startText.draw(g);
        }

        if (playField.isPlayFieldFull()) // TODO refactoring
        {
            fullText.draw(g);

            if(fullText.getTextVisibilityValue() < 20)
            {
                resetColumns();
                resetTokenList();
                playField.disablePlayFieldIsFull();
                fullText.reset();
            }
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

    public int getWinner()
    {
        int winner = playField.getCurrentPlayer();

        switch (winner)
        {
        case 1:  return 2;
        case 2:  return 1;
        default: return 0;
        }
    }

    public boolean isPlayFieldFull()
    {
        return playField.isPlayFieldFull();
    }

    public void disablePlayFieldIsFull()
    {
        playField.disablePlayFieldIsFull();
    }

    public boolean isVictory()
    {
        return playField.isVicotry();
    }

    public void resetTokenList()
    {
        playFieldScreen.getTokens()
            .clear();
    }

    public ArrayList<Token> getTokens()
    {
        return playFieldScreen.getTokens();
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

    public PlayField getPlayField()
    {
        return playField;
    }
}
