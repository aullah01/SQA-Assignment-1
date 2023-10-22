package Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
    private WebDriver webDriver;

    public ShoppingCartPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void clickElement(String elementId) throws Exception {
        try {
            WebElement element = webDriver.findElement(By.id(elementId));
            element.click();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void addToCart(String product) throws Exception {
        try {
            clickElement(product);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    public void checkout(String checkoutButtonId) throws Exception {
        try {
            clickElement(checkoutButtonId);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }



    public void navigateToCart(String elementId) throws Exception {
        try {
            clickElement(elementId);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }


}
