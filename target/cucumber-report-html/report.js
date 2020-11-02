$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("UK_VehicleComparison.feature");
formatter.feature({
  "line": 1,
  "name": "",
  "description": "",
  "id": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "",
  "description": "",
  "id": ";",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "I navigate to UK site to check my car valuation",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I read the registration number from an input file",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I extract the registration containing \"\u003cReg\u003e\" based on pattern onto the UK site",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I click the button Free Car Check",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I am able to navigate to the vehicle Identity page",
  "keyword": "Then "
});
formatter.examples({
  "comments": [
    {
      "line": 9,
      "value": "#And I can compare the vehicle reg displayed with the text file car output"
    }
  ],
  "line": 11,
  "name": "",
  "description": "",
  "id": ";;",
  "rows": [
    {
      "cells": [
        "Reg"
      ],
      "line": 12,
      "id": ";;;1"
    },
    {
      "cells": [
        "DN09HRM"
      ],
      "line": 13,
      "id": ";;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 12691565700,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "",
  "description": "",
  "id": ";;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "I navigate to UK site to check my car valuation",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I read the registration number from an input file",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I extract the registration containing \"DN09HRM\" based on pattern onto the UK site",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I click the button Free Car Check",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I am able to navigate to the vehicle Identity page",
  "keyword": "Then "
});
formatter.match({
  "location": "UK_VehicleComparisonStepdefs.iNavigateToUKSiteToCheckMyCarValuation()"
});
formatter.result({
  "duration": 345044800,
  "status": "passed"
});
formatter.match({
  "location": "UK_VehicleComparisonStepdefs.iReadTheRegistrationNumberFromAnInputFile()"
});
formatter.result({
  "duration": 31800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DN09HRM",
      "offset": 39
    }
  ],
  "location": "UK_VehicleComparisonStepdefs.iExtractTheRegistrationContainingBasedOnPatternOntoTheUKSite(String)"
});
formatter.result({
  "duration": 219210900,
  "status": "passed"
});
formatter.match({
  "location": "UK_VehicleComparisonStepdefs.iClickTheButtonFreeCarCheck()"
});
formatter.result({
  "duration": 777407500,
  "status": "passed"
});
formatter.match({
  "location": "UK_VehicleComparisonStepdefs.iAmAbleToNavigateToTheVehicleIdentityPage()"
});
formatter.result({
  "duration": 290489700,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1537908800,
  "status": "passed"
});
});