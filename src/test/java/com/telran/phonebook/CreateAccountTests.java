package com.telran.phonebook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        // precondition: user must be logged out
        // click on the LOGIN link
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            dr.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        } else {
            dr.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        }
    }


    // test
    @Test
    public void createAccountPositiveTest() throws InterruptedException {
        // assert is reg form displayed
        Assert.assertTrue(isElementPresent(By.cssSelector(".login_login__3EHKB")));
        // fill reg form
        dr.findElement(By.cssSelector("[placeholder='Email']")).click();
        dr.findElement(By.cssSelector("[placeholder='Email']")).clear();
        dr.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("karl+9@gmail.co");
        dr.findElement(By.cssSelector("[placeholder='Password']")).click();
        dr.findElement(By.cssSelector("[placeholder='Password']")).clear();
        dr.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Aa98765_");
        // click on Reg button
        dr.findElement(By.xpath("//button[contains(.,'Registration')]")).click();
        // verify that Sign out button is displayed
        Thread.sleep(1000);
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));

    }

    @Test
    public void createAccountNegativeTest() throws InterruptedException {
        // assert is reg form displayed
        Assert.assertTrue(isElementPresent(By.cssSelector(".login_login__3EHKB")));
        // fill reg form
        dr.findElement(By.cssSelector("[placeholder='Email']")).click();
        dr.findElement(By.cssSelector("[placeholder='Email']")).clear();
        dr.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("karl+9@gmail.co");
        dr.findElement(By.cssSelector("[placeholder='Password']")).click();
        dr.findElement(By.cssSelector("[placeholder='Password']")).clear();
        dr.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Aa98765");
        // click on Reg button
        dr.findElement(By.xpath("//button[contains(.,'Registration')]")).click();
        // verify that Sign out button is displayed
        //Thread.sleep(1000);
Assert.assertTrue(isAlertPresent());
Assert.assertTrue(isElementPresent(By.xpath("//*[contains(.,'Registration failed with code 400')]")));

    }


    public boolean isAlertPresent(){
        Alert alert = new WebDriverWait(dr, 20).until(ExpectedConditions.alertIsPresent());
        if (alert == null){
            return false;
        } else {
            dr.switchTo().alert();
            alert.accept();
            return true;
        }

    }


}
