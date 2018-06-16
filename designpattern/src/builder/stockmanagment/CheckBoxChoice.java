package src.builder.stockmanagment;
import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
public class CheckBoxChoice extends MultiChoice {
    //This derived class creates
    //vertical grid of checkboxes
    int count;           //number of checkboxes
    JPanel p;             //contained in here
    //--------------------------------------------
    public CheckBoxChoice(List choices) {
        super(choices);
        count = 0;
        p = new JPanel();
    }
    //--------------------------------------------
    public JPanel getUI() {
        String s;

        //create a grid layout 1 column by n rows
        p.setLayout(new GridLayout(choices.size(), 1));
        //and add labeled check boxes to it
        for (int i=0; i< choices.size(); i++) {
            s =(String)choices.get(i);
            p.add(new JCheckBox(s));
            count++;
        }
        return p;
    }
    //--------------------------------------------
    public String[] getSelected() {
        JCheckBox cb;
        List<String> clist = new ArrayList<>();
        //Copy checkboxes what are checked
        for (int i = 0; i < count; i++ ) {
            cb = (JCheckBox)p.getComponent(i);
            if (cb.isSelected ())
                clist.add(cb.getText());
        }
        //create a string array the size of the
        //number of checked boxes
        String[] slist = new String[clist.size()];

        //copy labels of chekced boxes into
        //the string array
        for (int i = 0; i < clist.size(); i++)
            slist[i] = clist.get(i);
        return(slist);
    }
    //--------------------------------------------
    public void clearAll() {
        //uncheck all boxes
        for (int i=0; i < count; i++) {
            ((Checkbox)(p.getComponent(i))).setState(false);
        }
    }
}