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
    
    private JPanel nameAndIconPanel;
    private JPanel buttonPanel;

    public VictoryDialogUI()
    {
    	initNameAndIconPanel();
        initVictoryDialog();
        initButtonPanel();
        insertPanelsIntoJDialog();
    }

    private void initNameAndIconPanel()
    {
    	nameAndIconPanel = new JPanel();
    	nameAndIconPanel.setLayout(new FlowLayout());
    	
        loadCrownicon();
        initCrownLabel();
        initWinnerNameLabel();
        
        nameAndIconPanel.add(crownLabel);
        nameAndIconPanel.add(winnerName);
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
    
	private void initCrownLabel()
    {
        crownLabel = new JLabel();
        crownLabel.setIcon(new ImageIcon(crownImage));
    }
	
    private void initWinnerNameLabel()
    {
        winnerName = new JLabel();
    }

	private void initButtonPanel() 
    {
    	buttonPanel = new JPanel();	
    	buttonPanel.setLayout(new FlowLayout());
    	
    	initButtons();
	}

    private void initVictoryDialog()
    {
        victoryDialog = new JDialog();
        victoryDialog.setLayout(new BorderLayout());
    }

    private void initButtons()
    {
        revanche = new JButton("Revanche");
        exit = new JButton("Exit");

        buttonPanel.add(revanche);
        buttonPanel.add(exit);
    }

    private void insertPanelsIntoJDialog()
    {
        victoryDialog.add(nameAndIconPanel, BorderLayout.NORTH);
        victoryDialog.add(buttonPanel, BorderLayout.SOUTH);
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
