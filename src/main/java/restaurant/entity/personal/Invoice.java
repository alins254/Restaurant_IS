package restaurant.entity.personal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class Invoice {

    private Date invoiceDate;
    //private Waiter waiter;
    private Double total;
    private String comanda;
    private String table;

    public Invoice(){
        invoiceDate = new Date();
    }

    public Double calculateTotal(String comanda){
        total = 0.0;
        return  total;
    }

    public void generate(){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("Bill_"+invoiceDate.toString()+".txt", "UTF-8");

            pw.println("Date: " + invoiceDate);
            pw.println("Table: " + table);
            pw.println("Order: " + comanda);

            pw.println();

            calculateTotal("gcsvhbxn");

            pw.println(total);

            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
