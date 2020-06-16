/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3_BaseCode;


import java.io.Serializable;

/**
 *
 * @author Pairat Thorncharoensri
 */
public class Ticket implements Serializable {
    private String ticketID;
    private String name;
    private String departureCity;
    private String destinationCity;
    private String flightNumber;
    private TicketType ticketType;
    private DiscountType discountType;
    private double price;
    private double discountAmount;

    public Ticket(String ticketCode, String name, String departureCity, String destinationCity, String flightNumber, TicketType ticketType,DiscountType discountType, double price, double discountAmount) {
        this.ticketID = ticketCode;
        this.name=name;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.flightNumber = flightNumber;
        this.ticketType = ticketType;
        this.discountType =discountType;
        this.price = price;
        this.discountAmount=discountAmount;
    }

    public String getTicketID() {
        return ticketID;
    }

    public String getName() {
        return name;
    }  

    public double getPrice() {
        return price;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public String[] toStringArray(){
        return new String[]{
                "ID: "+
                ticketID,
                "Name: "+
                name,
                "Departure: "+
                departureCity,
                "Destination: "+
                destinationCity,
                "Flight Number: "+
                flightNumber,
                "Discount Type: "+
                String.valueOf(discountType),
                "Discount Amount"+
                String.valueOf(discountAmount),
                "Price: $"+
                String.valueOf(price)
        };
    }
    @Override
    public String toString() {
        return "[" + "ticketID=" + ticketID + ", name=" + name + ", departureCity=" + departureCity + ", destinationCity=" + destinationCity + ", flightNumber=" + flightNumber + ", ticketType=" + ticketType + ", discountType=" + discountType + ", price=" + price + ", discountAmount=" + discountAmount + ']';
    }




}
