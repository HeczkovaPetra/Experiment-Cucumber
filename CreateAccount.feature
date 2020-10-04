Feature: Create Google account
  This is a description of test that creates new google account

  Background:
    Given I open form page in browser

  @SmokeTest
  Scenario: Account created
    When I fill names "Arthur" and "Dent"
    And I fill username "CompletelyNewUsername"
    And I fill password "PaSsWoRd123"
    And I fill confirm password "PaSsWoRd123"
    And I click next
    Then I should be shown the second step

  Scenario Outline: Username & password error
    When I fill names "Ford" and "Prefect"
    And I fill username "<username>"
    And I fill password "<pwd1>"
    And I fill confirm password "<pwd2>"
    And I click next
    Then I should be shown the error msg "<errorMsg>"

    Examples:
      | username              | pwd1        | pwd2        | errorMsg                                                               |
      | A                     | PaSsWoRd123 | PaSsWoRd123 | Sorry, your username must be between 6 and 30 characters long.         |
      | *$#^*@^$#&*@(&)(      | PaSsWoRd123 | PaSsWoRd123 | Sorry, only letters (a-z), numbers (0-9), and periods (.) are allowed. |
      | hitchhiker123         | PaSsWoRd123 | PaSsWoRd123 | That username is taken. Try another.                                   |
      | CompletelyNewUsername | 999         | 999         | Use 8 characters or more for your password                             |
      | CompletelyNewUsername | PaSsWoRd123 | 999         | Those passwords didn't match. Try again.                               |

  Scenario: Empty form
    # I do not fill anything
    When I click next
    Then I should be shown the error msg "Enter first name"
