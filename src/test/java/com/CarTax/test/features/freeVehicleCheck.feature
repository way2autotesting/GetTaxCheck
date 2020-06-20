Feature: To check vehicle identity
  As an automation tester
  I want to extract vehicle information details from an external source to my file
  So that I validate all the content of the vehicle

  Background:
    Given I have landed on webuyanycar website


  Scenario Outline:1- Extract vehicle information from external source into my file
    #Given I have landed on webuyanycar website
    When I enter vehicle registration number "<Reg>" to get quote
    And I tab on the green button GO
    Then I land in Car Details page
    And I extract the vehicle registration "<Reg>" into my notepad

    Examples:
      | Reg     |
      | DN09HRM |

    Scenario: 2- Validate all vehicle information extracted
      Given I have landed to Cartaccheck website to perform Free Car Check
      When I enter Vehicle registration number from our save file
      And I tab the blue button to get free car check
      Then I land in Vehicle Identity page
     # And I validate all the vehicle details within this page