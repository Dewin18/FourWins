package gameComponents.playField;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class PlayFieldScreen
{
    private BufferedImage playFieldScreen;
    private BufferedImage playerOneToken;
    private BufferedImage playerTwoToken;
    double y = 0;
    
    private final int TOKEN_SIZE = 68;

    public PlayFieldScreen()
    {
            playFieldScreen = getImageFromSource("/playField.png");
            playerOneToken = getImageFromSource("/redW.png");
            playerTwoToken = getImageFromSource("/yellowW.png");
    }

    private BufferedImage getImageFromSource(String source)
    {
        try
        {
            return ImageIO
                    .read(getClass().getResourceAsStream(source));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }


    public void draw(Graphics g)
    {
        int gap = 10;
//        int tokenSize = 66;
//        
//        int spielfeld00Eintrag = 25;
//        int spielfeld60Eintrag = 402;
        
        //placeable  -> placeToken
        
        g.drawImage(playerOneToken, 57, (int) y, TOKEN_SIZE, TOKEN_SIZE, null);
        
        if(y < 400)
        {
            y+=5;
        }
        

        g.drawImage(playFieldScreen, gap, gap, GamePanel.WIDTH - 2 * gap,
                GamePanel.HEIGHT - 10 * gap, null);        
        
    }
}
