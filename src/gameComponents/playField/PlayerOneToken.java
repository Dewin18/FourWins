package gameComponents.playField;

import java.awt.Graphics;

public class PlayerOneToken extends Token
{
    public PlayerOneToken(int xPosition, int yPosition, int width, int height)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        
        token = getImageFromSource("/s1.png");
    }
    
    @Override
    public void draw(Graphics g)
    {
        g.drawImage(token, xPosition, yPosition, width, height, null);
    }

    @Override
    protected void setXPosition(int xPosition)
    {
        this.xPosition = xPosition;
    }

    @Override
    protected void setYPosition(int yPosition)
    {
        this.yPosition = yPosition;
    }

    @Override
    protected int getYPosition()
    {
        return yPosition;
    }
    
    
}
