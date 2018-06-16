package src.builder.stockmanagment;

import javax.swing.*;
import java.util.List;

public abstract class MultiChoice {
    //This is the abstract base class
    //that the listBox and checkbox choice panels
    //are derived from
    protected List choices;    //array of labels

    public MultiChoice(List choiceList) {
        choices = choiceList;    //save list
    }
    //to be implemented in derived classes
    abstract public JPanel getUI();         //return a Panel of components
    abstract public String[] getSelected();   //get a list those selected
    abstract public void clearAll();       //clear all the selected items
}
