$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("freeVehicleCheck.feature");
formatter.feature({
  "line": 1,
  "name": "To check vehicle identity",
  "description": "As an automation tester\r\nI want to extract vehicle information details from an external source to my file\r\nSo that I validate all the content of the vehicle",
  "id": "to-check-vehicle-identity",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 10,
  "name": "1- Extract vehicle information from external source into my file",
  "description": "",
  "id": "to-check-vehicle-identity;1--extract-vehicle-information-from-external-source-into-my-file",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 11,
  "name": "I enter vehicle registration number \"\u003cReg\u003e\" to get quote",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I tab on the green button GO",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I land in Car Details page",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "I extract the vehicle registration \"\u003cReg\u003e\" into my notepad",
  "keyword": "And "
});
formatter.examples({
  "line": 16,
  "name": "",
  "description": "",
  "id": "to-check-vehicle-identity;1--extract-vehicle-information-from-external-source-into-my-file;",
  "rows": [
    {
      "cells": [
        "Reg"
      ],
      "line": 17,
      "id": "to-check-vehicle-identity;1--extract-vehicle-information-from-external-source-into-my-file;;1"
    },
    {
      "cells": [
        "DN09HRM"
      ],
      "line": 18,
      "id": "to-check-vehicle-identity;1--extract-vehicle-information-from-external-source-into-my-file;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 17171024100,
  "status": "passed"
});
formatter.background({
  "line": 6,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "I have landed on webuyanycar website",
  "keyword": "Given "
});
formatter.match({
  "location": "FreeVehicleCheckStepdefs.iHaveLandedOnWebuyanycarWebsite()"
});
formatter.result({
  "duration": 273413900,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "1- Extract vehicle information from external source into my file",
  "description": "",
  "id": "to-check-vehicle-identity;1--extract-vehicle-information-from-external-source-into-my-file;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 11,
  "name": "I enter vehicle registration number \"DN09HRM\" to get quote",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I tab on the green button GO",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I land in Car Details page",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "I extract the vehicle registration \"DN09HRM\" into my notepad",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "DN09HRM",
      "offset": 37
    }
  ],
  "location": "FreeVehicleCheckStepdefs.iEnterVehicleRegistrationNumberToGetQuote(String)"
});
formatter.result({
  "duration": 266603100,
  "status": "passed"
});
formatter.match({
  "location": "FreeVehicleCheckStepdefs.iTabOnTheGreenButtonGO()"
});
formatter.result({
  "duration": 125381400,
  "status": "passed"
});
formatter.match({
  "location": "FreeVehicleCheckStepdefs.iLandInCarDetailsPage()"
});
formatter.result({
  "duration": 38509400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DN09HRM",
      "offset": 36
    }
  ],
  "location": "FreeVehicleCheckStepdefs.iExtractTheVehicleRegistrationIntoMyNotepad(String)"
});
formatter.result({
  "duration": 1261511800,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 5433033700,
  "status": "passed"
});
formatter.before({
  "duration": 14656033300,
  "status": "passed"
});
formatter.background({
  "line": 6,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "I have landed on webuyanycar website",
  "keyword": "Given "
});
formatter.match({
  "location": "FreeVehicleCheckStepdefs.iHaveLandedOnWebuyanycarWebsite()"
});
formatter.result({
  "duration": 58558700,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "2- Validate all vehicle information extracted",
  "description": "",
  "id": "to-check-vehicle-identity;2--validate-all-vehicle-information-extracted",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "I have landed to Cartaccheck website to perform Free Car Check",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "I enter Vehicle registration number from our save file",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "I tab the blue button to get free car check",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "I land in Vehicle Identity page",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "I validate all the vehicle details within this page",
  "keyword": "And "
});
formatter.match({
  "location": "FreeVehicleCheckStepdefs.iHaveLandedToCartaccheckWebsiteToPerformFreeCarCheck()"
});
formatter.result({
  "duration": 1301060200,
  "status": "passed"
});
formatter.match({
  "location": "FreeVehicleCheckStepdefs.iEnterVehicleRegistrationNumberFromOurSaveFile()"
});
formatter.result({
  "duration": 216043400,
  "status": "passed"
});
formatter.match({
  "location": "FreeVehicleCheckStepdefs.iTabTheBlueButtonToGetFreeCarCheck()"
});
formatter.result({
  "duration": 72650900,
  "status": "passed"
});
formatter.match({
  "location": "FreeVehicleCheckStepdefs.iLandInVehicleIdentityPage()"
});
formatter.result({
  "duration": 24649000,
  "status": "passed"
});
formatter.match({
  "location": "FreeVehicleCheckStepdefs.iValidateAllTheVehicleDetailsWithinThisPage()"
});
formatter.result({
  "duration": 1049000,
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "duration": 1895752000,
  "status": "passed"
});
});