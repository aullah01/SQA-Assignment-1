package Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver webDriver = null;

    public LoginPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void navigateToUrl(String url) throws Exception {
        try {
            webDriver.get(url);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void enterText(String elementId, String text) throws Exception {
        try {
            WebElement element = webDriver.findElement(By.id(elementId));
            element.sendKeys(text);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void clickElement(String elementId) throws Exception {
        try {
            WebElement element = webDriver.findElement(By.id(elementId));
            element.click();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void login(String username, String password, String usernameTextBoxId, String passwordTextBoxId, String loginButtonId) throws Exception {
        try {
            enterText(usernameTextBoxId, username);
            enterText(passwordTextBoxId, password);
            clickElement(loginButtonId);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void verifyPageTitle(String xpathIdentifier, String expectedTitle) {
        try {
            String pageTitle = webDriver.findElement(By.xpath(xpathIdentifier)).getText();
            if (pageTitle.equals(expectedTitle)) {
                System.out.println(
                        "Title Verification Passed:\n" +
                                "Expected Title: " + expectedTitle + "\n" +
                                "Actual Title: " + pageTitle
                );
            } else {
                System.out.println(
                        "Title Verification Failed:\n" +
                                "Expected Title: " + expectedTitle + "\n" +
                                "Actual Title: " + pageTitle
                );
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
