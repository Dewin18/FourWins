package gameComponents;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import gameComponents.columnSelector.ColumnSelector;
import gameComponents.playField.PlayFieldHandler;
import gameComponents.scoreDisplay.ScoreDisplay;
import gameComponents.settings.Settings;
import gameComponents.settings.SettingsDialog;
import gameComponents.victoryDisplay.VictoryDialog;

public class ComponentTool implements ComponentObserver
{
    private ColumnSelector columnSelector;
    private PlayFieldHandler playFieldHandler;
    private ScoreDisplay scoreDisplay;
    private Settings settings;
    private SettingsDialog settingsDialog;
    private JPanel scoreAndSettingsPanel;

    public ComponentTool()
    {
        createComponents();
        initScoreAndSettingsPanel();
        combineScoreAndSettingsPanel();
        addComponentObservers();
    }

    private void createComponents()
    {
        playFieldHandler = new PlayFieldHandler();
        columnSelector = new ColumnSelector();
        scoreDisplay = new ScoreDisplay();
        settingsDialog = new SettingsDialog();
        settings = new Settings(settingsDialog);
    }

    private void initScoreAndSettingsPanel()
    {
        scoreAndSettingsPanel = new JPanel();
        scoreAndSettingsPanel.setLayout(new BorderLayout());
    }

    private void combineScoreAndSettingsPanel()
    {
        JPanel settingsPanel = settings.getSettingsPanel();
        JPanel scoreDisplayPanel = scoreDisplay.getSouthPanel();

        scoreAndSettingsPanel.add(scoreDisplayPanel, BorderLayout.CENTER);
        scoreAndSettingsPanel.add(settingsPanel, BorderLayout.SOUTH);
    }

    private void addComponentObservers()
    {
        columnSelector.addObserver(this);
        settingsDialog.addObserver(this);
    }

    public void update()
    {
        checkIfPlaceTokenButtonIsPressed();
        checkForNameChange();
    }

    private void checkIfPlaceTokenButtonIsPressed()
    {
        if (columnSelector.isButtonPressed())
        {
            checkForPlaceTokenAnimation();
            columnSelector.disablButtonPressed();
            checkForVictory();
        }
    }

    private void checkForPlaceTokenAnimation()
    {
        if (tokenPlaceAnimationIsNotRunning() && !playFieldHandler.isPlayFieldFull())
        {
            placeToken();
        }
    }

    private void placeToken()
    {
        int currentColumn = columnSelector.getCurrentColumn();
        playFieldHandler.placeToken(currentColumn);
    }

    private void checkForVictory()
    {
        if (playFieldHandler.isVictory())
        {
            int winnerNumber = playFieldHandler.getWinner();

            increaseWinnerScore(winnerNumber);

            String winnerName = scoreDisplay
                .getNameFromPlayerNumber(winnerNumber);

            new VictoryDialog(winnerName);

            playFieldHandler.resetPlayField();
            playFieldHandler.resetVicotry();
        }
    }

    private void increaseWinnerScore(int winner)
    {
        if (winner == 1)
            scoreDisplay.increasePlayerOneScore();
        else
            scoreDisplay.increasePlayerTwoScore();

    }

    private void checkForNameChange()
    {
        if (settingsDialog.namesAreChanged())
        {
            String playerOneName = settingsDialog.getPlayerOneName();
            String playerTwoName = settingsDialog.getPlayerTwoName();

            scoreDisplay.setPlayerOneName(playerOneName);
            scoreDisplay.setPlayerTwoName(playerTwoName);

            settingsDialog.disableNamesAreChanged();
        }
    }

    private boolean tokenPlaceAnimationIsNotRunning()
    {
        return !playFieldHandler.tokenPlacedAnimation();
    }

    public PlayFieldHandler getPlayFieldHandler()
    {
        return playFieldHandler;
    }

    public ColumnSelector getColumnSelector()
    {
        return columnSelector;
    }

    public ScoreDisplay getScoreDisplay()
    {
        return scoreDisplay;
    }

    public JPanel getScoreAndDisplayPanel()
    {
        return scoreAndSettingsPanel;
    }

    public Settings getSettings()
    {
        return settings;
    }
}
