package gameComponents.settings;

import java.awt.*;
import javax.swing.*;

public class SettingsDialogUI
{
    private JDialog settingsDialog;
    private JPanel settingsPanel;
    private JPanel buttonPanel;
    private JPanel nameTextFieldPanel;
    private JPanel titlePanel;

    private JLabel changeNameTitle;
    private JLabel playerOneTitle;
    private JLabel playerTwoTitle;

    private JTextField playerOneTextField;
    private JTextField playerTwoTextField;

    private JButton save;
    private JButton cancel;

    public SettingsDialogUI()
    {
        initSettingsDialog();
        initSettingsPanel();
        initTitles();
        initTitlePanel();
        initNameTextFields();
        initNameTextFieldPanel();
        initButtonPanel();
        initButtons();
        combineComponents();
    }

    private void initSettingsDialog()
    {
        settingsDialog = new JDialog();
    }

    private void initSettingsPanel()
    {
        settingsPanel = new JPanel();
        settingsPanel.setLayout(new BorderLayout());
        settingsPanel.setPreferredSize(new Dimension(300, 180));
        settingsPanel.setMaximumSize(new Dimension(400, 180));
    }

    private void initTitles()
    {
        changeNameTitle = new JLabel("Change names");
        changeNameTitle.setFont(new Font("Arial", Font.BOLD, 20));
        changeNameTitle.setForeground(Color.WHITE);
        
        playerOneTitle = new JLabel("Set new player one name: ");
        playerTwoTitle = new JLabel("Set new player two name: ");
    }

    private void initTitlePanel()
    {
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.DARK_GRAY);
        titlePanel.setPreferredSize(new Dimension(0, 50));
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        titlePanel.add(changeNameTitle);
    }

    private void initNameTextFields()
    {
        playerOneTextField = new JTextField();
        playerOneTextField.setPreferredSize(new Dimension(100, 30));
        playerTwoTextField = new JTextField();
        playerTwoTextField.setPreferredSize(new Dimension(100, 30));
    }

    private void initNameTextFieldPanel()
    {
        nameTextFieldPanel = new JPanel();
        nameTextFieldPanel.setBackground(Color.GRAY);

        nameTextFieldPanel.add(playerOneTitle);
        nameTextFieldPanel.add(playerOneTextField);
        nameTextFieldPanel.add(playerTwoTitle);
        nameTextFieldPanel.add(playerTwoTextField);
    }

    private void initButtonPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.setLayout(new FlowLayout());
    }

    private void initButtons()
    {
        save = new JButton("save");
        cancel = new JButton("cancel");

        buttonPanel.add(save);
        buttonPanel.add(cancel);
    }

    private void combineComponents()
    {
        settingsPanel.add(titlePanel, BorderLayout.NORTH);
        settingsPanel.add(nameTextFieldPanel, BorderLayout.CENTER);
        settingsPanel.add(buttonPanel, BorderLayout.SOUTH);

        settingsDialog.add(settingsPanel);
    }

    public void showDialog()
    {
        settingsDialog.pack();
        settingsDialog.setLocationRelativeTo(null);
        settingsDialog.setModal(true);
        settingsDialog.setResizable(false);
        settingsDialog.setVisible(true);
    }

    public JDialog getSettingsDialog()
    {
        return settingsDialog;
    }
    
    public JButton getSaveButton()
    {
        return save;
    }
    
    public JButton getCancelButton()
    {
        return cancel;
    }
    
    public JTextField getPlayerOneNameTextField()
    {
        return playerOneTextField;
    }
    
    public JTextField getPlayerTwoNameTextField()
    {
        return playerTwoTextField;
    }
}
