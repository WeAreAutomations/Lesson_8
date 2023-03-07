package Tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import static Main.Login.driver;

public class Test_1 {


    @Parameters({"StartUrlLogin"})
    @Test(groups = {"smoke"}, testName = "Scrolling 1")
    public void test1(String StartUrlLogin) throws InterruptedException, IOException {

        System.out.println("*** Scrolling 1 ***");

        // Переход на начальную страницу
        driver.get(StartUrlLogin);
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        Thread.sleep(4000);
        js.executeScript("window.scrollBy(0,2000)");

        long scrollPosition = (Long) js.executeScript("return window.scrollY");
        System.out.println("Current scroll position: " + scrollPosition);

        Thread.sleep(4000);
        js.executeScript("window.scrollBy(0,-2500)");

        long scrollPosition2 = (Long) js.executeScript("return window.scrollY");
        System.out.println("Current scroll position: " + scrollPosition2);

        int scroll = 2500;
        Assert.assertEquals(scroll, 2500);


    }

    @Parameters({"StartUrlLogin"})
    @Test(groups = {"regress"}, testName = "Scrolling 2")
    public void test2(String StartUrlLogin) throws InterruptedException, IOException {

        System.out.println("*** Scrolling 1 ***");

        // Переход на начальную страницу
        driver.get(StartUrlLogin);
        Thread.sleep(3000);

        WebElement logo = driver.findElement(By.xpath("//a[@data-test-id=\"logo-footer\"]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", logo);

        WebElement Apple = driver.findElement(By.xpath("//a[@class=\"app-item\"][1]"));

        boolean isDisplayed = logo.isDisplayed();
        Assert.assertTrue(isDisplayed);

    }


}


