package restaurant.entity.stock;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<ItemQuantity> stock;

    public Stock(){
        this.stock = new ArrayList<>();
    }

    public Stock(List<ItemQuantity>stock){
        this.stock = stock;
    }

    public List<ItemQuantity> getStock() {
        return stock;
    }

    public void setStock(List<ItemQuantity> stock) {
        this.stock = stock;
    }
}
