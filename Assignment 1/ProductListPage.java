package Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductListPage {
    private List<WebElement> productElements;
    private List<String> productNames;
    private List<String> productPrices;
    private List<String> addToCartButtonIds;
    private WebDriver webDriver;

    public ProductListPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void getAllProducts(String productsClass, String productNameClass, String productPriceClass, String addToCartTagName) throws Exception {
        try {
            productElements = webDriver.findElements(By.className(productsClass));
            productNames = new ArrayList<>();
            productPrices = new ArrayList<>();
            addToCartButtonIds = new ArrayList<>();

            for (WebElement element : productElements) {
                String name = element.findElement(By.className(productNameClass)).getText();
                String price = element.findElement(By.className(productPriceClass)).getText();
                String addToCartId = element.findElement(By.tagName(addToCartTagName)).getAttribute("id");

                productNames.add(name);
                productPrices.add(price);
                addToCartButtonIds.add(addToCartId);
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public int getRandomProductIndex() {
        return new Random().nextInt(productElements.size());
    }

    public String getRandomProductName(int index) {
        return productNames.get(index);
    }

    public String getRandomProductPrice(int index) {
        return productPrices.get(index);
    }

    public String getRandomProductAddToCartId(int index) {
        return addToCartButtonIds.get(index);
    }
}
