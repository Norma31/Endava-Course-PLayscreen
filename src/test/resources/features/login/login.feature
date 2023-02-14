@Login
Feature: Login

  @qa
  Scenario: Success Login to Sauce home page
    Given Carlos is a Sauce Customer
    When He tries to login
    Then He should see products list

  @inProgress
  Scenario Outline: Success Login to Sauce home page
    Given Carlos is a Sauce Customer
    When He tries to login with user name <userName> and password <password>
    Then He should see products list
    Examples:
      | userName       | password      |
      | standard_user  | secret_sauce  |

