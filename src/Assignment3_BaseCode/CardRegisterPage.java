package Assignment3_BaseCode;

import javax.swing.*;
import java.awt.*;

public class CardRegisterPage extends JFrame {
    private CardAndUserRegisterSystem cardRegister;
    private final JButton backbutt;
    private final JButton subbutt;
    private final JButton clearbutt;
    private JTextField IDField;
    private JTextField NameField;
    private JTextField AddressField;

    public CardRegisterPage(CardAndUserRegisterSystem system){
        cardRegister = system;
        backbutt = new JButton("Back");
        subbutt = new JButton("Submit");
        clearbutt = new JButton("Clear");
        JLabel IDlabel = new JLabel("ID");
        JLabel Namelabel = new JLabel("Please enter your name");
        JLabel Addresslabel = new JLabel("Please enter your address, separating each section with a comma.");
        JLabel Examplelabel = new JLabel("Example: 1, Loop Rd, Wollongong, Sydney, NSW, 1234");

        IDField = new JTextField(10);
        NameField = new JTextField(20);
        AddressField = new JTextField(100);

        setLayout(new FlowLayout());
        add(IDlabel);
        add(IDField);
        add(Namelabel);
        add(NameField);
        add(Addresslabel);
        add(AddressField);
        add(Examplelabel);
        add(subbutt);
        add(backbutt);
        add(clearbutt);

        subbutt.addActionListener(e -> returnCardRegisterInfoFromUserToSystem());
        backbutt.addActionListener(e -> backToPreviousPage());
        clearbutt.addActionListener(e -> clear());
    }
    public void openCardRegister(){

    }
    private void clear(){
        IDField.setText("");
        NameField.setText("");
        AddressField.setText("");
    }
    private void backToPreviousPage(){
        cardRegister.backToPreviousPage();
    }
    private void returnCardRegisterInfoFromUserToSystem(){
        String[][] output = new String[2][3];
        output[0][1] = NameField.getText();
        output[0][0] = IDField .getText();
        output[1] = AddressField.getText().split(",");
        cardRegister.registerCard(output);
    }
}