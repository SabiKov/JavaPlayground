package src.builder.stockmanagment;

import java.util.List;

public class ChoiceFactory {
    MultiChoice ui;
    //This class returns a Panel containing
    //a set of choices displayed by one of
    //several UI methods.
    public MultiChoice getChoiceUI(List choices) {
        if (choices.size() <=3)
            //return a panel of checkboxes
            ui = new CheckBoxChoice(choices);
        else if(choices.size() >=5) {
            ui = new RadioButtonChoice(choices);
        }
        else {
            //return a multi-select listbox panel
            ui = new ListBoxChoice(choices);
        }
        return ui;
    }
}
