package src.builder.stockmanagment;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RadioButtonChoice extends MultiChoice {

    JPanel radioButtonChoicePanel;
    public RadioButtonChoice(List choiceList) {
        super(choiceList);
    }

    @Override
    public JPanel getUI() {
        this.radioButtonChoicePanel = new JPanel();
        ButtonGroup group = new ButtonGroup();
        JRadioButton[] radioButtons = new JRadioButton[choices.size()];
        radioButtonChoicePanel.setLayout(
                new GridLayout(choices.size(), 1));
        for(int i = 0; i < radioButtons.length; i++) {
            radioButtons[i] = new JRadioButton((String) choices.get(i));
            group.add(radioButtons[i]);
        }
        for(int i = 0; i < radioButtons.length; i++) {
            this.radioButtonChoicePanel.add(radioButtons[i]);
        }
        return radioButtonChoicePanel;
    }

    @Override
    public String[] getSelected() {
        JRadioButton rb;
        List<String> rbList = new ArrayList<>();
        for(int i = 0; i < choices.size(); i++) {
            rb = (JRadioButton)radioButtonChoicePanel.getComponent(i);
            if(rb.isSelected()) {
                rbList.add(rb.getText());
            }
        }
        String[] rbChoice = {rbList.get(0)};
        return rbChoice;
    }

    @Override
    public void clearAll() {

    }
}
