package gameComponents.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Settings
{
    SettingsUI settingsUI;
    SettingsDialog settingsDialog;

    public Settings()
    {
        settingsUI = new SettingsUI();
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
                    settingsDialog = new SettingsDialog();
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
}
