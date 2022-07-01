package com.automation.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Manager {

    private WebDriver driver; // this driver will only be used internally (in the class) so it is private

    // these web elements need to be referenced in our steps so they are public
    // this tells the PageFactory to find the element with the id username and assign it to this field
    @FindBy(id = "AssignedTitle") 
    public WebElement DescInput;

    // this tells the PageFactory to find the element with the id password and assign it to this field
    //@FindBy(id = "password")
    //public WebElement passwordInput;

    // this tells the PageFactory to find the first element created via button tags and assign it to this field
    @FindBy(tagName = "button" )
    public WebElement AssignButton;


    @FindBy(id="testerSelected")
    public WebElement SelectedStatus;
    
    
    public Manager(WebDriver driver){
       this.driver = driver; // this initializes the private driver field

       /*
           The PageFactory class is provided by Selenium and it abstracts away from us the code that handles
           initializing our WebElement fields. We simpply provide the initElements() method with the privite driver
           we initialize above, and the PageFactory class handles the rest!
        */
       PageFactory.initElements(driver,this);
    }

    /*
       these methods are public so we can access them in the steps, and their return type is void because 
       the functions do not return any values: they just interact with the web page
    */

    // this method will allow both managers and testers to enter their usernames
        public void WriteDesc( String Desc){
            this.DescInput.sendKeys(Desc);
            System.out.println("Dsscription = "+Desc);
        }
        

        //  function Select status
        public void SendStatus( String SelectValue){
        SelectedStatus = this.driver.findElement(By.id("testerSelected"));
        Select selectObject=new Select(SelectedStatus);
        //selectObject.selectByVisibleText(SelectValue);
        selectObject.selectByValue(SelectValue);
        //this.SelectedStatus.sendKeys(String StatusValue);
        System.out.println("SelectValue = "+SelectValue);
    }
        
        public void ClickButtonAssign(){
            this.AssignButton.click();
        }
        

    
}
