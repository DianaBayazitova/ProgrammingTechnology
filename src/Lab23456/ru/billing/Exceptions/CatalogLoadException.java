package Lab23456.ru.billing.Exceptions;

public class CatalogLoadException extends Exception {

    public CatalogLoadException(Exception e) {
        e.printStackTrace();
    }
}