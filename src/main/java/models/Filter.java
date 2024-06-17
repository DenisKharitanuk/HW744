package models;

public class Filter {
    private String firstItemInMenu = "Электроника";
    private String secondItemInMenu = "Ноутбуки и компьютеры";
    private String thirdItemInMenu = "Ноутбуки";
    private String priceStartIn = "100 000";
    private String priceEnd = "149 000";
    private String radioButtonName = "до 3 дней";
    private String firstCheckboxName = "Apple";
    private String secondCheckboxName = "15.3\"";
    private String counterValue = "4";

    public Filter() {
        this.firstItemInMenu = firstItemInMenu;
        this.secondItemInMenu = secondItemInMenu;
        this.thirdItemInMenu = thirdItemInMenu;
        this.priceStartIn = priceStartIn;
        this.priceEnd = priceEnd;
        this.radioButtonName = radioButtonName;
        this.firstCheckboxName = firstCheckboxName;
        this.secondCheckboxName = secondCheckboxName;
        this.counterValue = counterValue;
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

    public String getPriceStartIn() {
        return priceStartIn;
    }

    public String getPriceEnd() {
        return priceEnd;
    }

    public String getRadioButtonName() {
        return radioButtonName;
    }

    public String getFirstCheckboxName() {
        return firstCheckboxName;
    }

    public String getSecondCheckboxName() {
        return secondCheckboxName;
    }

    public String getCounterValue() {
        return counterValue;
    }
}
