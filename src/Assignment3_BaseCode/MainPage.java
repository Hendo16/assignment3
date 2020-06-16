package Assignment3_BaseCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JPanel {
    private MainSystem main;
    private final JButton newbutt;
    private final JButton newtick;
    private final JButton searchNamebutt;
    private final JButton searchIDbutt;
    private final JButton searchTicketbutt;
    private final JButton quitbutt;
    public MainPage(MainSystem main){
        this.main = main;
        quitbutt = new JButton("Exit Application");
        newbutt = new JButton("Create New Card");
        newtick = new JButton("Create New Ticket");
        searchNamebutt = new JButton("Search for Card via Name");
        searchIDbutt = new JButton("Search for Card via Card ID");
        searchTicketbutt = new JButton("Search for Ticket");

        searchNamebutt.setName("Name");
        searchIDbutt.setName("ID");

        quitbutt.addActionListener(e -> System.exit(0));
        newbutt.addActionListener(e -> registerNewCard());
        newtick.addActionListener(e -> buyTicket());
        searchTicketbutt.addActionListener(e -> ticketSearch());
        searchNamebutt.addActionListener(new CardSorter());
        searchIDbutt.addActionListener(new CardSorter());

        setLayout(new FlowLayout());
        add(newbutt);
        add(newtick);
        add(searchNamebutt);
        add(searchIDbutt);
        add(searchTicketbutt);
        add(quitbutt);
    }
    private void registerNewCard(){
        main.createCardWithPage();
    }
    private class CardSorter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton) e.getSource()).getName();
            main.queryCardWithPage(name);
        }
    }
    private void buyTicket(){
        main.createTicketWithPage();
    }
    private void ticketSearch(){
        main.queryTicketWithPage();
    }
}