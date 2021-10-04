package Lab23456.ru.billing.Client;

import Lab23456.ru.billing.Exceptions.CatalogLoadException;
import Lab23456.ru.billing.StockListProject.ItemCatalog;

public interface CatalogLoader {

    void load(ItemCatalog catalog) throws CatalogLoadException;
}