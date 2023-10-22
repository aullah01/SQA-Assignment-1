package Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    private WebDriver webDriver;

    public CheckoutPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void verifyText(String xpathIdentifier, String expectedText) {
        try {
            String elementText = webDriver.findElement(By.xpath(xpathIdentifier)).getText();
            if (elementText.equals(expectedText)) {
                System.out.println(
                        "Text Verification Passed:\n" +
                                "Expected Text: " + expectedText + "\n" +
                                "Actual Text: " + elementText
                );
            } else {
                System.out.println(
                        "Text Verification Failed:\n" +
                                "Expected Text: " + expectedText + "\n" +
                                "Actual Text: " + elementText
                );
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void enterText(String elementId, String text) throws Exception {
        try {
            WebElement element = webDriver.findElement(By.id(elementId));
            element.sendKeys(text);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void clickElement(String elementId) throws Exception {
        try {
            WebElement element = webDriver.findElement(By.id(elementId));
            element.click();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void fillDetails(String firstName, String lastName, int zipCode, String firstNameElement, String lastNameElement, String zipCodeElement, String checkoutButtonId) throws Exception {
        try {
            enterText(firstNameElement, firstName);
            enterText(lastNameElement, lastName);
            enterText(zipCodeElement, String.valueOf(zipCode));
            clickElement(checkoutButtonId);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void verifyProductDetails(String productName, String productPrice, String productNameClass, String productPriceClass) {
        try {
            String nameElement = webDriver.findElement(By.className(productNameClass)).getText();
            String priceElement = webDriver.findElement(By.className(productPriceClass)).getText();
            if (nameElement.equals(productName) && priceElement.equals(productPrice)) {
                System.out.println(
                        "Product Details Verification Passed:\n" +
                                "Expected Product & Price: " + productName + " " + productPrice + "\n" +
                                "Actual Product & Price: " + nameElement + " " + priceElement + "\n"
                );
            } else {
                System.out.println(
                        "Product Details Verification Failed:\n" +
                                "Expected Product & Price: " + productName + " " + productPrice + "\n" +
                                "Actual Product & Price: " + nameElement + " " + priceElement + "\n"
                );
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }


    public void orderProduct(String elementId) throws Exception {
        try {
            clickElement(elementId);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void verifyOrderCompletion(String headerTextXpath, String expectedHeaderText) {
        try {
            String headerText = webDriver.findElement(By.xpath(headerTextXpath)).getText();
            if (headerText.equals(expectedHeaderText)) {
                System.out.println(
                        "Order Completion Verification Passed:\n" +
                                "Expected Header Text: " + expectedHeaderText + "\n" +
                                "Actual Header Text: " + headerText
                );
            } else {
                System.out.println(
                        "Order Completion Verification Failed:\n" +
                                "Expected Header Text: " + expectedHeaderText + "\n" +
                                "Actual Header Text: " + headerText
                );
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
