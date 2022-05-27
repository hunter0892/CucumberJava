#Author:
#Date:
#Description:
Feature: feature to test login functionality

  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enter <username> and <password>
    And clicks on login button
    Then navigated to home page

    Examples: 
      | username | password |
      | raghav   | 12345 |
      | shyam    | 12345 |
