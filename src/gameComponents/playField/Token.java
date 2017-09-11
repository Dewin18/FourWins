package gameComponents.playField;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Token
{
    protected int xPosition;
    protected int yPosition;
    protected int width;
    protected int height;

    protected BufferedImage token;
    
    protected abstract void draw(Graphics g);
    
    protected abstract void setXPosition(int x);
    
    protected abstract void setYPosition(int x);
    
    protected abstract int getYPosition();
    
    protected BufferedImage getImageFromSource(String source)
    {
        try
        {
            return ImageIO.read(getClass().getResourceAsStream(source));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
