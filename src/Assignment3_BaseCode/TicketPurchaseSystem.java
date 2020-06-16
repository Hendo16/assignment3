package Assignment3_BaseCode;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TicketPurchaseSystem {
    private ArrayList<Ticket> tickets;
    private ArrayList<TicketPurchaseRecord> ticketRecords;
    private MainSystem main;
    private TicketDisplayPage display;
    private TicketPurchasePage purchase;
    private TicketQueryPage query;

    public TicketPurchaseSystem(MainSystem main){
        this.main = main;
        display = new TicketDisplayPage(this);
        purchase = new TicketPurchasePage(this);
        query = new TicketQueryPage(this);
        tickets = new ArrayList();
        ticketRecords = new ArrayList();
    }
    public void openTicketPurchasePage(){
        changePanel(purchase, "Create Ticket", 500, 280);
    }
    public void changePanel(JPanel panel, String title, int width, int height){
        //Method to change the multiple panels based on information passed through, to stop code repetition.
        main.getFrame().setTitle(title);
        main.getFrame().setSize(width, height);
        main.getFrame().setContentPane(panel);
        main.getFrame().revalidate();
    }
    protected void createNewTicketAndRecordFromInfo(String[] info){
        String ID = info[0];
        String Name = info[1];
        String Depart = info[2];
        String Destin = info[3];
        String FlightNum = info[4];
        Double price = Double.parseDouble(info[5]);
        TicketType tick = TicketType.valueOf(info[6]);
        DiscountType disc = DiscountType.None;
        Double discAmount = 0.0;
        if(info[7] != "None"){
            disc = main.getDiscountType(info[8]);
            discAmount = main.getDiscountAmount(info[8], Double.parseDouble(info[5]), tick);
        }
        Ticket output = new Ticket(ID, Name, Depart, Destin, FlightNum, tick, disc, price, discAmount);
        tickets.add(output);
        TicketPurchaseRecord record = new TicketPurchaseRecord(output.getTicketID(),info[8], LocalDate.now());
        ticketRecords.add(record);
    }
    protected Ticket searchForStoredTicket(String ticketid){
        for(Ticket t: tickets){
            if(ticketid.equals(t.getTicketID())){
                return t;
            }
        }
        return null;
    }
    public void searchForTicket(){
        query.openRequestForTicket();
        changePanel(query, "Search For Ticket", 270, 100);
    }
    public void displayTicketInfo(String ticketid){
        try{
            Ticket ticket = searchForStoredTicket(ticketid);
            display.displayInformationToList(ticket.toStringArray());
            changePanel(display, "Ticket Information", 250, 210);
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(main.getFrame(), "Error: Ticket not found. Please try again.");
            return;
        }
    }
    public void backToMainMenu(){
        main.backToMainMenu();
    }
    public Object ReadFile(String filename) throws IOException, ClassNotFoundException {
        File file = new File(filename);
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        if(file.toString().contains("PurchaseRecord")){
            TicketPurchaseRecord object = (TicketPurchaseRecord) inputStream.readObject();
            return object;
        }
        else{
            Ticket object = (Ticket) inputStream.readObject();
            return object;
        }
    }
    public void WriteFile(Object obj) throws IOException {
        if (obj instanceof Ticket){
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Ticket.info"));
            outputStream.writeObject(obj);
            outputStream.close();
        }
        if(obj instanceof TicketPurchaseRecord){
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("TicketPurchaseRecord.info"));
            outputStream.writeObject(obj);
            outputStream.close();
        }
    }
}