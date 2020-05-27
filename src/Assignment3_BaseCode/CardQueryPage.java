package Assignment3_BaseCode;

import javax.swing.*;
import java.awt.*;

//Text Field and Event Handling
public class CardQueryPage extends JFrame {
    private CardAndUserRegisterSystem cardRegister;
    private JTextField idField;
    private final JButton subbutt;
    private final JButton backbutt;
    public Boolean name;

    public CardQueryPage(CardAndUserRegisterSystem system){
        this.setTitle("Card Search");
        cardRegister = system;
        name=false;
        subbutt = new JButton("Submit");
        backbutt = new JButton("Back");
        JLabel dialog = new JLabel();
        idField = new JTextField(20);

        subbutt.addActionListener(e -> returnQueryInfoToSystem());
        subbutt.addActionListener(e -> backToPreviousPage());
        setLayout(new FlowLayout());
        add(dialog);
        add(idField);
        add(subbutt);
        add(backbutt);
    }
    public void openRequestForCard(){
        if(name){idField.setText("Please enter card name");}
        else{idField.setText("Please enter ID");}
    }
    private void clear(){
        idField.setText("");
    }
    private void backToPreviousPage(){
        cardRegister.backToPreviousPage();
    }
    private void returnQueryInfoToSystem(){
        String cardID = idField.getText();
        if(name){
            cardRegister.searchCardByNameAndDisplayOnPage(cardID);
        }
        else{cardRegister.searchCardByIDAndDisplayOnPage(cardID);}
    }
}
