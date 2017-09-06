package gameComponents.playField;

public class VictoryInspector
{
    private int rows;
    private int columns;
    private int[][] playField;
    private int equalTokenSequence;

    public VictoryInspector(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
    }

    public boolean checkRows(int[][] playField)
    {
        this.playField = playField;

        resetTokenSequence();

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns - 1; j++)
            {
                if (tokensInRowAreEqual(i, j))
                {
                    extendTokenSequence();
                    if (fourTokensEqualInSequence()) return true;
                }
                else
                {
                    resetTokenSequence();
                }
            }
            resetTokenSequence();
        }
        return false;
    }

    private void resetTokenSequence()
    {
        equalTokenSequence = 0;
    }

    private boolean tokensInRowAreEqual(int row, int column)
    {
        return playField[row][column] != 0
                && playField[row][column] == playField[row][column + 1];
    }
    
    private void extendTokenSequence()
    {
        equalTokenSequence++;
    }
    
    private boolean fourTokensEqualInSequence()
    {
        return equalTokenSequence == 3;
    }

    //TODO
    public boolean checkColumns(int[][] playField)
    {
        this.playField = playField;
        resetTokenSequence();
        return false;
    }
    
    //TODO
    private boolean isTokensInColumnAreEqual(int row, int column)
    {
        return false;
    }

    public boolean checkDiagonal(int[][] playField)
    {
        return false;
    }
    
    public boolean checkAllCases(int[][] playField)
    {
        this.playField = playField;
        
        boolean rowVictory = false;
        boolean columnVictory = false;
        boolean diagonalVictory = false;

        rowVictory = checkRows(playField);
        columnVictory = checkColumns(playField);
        diagonalVictory = checkDiagonal(playField);

        return rowVictory || columnVictory || diagonalVictory;
    }
}
