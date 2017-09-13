package gameComponents.settings;

import java.awt.Dimension;

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
        settingsDialog.setPreferredSize(new Dimension(200, 300));
    }

    public void showDialog()
    {
        settingsDialog.pack();
        settingsDialog.setLocationRelativeTo(null);
        settingsDialog.setModal(true);
        settingsDialog.setVisible(true);
    }

    public JDialog getSettingsDialog()
    {
        return settingsDialog;
    }
}
