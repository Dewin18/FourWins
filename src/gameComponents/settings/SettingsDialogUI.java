package gameComponents.settings;

import javax.swing.JDialog;

public class SettingsDialogUI
{
    private JDialog settingsDialog;
    
    public SettingsDialogUI()
    {
        initSettingsDialog();
    }

    private void initSettingsDialog()
    {
        settingsDialog = new JDialog();
    }

    public void showDialog()
    {
        settingsDialog.setLocationRelativeTo(null);
        settingsDialog.setVisible(true);
    }

}
