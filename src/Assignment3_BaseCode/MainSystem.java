package Assignment3_BaseCode;

public class MainSystem {
    CardAndUserRegisterSystem cardsys;
    //private TicketPurchaseSystem ticketSys;
    //private MainPage main;
    public MainSystem(){
        cardsys = new CardAndUserRegisterSystem(this);
    }
    protected DiscountType getDiscountType(String discountID){
        return cardsys.getDiscountType(discountID);
    }
    protected double getDiscountAmount(String discountID, double price, TicketType ticketType){
        return cardsys.getDiscountAmount(discountID, price, ticketType);
    }
    public void createCardWithPage(){}
    public void queryCardWithPage(){}
    public void backToMainMenu(){}
}