package com.automation.steps;

import javax.management.loading.PrivateClassLoader;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
     /*
        User agnostic steps below
     */

     private String ManagerUser ;
     private String Managerpwd ;
     private String TesterUser ;
     private String Testerpwd ;


     public LoginSteps(){

        //  Initialize the test 
        this.ManagerUser = "Eric1";
        this.Managerpwd = "123" ;
        this.TesterUser = "Viet2";
        this.Testerpwd = "Viet2";
    }


    @Given("the employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        // when telling selenium to get a local file you have to add File:// to the start of the url
        System.out.println("\n * the employee is on the login page");
        TestRunner.driver.get("File://C:/revature/project1/defectmanagement/src/test/resources/web-pages/Identification.html");
    }

    @When("the employee clicks the login button")
    public void the_employee_clicks_the_login_button() {
        System.out.println("the employee clicks the login button");
        TestRunner.login.clickButton();
    }


    /*
        Manager steps below
     */

    @When("the manager enters his correct username")
    public void the_manager_enters_his_correct_username() {
        System.out.println("the manager enters his correct username");
        TestRunner.login.enterUsername(ManagerUser);
    }

    @When("the manager enters his correct password")
    public void the_manager_enters_his_correct_password() {
        System.out.println("the manager enters his correct password");
        TestRunner.login.enterPassword(Managerpwd);
    }

    @Then("the manager should be logged in to the manager home page")
    public void the_manager_should_be_logged_in_to_the_manager_home_page() {
        // this method checks that my simulated manager has actually ended up on the manager page
        System.out.println("the manager should be logged in to the manager home page");
        TestRunner.wait.until(ExpectedConditions.titleIs("Manager Page"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Manager Page", title);
    }

    /*
        Tester steps below
     */
    
    @When("the tester enters his correct username")
    public void the_tester_enters_his_correct_username() {
        System.out.println("the tester enters his correct username");
        TestRunner.login.enterUsername(TesterUser);
    }

    @When("the tester enters his correct password")
    public void the_tester_enters_his_correct_password() {
        System.out.println("the tester enters his correct password");
        TestRunner.login.enterPassword(Testerpwd);
    }
    
    @Then("the tester should be logged in to the tester home page")
    public void the_tester_should_be_logged_in_to_the_tester_home_page() {
        System.out.println("the tester should be logged in to the tester home page");
        TestRunner.wait.until(ExpectedConditions.titleIs("Tester Page"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Tester Page", title);
    }
}
