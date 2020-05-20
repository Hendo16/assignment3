package Assignment3_BaseCode;

import java.time.LocalDate;
import java.util.ArrayList;

public class CardAndUserRegisterSystem {
    private ArrayList<Card> flyerCards;
    private ArrayList<Coupon> coupons;
    private CardRegisterView view;
    private MainSystem main;

    private CardRegisterPage cardReg;
    private CardQueryPage query;
    private CardAndUserInformationDisplayPage display;

    public CardAndUserRegisterSystem(MainSystem main){
        this.main = main;
    }
    public Address buildAddressFromArray(String[] content){
        String StreetNum = content[0];
        String StreetName = content[1];
        String City = content[2];
        String State = content[3];
        int Postcode = Integer.parseInt(content[4]);
        String Suburb = content[5];
        return new Address(StreetNum, StreetName, Suburb, City, State, Postcode);
    }
    protected void registerCard(String[][] content){
        String ID = content[0][0];
        String name = content[0][1];
        String cardtype = content[0][2];
        Address address = buildAddressFromArray(content[1]);
        LocalDate date = LocalDate.now();
        if(cardtype.equals("Platinum")){
            PlatinumCard card = new PlatinumCard(ID, name, address, 0, date);
            flyerCards.add(card);
            view.displayInformationToConsole("Registered card information:\nID: "+ID+"\nName: "+name+"\nDate of Activation: "+date.toString());
        }
        if(cardtype.equals("Titanium")){
            TitaniumCard card = new TitaniumCard(ID, name, address, 0, date);
            flyerCards.add(card);
            view.displayInformationToConsole("Registered card information:\nID: "+ID+"\nName: "+name+"\nDate of Activation: "+date.toString());
        }
    }
    protected DiscountType getDiscountType(String discountID){
        for(Card card: flyerCards){
            if(discountID.equals(card.getDiscountID())){
                return DiscountType.CardDiscount;
            }
        }
        for(Coupon coup: coupons){
            if(discountID.equals(coup.getDiscountID())){
                return DiscountType.Coupon;
            }
        }
        return DiscountType.None;
    }
    protected double getDiscountAmount(String discountID, double price, TicketType ticketType){
        for(Card card:flyerCards){
            if(discountID.equals(card.getDiscountID())){
                return card.getDiscountAmount(price, ticketType);
            }
        }
        for(Coupon coup: coupons){
            if(discountID.equals(coup.getDiscountID())){
                return coup.getDiscountAmount(price, ticketType);
            }
        }
        return 0.0;
    }
    protected Discount searchByDiscountID(String discountID){
        for(Card card:flyerCards){
            if(discountID.equals(card.getDiscountID())){
                return card;
            }
        }
        for(Coupon coup: coupons){
            if(discountID.equals(coup.getDiscountID())){
                return coup;
            }
        }
        return null;
    }
    public void openCreateCardPage(){}
    public void processDataFromCardPage(String[] content){}
    protected void displayCardInformationToPage(String text){}
    public void displayCardInformationToPage(){}
    public void backToPreviousPage(){}
    public void backToMainSystemPage(){}
    public void searchCardByIDAndDisplayOnPage(String FlyerCard){}
    public void searchCardByNameAndDisplayOnPage(String FlyerCard){}
}