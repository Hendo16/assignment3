package Assignment3_BaseCode;

import java.io.IOException;
import java.time.LocalDate;

public class TestCode {
    static MainSystem main;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        main = new MainSystem();
        Ticket ticket = new Ticket("432", "Test", "Sydney",
                "Gold Coast", "asdfasdf", TicketType.EconomyClass,
                DiscountType.None, 234, 0);
        TicketPurchaseRecord record = new TicketPurchaseRecord(ticket.getTicketID(), "123", LocalDate.now());
        //Writes a test Ticket object to show writing functionality.
        main.writeToFile(ticket);
        main.writeToFile(record);
        //Outputs the test object from the .info file
        System.out.println(main.readFromFile("Ticket.info").toString());
        System.out.println(main.readFromFile("TicketPurchaseRecord.info").toString());
    }
}