package gameComponents.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;

import gameComponents.ComponentObserver;

public class Settings //TODO 
{
    private SettingsUI settingsUI;
    private SettingsDialog settingsDialog;

    public Settings(SettingsDialog settingsDialog)
    {
        settingsUI = new SettingsUI();
        this.settingsDialog = settingsDialog;
        registerSettingPanelListener();
    }

    public JPanel getSettingsPanel()
    {
        return settingsUI.getSettingPanel();
    }

    private void registerSettingPanelListener()
    {
        settingsUI.getSettingsButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    settingsDialog.getSettingsDialogUI().showDialog();
                }
            });

        settingsUI.getExitButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    System.exit(0);
                }
            });
    }

    public void updatePlayTime()
    {
        settingsUI.updateElapsedTime();
    }
    
    public SettingsDialog getSettingsDialog()
    {
        return settingsDialog;
    }
}
