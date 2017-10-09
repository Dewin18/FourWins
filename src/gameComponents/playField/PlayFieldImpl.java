package gameComponents.playField;

public class PlayFieldImpl implements PlayField
{
    private final boolean tracing = false;
    private final int columns = 7;
    private final int rows = 6;
    private VictoryInspector inspector;

    private int[][] playField;
    private int currentPlayerNumber = 1;
    private boolean victory;
    private boolean isFull = false;

    public PlayFieldImpl()
    {
        playField = new int[rows][columns];
        inspector = new VictoryInspector(rows, columns);

        if (tracing)
        {
            writeOnConsole(playField);
            System.out.println();
        }
    }

    public void placeTokenIfValidColumn(int column)
    {
        if (isValidColumn(column))
        {
            placeToken(column);
            checkForVictory();

            if (checkIfPlayFieldIsFull())
            {
                isFull = true;
                resetPlayField();
            }
            changePlayer();
        }

        if (tracing)
        {
            writeOnConsole(playField);
            System.out.println();
        }
    }

    public boolean isValidColumn(int column)
    {
        return playField[0][column] == 0;
    }

    private void placeToken(int column)
    {
        int lastRow = rows - 1;

        while (playField[lastRow][column] != 0)
        {
            lastRow--;
        }

        playField[lastRow][column] = currentPlayerNumber;
    }

    private void checkForVictory()
    {
        victory = inspector.checkAllCases(playField);

        if (victory)
        {
            resetPlayField();
        }
    }

    private void resetPlayField()
    {
        playField = new int[rows][columns];
    }

    private void changePlayer()
    {
        int number = currentPlayerNumber;

        if (number == 1)
            currentPlayerNumber = 2;
        else
            currentPlayerNumber = 1;
    }

    public boolean isPlayFieldFull()
    {
        return isFull;
    }

    public void disablePlayFieldIsFull()
    {
        isFull = false;
    }

    private boolean checkIfPlayFieldIsFull()
    {
        for (int i = 0; i < columns; i++)
        {
            if (playField[0][i] == 0) return false;
        }
        return true;
    }

    public int[][] getField()
    {
        return playField;
    }

    public void writeOnConsole(int[][] playField)
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                System.out.print(playField[i][j]);
            }
            System.out.println();
        }
    }

    public int getCurrentPlayer()
    {
        return currentPlayerNumber;
    }

    public boolean isVicotry()
    {
        return victory;
    }

    public void setVictoryFalse()
    {
        victory = false;
    }
}
