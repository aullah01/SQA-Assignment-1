package Assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static final String applicationUrl = "https://www.saucedemo.com/";
    public static final String expectedTitle = "Swag Labs";
    public static final String expectedResult = "Products";
    public static final String userName = "standard_user";
    public static final String password = "secret_sauce";
    public static final String pageTitleXpath = "//*[@id=\"header_container\"]/div[2]/span";
    public static final String userNameTextBoxId = "user-name";
    public static final String passwordTextBoxId = "password";
    public static final String loginButtonId = "login-button";
    public static final String driverProperty = "webdriver.chrome.driver";
    public static final String driverPath = "src/driver/chromedriver.exe";
    public static final String productClass = "inventory_item";
    public static final String productNameClass = "inventory_item_name";
    public static final String productPriceClass = "inventory_item_price";
    public static final String addToCartTagName = "button";
    public static final int sleepTime = 3000;
    private static final String cartIconId = "shopping_cart_container";
    private static final String cartExpectedTitle = "Your Cart";
    private static final String checkoutButtonId = "checkout";
    private static final String checkoutExpectedTitle1 = "Checkout: Your Information";
    private static final String checkoutExpectedTitle2 = "Checkout: Overview";
    private static final String firstName = "not";
    private static final String lastName = "wld";
    private static final int zipCode = 7996;
    private static final String firstNameTextBoxId = "first-name";
    private static final String zipCodeTextBoxId = "postal-code";
    private static final String lastNameTextBoxId = "last-name";
    private static final String finishButtonId = "finish";
    private static final String continueButtonId = "continue";
    private static final String headerTextXpath = "//*[@id=\"checkout_complete_container\"]/h2";
    private static final String expectedHeaderText = "Thank you for your order!";

    public static void main(String[] args) throws Exception {

        System.setProperty(driverProperty, driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToUrl(applicationUrl);
        loginPage.login(userName, password, userNameTextBoxId, passwordTextBoxId, loginButtonId);

        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.getAllProducts(productClass, productNameClass, productPriceClass, addToCartTagName);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        productListPage.getAllProducts(productClass, productNameClass, productPriceClass, addToCartTagName);


        int randomProductIndex = productListPage.getRandomProductIndex();


        String randomProductName = productListPage.getRandomProductName(randomProductIndex);
        String randomProductPrice = productListPage.getRandomProductPrice(randomProductIndex);


        shoppingCartPage.addToCart(randomProductName);

        shoppingCartPage.navigateToCart(cartIconId);
        shoppingCartPage.checkout(checkoutButtonId);

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Verify product details during checkout
        checkoutPage.verifyProductDetails(randomProductName, randomProductPrice, productNameClass, productPriceClass);

        checkoutPage.fillDetails(firstName, lastName, zipCode, firstNameTextBoxId, lastNameTextBoxId, zipCodeTextBoxId, continueButtonId);
        checkoutPage.orderProduct(finishButtonId);
        checkoutPage.verifyOrderCompletion(headerTextXpath, expectedHeaderText);

    }
}
