package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartDialogHandler
{
    private StartDialog startDialog;
    
    public StartDialogHandler()
    {
        startDialog = new StartDialog();
        registerDialogListener();
        startDialog.showDialog();
    }

    private void registerDialogListener()
    {
        startDialog.getStartGameButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                closeDialog();
                startDialog.createGameFrame();
                
            }
        });
        
        startDialog.getExitButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                closeDialog();
            }
        });
    }
    
    private void closeDialog()
    {
        startDialog.getDialog().dispose();
    }
}
