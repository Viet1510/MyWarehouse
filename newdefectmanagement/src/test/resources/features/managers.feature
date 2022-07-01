Feature: Managers should be able to Assign a defect to the testers
    Scenario: As a manager I want to sign in so I can view my custom homepage

        Given    the employee is on the login page
        When     the manager enters his correct username
        When     the manager enters his correct password
        When     the employee clicks the login button
        Then     the manager should be logged in to the manager home page

    Scenario: As manager I want to assign a defect to the tester

        Given : The manager is on the home page
        When :  the manager enters the defect Description
        When :  the manager selects the tester name
        When :  the manager clicks the button Assign
        Then :  the manager should get a id defect tester name and status
        
