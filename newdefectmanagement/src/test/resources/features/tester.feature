Feature: Testers should be able to update defect 

    Scenario: As a tester I want to sign in so I can view my custom homepage

        Given   the employee is on the login page
        When    the tester enters his correct username
        When    the tester enters his correct password
        When    the employee clicks the login button
        Then    the tester should be logged in to the tester home page
        
    Scenario: As tester I want to update the status

        Given : the tester is on his home page
        When : the tester selects the status
        When : the tester Click on the button update
        Then : the tester should have a the current status updated