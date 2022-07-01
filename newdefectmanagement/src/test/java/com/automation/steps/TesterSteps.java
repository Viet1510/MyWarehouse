package com.automation.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TesterSteps {
    private int DefectNum ;
    private String username;
    private String password;
    private String TestingStatus;


    public TesterSteps(){

        //  Initialize the test 
        this.DefectNum= 3;
        this.username="Viet1";
        this.password="Viet1";
        this.TestingStatus="Fixed";
    
    }

    @Given(": the tester is on his home page")
    public void the_tester_is_on_his_home_page() {
      //  TestRunner.driver3 = TestRunner.driver;
      //  TestRunner.driver.get("File://C:/revature/project1/defectmanagement/src/test/resources/web-pages/TestersHomePage.html");        
      System.out.println("* the tester is on his home page");

      // For getting Tester homne page , I need to start by login page and acces to the tester home page 
      // because the username is transferred fron login page in sessionStorage to the tesre page,
      // I need the username to select only the defects that concern the tester
      // BUT I still have the issue , sometime it works , somethimes It doesn't work , 
      // when I update the status of the defect by click button,
      // and when I check the column "Current Status" on the webpage by automation, it does't updated sometimes
      // 
      TestRunner.driver.get("File://C:/revature/project1/defectmanagement/src/test/resources/web-pages/Identification.html");
      TestRunner.login.enterUsername(this.username);
      TestRunner.login.enterPassword(this.password);
      TestRunner.login.clickButton();

      //TestRunner.driver.navigate().refresh();
      TestRunner.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }


//Some other steps were also undefined:

    @When(": the tester selects the status")
    public void the_tester_selects_the_status() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("The tester selects the status");
        TestRunner.tester.SelectStatus(this.TestingStatus, DefectNum);
    }
    @When(": the tester Click on the button update")
    public void the_tester_Click_on_the_button_update() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("the tester Click on the button update");
        TestRunner.tester.ClickButtonUpdate(DefectNum);
        TestRunner.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }



    @Then(": the tester should have a the current status updated")
    public void the_tester_should_have_a_the_current_status_updated() {
        System.out.println("the tester should have a the current status updated");
        TestRunner.wait.until(ExpectedConditions.titleIs("Tester Page"));
        String lastSelect = TestRunner.tester.GetLastSelect();
        String UpdatedStatus = TestRunner.tester.GetUpdateStatus(DefectNum);
        System.out.println("Select Status ="+lastSelect+", Updated Status ="+UpdatedStatus);
        Assert.assertEquals(lastSelect, UpdatedStatus);
    }

}
