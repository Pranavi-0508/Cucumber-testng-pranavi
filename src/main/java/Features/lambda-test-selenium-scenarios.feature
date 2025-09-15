Feature: Validating LambdaTest Selenium Playground Scenarios

Scenario: Lambdatest Simple Form Demo Page Scenario

Given User Navigates to Selenium Playground URL
When User Selects on Simple Form Demo
Then Validate the URL Contains Simple Form Demo Title
Then Enter the text "Welcome to LambdaTest" in the input box and click on Get CheckedValue
And  Check whether the same text message is displayed in the right handle panel


Scenario: Lambdatest Drag and Drop Scenario

Given User Navigates to Selenium Playground URL
When User Selects on Drag & Drop Sliders
Then Select the slider Default value 15 and drag the bar to 95
And Validate whether the range value shows 95

