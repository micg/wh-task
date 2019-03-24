Feature: Add new customer

Scenario: Add new customer
    Given there is default data in database
    When I add new user with parameters
    | id  | name    | balance | currency | preferences | isHighRoller |
    | 0   | James   | 20      | GBP      | Bingo       | false        |
    Then customer with parameters is present
    | name    | balance | currency | preferences |
    | James   | 20      | GBP      | Bingo       |