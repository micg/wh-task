Feature: Ballance is automatically converted to GBP

Scenario: There are no other curencies than GBP
    Given there is default data in database
    When I get list of users
    Then all of them have their balances in GBP

Scenario: Newly added users have their balances converted to GBP
    Given there is default data in database
    When I add new user with parameters
    | id  | name    | balance | currency | preferences | isHighRoller |
    | 200 | Michal  | 1000000 | PLN      | Slots       | false        |
    Then balance of user with id 200 is converted to GBP
