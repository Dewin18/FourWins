package gameComponents.victoryDisplay;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;

public class VictoryDialogUI
{
    private JDialog victoryDialog;
    private JButton revanche;
    private JButton exit;

    public VictoryDialogUI()
    {
        initVictoryDialog();
        initButtons();
        insertButtonsIntoDialog();
    }

    private void initVictoryDialog()
    {
        victoryDialog = new JDialog();
        victoryDialog.setLayout(new FlowLayout());
        victoryDialog.setPreferredSize(new Dimension(200, 100));
    }

    private void initButtons()
    {
        revanche = new JButton("Revanche");
        exit = new JButton("Exit");
    }

    private void insertButtonsIntoDialog()
    {
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
    
}
