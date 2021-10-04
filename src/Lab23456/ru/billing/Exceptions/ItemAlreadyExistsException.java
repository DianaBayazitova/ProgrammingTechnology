package Lab23456.ru.billing.Exceptions;

import Lab23456.ru.billing.StockListProject.GenericItem;

public class ItemAlreadyExistsException extends Exception {

    private GenericItem item;

    public GenericItem getItem() {
        return item;
    }

    public void setItem(GenericItem item) {
        this.item = item;
    }

    public ItemAlreadyExistsException(GenericItem item) {
        this.item = item;
    }

    public String toString() {
        return "Incorrect ID in " + this.item.toString();
    }
}