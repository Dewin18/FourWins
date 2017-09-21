package gameComponents.playField;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
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
        initDrawText();
    }

    private void initDrawText()
    {
        String start = "Player 1 Start!";
        String full = "Reset game board...";

        Point startTextPosition = new Point(150, 350);
        Point fullTextPosition = new Point(100, 350);

        Color startTextColor = Color.GREEN.darker();
        Color fullTextColor = Color.GREEN.darker();

        startText = new DrawText(start, startTextPosition, startTextColor);
        fullText = new DrawText(full, fullTextPosition, fullTextColor);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        drawPlayFieldScreen(g);
        drawStartTextIfVisible(g);
        drawFullTextIfPlayfieldIsFull(g);
    }

    private void drawPlayFieldScreen(Graphics g)
    {
        playFieldScreen.draw(g);
    }

    private void drawStartTextIfVisible(Graphics g)
    {
        if (textIsVisible(startText))
        {
            startText.draw(g);
        }
    }

    private boolean textIsVisible(DrawText drawText)
    {
        return (drawText.getTextVisibilityValue() > 20);
    }

    private void drawFullTextIfPlayfieldIsFull(Graphics g)
    {
        if (playField.isPlayFieldFull())
        {
            if (textIsVisible(fullText))
            {
                fullText.draw(g);
            }
            else
            {
                resetPlayField();
                playField.disablePlayFieldIsFull();
                fullText.resetValues();
            }
        }
    }

    public void resetPlayField()
    {
        resetColumns();
        resetTokenList();
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
        case 1:
            return 2;
        case 2:
            return 1;
        default:
            return 0;
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
