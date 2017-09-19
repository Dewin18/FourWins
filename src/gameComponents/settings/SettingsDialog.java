package gameComponents.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gameComponents.ObservableComponent;

public class SettingsDialog extends ObservableComponent
{
    private SettingsDialogUI settingsDialogUI;
    private boolean namesChanged = false;
    private String playerOneName;
    private String playerTwoName;

    public SettingsDialog()
    {
        settingsDialogUI = new SettingsDialogUI();
        registerSettingsDialogListener();
        //settingsDialogUI.showDialog();

    }

    private void registerSettingsDialogListener()
    {
        settingsDialogUI.getSaveButton()
            .addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    storeNewNames();
                    settingsDialogUI.getSettingsDialog()
                        .dispose();
                    
                    namesChanged = true;
                    notifyChanges();
                }

                private void storeNewNames()
                {
                    playerOneName = settingsDialogUI.getPlayerOneNameTextField()
                        .getText();

                    playerTwoName = settingsDialogUI.getPlayerTwoNameTextField()
                        .getText();
                }
            });

        settingsDialogUI.getCancelButton()
            .addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    settingsDialogUI.getSettingsDialog()
                        .dispose();
                }
            });
    }

    public String getPlayerOneName()
    {
        return playerOneName;
    }

    public String getPlayerTwoName()
    {
        return playerTwoName;
    }

    public boolean namesAreChanged()
    {
        return namesChanged;
    }
    
    public void disableNamesAreChanged()
    {
        namesChanged = false;
    }

    public SettingsDialogUI getSettingsDialogUI()
    {
        return settingsDialogUI;
    }
}
