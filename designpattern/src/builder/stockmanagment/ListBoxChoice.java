package src.builder.stockmanagment;

import javax.swing.*;
import java.util.List;

public class ListBoxChoice extends MultiChoice {
    JawtList list;
    //--------------------------------------------
    public ListBoxChoice(List choices) {
        super(choices);
    }
    //--------------------------------------------
    public JPanel getUI() {
        //create a panel containing a list box
        JPanel p = new JPanel();
        list = new JawtList(choices.size());
        list.setMultipleMode(true);
        p.add(list);
        for (int i=0; i< choices.size(); i++)
            list.add((String)choices.get(i));
        return p;
    }
    //--------------------------------------------
    public String[] getSelected() {
        String[] slist = list.getSelectedItems ();
        return(slist);
    }
    //--------------------------------------------
    public void clearAll() {
        //unselect all lines in the list
        for (int i=0; i < choices.size(); i++)
            list.deselect(i);
    }
}
