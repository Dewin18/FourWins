package gameComponents.scoreDisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.GamePanel;

public class ScoreDisplay
{
    private final int NO_OF_BLANKS = 20;
    private int DISPLAY_FONT_SIZE = 25;

    private JPanel displayPanel;
    private JPanel playerOneNamePanel;
    private JPanel scorePanel;
    private JPanel playerTwoNamePanel;

    private JLabel playerOneNameLabel;
    private JLabel playerTwoNameLabel;
    private JLabel scoreText;

    private Score score;
    private Font scoreDisplayFont;

    private String playerOneName;
    private String playerTwoName;

    public ScoreDisplay()
    {
        playerOneName = "Player 1";
        playerTwoName = "Player 2";

        initDisplayPanel();
        initPlayerAndScorePanels();
        initPlayerNames();
        initScore();
        initFont();
        combineNamesAndScore();
    }

    private void initDisplayPanel()
    {
        displayPanel = new JPanel();

        displayPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); // TODO ?GRIDLAYOUT?
        displayPanel.setPreferredSize(new Dimension(GamePanel.WIDTH, 38));
    }

    private void initPlayerAndScorePanels()
    {
        Color panelColor = Color.BLACK;

        playerOneNamePanel = new JPanel();
        scorePanel = new JPanel();
        playerTwoNamePanel = new JPanel();

        playerOneNamePanel.setPreferredSize(new Dimension(260, 38));
        scorePanel.setPreferredSize(new Dimension(100, 38));
        playerTwoNamePanel.setPreferredSize(new Dimension(260, 38));

        playerOneNamePanel.setBackground(panelColor);
        scorePanel.setBackground(panelColor);
        playerTwoNamePanel.setBackground(panelColor);
    }

    private void initPlayerNames()
    {
        playerOneNameLabel = new JLabel(playerOneDefaultName());
        playerTwoNameLabel = new JLabel(playerTwoDefaultName());

        playerOneNamePanel.add(playerOneNameLabel);
        playerTwoNamePanel.add(playerTwoNameLabel);
    }

    private String playerOneDefaultName()
    {
        return playerOneName + generateEmptyString(NO_OF_BLANKS);
    }

    private String playerTwoDefaultName()
    {
        return generateEmptyString(NO_OF_BLANKS) + playerTwoName;
    }

    private String generateEmptyString(int numberOfBlanks)
    {
        String emptyString = "";

        for (int i = 0; i < numberOfBlanks; i++)
            emptyString += " ";

        return emptyString;
    }

    private void initScore()
    {
        score = new Score(0, 0);
        scoreText = new JLabel(score.toString());
        scorePanel.add(scoreText);
    }

    private void initFont()
    {
        scoreDisplayFont = new Font("Arial", Font.BOLD, DISPLAY_FONT_SIZE);

        playerOneNameLabel.setFont(scoreDisplayFont);
        playerOneNameLabel.setForeground(Color.RED);

        playerTwoNameLabel.setFont(scoreDisplayFont);
        playerTwoNameLabel.setForeground(Color.YELLOW);

        scoreText.setFont(scoreDisplayFont);
        scoreText.setForeground(Color.GRAY);
    }

    private void combineNamesAndScore()
    {
        displayPanel.add(playerOneNamePanel);
        displayPanel.add(scorePanel);
        displayPanel.add(playerTwoNamePanel);
    }

    public void setPlayerOneName(String name)
    {
        playerOneName = name;
        playerOneNameLabel
            .setText(name.concat(generateEmptyString(NO_OF_BLANKS)));
    }

    public void setPlayerTwoName(String name)
    {
        playerTwoName = name;
        playerTwoNameLabel
            .setText(generateEmptyString(NO_OF_BLANKS).concat(name));
    }

    public JPanel getSouthPanel()
    {
        return displayPanel;
    }

    public void increasePlayerOneScore()
    {
        score.increasePlayerOneScore();
        updateScoreText();
    }

    private void updateScoreText()
    {
        scoreText.setText(score.toString());
    }

    public void increasePlayerTwoScore()
    {
        score.increasePlayerTwoScore();
        updateScoreText();
    }

    public String getNameFromPlayerNumber(int playerNumber)
    {
        if (playerNumber == 1)
            return playerOneName;
        else
            return playerTwoName;
    }
}
