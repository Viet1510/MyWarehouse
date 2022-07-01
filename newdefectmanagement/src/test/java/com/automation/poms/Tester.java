package com.automation.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Tester {
    private WebDriver driver; // this driver will only be used internally (in the class) so it is private
    private String LastSelect; 
    
    
   // @FindBy(id = "Updatedefect1")
    public WebElement BtnUpdate;


    //@FindBy(id="idSelect1")
    public WebElement selectOne;


    
    
    public Tester(WebDriver Testerdriver){
       this.driver = Testerdriver; // this initializes the private driver field

       /*
           The PageFactory class is provided by Selenium and it abstracts away from us the code that handles
           initializing our WebElement fields. We simpply provide the initElements() method with the privite driver
           we initialize above, and the PageFactory class handles the rest!
        */
       PageFactory.initElements(this.driver,this);
    }

   
        

        //  function Select status
        public void SelectStatus( String StatusActived, int num){
            // save for checking step, it will be compared will the current status columm on webpage that should be uodated
            LastSelect= StatusActived;  
            String SelectOption = "idSelect"+num;
            //System.out.println(StatusActived+" "+SelectOption);

            this.selectOne = driver.findElement(By.id(SelectOption));
            //selectOne=driver.
            Select selectObject=new Select(selectOne);
            //selectObject.selectByVisibleText(StatusActived);
            selectObject.selectByValue(StatusActived);
            //System.out.println("Selection passed :" + StatusActived+" "+SelectOption);

            //this.SelectedStatus.sendKeys(String StatusValue);
        }
        


        public void ClickButtonUpdate( int numBtn){
            BtnUpdate = this.driver.findElement(By.id("Updatedefect" + numBtn));
            //System.out.println("numBtn="+numBtn);
            //Actions actions = new Actions(driver);
            //actions.contextClick(BtnUpdate).perform();
            this.BtnUpdate.click();
            //System.out.println("Button Click Passed ="+numBtn);
            //BtnUpdate.click();
            //driver.navigate().refresh();
        }
        

        public String GetLastSelect(){

            return(this.LastSelect);
        }

        public String GetUpdateStatus( int Nbr){
            WebElement CurrentStatus = this.driver.findElement(By.id("Status" + Nbr));
            CurrentStatus.getText();
            return(CurrentStatus.getText());
        }






}
