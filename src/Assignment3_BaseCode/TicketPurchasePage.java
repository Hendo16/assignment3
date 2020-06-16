package Assignment3_BaseCode;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class TicketPurchasePage extends JPanel{
    private TicketPurchaseSystem ticket;
    private final JButton backbutt;
    private final JButton subbutt;
    private final JButton clearbutt;
    private ButtonGroup ticketgroup;
    private ButtonGroup discountgroup;
    private JRadioButton EconomyClass;
    private JRadioButton BusinessClass;
    private JRadioButton FirstClass;
    private JRadioButton CardDiscount;
    private JRadioButton Coupon;
    private JRadioButton None;
    private JTextField IDField;
    private JTextField NameField;
    private JTextField DepartureField;
    private JTextField DestinationField;
    private JTextField FlightNumField;
    private JTextField PriceField;
    private JTextField DiscountField;
    private JLabel DiscountLabel;

    public TicketPurchasePage(TicketPurchaseSystem tick){
        ticket = tick;
        //Building the UI Elements
        backbutt = new JButton("Back");
        subbutt = new JButton("Submit");
        clearbutt = new JButton("Clear");
        ticketgroup = new ButtonGroup();
        discountgroup = new ButtonGroup();
        JLabel IDlabel = new JLabel("ID");
        JLabel Namelabel = new JLabel("Please enter your name");
        JLabel DepartureLabel = new JLabel("Please enter Departure Location");
        JLabel DestinationLabel = new JLabel("Please enter your Destination");
        JLabel FlightNumLabel = new JLabel("Please enter the Flight Number ");
        JLabel PriceLabel = new JLabel("Price: ");
        JLabel TicketType = new JLabel("Please select a Ticket type ");
        JLabel DiscountType = new JLabel("Please select a Discount type ");
        DiscountLabel = new JLabel();

        EconomyClass = new JRadioButton();
        BusinessClass = new JRadioButton();
        FirstClass = new JRadioButton();
        EconomyClass.setSelected(true);
        EconomyClass.setText("Economy Class");
        BusinessClass.setText("Business Class");
        FirstClass.setText("First Class");
        EconomyClass.setBounds(120,30,120,50);
        BusinessClass.setBounds(250,30,80,50);
        FirstClass.setBounds(350,30,40,50);

        ticketgroup.add(EconomyClass);
        ticketgroup.add(BusinessClass);
        ticketgroup.add(FirstClass);

        CardDiscount = new JRadioButton();
        Coupon = new JRadioButton();
        None = new JRadioButton();
        None.setSelected(true);
        CardDiscount.setText("Card Discount");
        Coupon.setText("Coupon");
        None.setText("None");
        CardDiscount.setBounds(120,30,120,50);
        Coupon.setBounds(250,30,80,50);
        None.setBounds(350,30,40,50);

        discountgroup.add(CardDiscount);
        discountgroup.add(Coupon);
        discountgroup.add(None);

        IDField = new JTextField(5);
        NameField = new JTextField(10);
        DepartureField = new JTextField(20);
        DestinationField = new JTextField(20);
        FlightNumField = new JTextField(5);
        PriceField = new JTextField(5);
        DiscountField = new JTextField(5);

        //Disabling Coupon Field so it doesn't appear unless selected
        DiscountField.setVisible(false);

        //Adding Action Listeners
        subbutt.addActionListener(e -> ReturnTicketPurchaseInfo());
        backbutt.addActionListener(e -> backToPreviousPage());
        clearbutt.addActionListener(e -> clear());
        //If discount is selected, the discount field and label will appear
        CardDiscount.addActionListener(e -> EnableID());
        Coupon.addActionListener(e -> EnableID());
        None.addActionListener(e -> {DiscountField.setVisible(false);DiscountLabel.setText("");CheckIfFieldsAreEmpty();});

        EconomyClass.setActionCommand("EconomyClass");
        BusinessClass.setActionCommand("BusinessClass");
        FirstClass.setActionCommand("FirstClass");
        None.setActionCommand("None");
        CardDiscount.setActionCommand("Card Discount");
        Coupon.setActionCommand("Coupon");


        //Check to see if the Fields are empty; If they are, the submit button is disabled
        CheckingFields check = new CheckingFields();
        IDField.getDocument().addDocumentListener(check);
        NameField.getDocument().addDocumentListener(check);
        DepartureField.getDocument().addDocumentListener(check);
        DestinationField.getDocument().addDocumentListener(check);
        FlightNumField.getDocument().addDocumentListener(check);
        PriceField.getDocument().addDocumentListener(check);
        DiscountField.getDocument().addDocumentListener(check);
        subbutt.setEnabled(false);

        //Adding everything to the Panel
        setLayout(new FlowLayout());
        add(IDlabel);
        add(IDField);
        add(Namelabel);
        add(NameField);
        add(DepartureLabel);
        add(DepartureField);
        add(DestinationLabel);
        add(DestinationField);
        add(FlightNumLabel);
        add(FlightNumField);
        add(TicketType);
        add(EconomyClass);
        add(BusinessClass);
        add(FirstClass);
        add(DiscountType);
        add(None);
        add(Coupon);
        add(CardDiscount);
        add(DiscountLabel);
        add(DiscountField);
        add(PriceLabel);
        add(PriceField);
        add(subbutt);
        add(backbutt);
        add(clearbutt);
        setSize(300, 600);
    }
    public void EnableID(){
        DiscountField.setVisible(true);
        if(discountgroup.getSelection().getActionCommand() == "Coupon"){
            DiscountLabel.setText("Please enter Coupon ID");
        }
        else{
            DiscountLabel.setText("Please enter Card ID");
        }
        CheckIfFieldsAreEmpty();
    }
    private void clear(){
        IDField.setText("");
        NameField.setText("");
        DepartureField.setText("");
        DestinationField.setText("");
        FlightNumField.setText("");
        PriceField.setText("");
        DiscountField.setText("");
    }
    private void backToPreviousPage(){
        ticket.backToMainMenu();
    }
    private void ReturnTicketPurchaseInfo(){
        String[] output = new String[9];
        output[0] = IDField .getText();
        output[1] = NameField .getText();
        output[2] = DepartureField.getText();
        output[3] = DestinationField.getText();
        output[4] = FlightNumField.getText();
        output[5] = PriceField.getText();
        output[6] = ticketgroup.getSelection().getActionCommand();
        output[7] = discountgroup.getSelection().getActionCommand();
        //If coupon is selected, store the Coupon ID
        if(discountgroup.getSelection().getActionCommand() != "None"){
            output[8] = DiscountField.getText();
        }
        backToPreviousPage();
        ticket.createNewTicketAndRecordFromInfo(output);
    }
    private void CheckIfFieldsAreEmpty(){
        //Enabling the Submit button only if all the fields aren't empty
        boolean value = false;
        if(
                IDField.getText().trim().length() != 0 &&
                NameField.getText().trim().length() != 0 &&
                DepartureField.getText().trim().length() != 0 &&
                DestinationField.getText().trim().length() != 0 &&
                FlightNumField.getText().trim().length() != 0 &&
                PriceField.getText().trim().length() != 0){
            if((discountgroup.getSelection().getActionCommand() != "None" && DiscountField.getText().trim().length() != 0)){
                value = true;
            }
            else if (discountgroup.getSelection().getActionCommand() == "None"){
                value = true;
            }
        }
        subbutt.setEnabled(value);
    }
    private class CheckingFields implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent documentEvent) {
            CheckIfFieldsAreEmpty();
        }

        @Override
        public void removeUpdate(DocumentEvent documentEvent) {
            CheckIfFieldsAreEmpty();
        }

        @Override
        public void changedUpdate(DocumentEvent documentEvent) {
            CheckIfFieldsAreEmpty();
        }
    }
}