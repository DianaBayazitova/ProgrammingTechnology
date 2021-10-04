package Lab23456.ru.billing.Client;

import Lab23456.ru.billing.StockListProject.*;
import Lab23456.ru.billing.Exceptions.CatalogLoadException;
import Lab23456.ru.billing.Exceptions.ItemAlreadyExistsException;

import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        GenericItem firstItem = new GenericItem(
                "book1",
                3.5f,
                null,
                Category.GENERAL
        );

        GenericItem secondItem = new GenericItem(
                "water",
                5.0f,
                null,
                Category.FOOD
        );

        GenericItem tertiaryItem = new GenericItem(
                "pen",
                6.4f,
                null,
                Category.PRINT
        );

        GenericItem quaternaryItem = new GenericItem(
                "book2",
                4.0f,
                firstItem,
                Category.GENERAL
        );

        firstItem.printAll();
        secondItem.printAll();
        tertiaryItem.printAll();
        quaternaryItem.printAll();


        FoodItem firstFoodItem = new FoodItem(
                "apple",
                0.5f,
                null,
                Category.FOOD,
                new Date(),
                (short) 10
        );
        TechnicalItem firstTechnicalItem = new TechnicalItem(
                "laptop",
                1000.5f,
                null,
                Category.GENERAL,
                (short) 10
        );
        GenericItem[] items = {firstFoodItem, firstTechnicalItem};

        for (GenericItem item : items) {
            item.printAll();
        }


        FoodItem secondFoodItem = new FoodItem(
                "pear",
                0.7f,
                firstFoodItem,
                Category.FOOD,
                new Date(),
                (short) 10
        );

        System.out.println("\n Result of overridden equals method");
        System.out.println(firstFoodItem.equals(secondFoodItem));

        FoodItem tertiaryFoodItem = (FoodItem) secondFoodItem.clone();

        System.out.println("\n Cloning and clone comparison results");
        System.out.println(tertiaryFoodItem.equals(secondFoodItem));

        tertiaryFoodItem.setID(900);

        System.out.println("\n Clone field change and output");
        secondFoodItem.printAll();
        tertiaryFoodItem.printAll();

        System.out.println("\n Compare results with the clone after the change");
        System.out.println(tertiaryFoodItem.equals(secondFoodItem));

        System.out.println("\n Result of overridden toString method");
        System.out.println(firstItem);
        System.out.println(firstFoodItem);
        System.out.println(firstTechnicalItem);
        System.out.println(secondFoodItem);


        GenericItem newItem = (GenericItem) quaternaryItem.clone();

        System.out.println("\n Quaternary clone");
        newItem.printAll();

        System.out.println("\n Quaternary item");
        quaternaryItem.printAll();

        System.out.println("\n Quaternary analogue item");
        quaternaryItem.getAnalogue().printAll();

        System.out.println("\n Comparison of quaternary clone and quaternary analogue");
        System.out.println(newItem.equals(quaternaryItem.getAnalogue()));

        newItem.setID(901);
        newItem.printAll();
        quaternaryItem.getAnalogue().printAll();

        System.out.println("\n Comparison of quaternary clone and quaternary analogue after changing clone's ID");
        System.out.println(quaternaryItem.getAnalogue().equals(newItem));


        String line = "Конфеты ’Маска’;45;120";
        String[] item_fld;
        item_fld = line.split(";");
        System.out.println(Arrays.toString(item_fld));
        FoodItem foodItem = new FoodItem(item_fld[0], Float.parseFloat(item_fld[1]), Short.parseShort(item_fld[2]));
        foodItem.printAll();


        ItemCatalog catalog = new ItemCatalog();
        try {
            catalog.addItem(firstItem);
            catalog.addItem(secondItem);
            catalog.addItem(tertiaryItem);
            catalog.addItem(quaternaryItem);
            catalog.addItem(firstFoodItem);
            catalog.addItem(secondFoodItem);
            catalog.addItem(tertiaryFoodItem);
            catalog.addItem(firstTechnicalItem);
            catalog.addItem(foodItem);
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
        }

        long begin = new Date().getTime();

        for(int i = 0; i < 100000; i++) {
            catalog.findItemByID(8);
        }

        long end = new Date().getTime();

        System.out.println("In HashMap: "+ (end - begin));
        begin = new Date().getTime();

        for(int i = 0; i < 100000; i++) {
            catalog.findItemByIDAL(8);
        }
        end = new Date().getTime();
        System.out.println("In ArrayList: "+(end - begin));

        System.out.println("\n Before use load");
        catalog.printItems();

//        CatalogLoader loader = new CatalogStubLoader();
//        try {
//            loader.load(catalog);
//        } catch (CatalogLoadException e) {
//            e.printStackTrace();
//        }

        CatalogFileLoader fileLoader = new CatalogFileLoader("/Users/dianabayazitova/IdeaProjects/Lab1/src/Lab23456/ru/billing/Client/itemList");
        try {
            fileLoader.load(catalog);
        } catch (CatalogLoadException e) {
            e.printStackTrace();
        }

        System.out.println("\n After use load");
        catalog.printItems();
    }
}