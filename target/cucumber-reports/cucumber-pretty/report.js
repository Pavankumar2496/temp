$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "Data Extracting From Companies",
  "description": "",
  "id": "data-extracting-from-companies",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Test Data Extraction From Companies Functionality",
  "description": "",
  "id": "data-extracting-from-companies;test-data-extraction-from-companies-functionality",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user enters \"\u003cCompanyName\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 6,
  "name": "",
  "description": "",
  "id": "data-extracting-from-companies;test-data-extraction-from-companies-functionality;",
  "rows": [
    {
      "cells": [
        "CompanyName"
      ],
      "line": 7,
      "id": "data-extracting-from-companies;test-data-extraction-from-companies-functionality;;1"
    },
    {
      "cells": [
        "intraedge"
      ],
      "line": 8,
      "id": "data-extracting-from-companies;test-data-extraction-from-companies-functionality;;2"
    },
    {
      "cells": [
        "surchx"
      ],
      "line": 9,
      "id": "data-extracting-from-companies;test-data-extraction-from-companies-functionality;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 8,
  "name": "Test Data Extraction From Companies Functionality",
  "description": "",
  "id": "data-extracting-from-companies;test-data-extraction-from-companies-functionality;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user enters \"intraedge\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "intraedge",
      "offset": 13
    }
  ],
  "location": "LoginStepDefinition.user_already_on_login_page(String)"
});
