package gameComponents.victoryDisplay;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class VictoryDialogUI
{
    private JDialog victoryDialog;
    private JButton revanche;
    private JButton exit;
    private BufferedImage crownImage;
    private JLabel crownLabel;
    private JLabel winnerName;

    public VictoryDialogUI()
    {
        loadCrownicon();
        initCrownLabel();
        initWinnerLabel();
        initVictoryDialog();
        initButtons();
        insertButtonsIntoDialog();
    }

    private void initCrownLabel()
    {
        crownLabel = new JLabel();
        crownLabel.setIcon(new ImageIcon(crownImage));
    }

    private void loadCrownicon()
    {
        try
        {
            crownImage = ImageIO
                .read(getClass().getResourceAsStream("/crownIcon.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void initWinnerLabel()
    {
        winnerName = new JLabel();
    }

    private void initVictoryDialog()
    {
        victoryDialog = new JDialog();
        victoryDialog.setLayout(new FlowLayout());
        victoryDialog.setPreferredSize(new Dimension(200, 110));
    }

    private void initButtons()
    {
        revanche = new JButton("Revanche");
        exit = new JButton("Exit");
    }

    private void insertButtonsIntoDialog()
    {
        victoryDialog.add(crownLabel);
        victoryDialog.add(winnerName);
        victoryDialog.add(revanche);
        victoryDialog.add(exit);
    }

    public void showDialog()
    {
        victoryDialog.pack();
        victoryDialog.setLocationRelativeTo(null);
        victoryDialog.setModal(true);
        victoryDialog.setVisible(true);
    }

    public JButton getRevancheButton()
    {
        return revanche;
    }

    public JButton getExitButton()
    {
        return exit;
    }

    public JDialog getVictoryDialog()
    {
        return victoryDialog;
    }

    public void setWinner(String winner)
    {
        winnerName.setText(winner + " wins!");
    } 
}
