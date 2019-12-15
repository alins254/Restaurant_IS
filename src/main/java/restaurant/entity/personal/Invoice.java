package restaurant.entity.personal;

import restaurant.entity.menu.Dishes;
import restaurant.entity.menu.Drinks;
import restaurant.entity.menu.Menu;
import restaurant.entity.menu.MenuItem;
import restaurant.entity.orders.Orders;
import restaurant.entity.table.Table;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice {

    private Date invoiceDate;

    public Invoice(){
        invoiceDate = new Date();
    }

    public Double calculateTotal(Orders order){
        List items = new ArrayList<Menu>();
        items.addAll(order.getMenuItems());
        double price = 0.0;
        for(Object m: items)
            if(m instanceof Drinks)
                price+=((Drinks) m).getPrice();
            else
                if(m instanceof Dishes)
                    price+=((Dishes) m).getPrice();
        return  price;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }


    public void generate(Orders order){
        PrintWriter pw = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

        try {
            String fileName = new String("");
            fileName+= new String("Bill ");
            fileName+=new String(dateFormat.format(this.invoiceDate));
            fileName+=new String(".txt");
            pw = new PrintWriter(fileName, "UTF-8");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        pw.println("Date: " + new String(dateFormat.format(invoiceDate)));
        pw.println("Table: " + order.getTable());
        pw.println("Order: " + order.getId());
        pw.println();
        pw.println();
        pw.println("Comanda dvs: ");
        for(Object m : order.getMenuItems())
            if(m instanceof Drinks || m instanceof Dishes) {
                if (m instanceof Dishes)
                    pw.println(((Dishes) m).getName() + ": " + ((Dishes) m).getPrice() + "RON");
                if (m instanceof Drinks)
                    pw.println(((Drinks) m).getName() + ": " + ((Drinks) m).getPrice() + "RON");
            }

        pw.println();
        // pw.println(((Menu)m).showMenuItemDetails());

        Double price = calculateTotal(order);

        pw.println("TOTAL: " + price+"RON");

        pw.close();
        
    }
}