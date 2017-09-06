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
    private final int DISPLAY_FONT_SIZE = 25;

    private JPanel southPanel;
    private JPanel displayPanel;
    private JLabel playerOneName;
    private JLabel playerTwoName;
    private JLabel scoreText;
    private Score score;

    public ScoreDisplay()
    {
        initSouthDisplay();
        initDisplayPanel();
        initPlayerNames();
        initScore();
        initFont();
        combineNamesAndScore();
    }

    private void initSouthDisplay()
    {
        southPanel = new JPanel();
        
        southPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        southPanel.setPreferredSize(new Dimension(GamePanel.WIDTH, 38));
    }

    private void initDisplayPanel()
    {
        
        displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(GamePanel.WIDTH - 22, 36));
        displayPanel.setBackground(Color.BLACK);

        southPanel.add(displayPanel);
    }

    private void initPlayerNames()
    {
        playerOneName = new JLabel(getPlayerOneName());
        playerTwoName = new JLabel(getPlayerTwoName());
    }

    private String getPlayerOneName()
    {
        return "Player 1" + generateEmptyString(NO_OF_BLANKS);
    }

    private String getPlayerTwoName()
    {
        return generateEmptyString(NO_OF_BLANKS) + "Player 2";
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
        score = new Score();

        String playerOneNameAndScore = score.getPlayerOneScoreText();
        String playerTwoNameAndScore = score.getPlayerTwoScoreText();
        String nameScoreText = buildNameScoreText(playerOneNameAndScore,
                playerTwoNameAndScore);

        scoreText = new JLabel(nameScoreText);
    }

    private String buildNameScoreText(String playerOneNameAndScore,
            String playerTwoNameAndScore)
    {
        StringBuilder nameScoreText = new StringBuilder();

        nameScoreText.append(playerOneNameAndScore);
        nameScoreText.append("  -  ");
        nameScoreText.append(playerTwoNameAndScore);

        return nameScoreText.toString();
    }

    private void initFont()
    {
        Font scoreDisplayFont = new Font("Arial", Font.BOLD, DISPLAY_FONT_SIZE);

        playerOneName.setFont(scoreDisplayFont);
        playerOneName.setForeground(Color.RED);

        playerTwoName.setFont(scoreDisplayFont);
        playerTwoName.setForeground(Color.YELLOW);

        scoreText.setFont(scoreDisplayFont);
        scoreText.setForeground(Color.GRAY);
    }

    private void combineNamesAndScore()
    {
        displayPanel.add(playerOneName);
        displayPanel.add(scoreText);
        displayPanel.add(playerTwoName);
    }
    
    public JPanel getSouthPanel()
    {
        return southPanel;
    }
}
