package Assignment3_BaseCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Text Field and Event Handling
public class CardQueryPage extends JPanel {
    private CardAndUserRegisterSystem cardRegister;
    private JTextField idField;
    private final JButton subbutt;
    private final JButton backbutt;
    private Boolean name;

    public CardQueryPage(CardAndUserRegisterSystem system){
        cardRegister = system;
        subbutt = new JButton("Submit");
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
        setLayout(new FlowLayout());
        add(dialog);
        add(idField);
        add(subbutt);
        add(backbutt);
    }
    public void setName(Boolean name) {
        this.name = name;
    }
    public void openRequestForCard(){
        if(name){idField.setText("Please enter card name");}
        else{idField.setText("Please enter ID");}
    }
    private void clear(){
        idField.setText("");
    }
    private void backToPreviousPage(){
        cardRegister.backToMainSystemPage();
    }
    private void returnQueryInfoToSystem(){
        String cardID = idField.getText();
        if(name){
            cardRegister.searchCardByNameAndDisplayOnPage(cardID);
        }
        else{cardRegister.searchCardByIDAndDisplayOnPage(cardID);}
    }
}
