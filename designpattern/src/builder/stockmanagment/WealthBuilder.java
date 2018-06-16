package src.builder.stockmanagment;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class WealthBuilder extends JxFrame
        implements ListSelectionListener, ActionListener {
    private JawtList stockList;         //list of funds
    private JButton plot;               //plot command button
    private JPanel choicePanel;         //right panel
    private MultiChoice multiChoice;        //ui for right panel
    private List<String> bonds;
    private List<String> stocks;
    private List<String> mutuals;   //3 lists of investments
    private List<String> japanese;
    private ChoiceFactory choiceFactory;        //the factory

    public WealthBuilder() {
        super("Wealth Builder");     //frame title bar
        setGUI();                    //set up display
        buildStockLists();           //create stock lists
        choiceFactory = new ChoiceFactory(); //create builder-factory
    }
    //----------------------------------
    private void setGUI() {
        JPanel jp = new JPanel();
        getContentPane().add (jp);
        jp.setLayout(new BorderLayout());
        JPanel p = new JPanel();
        jp.add("Center", p);

        //center contains left and right panels
        p.setLayout(new GridLayout(1,2));
        stockList= new JawtList(10);              //left is list of stocks
        stockList.addListSelectionListener(this);
        p.add(stockList);
        stockList.add("Stocks");
        stockList.add("Bonds");
        stockList.add("Mutual Funds");
        stockList.add("Japan Stock");
        stockList.addListSelectionListener(this);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.lightGray);
        jp.add("South", p1);
        plot = new JButton("Plot");
        plot.setEnabled(false);        //disabled until stock picked
        plot.addActionListener(this);
        p1.add(plot);
        //right is empty at first
        choicePanel = new JPanel();
        choicePanel.setBackground(Color.lightGray);
        p.add(choicePanel);

        setBounds(100, 100, 300, 200);
        setVisible(true);
    }
    //----------------------------------
    public void valueChanged(ListSelectionEvent e) {
        //click on list box happens here
        stockListClick();
    }
    //----------------------------------
    public void actionPerformed(ActionEvent ev) {
        //click on "plot" button sent here
        PlDialog pl = new PlDialog(this, multiChoice);
        pl.show();
    }
    //----------------------------------
    private void stockListClick() {
        List<String> list = null;
        int index = stockList.getSelectedIndex();
        choicePanel.removeAll();  //remove previous ui panel

        //this just switches between 3 different Vectors
        //and passes the one you select to the Builder pattern
        switch (index) {
            case 0:
                list = stocks;  break;
            case 1:
                list = bonds;   break;
            case 2:
                list = mutuals; break;
            case 3:
                list = japanese; break;
            default:
                break;
        }
        multiChoice = choiceFactory.getChoiceUI(list);    //get one of the UIs
        choicePanel.add(multiChoice.getUI());    //insert in right panel
        choicePanel.validate();         //re-layout and display
        choicePanel.repaint ();
        plot.setEnabled(true);          //allow plots
    }
    //----------------------------------
    private void buildStockLists() {
        //arbitrary list of stock, bond and fund holdings
        bonds = new ArrayList<>();
        bonds.add("CT State GO 2012");
        bonds.add("New York GO 2005");
        bonds.add("GE Corp Bonds");

        stocks = new ArrayList<>();
        stocks.add("Cisco");
        stocks.add("Coca Cola");
        stocks.add("General Electric");
        stocks.add("Harley Davidson");
        stocks.add("IBM");
        stocks.add("Harley Davidson");

        mutuals = new ArrayList<>();
        mutuals.add("Fidelity Magellan");
        mutuals.add("T Rowe Price");
        mutuals.add("Vanguard PrimeCap");
        mutuals.add("Lindner Fund");

        japanese = new ArrayList<>();
        japanese.add("Toyota");
        japanese.add("Honda");
        japanese.add("Mazda");
        japanese.add("Suzuki");
        japanese.add("Mitsubishi");
        japanese.add("Isuzu");




    }
    //----------------------------------
    static public void main(String[] argv) {
        new WealthBuilder();
    }
}