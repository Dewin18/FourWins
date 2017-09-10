package gameComponents.playField;

public class VictoryInspector
{
    private int rows;
    private int columns;
    private int[][] playField;
    private int equalTokenSequence;

    private int[] diagonalSequenceArray;
    private int diagonalSequenceArrayIndex;
    private int startRow;
    private int startColumn;

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

    public boolean checkColumns(int[][] playField)
    {
        this.playField = playField;
        resetTokenSequence();

        for (int i = 0; i < columns; i++)
        {
            for (int j = 0; j < rows - 1; j++)
            {
                if (tokensInColumnAreEqual(j, i))
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

    private boolean tokensInColumnAreEqual(int row, int column)
    {
        return playField[row][column] != 0
                && playField[row][column] == playField[row + 1][column];
    }

    public boolean checkDiagonal(int[][] playField)
    {
        this.playField = playField;

        boolean leftToRightVictory = checkLeftToRightDiagonal();
        boolean rightToLeftVictory = checkRightToLeftDiagonal();

        return leftToRightVictory || rightToLeftVictory;
    }

    private boolean checkLeftToRightDiagonal()
    {
        initSequenceArray();

        transferLeftToRightIndices(3, 0, 4);
        transferLeftToRightIndices(4, 0, 5);
        transferLeftToRightIndices(5, 0, 6);
        transferLeftToRightIndices(5, 1, 6);
        transferLeftToRightIndices(5, 2, 5);
        transferLeftToRightIndices(5, 3, 4);

        return diagonalVictoryInSequenceArray();
    }

    private void initSequenceArray()
    {
        int diagonalFields = 30;
        diagonalSequenceArray = new int[diagonalFields];
        diagonalSequenceArrayIndex = 0;
    }

    private void transferLeftToRightIndices(int startRow, int startColumn,
            int iterations)
    {
        this.startRow = startRow;
        this.startColumn = startColumn;

        for (int i = 0; i < iterations; i++)
        {
            putPlayFieldIndicesInSequenceArray();
            changeLeftToRightIndices();
            diagonalSequenceArrayIndex++;
        }
    }

    private void putPlayFieldIndicesInSequenceArray()
    {
        diagonalSequenceArray[diagonalSequenceArrayIndex] = playField[startRow][startColumn];
    }

    private void changeLeftToRightIndices()
    {
        startRow--;
        startColumn++;
    }

    private boolean diagonalVictoryInSequenceArray()
    {
        for (int i = 0; i < diagonalSequenceArray.length - 1; i++)
        {
            if (victoryInSection(i)) return true;

            if (sectionIsOver(i))
            {
                resetTokenSequence();
            }
        }
        return false;
    }

    private boolean victoryInSection(int i)
    {
        if (tokenInSectionAreEqual(i))
        {
            extendTokenSequence();
            if (fourTokensEqualInSequence()) return true;
        }
        else
        {
            resetTokenSequence();
        }
        return false;
    }

    private boolean tokenInSectionAreEqual(int i)
    {
        return (diagonalSequenceArray[i] != 0
                && diagonalSequenceArray[i] == diagonalSequenceArray[i + 1]);
    }

    private boolean sectionIsOver(int index)
    {
        return (index == 3 || index == 8 || index == 14 || index == 20
                || index == 25);
    }

    private boolean checkRightToLeftDiagonal()
    {
        initSequenceArray();

        transferRightToLeftIndices(3, 6, 4);
        transferRightToLeftIndices(4, 6, 5);
        transferRightToLeftIndices(5, 6, 6);
        transferRightToLeftIndices(5, 5, 6);
        transferRightToLeftIndices(5, 4, 5);
        transferRightToLeftIndices(5, 3, 4);

        return diagonalVictoryInSequenceArray();
    }

    private void transferRightToLeftIndices(int startRow, int startColumn,
            int iterations)
    {
        this.startRow = startRow;
        this.startColumn = startColumn;

        for (int i = 0; i < iterations; i++)
        {
            putPlayFieldIndicesInSequenceArray();
            changeRightToLeftIndices();
            diagonalSequenceArrayIndex++;
        }
    }

    private void changeRightToLeftIndices()
    {
        startRow--;
        startColumn--;
    }

    public boolean checkAllCases(int[][] playField)
    {
        this.playField = playField;

        boolean rowVictory = false;
        boolean columnVictory = false;
        boolean diagonalVictory = false;

        rowVictory = checkRows(this.playField);
        columnVictory = checkColumns(this.playField);
        diagonalVictory = checkDiagonal(this.playField);

        return rowVictory || columnVictory || diagonalVictory;
    }
}
