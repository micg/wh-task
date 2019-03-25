Feature: I want to get target audience for marketing campaign for Starburst

  Scenario: Get users that like Slot games
    Given there is default data in database
    When I download list of users that like slot games
    Then I get list of three users: user1, Brian and Paul