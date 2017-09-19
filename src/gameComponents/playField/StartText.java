package gameComponents.playField;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class StartText extends DrawText
{
    private Font font;
    private int startSpeed = 1;
    private int visibility = 255;
    private int FONT_SIZE = 50;

    public StartText(String text, int xPosition, int yPosition)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.text = text;
        initFont();
    }

    private void initFont()
    {
        font = new Font("Arial", Font.BOLD, FONT_SIZE );
    }

    @Override
    protected void draw(Graphics g)
    {
        drawStartText(g);

        if (YThresholdReached())
        {
            moveTextFast();

            if (textIsNotInvisible())
            {
                visibility -= 20;
            }
        }
        yPosition -= startSpeed;
        textYPosition++;
    }

    private boolean textIsNotInvisible()
    {
        return (visibility > 21);
    }

    private void drawStartText(Graphics g)
    {
        g.setFont(font);
        Color color = new Color(0, 204, 0, visibility);
        g.setColor(color);
        g.drawString(text, xPosition, yPosition);
    }

    private boolean YThresholdReached()
    {
        return (textYPosition > 100);
    }

    private void moveTextFast()
    {
        startSpeed++;
    }
    
    @Override
    public int getTextVisibilityValue()
    {
        return visibility;
    }
}
