package com.telran.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class HomepageTests extends TestBase{

    @Test
    public void openHomepage() {

        System.out.println("Home Component: " + isHomeComponentPresent2());
        isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
    }

    public boolean isHomeComponentPresent() {
        return isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
    }

    public boolean isHomeComponentPresent2() {
        return isElementPresent2();
    }


}
