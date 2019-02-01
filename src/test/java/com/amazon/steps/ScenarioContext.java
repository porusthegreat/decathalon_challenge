package com.amazon.steps;

class ScenarioContext {

    private static String price;
    private static String itemName;

    String getPrice() {
        return price;
    }

    void setPrice(String price) {
        this.price = price;
    }

    void setItemName(String searchTerm) {
        this.itemName = searchTerm;
    }

    String getItemName() {
        return itemName;
    }
}
