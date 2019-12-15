package restaurant.entity.stock;

import restaurant.entity.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ItemQuantity {
    private Integer value;
    private MenuItem product;

    public ItemQuantity() {
    }

    public ItemQuantity(int value, MenuItem product) {
        this.value = value;
        this.product = product;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public MenuItem getProduct() {
        return product;
    }

    public void setProduct(MenuItem product) {
        this.product = product;
    }

    public List<ItemQuantity> setQuantity(List<MenuItem> menu, List<Integer> quantity) {
        List<ItemQuantity> stock = new ArrayList<>();
        for(int i = 0; i < menu.size(); i++){
            if(quantity.get(i) != null){
                ItemQuantity it = new ItemQuantity(quantity.get(i),menu.get(i));
                stock.add(it);
            }else{
                ItemQuantity it = new ItemQuantity(1,menu.get(i));
                stock.add(it);
            }
        }
        return stock;
    }

}