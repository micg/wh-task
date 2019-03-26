Feature: I want to know which game is most popular

Scenario: Download list of games and sort it by popularity
    Given there is default data in database
    When I download list of games sorted by StakesThisWeek
    Then Game called Starburst is most popular

