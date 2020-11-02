Feature: To check vehicle identity
  As an automation tester
  I want to extract vehicle information details from an input source file
  So that I compare all the contents from the web page align with the output file


  Scenario Outline: 1- Compare all vehicle information
    Given I navigate to UK site to check my car valuation
    And I read the registration number from an input file
    When I extract the registration containing "<Reg>" based on pattern onto the UK site
    And I click the button Free Car Check
    Then I am able to navigate to the vehicle Identity page
    And I can compare the vehicle registration "<Reg>"displayed in the site with the text file car output

    Examples:
      | Reg      |
 #     | DN09HRM  |
#      | BW57BOW  |
      | KT17DLX  |
#      | SG18 HTN |
