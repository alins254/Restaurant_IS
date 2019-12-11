package restaurant.entity.menu;

import java.util.ArrayList;

public class Menu implements MenuItem{

    private ArrayList<MenuItem> menu;

    public Menu () {
        menu = new ArrayList<>();
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<MenuItem> menu) {
        this.menu = menu;
    }

    @Override
    public String showMenuItemDetails() {
        String showMenu = "Menu";

        for(MenuItem item : menu){
            showMenu += " " + item.showMenuItemDetails();
        }

        return showMenu;
    }
}
