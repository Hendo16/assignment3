/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3_BaseCode;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Pairat Thorncharoensri
 */
public class TicketPurchaseRecord implements Serializable {
    String Ticketid;
    String discountId;
    LocalDate date;

    public TicketPurchaseRecord(String Ticketid, String discountId, LocalDate date) {
        this.Ticketid = Ticketid;
        this.discountId = discountId;
        this.date = date;
    }

    public String getTicketid() {
        return Ticketid;
    }

    public String getDiscountId() {
        return discountId;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "[" + "Ticketid=" + Ticketid + ", discountId=" + discountId + ", date=" + date + ']';
    }
    
    
    
    
}
