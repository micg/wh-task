Feature: I want to be able to alter users balance

Scenario: Update balance of user with id 4
    Given there is default data in database
    When I update balance of user with id 4 by 20000
    Then user of id 4 have more money