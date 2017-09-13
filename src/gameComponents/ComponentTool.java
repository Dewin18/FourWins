package gameComponents;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import gameComponents.columnSelector.ColumnSelector;
import gameComponents.playField.PlayFieldHandler;
import gameComponents.scoreDisplay.ScoreDisplay;
import gameComponents.settings.Settings;
import gameComponents.victoryDisplay.VictoryDialog;

public class ComponentTool implements ComponentObserver
{
    private ColumnSelector columnSelector;
    private PlayFieldHandler playFieldHandler;
    private ScoreDisplay scoreDisplay;
    private Settings settings;
    private JPanel scoreAndSettingsPanel;

    public ComponentTool()
    {
        playFieldHandler = new PlayFieldHandler();
        columnSelector = new ColumnSelector(playFieldHandler);
        scoreDisplay = new ScoreDisplay();
        settings = new Settings();
        
        initScoreAndSettingsPanel();
        combineScoreAndSettingsPanel();
        
        columnSelector.addObserver(this);
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

    public void update()
    {
        int currentColumn = columnSelector.getCurrentColumn();

        if (tokenPlaceAnimationIsNotRunning())
        {
            playFieldHandler.placeToken(currentColumn);
        }         
        
        if(playFieldHandler.isVictory())
        {
            new VictoryDialog();
            
            
            playFieldHandler.resetTokenList();
            playFieldHandler.resetColumns();
            playFieldHandler.resetVicotry();
        }
    }

    private boolean tokenPlaceAnimationIsNotRunning()
    {
        return !playFieldHandler.tokenPlacedAnimation();
    }
}
