package Assignment3_BaseCode;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class CardRegisterPage extends JPanel {
    private CardAndUserRegisterSystem cardRegister;
    private final JButton backbutt;
    private final JButton subbutt;
    private final JButton clearbutt;
    private ButtonGroup group;
    private JRadioButton platnium;
    private JRadioButton titanium;
    private JTextField IDField;
    private JTextField NameField;
    private JTextField AddressField;

    public CardRegisterPage(CardAndUserRegisterSystem system){
        cardRegister = system;
        backbutt = new JButton("Back");
        subbutt = new JButton("Submit");
        clearbutt = new JButton("Clear");
        group = new ButtonGroup();
        JLabel IDlabel = new JLabel("ID");
        JLabel Namelabel = new JLabel("Please enter your name");
        JLabel Addresslabel = new JLabel("Please enter your address, separating each section with a comma.");
        JLabel Examplelabel = new JLabel("Example: 1, Loop Rd, Wollongong, Sydney, NSW, 1234");
        JLabel typelabel = new JLabel("Please select the card type ");
        platnium = new JRadioButton();
        titanium = new JRadioButton();
        platnium.setSelected(true);
        platnium.setText("Platinum");
        titanium.setText("Titanium");
        platnium.setBounds(120,30,120,50);
        titanium.setBounds(250,30,80,50);

        group.add(platnium);
        group.add(titanium);

        IDField = new JTextField(5);
        NameField = new JTextField(10);
        AddressField = new JTextField(30);

        setLayout(new FlowLayout());
        add(IDlabel);
        add(IDField);
        add(Namelabel);
        add(NameField);
        add(Addresslabel);
        add(AddressField);
        add(Examplelabel);
        add(typelabel);
        add(platnium);
        add(titanium);
        add(subbutt);
        add(backbutt);
        add(clearbutt);

        subbutt.setEnabled(false);
        CheckingFields listener = new CheckingFields();
        IDField.getDocument().addDocumentListener(listener);
        NameField.getDocument().addDocumentListener(listener);
        AddressField.getDocument().addDocumentListener(listener);

        setSize(300, 600);

        subbutt.addActionListener(e -> returnCardRegisterInfoFromUserToSystem());
        backbutt.addActionListener(e -> backToPreviousPage());
        clearbutt.addActionListener(e -> clear());
    }
    private void clear(){
        IDField.setText("");
        NameField.setText("");
        AddressField.setText("");
    }
    private void backToPreviousPage(){
        cardRegister.backToMainSystemPage();
    }
    private void CheckIfFieldsAreEmpty(){
        boolean value = false;
        if(
                IDField .getText().trim().length() != 0 &&
                NameField.getText().trim().length() != 0 &&
                AddressField.getText().split(",").length == 6
        ){
            value = true;
        }
        subbutt.setEnabled(value);
    }
    private void returnCardRegisterInfoFromUserToSystem(){
        String[][] output = new String[2][3];
        String [] addresslist = AddressField.getText().split(",");
        String cardtype = "";
        output[0][1] = NameField.getText();
        output[0][0] = IDField .getText();
        addresslist[5] = addresslist[5].trim();
        output[1] = addresslist;
        if(platnium.isSelected()){
            cardtype = "Platinum";
        }
        if(titanium.isSelected()){
            cardtype = "Titanium";
        }
        output[0][2] = cardtype;
        cardRegister.registerCard(output);
        backToPreviousPage();
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