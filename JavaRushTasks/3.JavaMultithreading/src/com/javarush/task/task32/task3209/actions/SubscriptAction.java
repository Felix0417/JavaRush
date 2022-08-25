package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

public class SubscriptAction extends StyledEditorKit.StyledTextAction {
    /**
     * Creates a new StyledTextAction from a string action name.
     *
     * @param "Подстрочный знак" the name of the action
     */
    public SubscriptAction() {
        super("Подстрочный знак");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
