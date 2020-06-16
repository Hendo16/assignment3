package Assignment3_BaseCode;

import javax.swing.*;
import java.io.IOException;

public class MainSystem {
    CardAndUserRegisterSystem cardsys;
    private static JFrame frame;
    private TicketPurchaseSystem ticketSys;
    private MainPage main;
    public MainSystem(){
        cardsys = new CardAndUserRegisterSystem(this);
        ticketSys = new TicketPurchaseSystem(this);
        frame = new JFrame();
        main = new MainPage(this);
        frame.setContentPane(main);
        frame.setSize(300, 230);
        frame.setTitle("Main Menu");
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
        frame.setSize(300, 230);
        frame.setTitle("Main Menu");
        frame.setContentPane(main);
    }
    public void createTicketWithPage(){
        ticketSys.openTicketPurchasePage();
    }
    public void queryTicketWithPage(){
        ticketSys.searchForTicket();
    }
    public void writeToFile(Object obj) throws IOException {
        ticketSys.WriteFile(obj);
    }
    public Object readFromFile(String filename) throws IOException, ClassNotFoundException {
        return ticketSys.ReadFile(filename);
    }
}