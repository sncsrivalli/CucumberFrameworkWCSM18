
Feature: Organization feature

  Scenario: Create Organization
    Given Open chrome browser and enter VtigerCRM url
    Then Vtiger Login page should display
    When User enters username and password and clicks on login
    Then Vtiger home page should display 
    When User clicks on Organization tab
    Then Organizations page should display
    When User clicks plus button
    Then Creating New Organization page should display
    When user enters organization name, industry type, hits group radio button and selects from assigned To dropdown and clicks on save button
    Then New Organization Info page should display
    When user clicks on Organizations link
    Then Organizations page should display and Validate if new org is added to the list

 