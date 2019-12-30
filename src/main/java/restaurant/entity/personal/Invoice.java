package restaurant.entity.personal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setComanda(String comanda) {
        this.comanda = comanda;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void generate(){
        PrintWriter pw = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        try {
            String fileName = new String("");
            fileName+= new String("Bill_");
            fileName+=new String(dateFormat.format(this.invoiceDate));
            fileName+=new String(".txt");
            System.out.println(fileName);
            //nume factura
            pw = new PrintWriter("bill.txt", "UTF-8");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        pw.println("Date: " + new String(dateFormat.format(invoiceDate)));
        pw.println("Table: " + table);
        pw.println("Order: " + comanda);

        pw.println();

        calculateTotal("gcsvhbxn");

        pw.println(total);

        pw.close();
    }
}
