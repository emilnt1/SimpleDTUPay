Feature: Payment
  Scenario: List of payments
    Given a successful payment of 10 kr from customer 1 to merchant 1
    When the manager asks for a list of payments
    Then the list contains a payments where customer 1 paid 10 kr to merchant 1

  Scenario: Customer is not known
    Given a customer with id 20
    And a merchant with id 1
    When the merchant initiates a payment for 10 kr by the customer
    Then the payment is not successful
    And an error message is returned saying "customer with id 20 is unknown"

  Scenario: Merchant is not known
    Given a customer with id 1
    And a merchant with id 20
    When the merchant initiates a payment for 10 kr by the customer
    Then the payment is not successful
    And an error message is returned saying "merchant with id 20 is unknown"

  Scenario: Successful Payment
    Given a customer with a bank account with balance 1000
    And that the customer is registered with DTU Pay
    Given a merchant with a bank account with balance 2000
    And that the merchant is registered with DTU Pay
    When the merchant initiates a payment for 100 kr by the customer
    Then the payment is successful
    And the balance of the customer at the bank is 900 kr
    And the balance of the merchant at the bank is 2100 kr
