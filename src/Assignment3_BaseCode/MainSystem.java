package Assignment3_BaseCode;

import javax.swing.*;
import java.awt.*;

public class MainSystem {
    CardAndUserRegisterSystem cardsys;
    private static JFrame frame;
    //private TicketPurchaseSystem ticketSys;
    private MainPage main;
    public MainSystem(){
        cardsys = new CardAndUserRegisterSystem(this);
        frame = new JFrame();
        main = new MainPage(this);
        frame.setContentPane(main);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
    public JFrame getFrame() {
        return frame;
    }
    protected DiscountType getDiscountType(String discountID){
        return cardsys.getDiscountType(discountID);
    }
    protected double getDiscountAmount(String discountID, double price, TicketType ticketType){
        return cardsys.getDiscountAmount(discountID, price, ticketType);
    }
    public void createCardWithPage(){
        cardsys.openCreateCardPage();
    }
    public void queryCardWithPage(String name){
        if(name.equals("Name")){
            cardsys.searchForCardName();
        }
        else{
            cardsys.searchForCardID();
        }
    }
    public void backToMainMenu(){
        frame.setSize(300, 200);
        frame.setContentPane(main);
    }
    public void createTicketWithPage(){

    }
}