package com.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;

import com.automation.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManagerSteps {

    private String Descript;
    private String TesterSelection;


    public ManagerSteps(){

        //  Initialize the test 
        Descript = " by Automation";
        TesterSelection = "Viet1";
    }


    //private String Desc;
    @Given(": The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        System.out.println("\n * The manager is on the home page");
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.get("File://C:/revature/project1/defectmanagement/src/test/resources/web-pages/ManagersHomePage.html");        
       // throw new io.cucumber.java.PendingException();
    }
    
        
    @When(":  the manager enters the defect Description")
    public void the_manager_enters_the_defect_Description() {
        System.out.println("the manager enters the defect Description");
        TestRunner.manager.WriteDesc(Descript);
    }
    @When(":  the manager selects the tester name")
    public void the_manager_selects_the_tester_name() {
        System.out.println("the manager selects the tester name");
        TestRunner.manager.SendStatus(TesterSelection);
        
    }
        
    @When(":  the manager clicks the button Assign")
    public void the_manager_clicks_the_button_Assign() {
        System.out.println("the manager clicks the button Assign");
        TestRunner.manager.ClickButtonAssign();
    }


    @Then(":  the manager should get a id defect tester name and status")
    public void the_manager_should_get_a_id_defect_tester_name_and_status() {        
        System.out.println("the manager should get a id defect tester name and status");
        TestRunner.wait.until(ExpectedConditions.titleIs("Manager Page"));
        // Get the last line in the saveInfo element  saveInfo = 12458,Viet2,Accepted,Defect assign message
        WebElement saveElement = TestRunner.driver.findElement(By.id("saveInfo"));
        //String[] saveInf= saveElement.getText().split(",");
        Assert.assertNotEquals(" ",saveElement.getText()) ;
    }
    


}
