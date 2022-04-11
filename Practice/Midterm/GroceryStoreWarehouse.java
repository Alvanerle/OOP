package Practice.Midterm;

import java.util.*;


/*
   Ты разработчик сети супермаркетов
   У вас есть админка, в которую можно добавлять товары в систему
   Тебе дали задание добавить сюда еще 50 товаров, а завтра еще 100.
   Каждый отдельный вид товара добавляется через отдельный метод.

   Спустя месяц этот класс станет очень большим и трудноподдающимся к изменению

   Но тебе лень писать отдельный метод для каждого отдельного вида товара.
   Поэтому ты тут что-то где-то как-то перепишешь/добавишь/удалишь

   В конце объяснишь ход своих мыслей и причину совершенных действий
*/

class Product{
    String name;
    String type;
    boolean isRestricted;
    boolean hasBadManufacturer;
    Date expirationDate;
    Map<String, String> characteristics = new HashMap<>();

    Product(){

    }

    Product(String name, String type, boolean isRestricted, boolean hasBadManufacturer, Map<String, String> characteristics, Date expirationDate){
        this.name = name;
        this.type = type;
        this.isRestricted = isRestricted;
        this.hasBadManufacturer = hasBadManufacturer;
        this.characteristics = characteristics;
        this.expirationDate = expirationDate;
    }
}

public class GroceryStoreWarehouse {

    /*
        В стране идет поддержка отечественных производителей, поэтому эти виды сыров под запретом,
        в будущем добавят еще.

        Причем тут производители и виды сыров - ¯\_(ツ)_/¯, но код писать надо
    */

    public Set<Product> products = new HashSet<>();

    public String addProduct(Product product) {
        if (new Date().getTime() > product.expirationDate.getTime()) {
            return "Срок годности истек, нельзя добавить в систему";
        }

        if(product.isRestricted || product.hasBadManufacturer){
            return "Это запрещенный товар";
        }

        products.add(product);
        return "Продукт добавлен";
    }

}