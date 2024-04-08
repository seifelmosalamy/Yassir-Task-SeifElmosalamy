@FeatureOne
Feature: Checking login functionality for saucedemo.com

  Scenario Outline: Checking login functionality for proper login credential
    Given User is on "<website>" landing page
    Then Login page is opened
    When User enters "<username>" and "<password>" and clicks sign in button
    And Close browser

    Examples:
      | website                    | username       | password     |
      | https://www.saucedemo.com/ | standard_user  | secret_sauce |
      | https://www.saucedemo.com/  | problem_user| secret_sauce |


  Scenario Outline: Checking Wrong login credentials
    Given User is on "<website>" landing page
    Then Login page is opened
    When User enters "<username>" and "<password>" and clicks sign in button
    Then Error message is shown
    And Close browser
    Examples:
      | website                           | username     | password     |
      | https://www.saucedemo.com/ | testUsername | TestPassword |
