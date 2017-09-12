package gameComponents.playField;

import java.awt.Graphics;

public abstract class DrawText
{
    protected String text;
    protected int xPosition;
    protected int yPosition;
    protected int textYPosition = 0;
    
    protected abstract void draw(Graphics g);
    
    protected abstract int getTextVisibilityValue(); 
}
