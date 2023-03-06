package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static Main.Login.driver;

public class Test_2 {



    @Parameters({"StartUrlLogin"})
    @Test(groups = {"regress"}, testName = "Scrolling 3")
    public void test3(String StartUrlLogin) throws InterruptedException, IOException {

        System.out.println("*** Scrolling 3 ***");

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


