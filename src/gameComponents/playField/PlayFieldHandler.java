package gameComponents.playField;

import java.awt.Graphics;
import javax.swing.JPanel;

public class PlayFieldHandler extends JPanel
{
    private static final long serialVersionUID = 1L;
    private PlayFieldScreen playFieldScreen;
    private PlayFieldImpl playField;
    private DrawText startText;

    public PlayFieldHandler()
    {
        playFieldScreen = new PlayFieldScreen();
        playField = new PlayFieldImpl();
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
}
