package Assignment3_BaseCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardAndUserInformationDisplayPage extends JFrame {
    private CardAndUserRegisterSystem cardRegister;
    private JTextArea textArea;
    private final JButton butt;

    public CardAndUserInformationDisplayPage(CardAndUserRegisterSystem sys){
        cardRegister = sys;
        this.textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        this.butt = new JButton("Back");
        setLayout(new FlowLayout());
        add(textArea);
        add(butt);
        butt.addActionListener(e -> backToPreviousPage());
    }
    public void displayInformationToTextArea(String content){
        textArea.setText(content);
    }
    public void displayInformationToList(String[] content){
        for(String s: content){
            textArea.append(s+"\n");
        }
    }
    private void clear(){
        textArea.setText("");
    }
    private void backToPreviousPage(){
        cardRegister.backToPreviousPage();
    }
}
