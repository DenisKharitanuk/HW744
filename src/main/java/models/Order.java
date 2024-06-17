package models;

import java.util.Objects;

public class Order {
    private String firstItemInMenu = "Бытовая техника";
    private String secondItemInMenu = "Техника для дома";
    private String thirdItemInMenu = "Пылесосы и пароочистители";
    private String fourthItemInMenu = "Вертикальные пылесосы";
    private String color = "rgba(245, 81, 35, 1)";
    private String basketCounter = "1";
    private String price = "3 311";
    private String totalPrice = "3 311 ₽";
    private String productCardInfo = "Вертикальный проводной пылесос, SAFERET";

    public Order() {
        this.firstItemInMenu = firstItemInMenu;
        this.secondItemInMenu = secondItemInMenu;
        this.thirdItemInMenu = thirdItemInMenu;
        this.fourthItemInMenu = fourthItemInMenu;
        this.color = color;
        this.basketCounter = basketCounter;
        this.price = price;
        this.totalPrice = totalPrice;
        this.productCardInfo = productCardInfo;
    }

    public String getFirstItemInMenu() {
        return firstItemInMenu;
    }

    public String getSecondItemInMenu() {
        return secondItemInMenu;
    }

    public String getThirdItemInMenu() {
        return thirdItemInMenu;
    }

    public String getFourthItemInMenu() {
        return fourthItemInMenu;
    }

    public String getColor() {
        return color;
    }

    public String getBasketCounter() {
        return basketCounter;
    }

    public String getPrice() {
        return price;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public String getProductCardInfo() {
        return productCardInfo;
    }
}
