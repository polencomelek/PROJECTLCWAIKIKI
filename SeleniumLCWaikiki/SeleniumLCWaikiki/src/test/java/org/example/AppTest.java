package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;


public class AppTest extends BaseTest {
    public JavascriptExecutor js;

    @Test
    public void LcWaikikiOtomation() throws InterruptedException, AWTException {

        driver.navigate().to("https://www.lcwaikiki.com/tr-TR/TR");

        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.lcwaikiki.com/tr-TR/TR", url);
        System.out.println("LC Waikiki Ana Sayfasındasın.");

        WebElement homepageloginButton = driver.findElement(By.id("header-user-section"));
        homepageloginButton.click();

        Thread.sleep(1000);
        WebElement emailField = driver.findElement(By.id("LoginEmail"));
        emailField.sendKeys("akinkazar9@gmail.com");

        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("15754266916Ak*");

        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.id("loginLink"));
        loginButton.click();

        WebElement myAccountButton = driver.findElement(By.id("header-login-section"));
        Assert.assertEquals(myAccountButton.getText(), "Hesabım");
        System.out.println();
        System.out.println("Başarılı Bir Şekilde Oturum Açtınız.");

        WebElement SearchField = driver.findElement(By.id("search"));
        SearchField.sendKeys("Pantolon");

        WebElement SearchButton = driver.findElement(By.cssSelector("a[class='search-button active']"));
        SearchButton.click();

        Thread.sleep(1000);
        // Kaydırma işlemi için kullandık
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    //   js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement moreButton= driver.findElement(By.cssSelector("a[class=\"lazy-load-button\"]"));
        moreButton.click();

        WebElement selectProduct = driver.findElement(By.cssSelector("div ~img[alt=\"Kız Bebek Puantiyeli Gabardin Pantolon - LC WAIKIKI\"][data-index=\"0\"]"));
        selectProduct.click();

        WebElement productPrize = driver.findElement(By.xpath("(//span[@class='price'])[3]"));
        String expectedPrize = productPrize.getText();

        WebElement sizeSelection = driver.findElement(By.xpath("(//a[@key='1'])[1]"));
        sizeSelection.click();

        WebElement addBasketButton = driver.findElement(By.id("pd_add_to_cart"));
        addBasketButton.click();

        WebElement goToBasket = driver.findElement(By.cssSelector("i[class=\"header-bag-icon bndl-shopping-bag bndl-shopping-bag-dims\"]"));
        goToBasket.click();

        Thread.sleep(1000);
        WebElement basketPrize = driver.findElement(By.cssSelector("span[class='rd-cart-item-price mb-15']"));
        Assert.assertEquals(expectedPrize,basketPrize.getText());

        System.out.println("ürün fiyatı: "+ basketPrize.getText());

        WebElement increaseButton = driver.findElement(By.cssSelector("a[class=\"oq-up plus\"]"));
        increaseButton.click();

        WebElement numberOfProducts = driver.findElement(By.cssSelector("input[class=\"item-quantity-input ignored\"]"));
        Assert.assertEquals("2", numberOfProducts.getAttribute("value"));

        Thread.sleep(1000);
        WebElement deleteButton = driver.findElement(By.cssSelector("a[title=\"Sil\"]"));
        deleteButton.click();

        Thread.sleep(3000);
        WebElement popUpDeleteButton = driver.findElement(By.cssSelector("a[class=\"inverted-modal-button sc-delete ins-init-condition-tracking\"]"));
        popUpDeleteButton.click();

        Thread.sleep(1000);
        WebElement noProductText = driver.findElement(By.cssSelector("div[class=\"row cart-empty\"] p[class='cart-empty-title']"));
        Assert.assertEquals(noProductText.getText(), "Sepetinizde ürün bulunmamaktadır.");
    }
}
