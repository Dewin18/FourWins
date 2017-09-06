package gameComponents.columnSelector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import gameComponents.playField.PlayFieldHandler;

public class ColumnSelector extends JPanel
{
    private static final long serialVersionUID = 1L;

    private ColumnSelectorUI columnSelectorUI;
    private JButton[] buttons;
    private PlayFieldHandler playFieldHandler;

    public ColumnSelector(PlayFieldHandler playField)
    {
        this.playFieldHandler = playField;

        columnSelectorUI = new ColumnSelectorUI();

        add(columnSelectorUI.getSelectorButtonPanel());
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
                    JButton button = (JButton) e.getSource();
                    int position = getButtonPositionInArray(button, buttons);
                    placeToken(position);
                }

                private void placeToken(int position)
                {
                    playFieldHandler.placeToken(position);
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
}
