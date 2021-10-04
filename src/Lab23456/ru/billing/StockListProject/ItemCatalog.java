package Lab23456.ru.billing.StockListProject;

import Lab23456.ru.billing.Exceptions.ItemAlreadyExistsException;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog {

    private HashMap<Integer, GenericItem> catalog = new HashMap<>();
    private ArrayList<GenericItem> ALCatalog = new ArrayList<>();

    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        if (catalog.get(item.getID()) == null) {
            catalog.put(item.getID(), item);
            ALCatalog.add(item);
        } else {
            throw new ItemAlreadyExistsException(item);
        }
    }

    public void printItems() {
        for (GenericItem i : ALCatalog) {
            System.out.println(i);
        }
    }

    public GenericItem findItemByID(int id) {
        return catalog.getOrDefault(id, null);
    }

    public GenericItem findItemByIDAL(int id) {
        for (GenericItem i : ALCatalog) {
            if (i.getID() == id) {
                return i;
            }
        }
        return null;
    }

}