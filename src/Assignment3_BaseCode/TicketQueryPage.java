package Assignment3_BaseCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicketQueryPage extends JPanel{
    private TicketPurchaseSystem ticketSystem;
    private JTextField idField;
    private final JButton subbutt;
    private final JButton backbutt;
    private final JButton clearbutt;
    public TicketQueryPage(TicketPurchaseSystem system){
        ticketSystem = system;
        subbutt = new JButton("Submit");
        clearbutt = new JButton("Clear");
        backbutt = new JButton("Back");
        JLabel dialog = new JLabel();
        idField = new JTextField(20);

        idField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                idField.setText("");
            }
        });

        subbutt.addActionListener(e -> returnQueryInfoToSystem());
        backbutt.addActionListener(e -> backToPreviousPage());
        clearbutt.addActionListener(e -> clear());
        setLayout(new FlowLayout());
        add(dialog);
        add(idField);
        add(subbutt);
        add(backbutt);
        add(clearbutt);
    }
    public void openRequestForTicket(){
        idField.setText("Please enter ticket ID");
    }
    private void clear(){
        idField.setText("");
    }
    private void backToPreviousPage(){
        ticketSystem.backToMainMenu();
    }
    private void returnQueryInfoToSystem(){
        String ticketID = idField.getText();
        ticketSystem.displayTicketInfo(ticketID);
    }
}
