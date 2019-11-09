$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./src/test/Feature/LoginScnearios.feature");
formatter.feature({
  "line": 1,
  "name": "Login",
  "description": "",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Login Scenarios",
  "description": "",
  "id": "login;login-scenarios",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Verify user on HomePage",
  "keyword": "Given "
});
formatter.match({
  "location": "HomeScreenSteps.verifyUserOnHomePage()"
});
formatter.result({
  "duration": 9555702966,
  "status": "passed"
});
});