package Assignment3_BaseCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {
    private MainSystem main;
    private final JButton newbutt;
    private final JButton searchNamebutt;
    private final JButton searchIDbutt;
    private final JButton quitbutt;
    public MainPage(MainSystem main){
        this.main = main;
        quitbutt = new JButton("Exit Application");
        newbutt = new JButton("Create New Card");
        searchNamebutt = new JButton("Search for Card via Name");
        searchIDbutt = new JButton("Search for Card via Card ID");

        searchNamebutt.setName("Name");
        searchIDbutt.setName("ID");

        quitbutt.addActionListener(e -> System.exit(0));
        newbutt.addActionListener(e -> registerNewCard());
        CardSorter handler = new CardSorter();
        searchNamebutt.addActionListener(handler);
        searchNamebutt.addActionListener(handler);

        setLayout(new FlowLayout());
        add(newbutt);
        add(searchNamebutt);
        add(searchIDbutt);
        add(quitbutt);
    }
    public void mainMenu(){}
    private void registerNewCard(){}
    private void queryCard(){}
    private class CardSorter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String test = ((JButton) e.getSource()).getActionCommand();
            System.out.println(test);
        }
    }
    private void buyTicket(){}
}