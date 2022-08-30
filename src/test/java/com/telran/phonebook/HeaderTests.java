package com.telran.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase {

//      //td[text=’UserID’]                     -->     //td[@text=’UserID’]
//      tag.class[attribute=value]              -->     tag.class[attribute='value']
//      //input[@type=’text’])(2)               -->     //input[@type=’text’])(2)
//      [@attribute_name=’attribute_value']     -->     //*[@attribute_name=’attribute_value']
//      //**[@type=’password’]                  -->     //*[@type=’password’]
//      tag[@attribute=value]                   -->     tag[attribute='value']
//      label[for='skills']//..//p[for='mask']  -->     //label[@for='skills']/..//p[@for='mask']
//      .navbar menu > li:nth-child(3) > .link  -->     .navbar.menu>li:nth-child(3)>.link
//      input[#firstName]                       -->     input[firstName]
//      #textarea.form-control                  -->     textarea.form-control
//      textarea#currentAddress[placeholder()='Current Address']    -->     //textarea#currentAddress[placeholder()='Current Address']
//      div < textarea[placeholder='Current Address']   -->     //div>textarea[@placeholder='Current Address']
//      input[id$='userN']                      -->     //input[#id$='userN']
//      //a[starts(text(),’Mobile’)]            -->     //a[starts-with(text(),’Mobile’)]

    @Test
    public void unauthorizedHeaderTests() {
        // Phonebook logo:
        dr.findElement(By.xpath("//h1[contains(.,'PHONEBOOK')]"));
        // Home link:
        dr.findElement(By.xpath("//a[contains(.,'HOME')]"));
        // About link:
        dr.findElement(By.xpath("//a[contains(.,'ABOUT')]"));
        // Login link:
        dr.findElement(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    @BeforeMethod
    public void ensurePreconditions() {
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            dr.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        } else {
            dr.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        }
    }

    @Test
    public void authorizedHeaderTests() {
        Assert.assertTrue(isElementPresent(By.cssSelector(".login_login__3EHKB")));

        dr.findElement(By.cssSelector("[placeholder='Email']")).click();
        dr.findElement(By.cssSelector("[placeholder='Email']")).clear();
        dr.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("karl+9@gmail.co");
        dr.findElement(By.cssSelector("[placeholder='Password']")).click();
        dr.findElement(By.cssSelector("[placeholder='Password']")).clear();
        dr.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Aa98765_");
        dr.findElement(By.xpath("//button[contains(.,'Login')]")).click();
        // Thread.sleep(1000);
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));

        // Phonebook logo:
        dr.findElement(By.xpath("//h1[contains(.,'PHONEBOOK')]"));
        // Home link:
        dr.findElement(By.xpath("//a[contains(.,'HOME')]"));
        // About link:
        dr.findElement(By.xpath("//a[contains(.,'ABOUT')]"));
        // Contacts link:
        dr.findElement(By.xpath("//a[contains(.,'CONTACTS')]"));
        dr.findElement(By.xpath("//a[contains(.,'CONTACTS')]")).click();
        // Add link:
        dr.findElement(By.xpath("//a[contains(.,'ADD')]"));
        dr.findElement(By.xpath("//a[contains(.,'ADD')]")).click();
        // Login link:
        dr.findElement(By.xpath("//button[contains(.,'Sign Out')]"));

    }


}
