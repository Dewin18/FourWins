package gameComponents.playField;

import java.awt.Graphics;
import javax.swing.JPanel;

public class PlayFieldHandler extends JPanel
{
    private static final long serialVersionUID = 1L;
    private PlayFieldScreen playFieldScreen;
    private PlayField playField;
    
    public PlayFieldHandler()
    {
        playFieldScreen = new PlayFieldScreen();
        playField = new PlayField();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        drawPlayFieldScreen(g);
    }

    private void drawPlayFieldScreen(Graphics g)
    {
        playFieldScreen.draw(g);
    }
    
    public void placeToken(int position)
    {
        playField.placeTokenIfValidColumn(position);
    }
}
