Feature: Users balance is updated

Scenario: Update balance of user with id 4
    Given there is default data in database
    When I update ballance of user with id 4
    Then user of id 4 have more money