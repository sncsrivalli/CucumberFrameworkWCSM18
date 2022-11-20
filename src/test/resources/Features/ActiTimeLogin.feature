
Feature: ActiTime Login

  Scenario Outline: ActiTime login Test
    Given Open Browser and enter Actitime URL
    When User enters <username> and <password> and clicks login
    Then Home page should display with <status>

    Examples: 
      | username  | password | status  |
      | admin     | manager  | success |
      | trainee   |  trainee | success |
      | abcde     | 12345    | Fail    |