Feature: I want to know how many spins of each game can users do

Scenario: Return information on how many spins can user do
    Given there is default data in database
    When I get list of users
        And I get list of games
        And I prepare list of possible bets for every user
    Then I get list of at least five users and informations how many bets they can make