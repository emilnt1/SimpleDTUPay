Feature: Person

      * As a person
      * I want to be able to create a new person
      * So that I can add a new person to the system

  Scenario: Get a person
    Given A person with no name and address
    When I change the persons name and address to "Henrik" and "Buddinge"
    Then The name and address of the person is "Henrik" and "Buddinge"