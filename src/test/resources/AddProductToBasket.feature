Feature: Add product to the basket

  Scenario: Select smartwatch from product list
    Given As a user opens main page
    When User selects on main page devices tab
    And User clicks smartwatches in without contract column
    And User clicks in first product ont the list
    And User clicks add to cart button
    Then User go back to main page