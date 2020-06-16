package Assignment3_BaseCode;

import javax.swing.*;
import java.awt.*;

public class TicketDisplayPage extends JPanel{
    private TicketPurchaseSystem ticket;
    private JTextArea textArea;
    private final JButton butt;

    public TicketDisplayPage(TicketPurchaseSystem tick){
        ticket = tick;
        this.textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        this.butt = new JButton("Back");
        setLayout(new FlowLayout());
        add(textArea);
        add(butt);
        butt.addActionListener(e -> backToPreviousPage());
    }
    public void displayInformationToList(String[] content){
        clear();
        for(String s: content){
            textArea.append(s+"\n");
        }
    }
    private void clear(){
        textArea.setText("");
    }
    private void backToPreviousPage(){
        ticket.backToMainMenu();
    }
}