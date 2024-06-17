package models;

public class Search {
    private String searchProduct = "Iphone 13";
    private String expectedText = "По запросу Iphone 13 найдено";
    private String filterName = "По популярности";
    private String productLabelName = "Apple";

    public Search() {
        this.searchProduct = searchProduct;
        this.expectedText = expectedText;
        this.filterName = filterName;
        this.productLabelName = productLabelName;
    }

    public String getSearchProduct() {
        return searchProduct;
    }

    public String getExpectedText() {
        return expectedText;
    }

    public String getFilterName() {
        return filterName;
    }

    public String getProductLabelName() {
        return productLabelName;
    }
}
