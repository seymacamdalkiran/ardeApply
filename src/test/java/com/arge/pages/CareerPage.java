package com.arge.pages;

import com.arge.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CareerPage extends BasePage{

    @FindBy(xpath = "//span[text()='OPEN POSITIONS']")
    public WebElement openPositions;
    @FindBy(id = "comp-kmvrax20")
    public WebElement apply;
    @FindBy(id = "collection_comp-kmvpx1bb2")
    public WebElement positions;
    @FindBy(id = "input_comp-kmvpx1b01")
    public WebElement firstname;

    @FindBy(id = "input_comp-ko8huagw")
    public WebElement cvURL;
    @FindBy(id = "input_comp-ko8hvtbu")
    public WebElement linkedin;
    @FindBy(id = "textarea_comp-kmvpx1bm1")
    public WebElement description;
    @FindBy(xpath = "//button[@data-testid='buttonElement']")
    public WebElement send;
    Actions actions=new Actions(Driver.get());
    public void chooseJob(String job){
        Driver.get().findElement(By.xpath("//span[text()='"+job+"']")).click();
    }
    public void applyJob(String job){
        Driver.get().findElement(By.xpath("//div[.='"+job+"']/following-sibling::div[.='Apply Now']")).click();
    }
    public void fillTheApplicationList(String firstName, String lastName, String email, String telephone){
        actions.click(firstname)
                .sendKeys(firstName+Keys.TAB)
                .sendKeys(lastName+Keys.TAB)
                .sendKeys(email+Keys.TAB)
                .sendKeys(telephone).perform();
        Select select=new Select(positions);
        select.selectByIndex(5);
        select.getFirstSelectedOption().click();

    }


}
