package gameComponents.columnSelector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import gameComponents.ObservableComponent;

public class ColumnSelector extends ObservableComponent
{
    private ColumnSelectorUI columnSelectorUI;
    private JButton[] buttons;
    private int column;
    private boolean buttonPressed;

    public ColumnSelector()
    {
        columnSelectorUI = new ColumnSelectorUI();
        
        registerColumnButtonListener();
    }

    private void registerColumnButtonListener()
    {
        buttons = columnSelectorUI.getButtons();

        for (JButton button : buttons)
        {
            button.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    buttonPressed = true;
                    JButton currentButton = (JButton) e.getSource();
                    int position = getButtonPositionInArray(currentButton, buttons);
                    placeToken(position);
                }

                private void placeToken(int position)
                {
                    setColumn(position);
                    notifyChanges();
                }

                private void setColumn(int position)
                {
                    column = position;
                }
            });
        }
    }

    public int getButtonPositionInArray(JButton button, JButton[] buttons)
    {
        for (int index = 0; index < buttons.length; index++)
        {
            if (button.equals(buttons[index])) return index;
        }
        return -1;
    }
    
    public JPanel getColumnSelectorPanel()
    {
        return columnSelectorUI.getSelectorButtonPanel();
    }
    
    public int getCurrentColumn()
    {
        return column;
    }
    
    public ColumnSelectorUI getColumnSelectorUI()
    {
        return columnSelectorUI;
    }
    
    public JButton[] getButtons()
    {
        return columnSelectorUI.getButtons();
    }
    
    public void disablButtonPressed()
    {
        buttonPressed = false;
    }
    
    public boolean isButtonPressed()
    {
        return buttonPressed;
    }
}
