package gameComponents.playField;

import java.awt.*;

public class DrawText
{
    private String text;
    private Point position;
    private int xPosition;
    private int yPosition;
    private int red;
    private int green;
    private int blue;
    private int startSpeed;
    private int alpha;
    private final int FONT_SIZE = 50;
    private int textYPosition;
    private Font font;

    public DrawText(String text, Point position, Color color)
    {
        this.text = text;

        initXYPositionFromPoint(position);
        initRGBColorFromColor(color);

        startSpeed = 1;
        alpha = 255;
        textYPosition = 0;

        initFont();
    }

    private void initXYPositionFromPoint(Point position)
    {
        this.position = position;
        xPosition = this.position.x;
        yPosition = this.position.y;
    }

    private void initRGBColorFromColor(Color color)
    {
        red = color.getRed();
        green = color.getGreen();
        blue = color.getBlue();
    }

    private void initFont()
    {
        font = new Font("Arial", Font.BOLD, FONT_SIZE);
    }

    protected void draw(Graphics g)
    {
        drawText(g);

        if (YThresholdReached())
        {
            moveTextFast();

            if (textIsNotInvisible())
            {
                alpha -= 20;
            }
        }
        yPosition -= startSpeed;
        textYPosition++;
    }
    
    private void drawText(Graphics g)
    {
        g.setFont(font);
        Color color = new Color(red, green, blue, alpha);
        g.setColor(color);
        g.drawString(text, xPosition, yPosition);
    }

    public boolean textIsNotInvisible()
    {
        return (alpha > 21);
    }

    private boolean YThresholdReached()
    {
        return (textYPosition > 100);
    }

    private void moveTextFast()
    {
        startSpeed++;
    }

    public int getAlpha()
    {
        return alpha;
    }

    protected void resetValues()
    {
        xPosition = position.x;
        yPosition = position.y;
        textYPosition = 0;
        startSpeed = 1;
        alpha = 255;
    }
}
