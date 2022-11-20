
Feature: ActiTime login Using POM
 
  Scenario: Login Page Verification
    Given User opens browser 
    When enters URL - actitime.com
    Then I validate Login page
  
 Scenario Outline: ActiTime home page verification
    Given Launch Browser and enter Actitime URL
    When enter <username> and <password> and click login
    Then Home page is display with <status>

    Examples: 
      | username  | password | status  |
      | admin     | manager  | success |
      | trainee   |  trainee | success |
      