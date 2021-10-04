package Lab23456.ru.billing.Client;

import Lab23456.ru.billing.Exceptions.CatalogLoadException;
import Lab23456.ru.billing.StockListProject.Category;
import Lab23456.ru.billing.StockListProject.FoodItem;
import Lab23456.ru.billing.StockListProject.GenericItem;
import Lab23456.ru.billing.StockListProject.ItemCatalog;

import java.util.Date;

public class CatalogStubLoader implements CatalogLoader {

    @Override
    public void load(ItemCatalog catalog) throws CatalogLoadException {
        GenericItem item1 = new GenericItem("Sony TV", 23000, Category.GENERAL);
        FoodItem item2 = new FoodItem("Bread", 12, null, new Date(), (short) 10);
        item1.setID(2);
        try {
            catalog.addItem(item1);
            catalog.addItem(item2);
        } catch (Exception e) {
            throw new CatalogLoadException(e);
        }
    }
}