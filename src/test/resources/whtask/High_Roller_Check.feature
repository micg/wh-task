Feature: Check if there is a High-Roller

Scenario: There is a High-Roller in database fed with default data
    Given there is default data in database
    When I get list of users
    Then one of them is marked as High-Roller

Scenario: The High-Roller has the highest balance, irrescpetively to currency
    Given there is default data in database
    When I get list of users
    Then high-roller has the highest balance

Scenario: Newly added user with the higgest balance is marked as High-Roller
    Given there is default data in database
    When I add new user with parameters
    | id  | name    | balance | currency | preferences | isHighRoller |
    | 100 | Michal  | 1000000 | PLN      | Slots       | false        |
    Then user with ID 100 is marked as High-Roller

