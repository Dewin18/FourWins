package gameComponents.playField;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class PlayFieldScreen
{
    private BufferedImage playFieldScreen;

    public PlayFieldScreen()
    {
        try
        {
            playFieldScreen = ImageIO
                .read(getClass().getResourceAsStream("/playField.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    

    public void draw(Graphics g)
    {
        int gap = 10;

        g.drawImage(playFieldScreen, gap, gap, GamePanel.WIDTH - 2 * gap,
                GamePanel.HEIGHT - 10 * gap, null);        
    }
}
