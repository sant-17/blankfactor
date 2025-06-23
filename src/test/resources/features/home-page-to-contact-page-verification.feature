Feature: Navigate and verify the BlanckFactor page

  Scenario Outline: Verify the content in the Retirement and Wealth section
    Given the user is on the homepage
    When navigates to the "<nav_section>" section and opens the "<nav_page>" page
    And copy the text from the third tile in the "<page_section>" section
    And clicks on the "<redirect_button>" button
    Then the user should see that the current URL indicate the "<current_page>" page
    And the page title indicate the "<current_page>" page
    Examples:
    |nav_section  |nav_page             |page_section                               |redirect_button  |current_page |
    |Industries   |Retirement and wealth|Powering innovation in retirement services |Let's get started|Contact      |

