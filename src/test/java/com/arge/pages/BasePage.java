package com.arge.pages;

import com.arge.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    public void chooseArgeMenu(String menu){
        Driver.get().findElement(By.xpath("//p[text()='"+menu+"']")).click();
    }
}
