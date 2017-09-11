package gameComponents.playField;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import main.GamePanel;

public class PlayFieldScreen
{
    private final int TOKEN_PLACE_SPEED = 10;
    private final int TOKEN_SIZE = 70;
    private final int LAST_Y_POSITION = 398;
    private final int VERTICAL_SPACE_BETWEEN_TOKENS = 76;
    private int[] tokenXPositions = {56, 133, 210, 286, 362, 439, 515};

    private ArrayList<Token> tokens;
    private Token token;

    private int positioningCounter = 0;
    private HashMap<Integer, Integer> columnMap;
    private int column0 = LAST_Y_POSITION;
    private int column1 = LAST_Y_POSITION;
    private int column2 = LAST_Y_POSITION;
    private int column3 = LAST_Y_POSITION;
    private int column4 = LAST_Y_POSITION;
    private int column5 = LAST_Y_POSITION;
    private int column6 = LAST_Y_POSITION;

    private int currentColumnSize;
    private boolean tokenIsPlaced;

    private BufferedImage playFieldScreen;

    public PlayFieldScreen()
    {
        playFieldScreen = getImageFromSource("/playField.png");

        tokens = new ArrayList<>();
        columnMap = new HashMap<Integer, Integer>();

        initColumnMap();
    }

    private void initColumnMap()
    {
        columnMap.put(0, column0);
        columnMap.put(1, column1);
        columnMap.put(2, column2);
        columnMap.put(3, column3);
        columnMap.put(4, column4);
        columnMap.put(5, column5);
        columnMap.put(6, column6);
    }

    private BufferedImage getImageFromSource(String source)
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

    public void draw(Graphics g)
    {
        if (tokenIsPlaced)
        {
            tokens.add(token);
            startAndStopTokenPlaceAnimation();
        }

        updateAllTokens(g);
        drawPlayFieldGrid(g);
    }

    private void startAndStopTokenPlaceAnimation()
    {
        if (tokenIsNotInCorrectSlot())
        {
            startMoveTokenAnimation();
        }
        else
        {
            adaptColumnSize();
            stopMoveTokenAnimation();
        }
    }

    private boolean tokenIsNotInCorrectSlot()
    {
        return (token.getYPosition() < currentColumnSize);
    }

    private void startMoveTokenAnimation()
    {
        token.setYPosition(positioningCounter);
        positioningCounter += TOKEN_PLACE_SPEED;
    }

    private void adaptColumnSize()
    {
        currentColumnSize -= VERTICAL_SPACE_BETWEEN_TOKENS;
    }

    private void stopMoveTokenAnimation()
    {
        positioningCounter = 0;
        tokenIsPlaced = false;
    }

    private void updateAllTokens(Graphics g)
    {
        for (Token token : tokens)
        {
            token.draw(g);
        }
    }

    private void drawPlayFieldGrid(Graphics g)
    {
        int gap = 10;

        g.drawImage(playFieldScreen, gap, gap, GamePanel.WIDTH - 2 * gap,
                GamePanel.HEIGHT - 10 * gap, null);
    }

    public void updateScreen(int position, int currentPlayer)
    {
        initTokenForCurrentPlayer(currentPlayer);

        if (validColumn(position))
        {
            setStartPosition(position);
            updatePosition(position);
        }
    }

    private void setStartPosition(int position)
    {
        token.setXPosition(tokenXPositions[position]);
        token.setYPosition(0);
    }

    private void updatePosition(int position)
    {
        currentColumnSize = columnMap.get(position);

        int tempValue = columnMap.get(position);
        tempValue -= VERTICAL_SPACE_BETWEEN_TOKENS;

        columnMap.put(position, tempValue);
        startPositioningAnimation();
    }

    private void initTokenForCurrentPlayer(int currentPlayer)
    {
        if (currentPlayer == 1)
        {
            token = new PlayerOneToken(0, 0, TOKEN_SIZE, TOKEN_SIZE);
        }
        else
        {
            token = new PlayerTwoToken(0, 0, TOKEN_SIZE, TOKEN_SIZE);
        }
    }

    private void startPositioningAnimation()
    {
        tokenIsPlaced = true;
    }

    private boolean validColumn(int position)
    {
        int column = columnMap.get(position);
        return (column > 0);
    }

    public boolean tokenPlacedAnimation()
    {
        return tokenIsPlaced;
    }
}
