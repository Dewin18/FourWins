package gameComponents.playField;

public class PlayField
{
    private VictoryInspector inspector;
    private final int columns = 7;
    private final int rows = 6;

    private int[][] playField;
    private int currentPlayerNumber = 1;
    private boolean victory;

    public PlayField()
    {
        playField = new int[rows][columns];
        inspector = new VictoryInspector(rows, columns);
        
        writeOnConsole(playField);
        System.out.println();
    }

    public void placeTokenIfValidColumn(int column)
    {
        if (isValidColumn(column))
        {
            placeToken(column);
            checkForVictory();

            if (isPlayFieldFull())
            {
                resetPlayField();
            }
            changePlayer();
        }
        System.out.println();
        writeOnConsole(playField);
    }

    private boolean isValidColumn(int column)
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
            System.out.println("WON");
        } //resetPlayField();
    }

    private void resetPlayField()
    {
        System.out.println("FULL");
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
}
