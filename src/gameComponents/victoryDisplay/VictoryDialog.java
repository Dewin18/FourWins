package gameComponents.victoryDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VictoryDialog
{
    private VictoryDialogUI victoryDialogUI;
    
    public VictoryDialog(String winnerName)
    {
        victoryDialogUI = new VictoryDialogUI();
        victoryDialogUI.setWinner(winnerName);
        
        registerVictoryDialogListener();
        victoryDialogUI.showDialog();
    }

    private void registerVictoryDialogListener()
    {
        victoryDialogUI.getRevancheButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                victoryDialogUI.getVictoryDialog().dispose();
            }
        });
        
        victoryDialogUI.getExitButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
    }
}
