Feature: Navigate and verify the BlanckFactor page

  Scenario: Verify the content in the Retirement and Wealth section
    Given the user is on the homepage
    When navigates to the "Industries" section and opens the "Retirement and wealth" page
    And copy the text from the third tile in the "Powering innovation in retirement services" section
    And clicks on the "Let's get started" button
    Then the user should see that the current URL and page title indicate the "Contact" page
