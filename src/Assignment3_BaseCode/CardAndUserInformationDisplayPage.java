package Assignment3_BaseCode;

import javax.swing.*;
import java.awt.*;

public class CardAndUserInformationDisplayPage extends JFrame {
    private CardAndUserRegisterSystem cardRegister;
    private JTextArea textArea;
    private final JButton butt;

    public CardAndUserInformationDisplayPage(CardAndUserRegisterSystem sys, JTextArea textArea){
        cardRegister = sys;
        this.textArea = new JTextArea();
        this.butt = new JButton("Back");
        setLayout(new FlowLayout());
    }
    public void displayInformationToTextArea(String content){
        this.textArea = new JTextArea(content);
    }
    public void displayInformationToList(String[] content){

    }
    private void clear(){}
    private void backToPreviousPage(){}
}
