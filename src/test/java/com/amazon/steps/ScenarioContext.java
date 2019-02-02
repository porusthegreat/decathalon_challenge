package com.amazon.steps;

class ScenarioContext {

    private static String price;
    private static String itemName;
    private static Double cartPrice;

    String getPrice() {
        return price;
    }

    void setPrice(String price) {
        ScenarioContext.price = price;
    }

    void setItemName(String searchTerm) {
        itemName = searchTerm;
    }

    String getItemName() {
        return itemName;
    }

    void setCartPrice(Double cartPrice) {
        ScenarioContext.cartPrice = cartPrice;
    }

    Double getCartPrice() {
        return cartPrice;
    }
}
